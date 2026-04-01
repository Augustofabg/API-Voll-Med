package med.voll.api.Pacientes;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Endereco.AddressData;

public record PatientUpdateData(

        @NotNull
        Long id,

        String name,
        String phone,
        AddressData address

) {
}
