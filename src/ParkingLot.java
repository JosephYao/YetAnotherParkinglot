public class ParkingLot {

	private final int[] leaved;
	private int leaved_pos = 0;

	public ParkingLot(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException();
		}
		leaved = new int[cap];
		do {
			leaved[leaved_pos] = cap - leaved_pos;
		} while (++leaved_pos < cap);
	}

	public boolean isFull() {
		return 0 == leaved_pos;
	}

	public int park() {
		if (leaved_pos > 0) {
			return leaved[--leaved_pos];
		}
		throw new IllegalStateException();
	}

	public void leave(int c) {
		if (c <= 0 || c > leaved.length) {
			throw new IllegalArgumentException();
		}
		leaved[leaved_pos++] = c;
	}
}
