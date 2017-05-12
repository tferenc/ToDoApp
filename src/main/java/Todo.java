/**
 * Created by Tamás Ferenc on 2017. 05. 08..
 */
public class Todo {

    private Integer id;
    private String text;
    private boolean completed;


    public Todo(Integer id, String text, boolean completed) {
        this.id = id;
        this.text = text;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
