package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Pet;

public class Banco {
	private static List<Pet> pets = new ArrayList<>();
	private static int id = 0;
	
	public static void salva(Pet pet){
		if(pet != null) {
			pet.setId(++id);
			pets.add(pet);
		}
	}
	
	public static List<Pet> busca(){
		return pets;
	}
}

