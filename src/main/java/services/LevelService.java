package services;

import db.JDBIConnector;
import models.Level;

public class LevelService {
    private static LevelService instance;

    private LevelService() {

    }

    public static LevelService getInstance() {
        if (instance == null) {
            instance = new LevelService();
        }
        return instance;
    }
    public Level getLevel(int id){
        return JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select * from `level` where id= ?").bind(0, id).mapToBean(Level.class).one());
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getLevel(1));
    }
}
