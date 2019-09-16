package com.creditsuisse.canvas;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.credisuisse.canvas.command.invoker.CommandInvoker;
import com.creditsuisse.canvas.exception.CanvasException;

@Component
public class DrawingApp {

	@Autowired
	CommandInvoker invoker;
	
	public void startApp() {
		
		System.out.println("Welcome to Drawing App");
		System.out.println("Please enter following commands");
		System.out.println("C w h          Create a new canvas of width w and height h.\n" + 
				"L x1 y1 x2 y2   Create a new line from (x1,y1) to (x2,y2).\n" + 
				"R x1 y1 x2 y2   Create a new rectangle, whose upper left corner is (x1,y1) and\n" + 
				"                lower right corner is (x2,y2). \n" + 
				"B x y c         Fill the entire area connected to (x,y) with \"colour\" c. T\n" + 
				"Q               Quit the program.");
		
		Scanner scan = new Scanner(System.in);
		String command = new String();
		while(!command.equals("Q")) {
			try {
			System.out.print("enter command:");
			command = scan.nextLine();
			validateInput(command);
			invoker.invoke(command);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Program Exited!");
		scan.close();
		
	}
	
	private void validateInput(String command) throws CanvasException {
		if(StringUtils.isEmpty(command)) {
			throw new CanvasException("Empty command");
		}
		if(command.split(" ").length<3) {
			throw new CanvasException("Incomplete command");
		}
	}
	
	
	
}
