package lv.kotov.test;

import java.util.function.Function;

public class Rover {

	private final Point position;
	private final Direction direction;

	public Rover() {
		this(new Point(0, 0), Direction.NORTH);
	}

	private Rover(Point position, Direction direction) {
		super();
		this.position = position;
		this.direction = direction;
	}

	public Point getPosition() {
		return position;
	}

	public Direction getDirection() {
		return direction;
	}

	public Rover process(String cmdBatch) {
		Rover state = this;
		for (char cmd : cmdBatch.toCharArray()) {
			Command command = Command.of(cmd);
			Function<Rover, Rover> handler = command.getHandler();
			state = handler.apply(state);
		}
		return state;
	}

	static Rover back(Rover that) {
		return that.back();
	}

	private Rover back() {
		Point delta = direction.getDelta();
		return new Rover(position.advance(delta.neg()), direction);
	}

	static Rover advance(Rover that) {
		return that.advance();
	}

	private Rover advance() {
		Point delta = direction.getDelta();
		return new Rover(position.advance(delta), direction);
	}

	static Rover left(Rover that) {
		return that.left();
	}

	private Rover left() {
		return new Rover(position, direction.left());
	}

	static Rover right(Rover that) {
		return that.right();
	}

	private Rover right() {
		return new Rover(position, direction.right());
	}
}
