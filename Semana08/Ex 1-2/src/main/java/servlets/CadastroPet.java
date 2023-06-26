package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.WrongMethodTypeException;
import java.nio.channels.WritableByteChannel;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Pets;
import repositories.Banco;

public class CadastroPet extends HttpServlet {

	private Banco repository = new Banco();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pets novoPet = new Pets();

		novoPet.setNome(request.getParameter("nome"));
		novoPet.setEspecie(request.getParameter("especie"));
		novoPet.setRaca(request.getParameter("raca"));
		novoPet.setPeso(Double.parseDouble(request.getParameter("peso")));

		repository.cadastra(novoPet);

		PrintWriter writer = response.getWriter();
		writer.printf("<h2>Nome do pet: %s</h2>", novoPet.getNome());
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pets> pets = repository.busca();
		PrintWriter writer = response.getWriter();
		writer.print("<ul>");
		for (Pets pet : pets) {
			writer.printf("<li>Nome pet: %s</li>", pet.getNome());
		}
		writer.print("</ul>");

		writer.print(Banco.listPets());
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Pets> pets = repository.busca();
		Pets oldPet = null;
		
		for (Pets pet : pets) {
			if (pet.getId() == id) {
				oldPet = pet;
				break;
			}
		}
		
		if (oldPet != null) {
			String nome = request.getParameter("nome");
			String especie = request.getParameter("especie");
			String raca = request.getParameter("raca");
			String peso = request.getParameter("peso");
			
			if (nome != null) {
				oldPet.setNome(nome);
			}
			if (especie != null) {
				oldPet.setEspecie(especie);
			}
			if (raca != null) {
				oldPet.setRaca(raca);
			}
			if (peso != null) {
				oldPet.setPeso(Double.parseDouble(peso));
			}
						
		} else {
			response.setStatus(404);
		}
	}
		
		@Override
		protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			List<Pets> pets = repository.busca();
			Pets petParaDeletar = null;
			
			for(Pets pet : pets) {
				if (pet.getId() ==  id) {
					petParaDeletar = pet;
					break;
				}
			}
			
			if (petParaDeletar != null) {
				pets.remove(petParaDeletar);
			}
			
			response.setStatus(204);
		}
}