package com.api.cep;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.api.cep.entity.Usuarios;
import com.api.cep.repository.UsuariosRepository;
import com.api.cep.service.UsuariosService;

public class UsuariosServiceTest {

    @InjectMocks
    private UsuariosService usuariosService;

    @Mock
    private UsuariosRepository usuariosRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrUpdate_NewUser() throws Exception {
        Usuarios usuario = new Usuarios();
        usuario.setNome("Novo Usuário");
        usuario.setCpf("12345678901");

        when(usuariosRepository.save(any(Usuarios.class))).thenReturn(usuario);

        Usuarios result = usuariosService.createOrUpdate(usuario);

        assertNotNull(result);
        assertEquals("Novo Usuário", result.getNome());
        verify(usuariosRepository, times(1)).save(any(Usuarios.class));
    }

    @Test
    void testCreateOrUpdate_UpdateExistingUser() {
        Usuarios existingUser = new Usuarios();
        existingUser.setId(1L);
        existingUser.setNome("Usuário Atualizado");
        existingUser.setCpf("12345678901");

        when(usuariosRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(usuariosRepository.save(any(Usuarios.class))).thenReturn(existingUser);

        Usuarios result = usuariosRepository.save(existingUser);

        assertNotNull(result);
        assertEquals("Usuário Atualizado", result.getNome());
        verify(usuariosRepository, times(1)).save(any(Usuarios.class));
    }

    @Test
    void testCreateOrUpdate_UserNotFound() {
        Usuarios nonExistingUser = new Usuarios();
        nonExistingUser.setId(99L);

        when(usuariosRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> usuariosService.createOrUpdate(nonExistingUser));
        verify(usuariosRepository, times(0)).findById(99L);
        verify(usuariosRepository, times(0)).save(any(Usuarios.class));
    }
}
