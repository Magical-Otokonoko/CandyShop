package com.trakknamur.springRecap.models.forms;

import com.trakknamur.springRecap.models.entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandyForm {

    String label;

    int weight;

    float price;

    Set<Tag> tags;

}
