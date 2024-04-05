package controller;

import model.TaskModel;
import view.TaskView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TaskController {

    private TaskModel model;
    private TaskView view;
    private List<TaskModel> tasks = new ArrayList<>();

    public TaskController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;

        view.getCreateTask().addActionListener(e -> {
            JFrame frame = new JFrame("Créer une tâche");
            frame.setSize(600, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);

            JPanel panel = new JPanel();
            BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
            panel.setLayout(boxLayout);

            JLabel titreLabel = new JLabel("Titre");
            JTextField titreField = new JTextField();
            titreField.setSize(200, 30);
            panel.add(titreLabel);
            panel.add(titreField);

            JLabel descriptionLabel = new JLabel("Description");
            JTextField descriptionField = new JTextField();
            descriptionField.setSize(200, 30);
            panel.add(descriptionLabel);
            panel.add(descriptionField);

            JLabel dateEchanceLabel = new JLabel("Date d'échéance");
            JTextField dateEchanceField = new JTextField();
            dateEchanceField.setSize(200, 30);
            panel.add(dateEchanceLabel);
            panel.add(dateEchanceField);

            JComboBox<String> prioriteBox = new JComboBox<>();
            prioriteBox.addItem("Faible");
            prioriteBox.addItem("Moyenne");
            prioriteBox.addItem("Haute");
            panel.add(prioriteBox);


            JButton submit = new JButton("Créer");
            submit.addActionListener(e1 -> {
                String titre = titreField.getText();
                String description = descriptionField.getText();
                String dateEchance = dateEchanceField.getText();
                String priorite = (String) prioriteBox.getSelectedItem();


                TaskModel newTask = new TaskModel(titre, description, dateEchance, priorite);

                System.out.println(newTask.getId());
                tasks.add(newTask);

                frame.dispose();
            });
            panel.add(submit);

            frame.add(panel);

        });

        view.getDeleteTask().addActionListener(e -> {
            JFrame frame = new JFrame("Supprimer une tâche");
            frame.setSize(600, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);

            JPanel panel = new JPanel();
            BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
            panel.setLayout(boxLayout);

            JLabel idLabel = new JLabel("ID");
            JTextField idField = new JTextField();
            idField.setSize(200, 30);
            panel.add(idLabel);
            panel.add(idField);

            JButton submit = new JButton("Supprimer");
            submit.addActionListener(e1 -> {
                int id = Integer.parseInt(idField.getText());
                for (TaskModel task : tasks) {
                    if (task.getId() == id) {
                        tasks.remove(task);
                        break;
                    }
                }
                System.out.println(tasks);
                frame.dispose();
            });
            panel.add(submit);

            frame.add(panel);
        });
    }
}
