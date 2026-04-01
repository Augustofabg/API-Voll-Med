package med.voll.api.Medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Endereco.AddressData;

public record DoctorUpdateData(

        @NotNull
        Long id,

        String name,
        String phone,
        AddressData address

        ) {}
