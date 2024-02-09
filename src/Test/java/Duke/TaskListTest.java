package Duke;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {

    @Test
    public void testAddTask() {
        TaskList taskList = new TaskList();
        Task task = new Task("Task 1");
        taskList.addTask(task);
        assertEquals(1, TaskList.getTaskNum());
        assertEquals(task, TaskList.getTasks()[0]);
    }

    @Test
    public void testRemoveTask() {
        TaskList taskList = new TaskList();
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.removeTask(0);
        assertEquals(1, TaskList.getTaskNum());
        assertEquals(task2, TaskList.getTasks()[0]);
    }
}
