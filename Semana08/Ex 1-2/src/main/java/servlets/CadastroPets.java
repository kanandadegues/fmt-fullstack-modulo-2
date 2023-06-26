package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Pet;
import repositories.Banco;

@WebServlet(value = "/pets")
public class CadastroPets extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List<Pet> petsCadastrados = Banco.busca();
		
		PrintWriter writer = resp.getWriter();
		writer.print("<ul>");
			
			for(Pet pet : petsCadastrados) {
				writer.printf("<li>Id: %d, Nome: %s, Especie: %s, Raca: %s, Peso:%.2f </li>",
						pet.getId(), pet.getNome(), pet.getEspecie(), pet.getRaca(), pet.getPeso());
			}
		
		writer.print("</ul>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String especie = req.getParameter("especie");
		String raca = req.getParameter("raca");
		String peso = req.getParameter("peso");
		
		Pet novoPet = new Pet();
		novoPet.setNome(nome);
		novoPet.setEspecie(especie);
		novoPet.setRaca(raca);
		novoPet.setPeso(Double.parseDouble(peso));
		
		Banco.salva(novoPet);
		
		PrintWriter writer = resp.getWriter();
		writer.print("Pet cadastrado com sucesso!");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		List<Pet> pets = Banco.busca();
		Pet oldPet = null;
		
		for(Pet pet : pets) {
			if(pet.getId() == id) {
				oldPet = pet;
				break;
			}
			
			if(oldPet != null) {
				String nome = req.getParameter("nome");
				String especie = req.getParameter("especie");
				String raca = req.getParameter("raca");
				String peso = req.getParameter("peso");
				
				if(nome != null) {
					oldPet.setNome(nome);
				}
				if(especie != null) {
					oldPet.setEspecie(especie);
				}
				if(raca != null) {
					oldPet.setRaca(raca);
				}
				if(peso != null) {
					oldPet.setPeso(Double.parseDouble(peso));
				}
			} else {
				resp.setStatus(404);
			}
		}
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		List<Pet> pets = Banco.busca();
		Pet deletarPet = null;
		
		for(Pet pet : pets) {
			if(pet.getId() == id) {
				deletarPet = pet;
				break;
			}
		}
		
		if(deletarPet != null) {
			pets.remove(deletarPet);
		}
		
		resp.setStatus(204);
	}
	
}

