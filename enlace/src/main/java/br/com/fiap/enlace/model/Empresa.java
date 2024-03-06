package br.com.fiap.enlace.model;

import java.util.Random;

public record Empresa(Long id, String nome, String icone) {
    public Empresa(Long id, String nome, String icone){
        this.id = Math.abs( new Random().nextLong() );
        this.nome = nome;
        this.icone = icone;

    }
    
}
