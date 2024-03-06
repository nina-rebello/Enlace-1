package br.com.fiap.enlace.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.enlace.model.Empresa;



@RestController
@RequestMapping("categoria")
public class EmpresaController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Empresa> repository = new ArrayList<>();
    
    @GetMapping
    public List<Empresa> index(){
        return repository;
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa){
        log.info("Cadastrando categoria {}", empresa);
        repository.add(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> show(@PathVariable Long id){
        log.info("buscando empresa com id {}", id);

        for(Empresa empresa: repository){
            if (empresa.id().equals(id))
                return ResponseEntity.status(HttpStatus.OK).body(empresa);
        }

        //TODO refatorar com stream

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
}
