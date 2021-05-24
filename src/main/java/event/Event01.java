package event;

import main.GameManager;

public class Event01 {

    GameManager gm;
    public Event01(GameManager gm) {
        this.gm = gm;
    }

    public void lookHut(){
        gm.ui.messageText.setText("This is your house");
    }
    public void talkHut(){
        gm.ui.messageText.setText("Man this is only house, talk to someone who live");
    }
    public void resthut(){
        gm.ui.messageText.setText("Take your sit\nYour health grow here");
    }

    public void lookKnight(){
        gm.ui.messageText.setText("This is your house");
    }
    public void talkKnight(){
        gm.ui.messageText.setText("Man this is only house, talk to someone who live");
    }
    public void fightKnight(){
        gm.ui.messageText.setText("Take your sit\nYour health grow here");
    }

    public void lookViking(){
        gm.ui.messageText.setText("This is your house");
    }
    public void talkViking(){
        gm.ui.messageText.setText("Man this is only house, talk to someone who live");
    }
    public void fightViking(){
        gm.ui.messageText.setText("Lets fight");
    }

}
