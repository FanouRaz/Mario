package com.fanou.jeu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ClavierEvent implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            Main.arrierePlan.setDx(1);
            if(Main.arrierePlan.getxPos() == -1){
                Main.arrierePlan.setxPos(0);
                Main.arrierePlan.setxFond1(-50);
                Main.arrierePlan.setxFond2(750);
            }
            Main.arrierePlan.mario.setMarche(true);
            Main.arrierePlan.mario.setVersDroite(true);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Main.arrierePlan.setDx(-1);
            Main.arrierePlan.mario.setMarche(true);
            Main.arrierePlan.mario.setVersDroite(false);
        } 
    }   
    
    @Override
    public void keyReleased(KeyEvent e){
        Main.arrierePlan.setDx(0);
        Main.arrierePlan.mario.setMarche(false);
    }

    @Override 
    public void keyTyped(KeyEvent e){}
}
