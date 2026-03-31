package med.voll.api.Pacientes;

public record DadosListagemPacientes(String nome, String email, String cpf) {
    public DadosListagemPacientes(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
