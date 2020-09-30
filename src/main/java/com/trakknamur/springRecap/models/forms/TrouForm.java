package com.trakknamur.springRecap.models.forms;

import com.trakknamur.springRecap.models.enums.TypeTrou;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Deprecated
public class TrouForm {

    TypeTrou typeTrou;

    int distance;

    Long idParcours;
}
