package com.pomotask.pomotask.app.resource.hateoas.util;

import com.pomotask.pomotask.app.dto.view.RootEntryPointView;
import com.pomotask.pomotask.app.resource.*;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class HateoasUtil {


    public static Link makeLinkToWithSelfRel(AbsResource currClass, Integer userId, Integer id) {
        return linkTo(methodOn(currClass.getClass()).find(userId, id))
                .withSelfRel();
    }

    public static Link makeLinkToWithSelfRel(AbsResource currClass, Integer userId) {
        return linkTo(methodOn(currClass.getClass()).findAll(userId))
                .withSelfRel();
    }

    public static Link makeLinkToWithCollectionRel(AbsResource currClass, Integer userId) {
        return linkTo(methodOn(currClass.getClass()).findAll(userId))
                .withRel(IanaLinkRelations.COLLECTION);
    }

    public static RootEntryPointView makeRootEntryPointView() {
        RootEntryPointView view = new RootEntryPointView();
        view.add(linkTo(methodOn(TaskResource.class)
                .findAll(0))
                .withRel(IanaLinkRelations.COLLECTION));
        view.add(linkTo(methodOn(TimerManagerResource.class)
                .findAll(0))
                .withRel(IanaLinkRelations.COLLECTION));
        view.add(linkTo(methodOn(TimerResource.class)
                .findAll(0))
                .withRel(IanaLinkRelations.COLLECTION));
        return view;
    }

}
