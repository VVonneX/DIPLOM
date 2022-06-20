package ru.churikov.rest.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FeedDto {

    private Long id;
    private String name;
    private String description;

    public static List<FeedDto> entityToDtoList(List <Feed> list) {
        return list.stream().map(FeedDto::entityToDto).collect(Collectors.toList());
    }
    // объект для отправки заметки по http

    public static FeedDto entityToDto(Feed feed) {
        FeedDto dto = new FeedDto();
        dto.setId(feed.getId());
        dto.setName(feed.getName());
        dto.setDescription(feed.getDescription());
        return dto;
    }
    // методы Mapping из сущности базы данных в сущность отправки по http

    public static Feed DtoToEntity(FeedDto dto) {
        Feed feed = new Feed();
        feed.setId(dto.getId());
        feed.setDescription(dto.getDescription());
        feed.setName(dto.getName());
        return feed;
    }
    // методы Mapping из сущность отправки по http в сущности базы данных
}
