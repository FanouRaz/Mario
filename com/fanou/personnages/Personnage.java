package com.fanou.personnages;

import javax.swing.ImageIcon;

import com.fanou.jeu.Main;
import com.fanou.objets.Objet;

import java.awt.Image;

public class Personnage {
    private int hauteur, largeur; //Dimension du personnage
    private int x,y; //Position du personnage
    private boolean marche; //vrai quand le personnage se déplace
    private boolean versDroite;//vrai quand le personnage est tourné vers la droite
    private int compteur; //compteur des pas du personnage

    public Personnage(int x, int y, int hauteur, int largeur){
        this.x = x;
        this.y = y;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.compteur = 0;
        this.marche = false;
        this.versDroite = true;
    }
    public int getHauteur(){
        return hauteur;
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
    public boolean getMarche(){
        return this.marche;
    }
    public void setMarche(boolean marche){
        this.marche = marche;
    }
    public boolean getVersDroite(){
        return this.versDroite;
    }
    public void setVersDroite(boolean versDroite){
        this.versDroite = versDroite;
    }
    public int getCompteur(){
        return this.compteur;
    }
    public void setCompteur(int compteur){
        this.compteur = compteur;
    }


    public Image marche(String nom, int frequence){
        String str;
        ImageIcon ico;
        Image img;

        if(!this.marche ||Main.arrierePlan.getxPos() <= 0){
            if(this.versDroite){
                str = String.format("/assets/images/%sArretDroite.png",nom);
            }
            else {
                str = String.format("/assets/images/%sArretGauche.png",nom);
            }
        }
        else{
            this.compteur++;
            if(this.compteur / frequence == 0){
                if(this.versDroite){
                    str = String.format("/assets/images/%sArretDroite.png",nom);
                }
                else {
                    str = String.format("/assets/images/%sArretGauche.png",nom);
                }
            }
            else{
                if(this.versDroite){
                    str = String.format("/assets/images/%sMarcheDroite.png",nom);
                }
                else {
                    str = String.format("/assets/images/%sMarcheGauche.png",nom);
                }
            }
            if(this.compteur == 2*frequence){
                this.compteur =0;
            }
        }
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    public boolean collision(Objet objet){
        if(this.versDroite){
            if(this.x + this.largeur  < objet.getX() || this.x + this.largeur > 5 + objet.getX() || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
      
    }
}
