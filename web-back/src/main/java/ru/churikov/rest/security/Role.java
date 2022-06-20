package ru.churikov.rest.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum Role implements GrantedAuthority {
    SUPER_USER("ROLE_SUPER_USER", "SUPER_USER"), // объект роли для ауинтификации в spring
    USER("ROLE_USER", "USER");

    private final String value;
    private final String role;
    Role(String value, String role) {
        this.value = value;
        this.role = role;
    }


    @Override
    public String getAuthority() {
        return getRole();
    } // возвращает роль
}
