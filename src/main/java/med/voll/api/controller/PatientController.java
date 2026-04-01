package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Pacientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void registerPatients(@RequestBody @Valid PatientCreateDTO data){
        repository.save(new Patients(data));
    }

    @GetMapping
    public Page<PatientListData> listPatients(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return repository.findAllByActiveTrue(pageable ).map(PatientListData::new);
    }

    @PutMapping
    @Transactional
    public void updatePatient(@RequestBody @Valid PatientUpdateData data){
        var patients = repository.getReferenceById(data.id());
        patients.UpdateInformation(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePatient(@PathVariable Long id){
        var patients = repository.getReferenceById(id);
        patients.DeleteDoctor();
    }

}
