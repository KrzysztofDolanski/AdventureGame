package main;

public class SceneChanger {

    GameManager gm;


    public SceneChanger(GameManager gm) {
        this.gm = gm;
    }

    public void showScene1(){
        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.messageText.setText("Let's defeat the demon");
    }

    public void showScene2(){
        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.bgPanel[3].setVisible(true);
        gm.ui.messageText.setText("Scene 2 ");
    }

    public void showScene3(){
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(true);
        gm.ui.messageText.setText("Scene 3 ");
    }

    public void showGameoverScreeen(int currentBgNum){

        gm.ui.bgPanel[currentBgNum].setVisible(true);
        gm.ui.titleJLabel.setVisible(true);
        gm.ui.titleJLabel.setText("GAME OVER");
        gm.ui.restartButton.setVisible(true);
        gm.ui.restartButton.setText("Restart here");
    }

    public void existGameOverScreen(){
        gm.ui.titleJLabel.setVisible(false);
        gm.ui.restartButton.setVisible(false);
        gm.player.setPlayerDefaultStatus();
    }
}
