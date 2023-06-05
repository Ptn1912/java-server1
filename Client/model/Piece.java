package model;

import java.util.ArrayList;

import java.util.LinkedList;

import view.Board;

public class Piece {
   private int xp;
   private int yp;
   public int x;
  public int y;
   
  private boolean isWhite;
  ArrayList<Piece> ps;
  private String name;
public Piece(int xp, int yp, boolean isWhite,String n, ArrayList<Piece> ps) {
	super();
	this.xp = xp;
	this.yp = yp;
	x=xp*64;
	y=yp*64;
	this.isWhite = isWhite;
	name=n;
	this.ps=ps;
	ps.add(this);
}
  
 public int getXp() {
	return xp;
}

public void setXp(int xp) {
	this.xp = xp;
}

public int getYp() {
	return yp;
}

public void setYp(int yp) {
	this.yp = yp;
}

public boolean isWhite() {
	return isWhite;
}

public void setWhite(boolean isWhite) {
	this.isWhite = isWhite;
}

public ArrayList<Piece> getPs() {
	return ps;
}

public void setPs(ArrayList<Piece> ps) {
	this.ps = ps;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



public void move(int xp, int yp)

 {
	if(Board.getPiece(xp*64, yp*64) !=null)
	{
		if(Board.getPiece(xp*64, yp*64).isWhite!=isWhite)
		{
		  Board.getPiece(xp*64, yp*64).kill();
		  
		}
		else
		{
			 x=this.xp*64;
			 y=this.yp*64;
			 return;
		}
	}
	 this.xp=xp;
	 this.yp=yp;
	 x=xp*64;
	 y=yp*64;
 }
 public void kill()
 {
	 ps.remove(this);
 }
}
