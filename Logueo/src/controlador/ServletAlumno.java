package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import modelo.ModelAlumno;

/**
 * Servlet implementation class ServletAlumno
 */
@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ModelAlumno mod = new ModelAlumno();
	
    public ServletAlumno() {
        super();
    }
    
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		if(tipo.equals("listar")) {
			listar(request, response);
		} else if(tipo.equals("registrar")) {
			registrar(request, response);
		} else if(tipo.equals("buscar")) {
			buscar(request, response);
		} else if(tipo.equals("actualizar")) {
			actualizar(request, response);
		} else if(tipo.equals("eliminar")) {
			eliminar(request, response);
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		mod.eliminarAlumno(codigo);
		listar(request, response);
		//request.getRequestDispatcher("ServletListado").forward(request, response);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alumno alu = new Alumno();
		String cod = request.getParameter("txt_cod");
		String nom = request.getParameter("txt_nom");
		String pat = request.getParameter("txt_pat");
		String mat = request.getParameter("txt_mat");
		String edad = request.getParameter("txt_edad");
		
		alu.setCodigo(Integer.parseInt(cod));
		alu.setNombre(nom);
		alu.setPaterno(pat);
		alu.setMaterno(mat);
		alu.setEdad(Integer.parseInt(edad));
		
		int estado = mod.actualizarAlumno(alu);
		if (estado != -1) {
			listar(request, response);
		} else {
			response.sendRedirect("error.html");
		}
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		Alumno x = mod.buscarAlumno(codigo);
		request.setAttribute("registro", x);
		request.getRequestDispatcher("actualizarAlumno.jsp").forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alumno alu = new Alumno();
		String nom = request.getParameter("txt_nom");
		String pat = request.getParameter("txt_pat");
		String mat = request.getParameter("txt_mat");
		String edad = request.getParameter("txt_edad");
		
		alu.setNombre(nom);
		alu.setPaterno(pat);
		alu.setMaterno(mat);
		alu.setEdad(Integer.parseInt(edad));
		int estado = mod.registrarAlumno(alu);
		if (estado != -1) {
			listar(request, response);
		} else {
			response.sendRedirect("error.html");
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Alumno> info = mod.listar();
		request.setAttribute("data", info);
		request.getRequestDispatcher("listarAlumno.jsp").forward(request, response);
	}


}
