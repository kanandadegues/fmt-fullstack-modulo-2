package br.senai.ex7.services;

import br.senai.ex7.models.Pet;
import br.senai.ex7.models.Tutor;
import br.senai.ex7.repositories.PetRepository;
import br.senai.ex7.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private TutorRepository tutorRepository;

    public String listaDePets(){
        return PetRepository.listaDePets().toString();
    }

    public Pet buscarPetId(int idPet) {
        Pet petEspecifico = null;
        for (Pet pet : PetRepository.listaDePets()){
            if(pet.getId() == idPet) {
                petEspecifico = pet;
                break;
            }
        }
        return petEspecifico;
    }

    public void cadastarPet(Pet pet){
        petRepository.cadastrarPet(pet);
    }

    public String atualizarPet(int id, Pet petAtualizado) {
        Pet pet = petRepository.atualizarPet(id, petAtualizado);
        if (pet == null) {
            return "Pet não encontrado";
        } else {
            return "id " + pet.getId() + ", " +
                    "nome: " + pet.getNome() + ", " +
                    "especie: " + pet.getEspecie() + ", " +
                    "raca: " + pet.getRaca() + ", " +
                    "peso: " + pet.getPeso();
        }
    }

    public boolean apagarListaPets() {
        return petRepository.apagarListaPets();
    }

    public boolean apagarUnicoPet(int idPet) {
        return petRepository.deletarPet(idPet);
    }

    public List<Pet> buscarPetPorTutor(int idTutor) {
        boolean tutorId = false;
        for(Tutor tutor : TutorRepository.tutores){
            if(tutor.getId() == idTutor) {
                tutorId = true;
                break;
            } else {
                tutorId = false;
            }
        }
        if(tutorId) {
            return petRepository.encontrarPet(idTutor);
        }
        return null;
    }

}
