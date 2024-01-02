package com.api.vuttr.service;

import com.api.vuttr.domain.DTO.ToolsResponse;
import com.api.vuttr.domain.Tools;
import com.api.vuttr.repository.ToolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolsService {
    @Autowired
    private final ToolsRepository repository;

    public ToolsService(ToolsRepository repository) {
        this.repository = repository;
    }

    public List<Tools> getAll(){
        List<Tools> listAll = repository.findAll();
        return listAll;
    }
    public List<Tools> findToolsByTag(String tag){
        List<Tools> toolsList = repository.findByTags(tag);
        return toolsList;
    }
    public ToolsResponse saveTool(Tools tools){
        Tools toolsSaved = repository.save(tools);

        ToolsResponse toolsResponse = new ToolsResponse(
                toolsSaved.getId(),
                toolsSaved.getTitle(),
                toolsSaved.getLink(),
                toolsSaved.getDescription(),
                toolsSaved.getTags());

        return toolsResponse;
    }
    public void deleteToolId(Long id){
        repository.deleteById(id);
    }
}
