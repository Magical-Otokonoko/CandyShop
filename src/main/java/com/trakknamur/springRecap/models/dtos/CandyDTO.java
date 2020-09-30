package com.trakknamur.springRecap.models.dtos;

import com.trakknamur.springRecap.models.entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandyDTO {
    Long id;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    String label;

    int weight;

    float price;

    Set<Tag> tags;

}
