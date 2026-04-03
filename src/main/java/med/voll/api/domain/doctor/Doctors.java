package med.voll.api.domain.doctor;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.address.Address;

@Table (name = "doctors")
@Entity (name = "doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctors {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    private boolean active;

    public Doctors(DoctorCreateDTO data){
        this.active = true;
        this.email = data.email();
        this.phone = data.phone();
        this.name = data.name();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

    public void UpdateInformation(DoctorUpdateData data) {
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

    public void DeleteDoctor() {
        this.active = false;
    }
}
