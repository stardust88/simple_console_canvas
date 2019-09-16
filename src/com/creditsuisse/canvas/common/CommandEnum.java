package com.creditsuisse.canvas.common;

public enum CommandEnum {
	CREATE("C"),DRAW_LINE("L"),DRAW_RECTAGLE("R"),FILL_COLOR("B"),QUIT("Q");
	
	private String key;
	CommandEnum(String key){
		this.key=key;
	}
	
}
