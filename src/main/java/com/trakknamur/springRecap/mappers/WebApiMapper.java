package com.trakknamur.springRecap.mappers;

import com.trakknamur.springRecap.models.dtos.CandyDTO;
import com.trakknamur.springRecap.models.dtos.UserDTO;
import com.trakknamur.springRecap.models.entities.Candy;
import com.trakknamur.springRecap.models.entities.User;
import com.trakknamur.springRecap.models.forms.CandyForm;
import com.trakknamur.springRecap.models.forms.UserForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper()
public interface WebApiMapper {

//    @Mappings({
//            @Mapping(source = "idParcours", target = "id"),
//            @Mapping(target = "nbJoursDepuisCreation", source = "entity", qualifiedByName = "generateNbJours")
//    })
//    ParcoursDTO toDTO(Parcours entity);
//
//    @Mappings({
//            @Mapping(source = "idTrou", target = "id")
//    })
//    TrouDTO toDTO(Trou entity);
//
//    @Named("generateNbJours")
//    default int generateNbDaysFromCreation(Parcours entity) {
//        long temp = Instant.now().getEpochSecond() - entity.getDateCreation().getEpochSecond();
//        return (int) (temp / (60 * 60 * 24) + 1);
//    }
//
//    @Mappings({
//            @Mapping(source = "id", target = "idParcours")
//    })
//    Parcours toEntity(ParcoursDTO dto);
//
//    @Mappings({
//            @Mapping(target = "idTrou", source = "id")
//    })
//    Trou toEntity(TrouDTO dto);
//
//    @Mappings({
//            @Mapping(target = "idTrou", ignore = true),
//            @Mapping(target = "parcours.idParcours", source = "idParcours"),
//    })
//    Trou fromFormToEntity(TrouForm form);
//
//    @Mappings({
//            @Mapping(target = "idParcours", ignore = true),
//            @Mapping(target = "dateCreation", ignore = true),
//            @Mapping(target = "dateModification", ignore = true),
//            @Mapping(target = "trous", ignore = true)
//
//    })
//    Parcours fromFormToEntity(ParcoursForm form);

    @Mappings({
            @Mapping(target = "isAccountNonExpired", ignore = true),
            @Mapping(target = "isAccountNonLocked", ignore = true),
            @Mapping(target = "isCredentialsNonExpired", ignore = true),
            @Mapping(target = "isEnabled", ignore = true),
    })
    UserDTO toDTO(User user);

    @Mappings({
            @Mapping(target = "accountNonExpired", ignore = true),
            @Mapping(target = "accountNonLocked", ignore = true),
            @Mapping(target = "credentialsNonExpired", ignore = true),
            @Mapping(target = "enabled", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "authorities", ignore = true),
    })
    User toEntity(UserDTO dto);

    @Mappings({
            @Mapping(target = "idUser", ignore = true),
            @Mapping(target = "accountNonExpired", ignore = true),
            @Mapping(target = "accountNonLocked", ignore = true),
            @Mapping(target = "credentialsNonExpired", ignore = true),
            @Mapping(target = "enabled", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "authorities", ignore = true),
    })
    User fromFormToEntity(UserForm form);

    @Mappings({})
    CandyDTO toDTO(Candy entity);

    @Mappings({})
    Candy toEntity(CandyDTO dto);

    @Mappings({
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    Candy formFormToEntity(CandyForm form);


}
