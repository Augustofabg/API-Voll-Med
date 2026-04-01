package med.voll.api.Medico;

public record DoctorListData(
        Long id,
        String name,
        String crm,
        String email,
        Specialty specialty
) {

    public DoctorListData(Doctors doctors) {
        this(
                doctors.getId(),
                doctors.getName(),
                doctors.getCrm(),
                doctors.getEmail(),
                doctors.getSpecialty()
        );
    }
}