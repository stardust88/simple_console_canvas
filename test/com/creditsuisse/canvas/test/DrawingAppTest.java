package com.creditsuisse.canvas.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.credisuisse.canvas.command.invoker.CommandInvoker;
import com.credisuisse.config.AppConfig;
import com.creditsuisse.canvas.exception.CanvasException;

import junit.framework.Assert;

public class DrawingAppTest {
	AnnotationConfigApplicationContext ctx;
	@Before
	public void init() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}
	
	@Test(expected = CanvasException.class)
	public void testInvalidInput1() throws CanvasException {
		CommandInvoker app =ctx.getBean(CommandInvoker.class);
		app.invoke("1234");
	}
	
	@Test(expected = CanvasException.class)
	public void testInvalidInput2() throws CanvasException {
		CommandInvoker app =ctx.getBean(CommandInvoker.class);
		app.invoke("bsxkhajsbh");
	}
	
	@Test(expected = CanvasException.class)
	public void testInvalidInput3() throws CanvasException {
		CommandInvoker app =ctx.getBean(CommandInvoker.class);
		app.invoke("C -1 -2 ");
	}
	
	
	@Test
	public void testInvalidInputDisplayMsg() {
		CommandInvoker app =ctx.getBean(CommandInvoker.class);
		String exceptionMsg ="";
		try {
			app.invoke("1234");
		} catch (CanvasException e) {
			exceptionMsg = e.getMessage();
		}
		Assert.assertEquals("Command not found", exceptionMsg);
	}
	
	@Test
	public void testCommandTrigger() throws CanvasException {
		CommandInvoker app =ctx.getBean(CommandInvoker.class);
		Assert.assertEquals(true, app.invoke("C 1 2 "));
	}
	
	
	@Test
	public void testInvalidInputDisplayMsg2() {
		CommandInvoker app =ctx.getBean(CommandInvoker.class);
		String exceptionMsg ="";
		try {
			app.invoke("C a b c");
		} catch (CanvasException e) {
			exceptionMsg = e.getMessage();
		}
		Assert.assertEquals("Wrong cordinate formats", exceptionMsg);
	}
	
	@Test
	public void testInvalidInputDisplayMsg3() {
		CommandInvoker app =ctx.getBean(CommandInvoker.class);
		String exceptionMsg ="";
		try {
			app.invoke("R 1 2 3 4");
		} catch (CanvasException e) {
			exceptionMsg = e.getMessage();
		}
		Assert.assertEquals("canvas not created", exceptionMsg);
	}

}
