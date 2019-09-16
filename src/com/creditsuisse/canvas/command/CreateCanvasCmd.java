package com.creditsuisse.canvas.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creditsuisse.canvas.Canvas;
import com.creditsuisse.canvas.RenderDetails;

@Component
public class CreateCanvasCmd implements Command{

	@Autowired
	Canvas canvas;
	

	@Override
	public void execute(RenderDetails renderDetails) {
		canvas.createCanvas(renderDetails);
	}

}
