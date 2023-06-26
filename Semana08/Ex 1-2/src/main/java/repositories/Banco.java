package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Pets;

public class Banco { 
	
	private static List<Pets> pets = new ArrayList<>();
	
	private static int petSequence = 0;
	
	
	public void cadastra(Pets pet) {
		pet.setId(incrementaSequence());
		pets.add(pet);
	}
	
	private static int incrementaSequence() {
		return ++petSequence;
	}

	public List<Pets> busca() {
		return pets;
	}
	
	
	public static String listPets() {
		if(pets == null || pets.size() == 0) {
			return "<h1>Lista de pets vazia</h1>";
		}
		String texto ="<h2>Lista de Pets: <ul>";
		
		for(Pets pet : pets) {
			texto += "<li><ul>" +
					"<li>id: " + pet.getId() +
					"</li><li>nome: " + pet.getNome() + 
					"</li><li>especie: " + pet.getEspecie() +
					"</li><li>raca: " + pet.getRaca() + 
					"</li><li>peso: " + pet.getPeso() + "</li></ul></li>";
			
		};
		texto += "</ul>";
		return texto;
	}
	
	@Override
	public String toString() {
		
		String texto ="Lista de Pets: ";
		
		for(Pets pet : pets) {
			texto += 
					"id: " + pet.getId() +
					", nome: " + pet.getNome() + 
					", especie: " + pet.getEspecie() +
					", raca: " + pet.getRaca() + ", ";
			
		};
		return texto;
	}
	
}