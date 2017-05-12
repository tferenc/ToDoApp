/**
 * Created by Tamás Ferenc on 2017. 05. 08..
 */
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet({"/todos", "/todos/*"})
public class TodoServlet extends HttpServlet {
    int key;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        String insert = String.format("INSERT INTO list(activity) VALUES(\"%s\");", text);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String unicode = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/todo" + unicode + "&useSSL=true", "root", "admin");
            PreparedStatement statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);


            ResultSet generatedKeys = statement.getGeneratedKeys();
            PrintWriter out = resp.getWriter();
            while(generatedKeys.next())
            {
                key = generatedKeys.getInt(1);
                out.println(key);

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
