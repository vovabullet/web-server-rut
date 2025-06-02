package ru.autoservice.kurs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.autoservice.kurs.entity.Entity2;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/entity2")
public class Entity2Controller {

    private List<Entity2> entities = new ArrayList<>();

    @PostMapping
    public void addEntities() {
        for (int i = 0; i < 3; i++) {
            Entity2 entity = new Entity2();
            entity.setId((long) (entities.size() + 1));
            entity.setDescription("Entity " + (entities.size() + 1));
            entities.add(entity);
        }
    }

    @GetMapping
    public List<Entity2> getAllEntities() {
        return entities;
    }
}