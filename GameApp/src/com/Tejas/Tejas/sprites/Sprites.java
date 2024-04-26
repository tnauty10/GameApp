/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.richa.gaming.sprites;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Raja Roy
 */
public abstract class Sprites {
    public int speed;
    public int x;
    public int y;
    public int w;
    public int h;
    public ImageIcon image;
    public void draw(Graphics g) {
	g.drawImage(image.getImage(),x,y,w,h,null);
    }
    public void mode(){
        y = y+speed;
    }
}

