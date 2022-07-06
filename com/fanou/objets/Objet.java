package com.fanou.objets;

import com.fanou.jeu.Main;

public class Objet {
    private int hauteur, largeur; //Dimension de l'objet
    private int x,y;//Position de l'objet

    public Objet(int hauteur,int largeur, int x, int y){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.x = x;
        this.y = y;
    }

    public int getHauteur(){
        return this.hauteur;
    }
    public void setHauteur(int hauteur){
        this.hauteur = hauteur;
    }
    public int getLargeur(){
        return largeur;
    }
    public void setLargeur(int largeur){
        this.largeur = largeur;
    }
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return this.y;
    }
    public void setY(int y){
        this.y = y;
    }

    public void deplacement(){
        if(Main.arrierePlan.getxPos() >=0){
            this.x -= Main.arrierePlan.getDx();
        }
    }

}
