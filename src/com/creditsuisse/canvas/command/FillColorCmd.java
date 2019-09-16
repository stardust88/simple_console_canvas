package com.creditsuisse.canvas.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creditsuisse.canvas.Canvas;
import com.creditsuisse.canvas.RenderDetails;
import com.creditsuisse.canvas.exception.CanvasException;

@Component
public class FillColorCmd implements Command{
	@Autowired
	Canvas canvas;

	@Override
	public void execute(RenderDetails cmdDetails) throws CanvasException {
		canvas.fillColor(cmdDetails);
	}
}
