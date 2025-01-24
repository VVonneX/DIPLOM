package ru.churikov.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.churikov.rest.models.Feed;
import ru.churikov.rest.repoitory.FeedRepository;
import ru.churikov.rest.security.AuthUser;
import ru.churikov.rest.security.AuthUserRepository;
import ru.churikov.rest.security.Role;

@Component
public class Initializer {

    @Autowired
    private AuthUserRepository authUserRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FeedRepository feedRepository;


    public void initial(){
        objectMapper.registerModule(new Jdk8Module());
        authUserRepo.deleteAll();
        AuthUser admin = new AuthUser(true, "admin", "1234", Role.SUPER_USER);
        AuthUser user = new AuthUser(true, "user", "1234",Role.USER);
        authUserRepo.save(user);
        authUserRepo.save(admin);

        feedRepository.save(new Feed("Заметка 1", "Описновная заметка"));
        feedRepository.save(new Feed("Заметка 1", "Описание заметки 1"));
        feedRepository.save(new Feed("Заметка 1", "Описание заметки 1"));
        feedRepository.save(new Feed("Заметка 1", "Описание заметки 1"));
        feedRepository.save(new Feed("Заметка 1", "Описание заметки 1"));
    }
    // инициализирует записи в базе данных
}
