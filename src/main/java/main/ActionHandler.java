package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    GameManager gameManager;

    public ActionHandler(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();
        switch (yourChoice) {
            case "lookHut":
                gameManager.ev1.lookHut();
                break;
            case "talkHut":
                gameManager.ev1.talkHut();
                break;
            case "restHut":
                gameManager.ev1.resthut();
                break;
            case "talkKnight":
                gameManager.ev1.talkKnight();
                break;
            case "lookKnight":
                gameManager.ev1.lookKnight();
                break;
            case "fightKnight":
                gameManager.ev1.fightKnight();
                break;
            case "lookViking":
                gameManager.ev1.lookViking();
                break;
            case "talkViking":
                gameManager.ev1.talkViking();
                break;
            case "fightViking":
                gameManager.ev1.fightViking();
                break;

            case "goScene1": gameManager.sceneChanger.showScene1();
            case "goScene2": gameManager.sceneChanger.showScene2();
        }
    }

}
