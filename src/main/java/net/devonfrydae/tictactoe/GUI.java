package net.devonfrydae.tictactoe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import javax.swing.JFrame;

import net.devonfrydae.tictactoe.containers.Cell;
import net.devonfrydae.tictactoe.containers.Table;

public class GUI extends JFrame {
	private Game game;
	private Table table;
	
	public GUI() {
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Game game = new Game();
		this.game = game;
		this.table = game.getTable();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		table.drawTable(g2);
	}
}
