package ru.churikov.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.churikov.rest.models.FeedDto;
import ru.churikov.rest.service.FeedService;

import java.util.List;

@RestController
@RequestMapping("api/feed")
public class FeedController {

   /* @GetMapping(value = "Hello")
     String getHello() {
        return "Hello";
    }
*/
    @Autowired
    private FeedService feedService;

    @GetMapping(value = "/all")
    List <FeedDto> getAllFeed() {
        return FeedDto.entityToDtoList(feedService.getAllFeed());
    }
    // данная конструкция нажна для того, чтобы отвечать на запросы, в данном случае, он у нас получает список всех заметок
    @GetMapping("/{id}")
    FeedDto getOneById(@PathVariable("id") Long id) {
        return FeedDto.entityToDto(feedService.getOntById(id));
    }
    // получение 1 конкретной заметки по ее id

    @PostMapping
    FeedDto createOrEdit(@RequestBody FeedDto dto) {
        return FeedDto.entityToDto(feedService.save(FeedDto.DtoToEntity(dto)));
    }
    //сохранение или изменение заметики

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id) {
        feedService.delete(id);
    }
    //удаление заметки

}
