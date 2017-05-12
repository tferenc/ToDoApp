/**
 * Created by Tamás Ferenc on 2017. 05. 08..
 */
import java.util.ArrayList;
import java.util.List;

public class TodoDaoMem implements TodoDao {

    public static final TodoDao INSTANCE = new TodoDaoMem();

    private List<Todo> todos = new ArrayList<>();

    private TodoDaoMem() {
    }

    public List<Todo> getTodos()
    {
      return todos;
    }

    @Override
    public Todo getTodo(Integer id) {
        for (Todo t :todos)
        {
          if(t.getId().equals(id))
          {
              return t;
          }
        }
        return null;
    }

    @Override
    public Todo addTodo(String text) {
       Todo t =new Todo(todos.size()+1, text,false);
       todos.add(t);
       return t;
    }

    @Override
    public void toggleStatus(Integer id)
    {
        for (Todo t:todos)
        {
            if(id.equals(t.getId())){
                if(t.isCompleted() == false)
                {
                 t.setCompleted(true);
                }
            }
        }
    }

    @Override
    public void deleteTodo(Integer id)
    {
        for (Todo t:todos)
        {
         if(id.equals(t.getId())){
             todos.remove(t);
         }
        }
    }
}
