package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void CadastrarMedicos(@RequestBody @Valid DadosCadastroMedicos dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
      return repository.findAll(pageable).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void Atualizar(@RequestBody @Valid DadosAttMedicos dados){
        var medico = repository.getReferenceById(dados.id());
        medico.AttInformacoes(dados);
      }


    //exclusao logica: parar de exibir no sistema apenas
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id){
       repository.deleteById(id);
    }
}
