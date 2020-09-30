package com.trakknamur.springRecap.controlers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseController<TFORM, DTO, TID> {

    ResponseEntity<List<DTO>> getAll();

    ResponseEntity<DTO> getOne(TID id);

    ResponseEntity<DTO> insert(TFORM form) throws Exception;

    ResponseEntity<String> delete(TID id);

    ResponseEntity<DTO> update(TFORM form, TID id);

}
