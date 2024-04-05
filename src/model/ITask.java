package model;

public interface ITask {
    void ajouterTask(Task task);
    void modifierTask(Task task);
    void supprimerTask(Task task);

    Task[] getTasks();
}
