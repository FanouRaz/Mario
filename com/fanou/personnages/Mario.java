package com.fanou.personnages;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Mario extends Personnage {
    private Image imgMario;
    private ImageIcon icoMario;

    public Mario(int x, int y){
        super(x,y,50,28);
        this.icoMario = new ImageIcon(getClass().getResource("/assets/images/MarioArretDroite.png"));
        this.imgMario = icoMario.getImage();
    }

    public Image getImgMario(){
        return this.imgMario;
    }
    
}
