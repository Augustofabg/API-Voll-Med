package med.voll.api.domain.patient;

import med.voll.api.domain.address.Address;

public record PatientsDetailsData(Long id, String name, String cpf, String phone, Address address) {

    public PatientsDetailsData(Patients patients){
     this(patients.getId(), patients.getName(), patients.getCpf(), patients.getPhone(), patients.getAddress());
    }
}
