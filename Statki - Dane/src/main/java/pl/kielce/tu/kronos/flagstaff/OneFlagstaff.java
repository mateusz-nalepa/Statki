package pl.kielce.tu.kronos.flagstaff;

import pl.kielce.tu.kronos.logic.Const;

/**
 * klasa dziedziczy po flagstaff, sa tutaj dane o jednomasztowcu
 * @author Nalepa Mateusz & Olesinski Patryk
 *
 */
public class OneFlagstaff extends Flagstaff {

	protected int x1Point, y1Point;
	protected byte orientation;
	public int lives;


	public OneFlagstaff() {
		super();
		this.length=1;
		this.lives=1;

	}

	/*
	 * public int getX1Point() { return x1Point; }
	 * 
	 * public void setX1Point(int x1Point) { this.x1Point = x1Point; }
	 */
	
	
	

	/**
	 * ustawia wspolrzedne pol statku na podstawie wspolrzednych poczatkowych i orientacji statku (poziomy/pionowy)
	 * @param x1  - wsp x1 poczatkowa statku
	 * @param y1  - wsp y1 poczatkowa statku
	 * @param orientation
	 */
	public void setCoordinates(int x1, int y1, String orientation) {
		this.x1Point = x1;
		this.y1Point = y1;
		if(orientation.equals("Horizontal")){
			this.orientation=Const.HORIZONTAL;
		}
		else{
			this.orientation=Const.VERTICAL;
		}
		
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getX1Point() {
		return x1Point;
	}

	public int getY1Point() {
		return y1Point;
	}

	public void setX1Point(int x1Point) {
		this.x1Point = x1Point;
	}

	public void setY1Point(int y1Point) {
		this.y1Point = y1Point;
	}

	public byte getOrientation() {
		return orientation;
	}

	public void setOrientation(byte orientation) {
		this.orientation = orientation;
	}

	public static byte MAX_NUMBER_ONE_FLAGSTAFF = 4;

	/**
	 * 
	 * @param x1 - wsp x1 statku
	 * @param y1 - wsp x2 statku
	 * @param orientation - czy pinowy, czy poziomy
	 * @return - info o tym, czy udalo sie ulozyc statek do tablicy, czu nie
	 */
	public boolean setFlagstaff(int x1, int y1, String orientation) {
		if (OneFlagstaff.getNumber1Flagstaff() == MAX_NUMBER_ONE_FLAGSTAFF) {
			return false;
		} else {
			setCoordinates(x1, y1, orientation);
			OneFlagstaff.incNumber1Flagstaff();
			return true;
		}
	}

	private static byte number1Flagstaff = 0;

	public static byte getNumber1Flagstaff() {
		return number1Flagstaff;
	}

	public static void setNumber1Flagstaff(byte numberFlagstaff) {
		OneFlagstaff.number1Flagstaff = numberFlagstaff;
	}

	public static void incNumber1Flagstaff() {
		OneFlagstaff.number1Flagstaff++;
	}

	public static void resetNumber1Flagstaff() {
		OneFlagstaff.number1Flagstaff = 0;
	}

	public void print() {
		System.out.println("napis");
	}

}
