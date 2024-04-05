package view;

import model.TaskModel;

import javax.swing.*;
import java.awt.*;

public class TaskView extends JPanel{
    private TaskModel model;
    public TaskView(TaskModel model) {
        super();
        this.model = model;
        setBackground(Color.WHITE);

        JLabel title = new JLabel("Gestionnaire de tâches");
        title.setSize(200, 30);

        JPanel panelV = new JPanel();
        BoxLayout boxLayoutV = new BoxLayout(panelV, BoxLayout.Y_AXIS);
        panelV.setBackground(Color.WHITE);
        panelV.setLayout(boxLayoutV);


        JPanel panelH = new JPanel();
        BoxLayout boxLayoutH = new BoxLayout(panelH, BoxLayout.X_AXIS);
        panelH.setBackground(Color.WHITE);
        panelH.setLayout(boxLayoutH);

        JButton createTask = new JButton("Créer une tâche");


        JButton modifyTask = new JButton("Modifier une tâche");


        JButton deleteTask = new JButton("Supprimer une tâche");


        JButton listTask = new JButton("Lister les tâches");


        JButton exit = new JButton("Quitter");
        exit.addActionListener(e -> {
            System.exit(0);
        });

        panelV.add(title);
        panelV.add(panelH);
        panelH.add(createTask);
        panelH.add(modifyTask);
        panelH.add(deleteTask);
        panelH.add(listTask);
        panelH.add(exit);
        add(panelV);
    }
}
