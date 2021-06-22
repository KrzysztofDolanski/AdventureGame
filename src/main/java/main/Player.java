package main;

public class Player {

    GameManager gm;

    public int playerMaxLife;
    public int playerLife;

    public boolean hasSword;
    public boolean hasShield;
    public boolean hasCorpus;
    public boolean hasLighter;


    public Player(GameManager gm) {
        this.gm = gm;
    }

    public void setPlayerDefaultStatus(){
        playerMaxLife = 5;
        playerLife = 3;
        hasSword = false;
        hasShield = false;
        hasCorpus = true;
        hasLighter = false;

        updatePlayerStatus();
    }

    public void updatePlayerStatus(){
        int i = 0;
        while (i<5){
            gm.ui.lifeLabel[i].setVisible(false);
            i++;
        }

        int lifeCount = playerLife;
        while (lifeCount>0){
            gm.ui.lifeLabel[lifeCount].setVisible(true);
            lifeCount--;
        }
        if (!hasLighter){
            gm.ui.lighterLabel.setVisible(false);
        }
        if (hasLighter){
            gm.ui.lighterLabel.setVisible(true);
        }

        if (!hasSword){
            gm.ui.swordLabel.setVisible(false);
        }
        if (hasSword){
            gm.ui.swordLabel.setVisible(true);
        }

        if (!hasShield){
            gm.ui.shieldLabel.setVisible(false);
        }
        if (hasShield){
            gm.ui.shieldLabel.setVisible(true);
        }
        if (!hasCorpus){
            gm.ui.corpusLabel.setVisible(false);
        }
        if (hasCorpus){
            gm.ui.corpusLabel.setVisible(true);
        }


    }

}
