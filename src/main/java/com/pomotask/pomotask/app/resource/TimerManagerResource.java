package com.pomotask.pomotask.app.resource;

import com.pomotask.pomotask.app.dto.form.TimerManagerForm;
import com.pomotask.pomotask.app.dto.mapper.TimerManagerMapper;
import com.pomotask.pomotask.app.dto.mapper.TimerMapper;
import com.pomotask.pomotask.app.dto.view.TimerManagerView;
import com.pomotask.pomotask.app.model.TimerManagerModel;
import com.pomotask.pomotask.app.service.TimerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Set;
import java.util.stream.Collectors;

import static com.pomotask.pomotask.util.VersionUtil.API_VERSION_FOR_URL;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = API_VERSION_FOR_URL + "/timer-managers")
public class TimerManagerResource {


    final private TimerManagerService service;
    final private TimerManagerMapper mapper;
    final private TimerMapper timerMapper;


    @Autowired
    public TimerManagerResource(TimerManagerService service, TimerManagerMapper mapper, TimerMapper timerMapper) {
        this.service = service;
        this.mapper = mapper;
        this.timerMapper = timerMapper;
    }


    @GetMapping
    public ResponseEntity<CollectionModel<TimerManagerView>> findAll(
            @AuthenticationPrincipal(expression = "userId") Integer userId) {
        Set<TimerManagerModel> modelSet = this.service.findAllByUserId(userId);
        Set<TimerManagerView> viewSet = modelSet
                .stream()
                .map(obj -> {
                    TimerManagerView view = this.mapper.toView(obj);
                    view.add(makeLinkToWithSelfRel(userId, obj.getId()));
                    return view;
                }).collect(Collectors.toSet());
        CollectionModel<TimerManagerView> collectionView = CollectionModel.of(viewSet);
        collectionView.add(makeLinkToWithCollectionRel(userId));
        return ResponseEntity.ok().body(collectionView);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TimerManagerView> find(
            @AuthenticationPrincipal(expression = "userId") Integer userId,
            @PathVariable Integer id) {
        TimerManagerModel model = this.service.findByUserIdAndId(userId, id);
        TimerManagerView view = this.mapper.toView(model);
        model.getTimerSet().forEach(obj -> view.getTimerList().add(this.timerMapper.toView(obj)));
        view.add(makeLinkToWithSelfRel(userId, model.getId()));
        view.add(makeLinkToWithCollectionRel(userId));
        return ResponseEntity.ok().body(view);
    }

    @PostMapping
    public ResponseEntity<Void> insert(
            @AuthenticationPrincipal(expression = "userId") Integer userId,
            @Valid @RequestBody TimerManagerForm form) {
        TimerManagerModel obj = this.service.insert(userId, form);
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
            @Valid @RequestBody TimerManagerForm form,
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
        return linkTo(methodOn(TimerManagerResource.class).find(userId, id))
                .withSelfRel();
    }

    private static Link makeLinkToWithCollectionRel(Integer userId) {
        return linkTo(methodOn(TimerManagerResource.class).findAll(userId))
                .withRel(IanaLinkRelations.COLLECTION);
    }

}
