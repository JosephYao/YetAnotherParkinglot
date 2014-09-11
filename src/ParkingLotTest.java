import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {

	ParkingLot parkinglot;

	@Test
	public void notFull() {
		initParkingLot(1, 0);
		assertFalse(parkinglot.isFull());
	}

	@Test
	public void parkFirstCar() {
		initParkingLot(2, 0);
		assertEquals(1, parkinglot.park());
	}

	@Test
	public void parkSecondCar() {
		initParkingLot(2, 1);
		assertEquals(2, parkinglot.park());
	}

	@Test
	public void parkOnlyOne() {
		initParkingLot(1, 1);
		assertTrue(parkinglot.isFull());
	}

	@Test
	public void parkAll() {
		initParkingLot(3, 3);
		assertTrue(parkinglot.isFull());
	}

	@Test(expected = IllegalStateException.class)
	public void parkWhenFull() {
		initParkingLot(1, 1);
		parkinglot.park();
	}

	@Test
	public void oneCarLeave() {
		initParkingLot(2, 2);
		parkinglot.leave(2);
		assertEquals(parkinglot.park(), 2);
	}

	@Test
	public void twoCarLeave() {
		initParkingLot(2, 2);
		parkinglot.leave(2);
		parkinglot.leave(1);
		assertEquals(parkinglot.park(), 1);
		assertEquals(parkinglot.park(), 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void capacityShouldNotZero() {
		initParkingLot(0, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void capacityShouldNotNegative() {
		initParkingLot(-1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void leaveParkedCar_1() {
		initParkingLot(2, 2);
		parkinglot.leave(3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void leaveParkedCar_2() {
		initParkingLot(2, 2);
		parkinglot.leave(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void leaveParkedCar_3() {
		initParkingLot(2, 2);
		parkinglot.leave(-1);
	}

	private void initParkingLot(int cap, int parked) {
		parkinglot = new ParkingLot(cap);
		parkSome(parked);
	}

	private void parkSome(int c) {
		while (c-- > 0) {
			parkinglot.park();
		}
	}
}
