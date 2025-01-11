package com.api.cep;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.api.cep.controller.UsuariosController;
import com.api.cep.entity.Usuarios;
import com.api.cep.service.UsuariosService;

@WebMvcTest(UsuariosController.class)
class UsuariosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private UsuariosService usuariosService;

    @Test
    void testCreateUsuario() throws Exception {
        Usuarios usuario = new Usuarios();
        usuario.setNome("João Silva");
        usuario.setCpf("12345678900");
        usuario.setCep("12345-678");

        when(usuariosService.createOrUpdate(any(Usuarios.class))).thenReturn(usuario);

        mockMvc.perform(post("/api/usuarios/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "nome": "João Silva",
                            "cpf": "12345678900",
                            "cep": "12345-678"
                        }
                        """))
                .andExpect(status().isNoContent());

        verify(usuariosService, times(1)).createOrUpdate(any(Usuarios.class));
    }

    @Test
    void testCreateInvalidUsuario() throws Exception {
        when(usuariosService.createOrUpdate(any(Usuarios.class))).thenThrow(new IllegalArgumentException("CPF é obrigatório"));

        mockMvc.perform(post("/api/usuarios/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "nome": "João Silva",
                            "cep": "12345-678",
                            "cpf: ""
                        }
                        """))
                .andExpect(status().isBadRequest());
    }
}
