package controller;

import model.TaskModel;
import view.TaskView;

public class TaskController {

    private TaskModel model;
    private TaskView view;

    public TaskController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;
    }
}
