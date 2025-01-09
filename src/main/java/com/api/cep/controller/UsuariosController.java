package com.api.cep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("save")
    public ResponseEntity<Object> saveOrUpdate(@Valid @RequestBody Usuarios usuario) throws Exception {
        usuariosService.saveOrUpdate(usuario);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("delete")
    public ResponseEntity<Object> delete(@RequestBody Long id) {
        usuariosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
