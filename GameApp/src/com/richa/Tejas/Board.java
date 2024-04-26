/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.richa.gaming;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.richa.gaming.sprites.Enemy1;
import com.richa.gaming.sprites.Enemy2;
import com.richa.gaming.sprites.Player;

public class Board extends JPanel{
	Timer timer;
	BufferedImage backgroundImage;
	Player player;
        Enemy1 enemies1[] = new Enemy1[2];
        Enemy2 enemies2[] = new Enemy2[2];
	public Board() {
            setSize(1500,800);
            loadBackgroundImage();
            player = new Player();
            gameLoop();
            loadEnemies();
            
            bindEvents();
            setFocusable(true);
	}
        private void loadEnemies(){
            int x1 =400;
            int x2 = 650;
            int gap = 550;
            int speed1 = 5;
            int speed2 = 10;
            for(int i=0;i<enemies1.length;i++){
                enemies1[i] = new Enemy1(x1,speed1);  
                x1= x1+gap;
                speed1 = speed1+5;
            }
            for(int i=0;i<enemies2.length;i++){
                enemies2[i] = new Enemy2(x2,speed2);  
                x2= x2+gap;
                speed2 = speed2 +10;
            }
        }
	private void gameLoop() {
		timer = new Timer(50, (e) -> {
			repaint();
			gameOver(getGraphics());
		});
		timer.start();
	}
	private void loadBackgroundImage() {
		try {
			backgroundImage = ImageIO.read(Board.class.getResource("background.jpg"));
		} catch (IOException e) {
			System.out.println("Background Image not found");
			System.exit(1);
			e.printStackTrace();
		}
	}
        private void printEnemies(Graphics g){
            for(Enemy1 enemy1 :enemies1){
               enemy1.draw(g);
               enemy1.move();
               
            }
            for(Enemy2 enemy2 :enemies2){
               enemy2.draw(g);
               enemy2.move();
            }
        }
        private void bindEvents() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
                            player.speed = 10;
                            else if (e.getKeyCode() == KeyEvent.VK_LEFT) 
                            player.speed = -10;
			}

			@Override
			public void keyReleased(KeyEvent e) {
                            player.speed = 0;
			}
		});
	}
        private void gameOver(Graphics pen) {
		if (player.outOfScreen()) {
			pen.setFont(new Font("times", Font.BOLD, 30));
			pen.setColor(Color.red);
			pen.drawString("Game Win", 1500 / 2, 930 / 2);
			timer.stop();
			return;

		}
		for (Enemy1 enemy1 : enemies1) {
			if (isCollide1(enemy1)) {
				pen.setFont(new Font("times", Font.BOLD, 30));
				pen.setColor(Color.red);
				pen.drawString("Game Over", 1500 / 2, 800 / 2);
				timer.stop();
			}
		}
                for (Enemy2 enemy2 : enemies2) {
			if (isCollide2(enemy2)) {
				pen.setFont(new Font("times", Font.BOLD, 30));
				pen.setColor(Color.red);
				pen.drawString("Game Over", 1500 / 2, 800 / 2);
				timer.stop();
			}
		}

	}
        private boolean isCollide1(Enemy1 enemy1) {
		int xDistance = Math.abs(player.x - enemy1.x);
		int yDistance = Math.abs(player.y - enemy1.y);
		int maxH = Math.max(player.h, enemy1.h);
		int maxW = Math.max(player.w, enemy1.w);
		return xDistance <= maxW - 120 && yDistance <= maxH - 120;
	}
        private boolean isCollide2(Enemy2 enemy2) {
		int xDistance = Math.abs(player.x - enemy2.x);
		int yDistance = Math.abs(player.y - enemy2.y);
		int maxH = Math.max(player.h, enemy2.h);
		int maxW = Math.max(player.w, enemy2.w);
		return xDistance <= maxW - 120 && yDistance <= maxH - 120;
	}
	public void paintComponent(Graphics g) {
		// all printing logic will be here
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,1500,800,null);
		player.draw(g);
                player.move();
                printEnemies(g);
                gameOver(g);
	}
}

