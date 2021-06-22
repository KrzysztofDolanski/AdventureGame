package main;

import event.Event01;
import event.Event02;

public class GameManager {

    ActionHandler aHandler = new ActionHandler(this);

    public UI ui = new UI(this);
    public Event01 ev1 = new Event01(this);
    public Event02 ev2 = new Event02(this);
    public Player player = new Player(this);
    public SceneChanger sceneChanger = new SceneChanger(this);

    public static void main(String[] args) {
        new GameManager();
    }

    public GameManager() {
        player.setPlayerDefaultStatus();
        sceneChanger.showScene1();
    }
}
