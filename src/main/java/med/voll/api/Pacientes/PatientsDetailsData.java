package med.voll.api.Pacientes;

import med.voll.api.Endereco.Address;
import med.voll.api.Medico.Specialty;

public record PatientsDetailsData(Long id, String name, String cpf, String phone, Address address) {

    public PatientsDetailsData(Patients patients){
     this(patients.getId(), patients.getName(), patients.getCpf(), patients.getPhone(), patients.getAddress());
    }
}
