package com.pomotask.pomotask.app.resource;

import com.pomotask.pomotask.app.dto.form.TimerForm;
import com.pomotask.pomotask.app.dto.mapper.TimerMapper;
import com.pomotask.pomotask.app.dto.view.TimerView;
import com.pomotask.pomotask.app.model.TimerModel;
import com.pomotask.pomotask.app.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

import static com.pomotask.pomotask.util.VersionUtil.API_VERSION_FOR_URL;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = API_VERSION_FOR_URL + "/timers")
public class TimerResource {


    final private TimerService service;
    final private TimerMapper mapper;


    @Autowired
    public TimerResource(TimerService service, TimerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    @GetMapping
    public ResponseEntity<CollectionModel<TimerView>> findAll(
            @AuthenticationPrincipal(expression = "userId") Integer userId) {
        Set<TimerModel> modelSet = this.service.findAllByUserId(userId);
        Set<TimerView> viewSet = modelSet
                .stream()
                .map(obj -> {
                    TimerView view = this.mapper.toView(obj);
                    view.add(makeLinkToWithSelfRel(userId, obj.getId()));
                    return view;
                }).collect(Collectors.toSet());
        CollectionModel<TimerView> collectionView = CollectionModel.of(viewSet);
        collectionView.add(makeLinkToWithCollectionRel(userId));
        return ResponseEntity.ok().body(collectionView);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TimerView> find(
            @AuthenticationPrincipal(expression = "userId") Integer userId,
            @PathVariable Integer id) {
        TimerModel model = this.service.findByUserIdAndId(userId, id);
        TimerView view = this.mapper.toView(model);
        view.add(makeLinkToWithSelfRel(userId, model.getId()));
        view.add(makeLinkToWithCollectionRel(userId));
        return ResponseEntity.ok().body(view);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(
            @AuthenticationPrincipal(expression = "userId") Integer userId,
            @Valid @RequestBody TimerForm form,
            @PathVariable Integer id) {
        this.service.update(userId, id, form);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(
            @AuthenticationPrincipal(expression = "userId") Integer userId,
            @PathVariable Integer id) {
        this.service.deleteByUserIdAndId(userId, id);
        return ResponseEntity.noContent().build();
    }

    private static Link makeLinkToWithSelfRel(Integer userId, Integer id) {
        return linkTo(methodOn(TimerResource.class).find(userId, id))
                .withSelfRel();
    }

    private static Link makeLinkToWithCollectionRel(Integer userId) {
        return linkTo(methodOn(TimerResource.class).findAll(userId))
                .withRel(IanaLinkRelations.COLLECTION);
    }

}