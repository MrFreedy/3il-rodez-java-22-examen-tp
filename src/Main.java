import controller.TaskController;
import model.TaskModel;
import view.TaskView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TaskModel taskModel = new TaskModel();
        TaskView taskView = new TaskView(taskModel);
        TaskController taskController = new TaskController(taskModel, taskView);


        JFrame frame = new JFrame("Gestionnaire de tâches");
        frame.add(taskView);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
