//package com.trakknamur.springRecap.util;
//
//import com.trakknamur.springRecap.models.dtos.ParcoursDTO;
//import com.trakknamur.springRecap.models.forms.TrouForm;
//import com.trakknamur.springRecap.services.ParcoursService;
//import org.springframework.stereotype.Component;
//
//@Component
//@Deprecated
//public class GolfUtils {
//
//    private final ParcoursService parcoursService;
//
//    public GolfUtils(ParcoursService parcoursService) {
//        this.parcoursService = parcoursService;
//    }
//
//    public boolean checkIfNbHolesNotExceededTypeParcours(TrouForm trou) {
//
//        ParcoursDTO parcoursDTO = parcoursService.getOne(trou.getIdParcours());
//
//        int nbHoles = parcoursDTO.getTrous().size();
//
//        return nbHoles < parcoursDTO.getTypeParcours().getNbHoles();
//    }
//
//}
