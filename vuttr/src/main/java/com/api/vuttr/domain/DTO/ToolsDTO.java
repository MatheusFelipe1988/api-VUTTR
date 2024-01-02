package com.api.vuttr.domain.DTO;

import com.api.vuttr.domain.Tools;

import java.util.List;

public record ToolsDTO(String title, String link, String description, List<String> tags) {
    public Tools toType(){
        return new Tools(title,link,description,tags);
    }
}
