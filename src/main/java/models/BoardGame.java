package models;

import java.io.Serializable;
import java.util.List;

public class BoardGame implements Serializable {
    private int id;
    private String key_room;
    private int id_team_win;
    private int quantity_de;
    private int quantity_tb;
    private int quantity_kho;

    public BoardGame() {
    }

    public BoardGame(int id, String key_room, int id_team_win, int quantity_de, int quantity_tb, int quantity_kho) {
        this.id = id;
        this.key_room = key_room;
        this.id_team_win = id_team_win;
        this.quantity_de = quantity_de;
        this.quantity_tb = quantity_tb;
        this.quantity_kho = quantity_kho;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "id=" + id +
                ", key_room='" + key_room + '\'' +
                ", id_team_win=" + id_team_win +
                ", quantity_de=" + quantity_de +
                ", quantity_tb=" + quantity_tb +
                ", quantity_kho=" + quantity_kho +
                '}';
    }

    public int getQuantity_de() {
        return quantity_de;
    }

    public void setQuantity_de(int quantity_de) {
        this.quantity_de = quantity_de;
    }

    public int getQuantity_tb() {
        return quantity_tb;
    }

    public void setQuantity_tb(int quantity_tb) {
        this.quantity_tb = quantity_tb;
    }

    public int getQuantity_kho() {
        return quantity_kho;
    }

    public void setQuantity_kho(int quantity_kho) {
        this.quantity_kho = quantity_kho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey_room() {
        return key_room;
    }

    public void setKey_room(String key_room) {
        this.key_room = key_room;
    }

    public int getId_team_win() {
        return id_team_win;
    }

    public void setId_team_win(int id_team_win) {
        this.id_team_win = id_team_win;
    }

}
