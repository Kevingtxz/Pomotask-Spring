package com.pomotask.pomotask.main.resource;

import com.pomotask.pomotask.main.domain.AbsModel;
import com.pomotask.pomotask.main.dto.mapper.AbsMapper;
import com.pomotask.pomotask.main.service.AbsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public abstract class AbsResource<Model extends AbsModel, Form, View> {


    final protected AbsService<Model, Form> service;
    final protected AbsMapper<Model, Form, View> mapper;


    @GetMapping(value = "/page")
    public ResponseEntity<Page<View>> findPage(
            @AuthenticationPrincipal OAuth2User principal,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "5")  Integer linesPerPage) {
        String userEmail = principal.getAttribute("email");
        Page<Model> list = this.service.findPageByUserEmail(userEmail, page, linesPerPage);
        Page<View> listView = list.map(obj -> this.mapper.toView(obj));
        return ResponseEntity.ok().body(listView);
    }

    @GetMapping
    public ResponseEntity<Set<View>> findAll(
            @AuthenticationPrincipal OAuth2User principal) {
        String userEmail = principal.getAttribute("email");
        Set<Model> set = this.service.findAllByUserEmail(userEmail);
        Set<View> viewSet = set
                .stream()
                .map(obj -> this.mapper.toView(obj))
                .collect(Collectors.toSet());
        return ResponseEntity.ok().body(viewSet);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<View> find(
            @AuthenticationPrincipal OAuth2User principal,
            @PathVariable Integer id) {
        String userEmail = principal.getAttribute("email");
        Model entity = this.service.findByUserEmailAndId(userEmail, id);
        return ResponseEntity.ok().body(this.mapper.toView(entity));
    }

    @PostMapping
    public ResponseEntity<Void> insert(
            @AuthenticationPrincipal OAuth2User principal,
            @Valid @RequestBody Form form) {
        String userEmail = principal.getAttribute("email");
        Model obj = this.service.insert(userEmail, form);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(
            @AuthenticationPrincipal OAuth2User principal,
            @Valid @RequestBody Form form,
            @PathVariable Integer id) {
        String userEmail = principal.getAttribute("email");
        this.service.update(userEmail, form, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(
            @AuthenticationPrincipal OAuth2User principal,
            @PathVariable Integer id) {
        String userEmail = principal.getAttribute("email");
        this.service.deleteByUserEmailAndId(userEmail, id);
        return ResponseEntity.noContent().build();
    }

}
