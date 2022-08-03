package com.pomotask.pomotask.app.resource;

import com.pomotask.pomotask.app.model.AbsModel;
import com.pomotask.pomotask.app.dto.mapper.AbsMapper;
import com.pomotask.pomotask.app.service.AbsService;
import com.pomotask.pomotask.config.security.oauth2.AuthPrincipal;
import com.pomotask.pomotask.config.security.oauth2.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Set;
import java.util.stream.Collectors;

import static com.pomotask.pomotask.util.Version.API_VERSION_FOR_URL;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RequestMapping(value = API_VERSION_FOR_URL)
@RequiredArgsConstructor
public abstract class AbsResource<Model extends AbsModel, Form, View> {


    final protected AbsService<Model, Form, View> service;
    final protected AbsMapper<Model, Form, View> mapper;


    @GetMapping
    public ResponseEntity<Set<View>> findAll(
            @AuthenticationPrincipal(expression = "userId") Integer userId) {
        Set<Model> set = this.service.findAllByUserId(userId);
        if (set.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            for (Model model : set)
                model.add(
                        linkTo(methodOn(AbsResource.class)
                        .find(userId, model.getId()))
                        .withSelfRel());
        Set<View> viewSet = set
                .stream()
                .map(obj -> this.mapper.toView(obj))
                .collect(Collectors.toSet());
        return ResponseEntity.ok().body(viewSet);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<View> find(
            @AuthenticationPrincipal(expression = "userId") Integer userId,
            @PathVariable Integer id) {
        Model entity = this.service.findByUserIdAndId(userId, id);
        return ResponseEntity.ok().body(this.mapper.toView(entity));
    }

    @PostMapping
    public ResponseEntity<Void> insert(
            @AuthenticationPrincipal(expression = "userId") Integer userId,
            @Valid @RequestBody Form form) {
        Model obj = this.service.insert(userId, form);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(
            @AuthenticationPrincipal(expression = "userId") Integer userId,
            @Valid @RequestBody Form form,
            @PathVariable Integer id) {
        this.service.update(userId, form, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(
            @AuthenticationPrincipal(expression = "userId") Integer userId,
            @PathVariable Integer id) {
        this.service.deleteByUserIdAndId(userId, id);
        return ResponseEntity.noContent().build();
    }

}
