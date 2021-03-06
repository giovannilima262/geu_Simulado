package br.ucsal.geu.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.geu.dao.EspacoDAO;
import br.ucsal.geu.dao.ReservaDAO;
import br.ucsal.geu.model.Espaco;
import br.ucsal.geu.model.Reserva;

/**
 * Servlet implementation class ReservaController
 */
@WebServlet("/reservas")
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			EspacoDAO dao = new EspacoDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("reservaform.jsp").forward(request, response);
		} else {
			ReservaDAO dao = new ReservaDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("reservalist.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String espacoID = request.getParameter("espaco");
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String justificativa = request.getParameter("justificativa");
		String solicitante = request.getParameter("solicitante");
		String telefone = request.getParameter("telefone");
		String data = request.getParameter("data");
		String inicio = request.getParameter("inicio");
		String fim = request.getParameter("fim");

		try {

			Reserva reserva = new Reserva();
			reserva.setTitulo(titulo);
			reserva.setDescricao(descricao);
			reserva.setJustificativa(justificativa);
			reserva.setSolicitante(solicitante);
			reserva.setTelefone(telefone);

			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			reserva.setData(LocalDate.parse(data, dateFormat));
			DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
			reserva.setInicioHorario(LocalTime.parse(inicio, timeFormat));
			reserva.setFimHorario(LocalTime.parse(fim, timeFormat));

			int id_espaco = Integer.parseInt(espacoID);
			EspacoDAO espacoDAO = new EspacoDAO();
			Espaco espaco = espacoDAO.getByID(id_espaco);
			reserva.setEspaco(espaco);

			ReservaDAO dao = new ReservaDAO();
			validarReserva(espaco, reserva);
			dao.inserir(reserva);
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("reservalist.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
			EspacoDAO dao = new EspacoDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("reservaform.jsp").forward(request, response);
		}
	}

	private void validarReserva(Espaco espaco, Reserva reserva) throws Exception {
		ReservaDAO dao = new ReservaDAO();
		List<Reserva> reservas = dao.listar();
		for (Reserva reserva2 : reservas) {
			if (reserva.getData().equals(reserva2.getData())
					&& reserva.getEspaco().getId().equals(reserva2.getEspaco().getId())) {
				throw new Exception("Error reservas com espaco e data iguais");
			}
		}
	}

}
