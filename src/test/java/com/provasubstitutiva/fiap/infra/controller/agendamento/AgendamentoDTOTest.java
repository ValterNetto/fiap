import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

import com.provasubstitutiva.fiap.domain.model.Agendamento;
import com.provasubstitutiva.fiap.domain.model.constant.StatusEnum;
import com.provasubstitutiva.fiap.infra.controller.agendamento.AgendamentoDTO;

public class AgendamentoDTOTest {

    @Test
    void deveConstruirDTOCorretamenteAPartirDeAgendamento() {
        LocalDate data = LocalDate.of(2025, 1, 1);
        LocalTime inicio = LocalTime.of(10, 0);
        LocalTime fim = LocalTime.of(11, 0);

        Agendamento agendamento = new Agendamento(
                1L,
                2L,
                3L,
                4L,
                5L,
                StatusEnum.AGENDADO,
                data,
                inicio,
                fim
        );

        AgendamentoDTO dto = new AgendamentoDTO(agendamento);

        assertEquals(1L, dto.id());
        assertEquals(2L, dto.idProfissional());
        assertEquals(3L, dto.idEstabelecimento());
        assertEquals(4L, dto.idCliente());
        assertEquals(5L, dto.idServico());
        assertEquals(StatusEnum.AGENDADO, dto.status());
        assertEquals(data, dto.data());
        assertEquals(inicio, dto.horaInicio());
        assertEquals(fim, dto.horaTermino());
    }
}
