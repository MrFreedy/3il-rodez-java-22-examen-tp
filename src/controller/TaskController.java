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

        view.getModifyTask().addActionListener(e -> {
            JFrame frame = new JFrame("Modifier une tâche");
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

            JButton submit = new JButton("Modifier");
            submit.addActionListener(e1 -> {
                int id = Integer.parseInt(idField.getText());
                String titre = titreField.getText();
                String description = descriptionField.getText();
                String dateEchance = dateEchanceField.getText();
                String priorite = (String) prioriteBox.getSelectedItem();

                for (TaskModel task : tasks) {
                    if (task.getId() == id) {
                        task.setTitre(titre);
                        task.setDescription(description);
                        task.setDateEchance(dateEchance);
                        task.setPriorite(priorite);
                        break;
                    }
                }

                frame.dispose();
            });
            panel.add(submit);

            frame.add(panel);
        });

        view.getListTask().addActionListener(e -> {
            JFrame frame = new JFrame("Liste des tâches");
            frame.setSize(600, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);

            JPanel panel = new JPanel();
            BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
            panel.setLayout(boxLayout);

            int i =0;
            String [] columnNames = {"ID", "Titre", "Description", "Date d'échéance", "Priorité"};
            String [][] data = new String[tasks.size()][5];
            for (TaskModel task : tasks) {
                data[i][0] = String.valueOf(task.getId());
                data[i][1] = task.getTitre();
                data[i][2] = task.getDescription();
                data[i][3] = task.getDateEchance();
                data[i][4] = task.getPriorite();
                i++;
            }
            JTable table = new JTable(data, columnNames);
            table.setBounds(30,40,200,300);
            JScrollPane sp = new JScrollPane(table);
            panel.add(sp);

            frame.add(panel);
        });
    }
}
