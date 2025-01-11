package com.api.cep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.cep.entity.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    @Query(value = "SELECT EXISTS (SELECT 1 FROM Usuarios WHERE cpf = :pCpf ) AS registro_existe", nativeQuery = true)
    boolean existsByCpf(@Param("pCpf") String pCpf);
}
