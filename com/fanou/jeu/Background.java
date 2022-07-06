package com.fanou.jeu;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.fanou.objets.Bloc;
import com.fanou.objets.Tuyau;
import com.fanou.personnages.Mario;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Background extends JPanel {
    private ImageIcon icoFond;
    private Image imgFond1;
    private Image imgFond2;
    private ImageIcon icoChateau1;
    private Image imgChateau1;
    private ImageIcon icoDepart;
    private Image imgDepart;

    private int xFond1;
    private int xFond2;
    private int dx;
    private int xPos;

    public Mario mario;
    public Tuyau tuyau1;
    public Bloc bloc;

    public Background(){
        super();
        this.xFond2 = 750;    
        this.xFond1 = -50;
        this.dx = 0;
        this.xPos = -1;
        this.icoFond = new ImageIcon(getClass().getResource("/assets/images/fondEcran.png"));
        this.icoFond = new ImageIcon(getClass().getResource("/assets/images/fondEcran.png"));
       
        
        this.icoChateau1 = new ImageIcon(getClass().getResource("/assets/images/chateau1.png"));
        this.imgChateau1 = icoChateau1.getImage();
        this.icoDepart = new ImageIcon(getClass().getResource("/assets/images/depart.png"));
        this.imgDepart = icoDepart.getImage();
        
        mario = new Mario(300,245);
        tuyau1 = new Tuyau(600, 230);
        bloc = new Bloc(400,180);
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();
        this.setFocusable(true);
        this.requestFocusInWindow();   
        this.addKeyListener(new ClavierEvent());
        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }    
    
    public int getxFond1(){
        return xFond1;
    }
    public void setxFond1(int xFond1){
        this.xFond1 = xFond1;
    }
    public int getxFond2(){
        return this.xFond2;
    }
    public void setxFond2(int xFond2){
        this.xFond2 = xFond2;
    }

    public void deplacementFond(){
        if(this.xPos >=0){
            this.xFond1 -= this.dx; 
            this.xFond2 -= this.dx;
            this.xPos += this.dx; 
        }
        
        if(this.xFond1 == -800){
            this.xFond1 = 800;
        }
        else if(this.xFond2 == -800){
            this.xFond2 = 800;
        }
        
        else if(this.xFond1 == 800){
            this.xFond1 = -800;
        }
        else if(this.xFond2 == 800){
            this.xFond2 = -800;
        }
    }

    public int getDx(){
        return this.dx;
    }

    public void setDx(int dx){
        this.dx = dx;
    }

    public int getxPos(){
        return this.xPos;
    }
    public void setxPos(int xPos){
        this.xPos = xPos;
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics g2 = (Graphics2D)g;
        if(mario.collision(this.tuyau1)){
            this.mario.setMarche(false);
            this.dx = 0;
        }
        this.deplacementFond();
        this.tuyau1.deplacement();
        //Detection collision avec tuyau
       

        g2.drawImage(this.imgFond1, this.xFond1, 0, null);
        g2.drawImage(this.imgFond2, this.xFond2, 0, null);
        g2.drawImage(mario.marche("mario",25), 300, 245, null);
        g2.drawImage(this.imgChateau1,10 - this.xPos,95,null);
        g2.drawImage(this.imgDepart,220 - this.xPos,234,null);
        g2.drawImage(this.tuyau1.getImgTuyau(), this.tuyau1.getX(),this.tuyau1.getY(),null );
        g2.drawImage(this.bloc.getImgBloc(), this.bloc.getX() - this.xPos,this.bloc.getY(),null );
    }
}
