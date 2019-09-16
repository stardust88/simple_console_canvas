package com.creditsuisse.canvas.command;

import com.creditsuisse.canvas.RenderDetails;
import com.creditsuisse.canvas.exception.CanvasException;

public interface Command {
	
	public void execute(RenderDetails renderDetails) throws CanvasException;

}
