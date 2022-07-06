package com.fanou.objets;

import javax.swing.ImageIcon;

import java.awt.Image;

public class Tuyau extends Objet {
    private ImageIcon icoTuyau;
    private Image imgTuyau;    

    public Tuyau(int x, int y){
        super(43,65,x,y);
        this.icoTuyau = new ImageIcon(getClass().getResource("/assets/images/tuyau.png"));
        this.imgTuyau = icoTuyau.getImage();
    }

    public Image getImgTuyau(){
        return this.imgTuyau;
    }
}
