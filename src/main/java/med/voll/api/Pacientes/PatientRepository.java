package med.voll.api.Pacientes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patients, Long> {
    Page<Patients> findAllByActiveTrue(Pageable pageable);
}
