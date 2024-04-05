package view;

import model.TaskModel;

import javax.swing.*;

public class TaskView extends JPanel{
    private TaskModel model;
    public TaskView(TaskModel model) {
        JFrame frame = new JFrame("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
