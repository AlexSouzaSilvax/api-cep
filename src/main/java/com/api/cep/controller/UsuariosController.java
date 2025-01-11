package com.api.cep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cep.entity.Usuarios;
import com.api.cep.service.UsuariosService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuários", description = "Endereços de usuários")
@CrossOrigin
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("find-all")
    public ResponseEntity<List<Usuarios>> findAll() {
        return ResponseEntity.ok(usuariosService.findAll());
    }

    @PostMapping("create")
    public ResponseEntity<Object> createOrUpdate(@Valid @RequestBody Usuarios usuario) throws Exception {
        return ResponseEntity.ok(usuariosService.createOrUpdate(usuario));
    }

    @PostMapping("delete")
    public ResponseEntity<Object> delete(@RequestBody String id) {
        usuariosService.delete(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/check-cpf/{cpf}")
    public ResponseEntity<Boolean> checkCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(usuariosService.existsByCpf(cpf));
    }

}
