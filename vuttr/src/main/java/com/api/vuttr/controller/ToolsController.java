package com.api.vuttr.controller;

import com.api.vuttr.domain.DTO.ToolsDTO;
import com.api.vuttr.domain.DTO.ToolsResponse;
import com.api.vuttr.domain.Tools;
import com.api.vuttr.service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolsController {
    @Autowired
    private ToolsService service;


    @GetMapping
    public ResponseEntity findALL(){
        List<Tools> allTools = service.getAll();

        return ResponseEntity.ok().body(allTools);
    }
    @GetMapping("/findByTag")
    public ResponseEntity findToolsByTags(@RequestParam String tags){
        List<Tools> toolsList = service.findToolsByTag(tags);

        return ResponseEntity.ok().body(toolsList);
    }
    @PostMapping
    public ResponseEntity postTools(@RequestBody ToolsDTO toolsDTO){
        Tools toolsToBepost = toolsDTO.toType();

        ToolsResponse toolsResponse = service.saveTool(toolsToBepost);


        URI headerlocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(toolsResponse.id())
                .toUri();

        return ResponseEntity.created(headerlocation).body(toolsResponse);
    }

    @DeleteMapping
    public ResponseEntity deleteTools(@RequestParam Long id){
        service.deleteToolId(id);

        return ResponseEntity.ok().body("Deleted Tools");
    }
}
