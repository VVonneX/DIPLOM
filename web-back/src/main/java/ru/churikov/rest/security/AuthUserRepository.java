package ru.churikov.rest.security;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthUserRepository extends CrudRepository<AuthUser, Long> {
    Optional<AuthUser> findByUsername(String aString); // сохдает sql запрос, который ищет пользователя по юзер найм
}
// интерфейс для генерации репозитория (пишет sql за меня)
