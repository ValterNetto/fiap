package com.provasubstitutiva.fiap.infra.controller.agendamento;

import com.provasubstitutiva.fiap.application.usecase.agendamento.impl.BuscarAgendamentosPorProfissionalEDiaImpl;
import com.provasubstitutiva.fiap.application.usecase.agendamento.impl.CancelarAgendamentoImpl;
import com.provasubstitutiva.fiap.application.usecase.agendamento.impl.RealizarAgendamentoImpl;
import com.provasubstitutiva.fiap.domain.model.Agendamento;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@AllArgsConstructor
public class AgendamentoController {

    private final BuscarAgendamentosPorProfissionalEDiaImpl buscarAgendamentosPorProfissionalEDia;
    private final CancelarAgendamentoImpl cancelarAgendamento;
    private final RealizarAgendamentoImpl realizarAgendamento;

    @GetMapping("/profissional/{id}")
    public List<AgendamentoDTO> buscarAgendamentos(@PathVariable("id") Long id, @RequestBody LocalDate localDate) {
        return buscarAgendamentosPorProfissionalEDia.buscarAgendamentos(id, localDate)
                .stream()
                .map(AgendamentoDTO::new)
                .toList();
    }

    @DeleteMapping("cancelar/{id}")
    public AgendamentoDTO cancelar(@PathVariable Long id) {
        return new AgendamentoDTO(cancelarAgendamento.cancelar(id));
    }

    @PostMapping
    public AgendamentoDTO agendar(@RequestBody AgendamentoDTO agendamentoDTO) {
        return new AgendamentoDTO(
                realizarAgendamento.realizarAgendamento(
                        new Agendamento(
                                agendamentoDTO.id(),
                                agendamentoDTO.idProfissional(),
                                agendamentoDTO.idEstabelecimento(),
                                agendamentoDTO.idCliente(),
                                agendamentoDTO.idServico(),
                                agendamentoDTO.status(),
                                agendamentoDTO.data(),
                                agendamentoDTO.horaInicio(),
                                agendamentoDTO.horaTermino()
                        )
                )
        );
    }
}
