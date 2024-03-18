package br.com.fiap.enlace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.enlace.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {


    
}
