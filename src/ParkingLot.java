import java.util.Stack;

public class ParkingLot {

    private final Stack<Integer> parkingSeats = new Stack<>();
    private final int capacity;

	public ParkingLot(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException();
		}
        this.capacity = cap;
        while (cap > 0)
            parkingSeats.push(cap--);
	}

	public boolean isFull() {
		return parkingSeats.isEmpty();
	}

	public int park() {
		if (!parkingSeats.isEmpty()) {
            return parkingSeats.pop();
		}
		throw new IllegalStateException();
	}

	public void leave(int c) {
		if (c <= 0 || c > capacity) {
			throw new IllegalArgumentException();
		}
        parkingSeats.push(c);
	}
}
