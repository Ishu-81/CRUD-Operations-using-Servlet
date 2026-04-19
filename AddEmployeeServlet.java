package ebook581;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("empid"));
        String name = req.getParameter("name");
        int salary = Integer.parseInt(req.getParameter("salary"));
        String dept = req.getParameter("department");

        Employee emp = new Employee(id, name, salary, dept);

        EmployeeDAO dao = new EmployeeDAO();
        boolean status = dao.addEmployee(emp);

        resp.getWriter().print(status ? "Inserted Successfully" : "Insert Failed");
    }
}
