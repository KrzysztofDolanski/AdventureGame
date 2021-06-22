package event;

import main.GameManager;

public class Event02 {

    public GameManager gm;

    public Event02(GameManager gm) {
        this.gm = gm;
    }

    public void lookCave(){
        gm.ui.messageText.setText("Its a cave");
    }

    public void talkCave(){
        gm.ui.messageText.setText("you hera echo of your voice");
    }

    public void enterCave(){
        if (gm.player.hasLighter==false){
        gm.ui.messageText.setText("Its too dark to enter");
        } else {
            gm.sceneChanger.showScene3();
        }
    }

    public void lookRoot(){
        gm.ui.messageText.setText("There is something on the tree");
    }

    public void talkRoot(){
        gm.ui.messageText.setText("Dont talk to palant");
    }
    public void searchRoot(){
        if (gm.player.hasLighter==false){
            gm.ui.messageText.setText("You find a lighter");
            gm.player.hasLighter = true;
            gm.player.updatePlayerStatus();

        } else gm.ui.messageText.setText("There is nothing here");
    }
}
