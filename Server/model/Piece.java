package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Piece {
   private int xp;
   private int yp;
  private boolean isWhite;
  ArrayList<Piece> ps;
  private String name;
public Piece(int xp, int yp, boolean isWhite,String n, ArrayList<Piece> ps) {
	super();
	this.xp = xp;
	this.yp = yp;
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
	 for(Piece p:ps)
	 {
		 if (p.xp==xp && p.yp==yp)
		 {
			 p.kill();
		 }
	 }
	 this.xp=xp;
	 this.yp=yp;
 }
 public void kill()
 {
	 
 }
}