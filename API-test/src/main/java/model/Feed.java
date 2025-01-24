package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feed { // наследование из класса BaseEntity, чтобы были id
    private Long id;
    private String name;
    private String description;
}

    // заметки

