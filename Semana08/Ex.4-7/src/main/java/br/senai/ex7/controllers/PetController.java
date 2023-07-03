package br.senai.ex7.controllers;

import br.senai.ex7.models.Pet;
import br.senai.ex7.models.Tutor;
import br.senai.ex7.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/{idPet}")
    public String buscaPet(@PathVariable("idPet") int idPet) {
        return "Este é um pet com id: " + idPet;
    }

    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet novoPet) {
        return novoPet;
    }

    @PutMapping
    public String atualizarPet() {
        return "Pet Atualizado";
    }
}
