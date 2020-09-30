package com.trakknamur.springRecap.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(nullable = false, unique = true)
    String label;

    @Column(nullable = false)
    int weight;

    @Column(nullable = false)
    float price;

    @ManyToMany()
    Set<Tag> tags;
}
