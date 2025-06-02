package ru.autoservice.kurs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.autoservice.kurs.entity.Entity1;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/entity1")
public class Entity1Controller {

    private List<Entity1> entities = new ArrayList<>();

    @PostMapping
    public void addEntities() {
        for (int i = 0; i < 3; i++) {
            Entity1 entity = new Entity1();
            entity.setId((long) (entities.size() + 1));
            entity.setName("Entity " + (entities.size() + 1));
            entities.add(entity);
        }
    }

    @GetMapping
    public List<Entity1> getAllEntities() {
        return entities;
    }
}
