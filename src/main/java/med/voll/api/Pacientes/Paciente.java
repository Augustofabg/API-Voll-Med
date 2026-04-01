package med.voll.api.Pacientes;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.Endereco.Endereco;

@Table (name = "Pacientes")
@Entity (name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Paciente(DadosDeCadastroPaciente dados){
        this.ativo = true;
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    public void AttInformacoes(DadosAttPacientes dados) {
    if (dados.nome() != null){
        this.nome = dados.nome();
    }
    if (dados.telefone() != null){
        this.telefone = dados.telefone();
        }
    if (dados.endereco() != null){
        this.endereco.AttInformacoes(dados.endereco());
        }
    }

    public void excluir(){
        this.ativo = false;
    }


}
