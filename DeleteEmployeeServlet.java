package ebook581;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("empid"));

        EmployeeDAO dao = new EmployeeDAO();
        boolean status = dao.deleteEmployee(id);

        resp.getWriter().print(status ? "Deleted Successfully" : "Delete Failed");
    }
}
