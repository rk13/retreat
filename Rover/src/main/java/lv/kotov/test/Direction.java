package lv.kotov.test;

public enum Direction {

	NORTH (0,  1), 
	EAST  (1,  0), 
	SOUTH (0, -1), 
	WEST  (-1, 0);

	private final Point delta;

	public Point getDelta() {
		return delta;
	}

	private Direction(int deltaX, int deltaY) {
		this.delta = new Point(deltaX, deltaY);
	}

	public Direction right() {
		Direction[] values = Direction.values();
		int currPos = ordinal();
		int nextPos = (currPos + 1) % values.length;
		return values[nextPos];
	}

	public Direction left() {
		Direction[] values = Direction.values();
		int currPos = ordinal();
		int nextPos = currPos == 0 ? values.length - 1 : currPos - 1;
		return values[nextPos];
	}

}
