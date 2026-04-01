package med.voll.api.Medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctors, Long> {

    Page<Doctors> findAllByActiveTrue(Pageable pageable);
}
