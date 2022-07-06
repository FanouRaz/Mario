package com.fanou.jeu;

import javax.swing.JFrame;

public class Main extends JFrame {
    public static Background arrierePlan;
    public Main(){
        arrierePlan = new Background();
        this.setTitle("Mario");
        this.setSize(700,360);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(arrierePlan);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new Main();
    }
}
