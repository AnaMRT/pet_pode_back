
package app.pet_pode_back.controller;

import app.pet_pode_back.model.Plantas;
import app.pet_pode_back.service.PlantaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "plantas")
public class PlantaController {


    @Autowired
    private PlantaService plantaService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Plantas>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(plantaService.listarTodos());
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plantas> adicionar(@RequestBody @Valid Plantas plantas) {
        return ResponseEntity.status(HttpStatus.CREATED).body(plantaService.cadastrar(plantas));
    }


    @GetMapping(value = {"consulta-nomePopular"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Plantas>> getNomePopular(@RequestParam("nomePopular") String nomePopular) {
        return ResponseEntity.status(HttpStatus.OK).body(plantaService.findByNomePoular(nomePopular));
    }

    @GetMapping(value = {"consulta-nomeCientifico"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Plantas>> getNomeCientifico(@RequestParam("nomeCientifico") String nomeCientifico) {
        return ResponseEntity.status(HttpStatus.OK).body(plantaService.findByNomeCientifico(nomeCientifico));
    }

}


