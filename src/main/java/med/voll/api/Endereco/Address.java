package med.voll.api.Endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String neighborhood;
    private String zip_code;
    private String number;
    private String complement;
    private String city;
    private String state;

    public Address(AddressData dados) {
        this.street = dados.street();
        this.neighborhood = dados.neighborhood();
        this.zip_code = dados.zip_code();
        this.state = dados.state();
        this.city = dados.city();
        this.number = dados.number();
        this.complement = dados.complement();
    }

    public void AttInformacoes(AddressData dados) {
        if (dados.street() != null) {
            this.street = dados.street();
        }
        if (dados.neighborhood () != null) {
            this.neighborhood = dados.neighborhood ();
        }
        if (dados.zip_code() != null) {
            this.zip_code = dados.zip_code();
        }
        if (dados.state() != null) {
            this.state = dados.state();
        }
        if (dados.city() != null) {
            this.city = dados.city();
        }
        if (dados.number() != null) {
            this.number = dados.number();
        }
        if (dados.complement() != null) {
            this.complement = dados.complement();
    }}
}
