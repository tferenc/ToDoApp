import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Tamás Ferenc on 2017. 05. 10..
 */
@WebServlet("/dbserv")
public class DatabaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("hidden");
        String unicode = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        int id = Integer.parseInt(value);
        String input = String.format("DELETE FROM list WHERE id =\"%s\"", id);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/todo" + unicode + "&useSSL=true", "root", "admin");
            Statement statement = connection.createStatement();
            statement.executeUpdate(input);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String unicode = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/todo" + unicode + "&useSSL=true", "root", "admin");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM list", Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.executeQuery("SELECT * FROM list");
            out.println("<html><head><meta charset = 'UTF-8'><title>Todos</title><head>");
            out.println("<body>");
            while(result.next()){
                out.println("<colspan id="+result.getInt(1)+">" + result.getString("activity") + "<button id="+result.getInt(1)+" class='butt'>Remove</button></br></colspan>");
            }
            out.println("</colspan></body></html>");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
