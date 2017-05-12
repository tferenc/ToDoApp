import java.util.List;

/**
 * Created by Tamás Ferenc on 2017. 05. 08..
 */
import java.util.List;

public interface TodoDao {

    List<Todo> getTodos();
    Todo getTodo(Integer id);
    Todo addTodo(String text);
    void toggleStatus(Integer id);
    void deleteTodo(Integer id);
}

