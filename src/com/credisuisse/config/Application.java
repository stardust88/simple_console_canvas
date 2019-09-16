package com.credisuisse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.creditsuisse.canvas.DrawingApp;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	DrawingApp app;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		app.startApp();

	}

}
