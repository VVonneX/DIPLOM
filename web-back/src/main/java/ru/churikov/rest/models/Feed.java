package ru.churikov.rest.models;

import lombok.*;
import ru.churikov.rest.db.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Feed extends BaseEntity {

    private String name;
    private String description;

}
