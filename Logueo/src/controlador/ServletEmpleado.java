package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Empleado;
import modelo.ModelEmpleado;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModelEmpleado m = new ModelEmpleado();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpleado() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login, clave;
        login = request.getParameter("txtlogin");
        clave = request.getParameter("txtpass");
        Empleado e = m.iniciarSesion(login, clave);
        if (e == null) {
            request.setAttribute("msj", "Error usuario y/o clave");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            response.sendRedirect("menu.jsp");
        }
	}

}
