package med.voll.api.Pacientes;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Endereco.DadosEndereco;

public record DadosAttPacientes(

        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEndereco endereco

) {
}
