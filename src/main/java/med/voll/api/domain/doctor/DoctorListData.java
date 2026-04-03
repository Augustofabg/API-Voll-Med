package med.voll.api.domain.doctor;

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