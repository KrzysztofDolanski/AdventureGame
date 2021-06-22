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

                //scene2
            case "lookCave":
                gameManager.ev2.lookCave();
            case "talkCave":
                gameManager.ev2.talkCave();
            case "enterCave":
                gameManager.ev2.enterCave();
            case "lookRoot":
                gameManager.ev2.lookRoot();
            case "talkRoot":
                gameManager.ev2.talkRoot();
            case "searchRoot":
                gameManager.ev2.searchRoot();

            case "goScene1": gameManager.sceneChanger.showScene1();
            case "goScene2": gameManager.sceneChanger.showScene2();

            case "restart":
                gameManager.sceneChanger.existGameOverScreen();
                gameManager.sceneChanger.showScene1(); break;
        }
    }

}
