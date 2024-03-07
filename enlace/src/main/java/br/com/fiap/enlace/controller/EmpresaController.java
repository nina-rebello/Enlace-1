package br.com.fiap.enlace.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.enlace.model.Empresa;



@RestController
@RequestMapping("empresa")
public class EmpresaController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Empresa> repository = new ArrayList<>();
    
    @GetMapping
    public List<Empresa> index(){
        return repository;
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa){
        log.info("Cadastrando empresa {}", empresa);
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

        // stream
        var empresaEncontrada = getEmpresaById(id);

        if(empresaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(empresaEncontrada.get());  

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("apagando empresa {}", id);

        var empresaEncontrada = getEmpresaById(id);

        if(empresaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        repository.remove(empresaEncontrada.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody Empresa empresa){
        log.info("Atualiza empresa {} para {}", id, empresa);

        // busca a categoria antiga -> 404
        var empresaEncontrada = getEmpresaById(id);

        if (empresaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        var empresaAntiga = empresaEncontrada.get();

        // criar a categoria nova com os dados atualizados
        var empresaNova = new Empresa(id, empresa.nome(), empresa.icone());

        // apagar a categoria antiga
        repository.remove(empresaAntiga);

        // adicionar a categoria nova
        repository.add(empresaNova);

        return ResponseEntity.ok(empresaNova);
    }

    private Optional<Empresa> getEmpresaById(Long id) {
        var empresaEncontrada = repository
                .stream()
                .filter(e -> e.id().equals(id))
                .findFirst();
        return empresaEncontrada;
    }
    
}
