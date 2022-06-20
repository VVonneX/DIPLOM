package ru.churikov.rest.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.churikov.rest.models.Feed;

import java.util.Optional;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Long> {
    Optional <Feed> findOneById(Long id); //сохдает sql запрос, который ищет заметку по id
}

// интерфейс для генерации репозитория (пишет sql за меня)
