package com.pomotask.pomotask.app.resource.hateoas;

import com.pomotask.pomotask.app.dto.view.RootEntryPointView;
import com.pomotask.pomotask.app.resource.hateoas.util.HateoasUtil;
import com.pomotask.pomotask.util.VersionUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(VersionUtil.API_VERSION_FOR_URL)
public class RootEntryPointResource {


    @GetMapping
    public ResponseEntity<RootEntryPointView> root() {
        return ResponseEntity.ok().body(
                HateoasUtil.makeRootEntryPointView());
    }

}
