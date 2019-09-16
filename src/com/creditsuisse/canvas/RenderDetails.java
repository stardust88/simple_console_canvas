package com.creditsuisse.canvas;

public class RenderDetails {

	public RenderDetails(Integer x1, Integer y1, Integer x2, Integer y2, Character color) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	public RenderDetails() {}


	private Integer x1;
	private Integer y1;
	private Integer x2;
	private Integer y2;
	private Character color;
	

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	
	
	public void setValues(Integer x1,Integer y1,Integer x2,Integer y2,Character color) {
		this.x1 =x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
		
	}
	

}
