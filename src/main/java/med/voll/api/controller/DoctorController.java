package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping ("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerDoctors(@RequestBody @Valid DoctorCreateDTO data, UriComponentsBuilder uriBuilder){
        var doctor = new Doctors(data);
        repository.save(doctor);
        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorDetailsData(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorListData>> listDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
      var page = repository.findAllByActiveTrue(pageable).map(DoctorListData::new);

      return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detailDoctor(@PathVariable Long id){
      var doctor = repository.getReferenceById(id);

      return ResponseEntity.ok(new DoctorDetailsData(doctor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateDoctor(@RequestBody @Valid DoctorUpdateData data){
        var doctor = repository.getReferenceById(data.id());
        doctor.UpdateInformation(data);

        return ResponseEntity.ok(new DoctorDetailsData(doctor));
      }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteDoctor(@PathVariable Long id){
       var doctor = repository.getReferenceById(id);
        doctor.DeleteDoctor();

        return ResponseEntity.noContent().build();
    }
}
