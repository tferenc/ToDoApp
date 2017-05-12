import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/hi")
public class HiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            String todos = (String)session.getAttribute("name");
            String name = req.getParameter("name");
            //String lang = req.getParameter("lang");

            //String msg = MessageDAO.getMsg(lang);
            //req.setAttribute("msg", String.format(msg, todos));

            req.getRequestDispatcher("index.html").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
