package models;

import java.io.Serializable;

public class Level implements Serializable {
    private int id;
    private String name;
    private int time;

    public Level(int id, String name, int time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public Level() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
