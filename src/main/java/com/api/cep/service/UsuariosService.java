package com.api.cep.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.cep.entity.Usuarios;
import com.api.cep.repository.UsuariosRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;

    @Transactional
    @SuppressWarnings("UseSpecificCatch")
    public Usuarios createOrUpdate(Usuarios usuario) throws Exception {

        String msgAcaoMetodo = "salvar";

        try {

            if (usuario.getId() != null) {

                msgAcaoMetodo = "atualizar";

                boolean exists = usuariosRepository.existsById(usuario.getId());

                if (!exists) {
                    throw new EntityNotFoundException("Usuário não existente: " + usuario.getId());
                }

                usuario.setDataAtualizacao(LocalDateTime.now());

            } else {
                usuario.setDataCriacao(LocalDateTime.now());
            }

            return usuariosRepository.save(usuario);

        } catch (Exception e) {
            throw new Exception("Erro ao " + msgAcaoMetodo + " o usuário. " + e.getMessage(), e);
        }

    }

    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        if (!usuariosRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não existente: " + id);
        }
        usuariosRepository.deleteById(id);
    }

    public boolean existsByCpf(String cpf) {
        return usuariosRepository.existsByCpf(cpf);
    }

}
