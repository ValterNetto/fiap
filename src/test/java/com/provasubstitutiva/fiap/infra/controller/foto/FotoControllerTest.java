package com.provasubstitutiva.fiap.infra.controller.foto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.provasubstitutiva.fiap.application.usecase.foto.impl.AdicionarFotoImpl;
import com.provasubstitutiva.fiap.application.usecase.foto.impl.BuscarFotosPorIdEstabelecimentoImpl;
import com.provasubstitutiva.fiap.application.usecase.foto.impl.ExcluirFotoImpl;
import com.provasubstitutiva.fiap.domain.model.Foto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FotoController.class)
class FotoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdicionarFotoImpl adicionarFoto;

    @MockBean
    private BuscarFotosPorIdEstabelecimentoImpl buscarFotosPorIdEstabelecimento;

    @MockBean
    private ExcluirFotoImpl excluirFoto;

    @Autowired
    private ObjectMapper objectMapper;

    private Foto getFoto() {
        return new Foto(1L, "fachada", "base64image", 10L);
    }

    private FotoDTO getDTO() {
        return new FotoDTO(1L, "fachada", "base64image", 10L);
    }

    @Test
    void testAdicionarFoto() throws Exception {
        Mockito.when(adicionarFoto.adicionarFoto(any())).thenReturn(getFoto());

        mockMvc.perform(post("/fotos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getDTO())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("fachada"))
                .andExpect(jsonPath("$.idEstabelecimento").value(10L));
    }

    @Test
    void testBuscarFotos() throws Exception {
        Mockito.when(buscarFotosPorIdEstabelecimento.buscarFotoPorIdEstabelecimento(10L))
                .thenReturn(List.of(getFoto()));

        mockMvc.perform(get("/fotos?idEstabelecimento=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].foto").value("base64image"));
    }

    @Test
    void testExcluirFoto() throws Exception {
        mockMvc.perform(delete("/fotos/1"))
                .andExpect(status().isOk());

        Mockito.verify(excluirFoto).excluir(1L);
    }
}
