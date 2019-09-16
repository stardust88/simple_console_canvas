package com.creditsuisse.canvas.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.credisuisse.config.AppConfig;
import com.creditsuisse.canvas.Canvas;
import com.creditsuisse.canvas.RenderDetails;
import com.creditsuisse.canvas.exception.CanvasException;

import junit.framework.Assert;

public class CanvasTest {
	AnnotationConfigApplicationContext ctx;
	@Before
	public void init() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}
	
	
	@Test
	public void createCanvas() {
		Canvas canvas = ctx.getBean(Canvas.class);
		RenderDetails details =  ctx.getBean(RenderDetails.class);
		details.setValues(5, 5, null, null, 'x');
		canvas.createCanvas(details);
		Assert.assertEquals(true, canvas.isCanvasCreted());
	}
	
	@Test(expected= CanvasException.class)
	public void drawLine() throws CanvasException {
		Canvas canvas = ctx.getBean(Canvas.class);
		RenderDetails details =  ctx.getBean(RenderDetails.class);
		details.setValues(5, 5, null, null, 'x');
		canvas.createCanvas(details);
		
		details.setValues(1, 2, 3, 3, 'x');
		canvas.drawLine(details, false);
	}
	
	@Test
	public void testDrawRetangle() throws CanvasException {
		Canvas canvas = ctx.getBean(Canvas.class);
		RenderDetails details =  ctx.getBean(RenderDetails.class);
		details.setValues(10, 10, null, null, 'x');
		canvas.createCanvas(details);
		
		details.setValues(2, 2, 6, 6, 'x');
		canvas.drawRectangle(details);
		
		boolean rectangleDraw=true;
		char[][] canvasArray = canvas.getCanvasCopy();
		for(int i=2;i<6;i++) {
			if(canvasArray[2][i]!='x') {
				rectangleDraw = false;
				break;
			}
		}
		
		
		for(int i=2;i<6;i++) {
			if(canvasArray[i][2]!='x') {
				rectangleDraw = false;
				break;
			}
		}
		
		for(int i=2;i<6;i++) {
			if(canvasArray[i][6]!='x') {
				rectangleDraw = false;
				break;
			}
		}
		
		
		for(int i=2;i<6;i++) {
			if(canvasArray[6][i]!='x') {
				rectangleDraw = false;
				break;
			}
		}
		
		
		Assert.assertEquals(true, rectangleDraw);
		
		
	}

}
