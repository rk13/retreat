package lv.kotov.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoverTest {

	@Test
	public void testRoverStartsAtZero() {
		Rover rover = new Rover();
		assertEquals(new Point(0, 0), rover.getPosition());
	}

	@Test
	public void testRoverStartsToNorth() {
		Rover rover = new Rover();
		assertEquals(Direction.NORTH, rover.getDirection());
	}

	@Test
	public void testRoverRight() {
		Rover rover = new Rover().process("R");
		assertEquals(Direction.EAST, rover.getDirection());
	}

	@Test
	public void testRoverLeft() {
		Rover rover = new Rover().process("L");
		assertEquals(Direction.WEST, rover.getDirection());
	}

	@Test
	public void testRoverAdvance() {
		Rover rover = new Rover().process("A");
		assertThat(rover.getPosition(), is(new Point(0, 1)));
	}

	@Test
	public void testRoverBack() {
		Rover rover = new Rover().process("B");
		assertThat(rover.getPosition(), is(new Point(0, -1)));
	}
	
	@Test
	public void testRoverLara() {
		Rover rover = new Rover().process("LARA");
		assertThat(rover.getPosition(), is(new Point(-1, 1)));
	}
}
