package com.credisuisse.canvas.command.invoker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creditsuisse.canvas.CommandFactory;
import com.creditsuisse.canvas.RenderDetails;
import com.creditsuisse.canvas.command.Command;
import com.creditsuisse.canvas.command.CreateCanvasCmd;
import com.creditsuisse.canvas.command.CreateLineCmd;
import com.creditsuisse.canvas.command.CreateRectangleCmd;
import com.creditsuisse.canvas.command.FillColorCmd;
import com.creditsuisse.canvas.exception.CanvasException;

@Component
public class CommandInvoker {

	@Autowired
	CommandFactory commandFactory;

	public static final char defaultChar = 'x';

	public boolean invoke(String commandArgs) throws CanvasException {
		char ch = commandArgs.charAt(0);
		boolean triggeredSucccess = false;
		Command command = commandFactory.getCommand(ch);
		if (command == null) {
			throw new CanvasException("Command not found");
		}

		String[] cmd = commandArgs.split(" ");
		try {
			command.execute(populateRenderDetails(cmd));
			triggeredSucccess = true;

		} catch (Exception e) {
			throw new CanvasException(e.getLocalizedMessage());
		}
		
		return triggeredSucccess;
	}

	private RenderDetails populateRenderDetails(String[] cmd) throws CanvasException {
		Integer x1 = null, x2 = null, y1 = null, y2 = null;
		Character color = defaultChar;
		try {
			x1 = Integer.parseInt(cmd[1]);
			y1 = Integer.parseInt(cmd[2]);

			if (cmd[0].equals("B")) {
				color = cmd[3].charAt(0);
			} else if (cmd[0].equals("L") || cmd[0].equals("R")) {
				x2 = Integer.parseInt(cmd[3]);
				y2 = Integer.parseInt(cmd[4]);
			}
		} catch (Exception e) {
			throw new CanvasException("Wrong cordinate formats");
		}

		return new RenderDetails(x1, y1, x2, y2, color);

	}

}
