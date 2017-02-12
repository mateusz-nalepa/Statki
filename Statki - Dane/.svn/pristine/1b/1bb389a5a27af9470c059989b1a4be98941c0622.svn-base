package pl.kielce.tu.kronos.flagstaff;


/**
 * klasa dziedziczy po twoflagstaff, sa tutaj dane o trzymasztowcu
 * @author Nalepa Mateusz & Olesinski Patryk
 *
 */
public class ThreeFlagstaff extends TwoFlagstaff {

	protected int x3Point, y3Point;

	public ThreeFlagstaff() {
		super();
		this.length=3;
		this.lives=3;
	}

	@Override
	public void setCoordinates(int x1, int y1, String orientation) {
		// super(x1,y1,orientation);
		super.setCoordinates(x1, y1, orientation);

		if (orientation.equals("Vertical")) {
			this.y3Point = y2Point + 1;
			this.x3Point = x1;
		}

		if (orientation.equals("Horizontal")) {
			this.y3Point = y1;
			this.x3Point = x2Point + 1;
		}

	}
	
	

	public int getX3Point() {
		return x3Point;
	}

	public int getY3Point() {
		return y3Point;
	}

	public void setX3Point(int x3Point) {
		this.x3Point = x3Point;
	}

	public void setY3Point(int y3Point) {
		this.y3Point = y3Point;
	}



	private static byte number3Flagstaff = 0;

	public static byte getNumber3Flagstaff() {
		return number3Flagstaff;
	}

	public static void setNumber3Flagstaff(byte number3Flagstaff) {
		ThreeFlagstaff.number3Flagstaff = number3Flagstaff;
	}

	public static void incNumber3Flagstaff() {
		ThreeFlagstaff.number3Flagstaff++;
	}

	public static void resetNumber3Flagstaff() {
		ThreeFlagstaff.number3Flagstaff = 0;
	}

	public static byte MAX_NUMBER_THREE_FLAGSTAFF = 2;

	/**
	 * 
	 * @param x1 - wsp x1 statku
	 * @param y1 - wsp x2 statku
	 * @param orientation - czy pinowy, czy poziomy
	 * @return - info o tym, czy udalo sie ulozyc statek do tablicy, czu nie
	 */
	@Override
	public boolean setFlagstaff(int x1, int y1, String orientation) {
		if (ThreeFlagstaff.getNumber3Flagstaff() == MAX_NUMBER_THREE_FLAGSTAFF) {
			return false;
		} else {
			setCoordinates(x1, y1, orientation);
			ThreeFlagstaff.incNumber3Flagstaff();
			return true;
		}
	}

}
