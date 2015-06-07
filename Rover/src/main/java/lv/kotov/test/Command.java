package lv.kotov.test;

import java.util.function.Function;

public enum Command {
	
	LEFT    ('L', Rover::left), 
	RIGHT   ('R', Rover::right), 
	ADVANCE ('A', Rover::advance), 
	BACK    ('B', Rover::back);

	private final char code;
	private final Function<Rover, Rover> handler;
	
	public char getCode() {
		return code;
	}

	public Function<Rover, Rover> getHandler() {
		return handler;
	}

	private Command(char code, Function<Rover, Rover> handler) {
		this.code = code;
		this.handler = handler;
	}

	public static Command of(int value) {
		for (Command command : Command.values()) {
			if (command.getCode() == value) {
				return command;
			}
		}
		throw new IllegalArgumentException("Unknown command value [" + value + "]");
	}

}
