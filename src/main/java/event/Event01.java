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

        if(gm.player.playerLife != gm.player.playerMaxLife){
        gm.ui.messageText.setText("Take your sit\nYour health grow here");
        gm.player.playerLife++;
        gm.player.updatePlayerStatus();
        }
        else {
                gm.ui.messageText.setText("Your life is full");
        }
    }

    public void lookKnight(){
        gm.ui.messageText.setText("This is your house");
    }
    public void talkKnight(){
        gm.ui.messageText.setText("Man this is only house, talk to someone who live");
    }
    public void fightKnight(){
        if (gm.player.hasShield==false){
            if (gm.player.hasSword==false){
                if (gm.player.playerLife!=1) {
                    gm.ui.messageText.setText("Dont be stupid\nguard hits you back you take damage of your body");
                    gm.player.playerLife--;
                }
                else if (gm.player.playerLife==1){
                    gm.ui.messageText.setText("What a fool\n you die");
                    gm.player.playerLife--;
                    gm.sceneChanger.showGameoverScreeen(1);
                }
            }
            else if (gm.player.hasSword==true){
                gm.ui.messageText.setText("You defeated guad and grabhis shield");
                gm.player.hasShield=true;
            }
            gm.player.updatePlayerStatus();
        }
        else
        gm.ui.messageText.setText("Leave me alone");
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

    public void openChest(){
        gm.ui.messageText.setText("You open and find sword");
        if (gm.player.hasSword=false){
            gm.player.hasSword=true;
            gm.player.updatePlayerStatus();
        }
        else{
            gm.ui.messageText.setText("there is nothing inside");
        }
    }

}
