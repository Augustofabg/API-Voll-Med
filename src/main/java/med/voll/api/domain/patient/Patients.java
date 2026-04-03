package med.voll.api.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;

@Table (name = "patients")
@Entity (name = "patients")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patients {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String cpf;

    @Embedded
    private Address address;

    private boolean active;

    public Patients(PatientCreateDTO data){
        this.active = true;
        this.email = data.email();
        this.phone = data.phone();
        this.name = data.name();
        this.cpf = data.cpf();
        this.address = new Address(data.address());
    }

    public void UpdateInformation(PatientUpdateData data) {
    if (data.name() != null){
        this.name = data.name();
    }
    if (data.phone() != null){
        this.phone = data.phone();
        }
    if (data.address() != null){
        this.address.AttInformacoes(data.address());
        }
    }

    public void DeleteDoctor(){
        this.active = false;
    }


}
