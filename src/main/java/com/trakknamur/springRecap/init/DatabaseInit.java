package com.trakknamur.springRecap.init;

import com.trakknamur.springRecap.models.forms.UserForm;
import com.trakknamur.springRecap.services.impl.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class DatabaseInit implements InitializingBean {

//    private final ParcoursService parcoursService;
//
//    private final TrouService trouService;

    private final UserDetailsServiceImpl userDetailsService;

    public DatabaseInit(/*ParcoursService parcoursService, TrouService trouService, */UserDetailsServiceImpl userDetailsService) {
//        this.parcoursService = parcoursService;
//        this.trouService = trouService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void afterPropertiesSet() /*throws Exception */{

        log.info("INITIALISATION DES DONNEES DE DEMARRAGE");

        // Création d'un principal ADMIN pour l'initialisation des données (appel de la méthode protégée du service UserDetailsServiceImpl::insert)
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                "admin_init", "1234", Arrays.asList(
                new SimpleGrantedAuthority("USER"),
                new SimpleGrantedAuthority("ADMIN"))
        );
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(authenticationToken);

        log.info("CHARGEMENT DES UTILISATEURS");

        List<UserForm> users = Arrays.asList(
                UserForm.builder()
                        .username("greg")
                        .password("1234")
                        .email("nae@mail.com")
                        .address("some address")
                        .deliveryAddress("some address")
                        .roles(Collections.singletonList(
                                "USER"
                        ))
                        .build(),
                UserForm.builder()
                        .username("admin")
                        .password("1234")
                        .email("nae@mail.com")
                        .address("some address")
                        .deliveryAddress("some address")
                        .roles(Arrays.asList(
                                "USER", "ADMIN"
                        ))
                        .build()
        );

        users.forEach(this.userDetailsService::insert);

//        log.info("CHARGEMENT DES PARCOURS");
//
//
//        List<ParcoursForm> list = Arrays.asList(
//                ParcoursForm.builder()
//                        .nom("Golf de LLN")
//                        .email("golf@lln.be")
//                        .typeParcours(TypeParcours.TROU_18)
//                        .build(),
//                ParcoursForm.builder()
//                        .nom("Golf de la Bawette")
//                        .email("golf@bawette.be")
//                        .typeParcours(TypeParcours.TROU_18)
//                        .build(),
//                ParcoursForm.builder()
//                        .nom("Golf d'Avernas le Baudouin")
//                        .email("golf@avernas.be")
//                        .typeParcours(TypeParcours.TROU_9)
//                        .build()
//        );
//
//        list.forEach(this.parcoursService::insert);
//
//        log.info("CHARGEMENT DES TROUS");
//
//
//        // Récupérer la liste des parcours fraichement créée
//        List<ParcoursDTO> parcours = this.parcoursService.getAll();
//
//        // Affectations des trous pour le parcours 0
//        List<TrouForm> trouFormList0 = Arrays.asList(
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_3)
//                        .distance(142)
//                        .idParcours(parcours.get(0).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_4)
//                        .distance(295)
//                        .idParcours(parcours.get(0).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_5)
//                        .distance(425)
//                        .idParcours(parcours.get(0).getId())
//                        .build()
//        );
//
//        trouFormList0.forEach(trouForm -> {
//                    try {
//                        this.trouService.insert(trouForm);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//        );
//
//
//        // Affectations des trous pour le parcours 1
//        List<TrouForm> trouFormList1 = Arrays.asList(
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_3)
//                        .distance(168)
//                        .idParcours(parcours.get(1).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_4)
//                        .distance(324)
//                        .idParcours(parcours.get(1).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_5)
//                        .distance(456)
//                        .idParcours(parcours.get(1).getId())
//                        .build()
//        );
//        trouFormList1.forEach(trouForm -> {
//            try {
//                this.trouService.insert(trouForm);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//        // Affectation des trous pour le parcours 2
//        List<TrouForm> trouFormList2 = Arrays.asList(
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_3)
//                        .distance(118)
//                        .idParcours(parcours.get(2).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_4)
//                        .distance(278)
//                        .idParcours(parcours.get(2).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_5)
//                        .distance(500)
//                        .idParcours(parcours.get(2).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_3)
//                        .distance(118)
//                        .idParcours(parcours.get(2).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_4)
//                        .distance(278)
//                        .idParcours(parcours.get(2).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_5)
//                        .distance(500)
//                        .idParcours(parcours.get(2).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_3)
//                        .distance(118)
//                        .idParcours(parcours.get(2).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_4)
//                        .distance(278)
//                        .idParcours(parcours.get(2).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_5)
//                        .distance(500)
//                        .idParcours(parcours.get(2).getId())
//                        .build(),
//                TrouForm.builder()
//                        .typeTrou(TypeTrou.PAR_5)
//                        .distance(400)
//                        .idParcours(parcours.get(2).getId())
//                        .build()
//        );
//
//        trouFormList2.forEach(trouForm -> {
//            try {
//                this.trouService.insert(trouForm);
//            } catch (Exception e) {
////                e.printStackTrace();
//            }
//        });

    }
}
