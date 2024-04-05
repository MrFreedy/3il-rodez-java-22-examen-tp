import controller.TaskController;
import model.TaskModel;
import view.TaskView;

public class Main {
    public static void main(String[] args) {
        TaskModel taskModel = new TaskModel();
        TaskView taskView = new TaskView(taskModel);
        TaskController taskController = new TaskController(taskModel, taskView);
    }
}
