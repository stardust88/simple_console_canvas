package com.credisuisse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.credisuisse.canvas.command.invoker.CommandInvoker;
import com.creditsuisse.canvas.Canvas;
import com.creditsuisse.canvas.CommandFactory;
import com.creditsuisse.canvas.DrawingApp;
import com.creditsuisse.canvas.RenderDetails;
import com.creditsuisse.canvas.command.CreateCanvasCmd;
import com.creditsuisse.canvas.command.CreateLineCmd;
import com.creditsuisse.canvas.command.CreateRectangleCmd;
import com.creditsuisse.canvas.command.FillColorCmd;

@Configuration
@ComponentScan
public class AppConfig {

	@Bean
	public Canvas getCanvas() {
		return new Canvas();
	}

	@Bean
	public CommandInvoker getCommandInvoker() {
		return new CommandInvoker();
	}

	@Bean
	public DrawingApp getDrawingApp() {
		return new DrawingApp();
	}

	@Bean
	public CreateLineCmd getCreateLineCmd() {
		return new CreateLineCmd();
	}

	@Bean
	public CreateCanvasCmd getCreateCanvasCmd() {
		return new CreateCanvasCmd();
	}

	@Bean
	public FillColorCmd getFillColorCmd() {
		return new FillColorCmd();
	}

	@Bean
	public CreateRectangleCmd getCreateRectangleCmd() {
		return new CreateRectangleCmd();
	}

	@Bean
	public CommandFactory getCommandFactory() {
		return new CommandFactory();
	}
}
