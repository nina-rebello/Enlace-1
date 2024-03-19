package br.com.fiap.enlace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.enlace.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
}
