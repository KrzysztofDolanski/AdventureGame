package main;

import event.Event01;

public class GameManager {

    ActionHandler aHandler = new ActionHandler(this);

    public UI ui = new UI(this);
    public Event01 ev1 = new Event01(this);
    public SceneChanger sceneChanger = new SceneChanger(this);

    public static void main(String[] args) {
        new GameManager();
    }

    public GameManager() {
        sceneChanger.showScene1();
    }
}
