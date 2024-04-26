/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.richa.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	public GameFrame() {
		Board board = new Board();
		setVisible(true);
		setSize(1500,800);
		setResizable(false);
		setTitle("Game Development in Java");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(board);
	}
	public static void main(String[] args) {
		new GameFrame();
		
	}
}

