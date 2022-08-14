package com.pomotask.pomotask.app.resource;

import com.pomotask.pomotask.app.dto.form.AbsForm;
import com.pomotask.pomotask.app.dto.mapper.AbsMapper;
import com.pomotask.pomotask.app.dto.view.AbsView;
import com.pomotask.pomotask.app.model.AbsModel;
import com.pomotask.pomotask.app.resource.hateoas.util.HateoasUtil;
import com.pomotask.pomotask.app.service.AbsService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Set;
import java.util.stream.Collectors;

import static com.pomotask.pomotask.util.VersionUtil.API_VERSION_FOR_URL;


@RequestMapping(value = API_VERSION_FOR_URL)
@RequiredArgsConstructor
public abstract class AbsResource<
        Model extends AbsModel,
        Form extends AbsForm<Model>,
        View extends AbsView<Model>> {


    final protected AbsService<Model, Form, View> service;
    final protected AbsMapper<Model, Form, View> mapper;


    
    @GetMapping
    public ResponseEntity<CollectionModel<View>> findAll(
            @AuthenticationPrincipal(expression = "userId") Integer userId) {
        Set<Model> modelSet = this.service.findAllByUserId(userId);
        Set<View> viewSet = modelSet
            .stream()
            .map(obj -> {
                View view = this.mapper.toView(obj);
                view.add(HateoasUtil.makeLinkToWithSelfRel(this, userId, obj.getId()));
                return view;
            }).collect(Collectors.toSet());
        CollectionModel<View> collectionView = CollectionModel.of(viewSet);
        collectionView.add(HateoasUtil.makeLinkToWithSelfRel(this, userId));
        return ResponseEntity.ok().body(collectionView);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<View> find(
            @AuthenticationPrincipal(expression = "userId") Integer userId,
            @PathVariable Integer id) {
        Model model = this.service.findByUserIdAndId(userId, id);
        View view = this.mapper.toView(model);
        view.add(HateoasUtil.makeLinkToWithSelfRel(this, userId, model.getId()));
        view.add(HateoasUtil.makeLinkToWithCollectionRel(this, userId));
        return ResponseEntity.ok().body(view);
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
