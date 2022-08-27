package com.pomotask.pomotask.app.resource.hateoas_entry_point;

import com.pomotask.pomotask.app.dto.view.RootEntryPointView;
import com.pomotask.pomotask.app.resource.TimerManagerResource;
import com.pomotask.pomotask.app.resource.TimerResource;
import com.pomotask.pomotask.util.VersionUtil;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(VersionUtil.API_VERSION_FOR_URL)
public class RootEntryPointResource {


    @GetMapping
    public ResponseEntity<RootEntryPointView> root() {
        return ResponseEntity.ok().body(makeRootEntryPointView());
    }

    private static RootEntryPointView makeRootEntryPointView() {
        RootEntryPointView view = new RootEntryPointView();
        view.add(linkTo(methodOn(TimerManagerResource.class)
                .findAll(0))
                .withRel(IanaLinkRelations.COLLECTION));
        view.add(linkTo(methodOn(TimerResource.class)
                .findAll(0))
                .withRel(IanaLinkRelations.COLLECTION));
        return view;
    }

}
