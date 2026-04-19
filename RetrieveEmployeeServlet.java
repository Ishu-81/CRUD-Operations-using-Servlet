package ebook581;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/getEmployees")
public class RetrieveEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");

        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> list = dao.getEmployees();

        Gson gson = new Gson();
        String json = gson.toJson(list);

        PrintWriter out = resp.getWriter();
        out.print(json);
    }
}
