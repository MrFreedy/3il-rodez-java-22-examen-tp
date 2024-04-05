package model;

public interface ITask {
    void ajouterTask(TaskModel task);
    void modifierTask(TaskModel task);
    void supprimerTask(TaskModel task);

    TaskModel[] getTasks();
}
