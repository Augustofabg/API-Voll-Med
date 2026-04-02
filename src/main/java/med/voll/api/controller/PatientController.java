package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Pacientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping ("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerPatients(@RequestBody @Valid PatientCreateDTO data, UriComponentsBuilder uriBuilder){
        var patients = new Patients(data);
        repository.save(patients);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patients.getId()).toUri();

        return ResponseEntity.created(uri).body(new PatientsDetailsData(patients));
    }

    @GetMapping
    public ResponseEntity<Page<PatientListData>> listPatients(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        var page = repository.findAllByActiveTrue(pageable ).map(PatientListData::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePatient(@RequestBody @Valid PatientUpdateData data){
        var patients = repository.getReferenceById(data.id());
        patients.UpdateInformation(data);

        return ResponseEntity.ok(new PatientsDetailsData(patients));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id){
        var patients = repository.getReferenceById(id);
        patients.DeleteDoctor();

       return ResponseEntity.noContent().build();
    }

}
