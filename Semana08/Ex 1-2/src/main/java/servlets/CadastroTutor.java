package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/tutores")
public class CadastroTutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CadastroTutor() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.print("<h1>Recebendo dados de Tutor: READ</h1><p>from C<strong>R</strong>UD</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.print("<h1>Criando dados de Tutor: CREATE</h1><p>from <strong>C</strong>RUD</p>");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.print("<h1>Alterando dados de Tutor: UPDATE</h1><p>from CR<strong>U</strong>D</p>");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.print("<h1>Apagando dados de Tutor: DELETE</h1><p>from CRU<strong>D</strong></p>");
	}

}
