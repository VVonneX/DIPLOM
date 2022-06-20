package ru.churikov.rest.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.churikov.rest.db.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Collections;

@Setter
@Getter
@Entity
@Table(name = "user_entity")
@NoArgsConstructor
public class AuthUser extends BaseEntity implements UserDetails {
    static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public AuthUser(boolean enabled, String username, String password, Role role) {
        this.password = passwordEncoder.encode(password);
        this.enabled = enabled;
        this.username = username;
        this.role = role;
    } //объект о хранение информации пользователя в бд

    private String username;
    private boolean enabled;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    // в базе данных храниться строка, а в заимодействие происходит как с enum

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
    }
    //возвращает список прав пользователей

    @Override
    public boolean isAccountNonExpired() {
        return true;
    } // проверка, что аккаунт не истек

    @Override
    public boolean isAccountNonLocked() {
        return true;
    } // проверка, что аккаунт не заблокирован

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    } // проверка, что права доступа не истекли
}