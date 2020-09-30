package com.trakknamur.springRecap.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Tag {
    @Id
    @Column(unique = true, nullable = false)
    String label;

    @ManyToMany
    Set<Candy> candies;
}
