package com.fanou.objets;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Bloc extends Objet {
    private ImageIcon icoBloc;
    private Image imgBloc;    

    public Bloc(int x, int y){
        super(43,65,x,y);
        this.icoBloc = new ImageIcon(getClass().getResource("/assets/images/bloc.png"));
        this.imgBloc = icoBloc.getImage();
    }

    public Image getImgBloc(){
        return this.imgBloc;
    }
}

