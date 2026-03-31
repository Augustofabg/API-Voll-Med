package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Pacientes.DadosDeCadastroPaciente;
import med.voll.api.Pacientes.DadosListagemPacientes;
import med.voll.api.Pacientes.Paciente;
import med.voll.api.Pacientes.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/pacientes")
public class PacienteController {

    @Autowired
    private PacientesRepository repository;

    @PostMapping
    @Transactional
    public void CadastrarPacientes(@RequestBody @Valid DadosDeCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacientes> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return repository.findAll(pageable  ).map(DadosListagemPacientes::new);
    }

}
