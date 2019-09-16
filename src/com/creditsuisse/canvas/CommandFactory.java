package com.creditsuisse.canvas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creditsuisse.canvas.command.Command;
import com.creditsuisse.canvas.command.CreateCanvasCmd;
import com.creditsuisse.canvas.command.CreateLineCmd;
import com.creditsuisse.canvas.command.CreateRectangleCmd;
import com.creditsuisse.canvas.command.FillColorCmd;

@Component
public class CommandFactory {
	
	@Autowired
	CreateCanvasCmd createCmd;
	@Autowired
	CreateLineCmd createLine;
	@Autowired
	CreateRectangleCmd createRectangle;
	@Autowired
	FillColorCmd fillColor;
	
	
	public Command getCommand(char cmd) {
		
		Command command = null;
			switch(cmd) {
				case 'C' :
					command = createCmd;
				break;
				case 'L' :
					command = createLine;
				break;
				case 'R' :
					command = createRectangle;
				break;
				case 'B' :
					command = fillColor;
				break;
			}
			
		return command;
	}
}
