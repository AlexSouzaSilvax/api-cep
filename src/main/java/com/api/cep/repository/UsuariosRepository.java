package com.api.cep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cep.entity.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    
}
