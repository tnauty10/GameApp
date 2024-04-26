/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.richa.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprites {
	
	public Player() {
		w=150;
		h=200;
		x=50;
		y=550;
		image= new ImageIcon(Player.class.getResource("player.gif"));
	}
        public void move(){
            x = x+speed;
        }
        public boolean outOfScreen() {
		return x > 1500;
	}
	
}
