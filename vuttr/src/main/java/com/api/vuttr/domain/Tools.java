package com.api.vuttr.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity(name = "tools")
@Table(name = "tools")
public class Tools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String link;
    private String description;

    private List<String> tags;

    public Tools(Long id, String title, String link, String description, List<String> tags) {
        this.id = id;
        this.link = link;
        this.title = title;
        this.description = description;
        this.tags = tags;
    }
    public Tools(){

    }

    public Tools(String title, String link, String description, List<String> tags) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.tags = tags;
    }
}
