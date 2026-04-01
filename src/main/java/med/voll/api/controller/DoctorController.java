package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void registerDoctors(@RequestBody @Valid DoctorCreateDTO data){
        repository.save(new Doctors(data));
    }

    @GetMapping
    public Page<DoctorListData> listDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
      return repository.findAllByActiveTrue(pageable).map(DoctorListData::new);
    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody @Valid DoctorUpdateData data){
        var medico = repository.getReferenceById(data.id());
        medico.UpdateInformation(data);
      }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id){
       var doctor = repository.getReferenceById(id);
        doctor.DeleteDoctor();
    }
}
