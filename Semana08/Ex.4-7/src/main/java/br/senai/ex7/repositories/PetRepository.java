package br.senai.ex7.repositories;

import br.senai.ex7.models.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepository {
    public static List<Pet> pets = new ArrayList<>();
    private static int idPet = 0;

    private static int incrementaId(){
        return ++idPet;
    }

    public static List<Pet> listaDePets() {
        return pets;
    }

    public void cadastrarPet(Pet pet) {
        incrementaId();
        pet.setId(idPet);
        pets.add(pet);
    }

    public Pet atualizarPet(int id, Pet petAtualizado) {
        Pet petSelecionado = (Pet) encontrarPet(idPet);
        if (petAtualizado.getNome() != null) {
            petSelecionado.setNome(petAtualizado.getNome());
        }
        if (petAtualizado.getEspecie() != null) {
            petSelecionado.setEspecie(petAtualizado.getEspecie());
        }
        if (petAtualizado.getRaca() != null) {
            petSelecionado.setRaca(petAtualizado.getRaca());
        }
        if (petAtualizado.getPeso() != 0.0) {
            petSelecionado.setPeso(petAtualizado.getPeso());
        }
        return petSelecionado;
    }

    public boolean apagarListaPets() {
        pets.clear();
        return false;
    }

    public boolean apagarPet(int id) {
        Pet petMatch = (Pet) encontrarPet(idPet);
        if (petMatch == null) {
            return false;
        }
        pets.remove(petMatch);
        return true;
    }

    public List<Pet> encontrarPet(int idPet) {
        Pet petExistente = null;
        for(Pet pet : pets){
            if(pet.getId() == idPet){
                petExistente = pet;
                break;
            }
        }
        return (List<Pet>) petExistente;
    }
}
