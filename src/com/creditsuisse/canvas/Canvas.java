package com.creditsuisse.canvas;

import org.springframework.stereotype.Component;

import com.creditsuisse.canvas.exception.CanvasException;

@Component
public class Canvas {
 private int width;
 private int height;
 
 private char[][] canvasArray;
 
 private static final char HORIZONTAL_BOUNDARY_CHAR='-';
 private static final char VERTICAL_BOUNDARY_CHAR='|';

 
 public void createCanvas (RenderDetails cmdDetails) {
	 canvasArray = null;
	 this.width = cmdDetails.getX1()+2;
	 this.height = cmdDetails.getY1()+2;
	 canvasArray = new char[this.height][this.width];
	 
	 
	 drawCanvasBoundary();
 }
 
 
 private void drawCanvasBoundary() {

		for(int i=0;i<this.width;i++) {			 
			canvasArray[0][i]=HORIZONTAL_BOUNDARY_CHAR;
		}
		for(int i=0;i<this.height;i++) {			 
			canvasArray[i][0]=VERTICAL_BOUNDARY_CHAR;
		}

		for(int i=0;i<this.height;i++) {			 
			canvasArray[i][width-1]=VERTICAL_BOUNDARY_CHAR;
		}	
		
		for(int i=0;i<this.width;i++) {			 
			canvasArray[height-1][i]=HORIZONTAL_BOUNDARY_CHAR;
		}
		
		render();		
	
}


public void drawLine(RenderDetails cmdDetails, boolean render) throws CanvasException{
	if(canvasArray==null || canvasArray.length==0) {
		  throw new CanvasException("canvas not created");
	 }
	if(cmdDetails.getY1()>this.height-1 || cmdDetails.getX1()>this.width-1 || cmdDetails.getY2()>this.height-1 || cmdDetails.getX2()>this.width-1) {
		throw new CanvasException("Invalid coordinates.");
	}
	
	if(cmdDetails.getY1()== cmdDetails.getY2() || cmdDetails.getX1()==cmdDetails.getX2()) {
		 for(int i=cmdDetails.getY1(); i<=cmdDetails.getY2(); i++) {
				for(int j=cmdDetails.getX1(); j<=cmdDetails.getX2(); j++) {
					canvasArray[i][j] = cmdDetails.getColor();				
				}
			}
		 
		 if(render) {
			 render();
		 }
	 }else {
		 throw new CanvasException("Invalid coordinates.");
	 }
 }
 
 public void drawRectangle(RenderDetails cmdDetails) throws CanvasException {

	 int x1 =	cmdDetails.getX1();
	 int x2 = cmdDetails.getX2();
	 int y1 = cmdDetails.getY1();
	 int y2 = cmdDetails.getY2();
	 char color = cmdDetails.getColor();
	 
	 
	 	RenderDetails details = new RenderDetails(x1, y1, x2, y1, color);
		drawLine(details,false);
		
	 	details.setValues(x1, y2, x2, y2, color);
		drawLine(details, false);

	 	details.setValues(x1, y1, x1, y2, color);
		drawLine(details,false);
		
		
	 	details.setValues(x2, y1, x2, y2, color);
		drawLine(details, false);
		
		render();
	}
  
 // NOT WORKING. Could' complete this on time
 public void fillColor(RenderDetails cmdDetails) throws CanvasException{
	 int x = cmdDetails.getX1();
	 int y = cmdDetails.getY1();
	 char charToDraw = cmdDetails.getColor();
	 if(x<0 || y<0 ||x>width || y>height)
		 return;
	 
	 if((int)canvasArray[y][x] != ' ') {
			return;
		}
		
		if(x > 0 || x < this.height || y > 0 || y  < this.width) {
			if((int)canvasArray[y][x] == ' ')
				canvasArray[y][x] = charToDraw;
			fillColor(new RenderDetails(x-1,y,-1,-1,charToDraw));
			fillColor(new RenderDetails(x,y-1,-1,-1,charToDraw));
			fillColor(new RenderDetails(x-1,y-1,-1,-1,charToDraw));
			fillColor(new RenderDetails(x+1,y+1,-1,-1,charToDraw));			
		}
 }
 
 
 private void render() {		
		for(int i=0;i<this.height;i++) {
			for(int j=0;j<this.width;j++) {
				if(canvasArray[i][j]=='\u0000') {
					canvasArray[i][j]=' ';
				}
				System.out.print(canvasArray[i][j]);
			}
			System.out.println();
		}
	}
 
 public boolean isCanvasCreted() {
	 if(canvasArray==null || canvasArray.length==0) {
		 return false;
	 }
	 return true;
 }
 
 public char[][] getCanvasCopy() {
	 char [] [] canvasArrayCopy = new char[this.height][this.width];
	 for(int i=0; i<canvasArray.length; i++)
		  for(int j=0; j<canvasArray[i].length; j++)
			  canvasArrayCopy[i][j]=canvasArray[i][j];
	 
	 return canvasArrayCopy;
 }
 
}
