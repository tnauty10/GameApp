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
public class Enemy1 extends Sprites{
    
    public Enemy1(int x, int speed){
        y=50;
        this.x=x;
        this.speed = speed;
        w=150;
        h=150;
        image = new ImageIcon(Enemy1.class.getResource("enemy1.gif"));
    }
    public void move(){
        if(y>800){
            y=0;
        }
        y = y+speed;
    }
}
