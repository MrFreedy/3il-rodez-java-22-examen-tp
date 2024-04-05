package model;

import java.util.Objects;

public class TaskModel {
    int id;
    String titre;
    String description;
    String dateEchance;
    String priorite;

    public TaskModel() {
    }

    public TaskModel(int id, String titre, String description, String dateEchance, String priorite) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dateEchance = dateEchance;
        this.priorite = priorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateEchance() {
        return dateEchance;
    }

    public void setDateEchance(String dateEchance) {
        this.dateEchance = dateEchance;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskModel task = (TaskModel) o;
        return id == task.id && Objects.equals(titre, task.titre) && Objects.equals(description, task.description) && Objects.equals(dateEchance, task.dateEchance) && Objects.equals(priorite, task.priorite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, description, dateEchance, priorite);
    }
}
