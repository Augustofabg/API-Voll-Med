package med.voll.api.Medico;

import med.voll.api.Endereco.Address;

public record DoctorDetailsData(Long id, String name, String crm, String phone, Specialty specialty, Address address) {

public DoctorDetailsData(Doctors doctors){
    this(doctors.getId(), doctors.getName(), doctors.getCrm(), doctors.getPhone(), doctors.getSpecialty(), doctors.getAddress());
}

}
