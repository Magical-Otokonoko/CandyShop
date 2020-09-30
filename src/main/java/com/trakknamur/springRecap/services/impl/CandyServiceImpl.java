package com.trakknamur.springRecap.services.impl;

import com.trakknamur.springRecap.mappers.WebApiMapper;
import com.trakknamur.springRecap.models.dtos.CandyDTO;
import com.trakknamur.springRecap.models.entities.Candy;
import com.trakknamur.springRecap.models.forms.CandyForm;
import com.trakknamur.springRecap.repositories.CandyRepo;
import com.trakknamur.springRecap.services.BaseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@PreAuthorize("hasAuthority('USER')")
public class CandyServiceImpl implements BaseService<CandyDTO, CandyForm, Long> {

    private final CandyRepo candyRepo;

    private final WebApiMapper webApiMapper;

    public CandyServiceImpl(CandyRepo candyRepo, WebApiMapper webApiMapper) {
        this.candyRepo = candyRepo;
        this.webApiMapper = webApiMapper;
    }

    @Override
    public List<CandyDTO> getAll() {
        return this.candyRepo.findAll().stream().map(this.webApiMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CandyDTO getOne(Long id) {
        return this.webApiMapper.toDTO(this.candyRepo.getOne(id));
    }

    @Override
    public boolean insert(CandyForm form) {
        Candy entity = this.webApiMapper.formFormToEntity(form);
        this.candyRepo.save(entity);
        return entity.getIdUser()>0;
    }

    @Override
    public boolean delete(Long id) {
        Candy toDelete = this.candyRepo.getOne(id);
        this.candyRepo.delete(toDelete);
        return !this.candyRepo.findById(toDelete.getIdUser()).isPresent();
    }

    @Override
    public CandyDTO update(CandyForm form, Long id) {
        Candy updated = this.webApiMapper.toEntity(getOne(id));

        updated.setLabel(form.getLabel());
        updated.setWeight(form.getWeight());

        return this.webApiMapper.toDTO(this.candyRepo.save(updated));
    }
}
