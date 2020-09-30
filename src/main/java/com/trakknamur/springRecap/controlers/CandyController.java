package com.trakknamur.springRecap.controlers;

import com.trakknamur.springRecap.models.dtos.CandyDTO;
import com.trakknamur.springRecap.models.forms.CandyForm;
import com.trakknamur.springRecap.services.impl.CandyServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/candies")
@PreAuthorize("hasAuthority('USER')")
public class CandyController {
    private final CandyServiceImpl candyService;

    public CandyController(CandyServiceImpl candyService) {
        this.candyService = candyService;
    }
    
    @GetMapping
    public ResponseEntity<List<CandyDTO>> getAll() {
        return ResponseEntity.ok(this.candyService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CandyDTO> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.candyService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> postCandy(@RequestBody CandyForm form) {
        boolean inserted = this.candyService.insert(form);
        return inserted ? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CandyDTO> updateCandy(@RequestBody CandyForm candyForm, @PathVariable("id") Long id) {
        return ResponseEntity.ok(this.candyService.update(candyForm, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteCandy(@PathVariable("id") Long id) {
        boolean deleted = this.candyService.delete(id);
        return deleted ? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }


}
