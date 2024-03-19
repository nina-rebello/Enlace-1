package br.com.fiap.enlace.controller;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.enlace.model.Servico;
import br.com.fiap.enlace.repository.ServicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("servico")
public class ServicoController {

    @Autowired
    ServicoRepository repository;

    @GetMapping
    public List<Servico> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Servico create(@RequestBody @Valid Servico servico){
        return repository.save(servico);
    }
    
}
