package med.voll.api.Pacientes;

public record PatientListData(
        Long id,
        String name,
        String email,
        String cpf
) {

    public PatientListData(Patients patients) {
        this(
                patients.getId(),
                patients.getName(),
                patients.getEmail(),
                patients.getCpf()

        );
    }
}
