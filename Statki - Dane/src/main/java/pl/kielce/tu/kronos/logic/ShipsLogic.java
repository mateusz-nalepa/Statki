package pl.kielce.tu.kronos.logic;

import java.io.IOException;
import java.util.Random;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import pl.kielce.tu.kronos.flagstaff.Flagstaff;
import pl.kielce.tu.kronos.flagstaff.FourFlagstaff;
import pl.kielce.tu.kronos.flagstaff.OneFlagstaff;
import pl.kielce.tu.kronos.flagstaff.ThreeFlagstaff;
import pl.kielce.tu.kronos.flagstaff.TwoFlagstaff;
import pl.kielce.tu.kronos.gui.ControllerDuel;
import pl.kielce.tu.kronos.gui.PopUp;
import pl.kielce.tu.kronos.logic.Const;

public class ShipsLogic {
	private static ShipsLogic shipsLogic = null;

	private ShipsLogic() {
	}

	/**
	 * 
	 * @return instancja klasy ShipsLogic jako singleton
	 */
	public static ShipsLogic getInstance() {
		if (shipsLogic == null) {
			shipsLogic = new ShipsLogic();
		}
		return shipsLogic;
	}

	// public static ClientConnection connect;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * public static ClientConnection getConnect() { return connect; }
	 * 
	 * public static void setConnect(ClientConnection connect) {
	 * ShipsLogic.connect = connect; }
	 */

	/*
	 * public static byte GOOD_AREA_HORIZONTAL = 0; public static byte
	 * Const.GOOD_AREA_VERTICAL = 1; public static byte
	 * Const.OUT_OF_RANGE_HORIZONTAL = 2; public static byte
	 * Const.OUT_OF_RANGE_VERTICAL = 3; public static byte
	 * Const.BLOCKED_HORIZONTAL = 4; public static byte Const.BLOCKED_VERTICAL =
	 * 5; public static byte Const.NOT_BLOCKED_HORIZONTAL = 6; public static
	 * byte Const.NOT_BLOCKED_VERTICAL = 7; public static byte
	 * Const.READY_TO_SET = 8; public static byte Const.NOT_READY_TO_SET = 9;
	 * public static byte Const.MAX_NUMBER_SHIP = 10; public static byte
	 * Const.BAD_AREA = 11; public static byte BLOCKED = 12;
	 * 
	 * public static byte MISS = 13; public static byte HIT = 14; public static
	 * byte HIT_AND_SUNK = 15; public static byte YOUR_TURE = 16; public static
	 * byte ENEMY_TURE = 17; public static byte HORIZONTAL = 18; public static
	 * byte VERTICAL = 19; public static byte OWN_IMAGES = 20; public static
	 * byte ENEMY_IMAGES = 21;
	 * 
	 * public static byte DEFEAT = 22; public static byte VICTORY = 23;
	 */

	private Label nickAndNumberOfFlagstaff;
	private int error;
	private int numberOfShip;

	public String orientation;
	public String typeOfShip;

	public ComboBox<String> orientationCombo;
	public ComboBox<String> typeOfShipCombo;

	private Label labelMessage;
	Label ownRemainedShips;
	private Button startGameButton;

	Player player;

	private int lengthFlagstaff;
	private String idButton;
	public Button[][] buttons;
	public Button[][] enemyButtons;

	public ImageView[][] ownImages;

	public ImageView[][] enemyImages;

	public Flagstaff[] tabOfShips;

	private int pointX;
	private int pointY;

	private Label enemySunkShips;
	private TextFlow logs;
	private ScrollPane scrollPane;

	private Map enemyMap;
	private Label labelTure;

	int activeTure;

	public Label enemyNick;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Label getNickAndNumberOfFlagstaff() {
		return nickAndNumberOfFlagstaff;
	}

	public Label getEnemyNick() {
		return enemyNick;
	}

	public void setEnemyNick(Label enemyNick) {
		this.enemyNick = enemyNick;
	}

	public int getActiveTure() {
		return activeTure;
	}

	public void setActiveTure(int activeTure) {
		this.activeTure = activeTure;
	}

	public Map getEnemyMap() {
		return enemyMap;
	}

	public void setEnemyMap(Map enemyMap) {
		this.enemyMap = enemyMap;
	}

	public Label getLabelTure() {
		return labelTure;
	}

	public void setLabelTure(Label ture) {
		this.labelTure = ture;
	}

	public ScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(ScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public TextFlow getLogs() {
		return logs;
	}

	public void setLogs(TextFlow logs) {
		this.logs = logs;
	}

	public Label getEnemySunkShip() {
		return enemySunkShips;
	}

	public void setEnemySunkShips(Label enemySunkShips) {
		this.enemySunkShips = enemySunkShips;
	}

	public void setNickAndNumberOfFlagstaff(Label nickAndNumberOfFlagstaff) {
		this.nickAndNumberOfFlagstaff = nickAndNumberOfFlagstaff;
	}

	public Button getStartGameButton() {
		return startGameButton;
	}

	public void setStartGameButton(Button startGameButton) {
		this.startGameButton = startGameButton;
	}

	public Label getRemainedShips() {
		return ownRemainedShips;
	}

	/**
	 * resetuje na widoku gracza podczas ukladania statkow ilosc statkow do ulozenia
	 */
	public void resetRemainedShips() {
		this.ownRemainedShips.setText("10 ships to set.");
	}

	public void setRemainedShips(Label remainedShips) {
		this.ownRemainedShips = remainedShips;
	}

	public Label getLabelMessage() {
		return labelMessage;
	}

	public void setLabelMessage(Label labelMessage) {
		this.labelMessage = labelMessage;
	}

	public ComboBox<String> getOrientationCombo() {
		return orientationCombo;
	}

	public void setOrientationCombo(ComboBox<String> orientationCombo) {
		this.orientationCombo = orientationCombo;
	}

	public ComboBox<String> getTypeOfShipCombo() {
		return typeOfShipCombo;
	}

	public void setTypeOfShipCombo(ComboBox<String> typeOfShipCombo) {
		this.typeOfShipCombo = typeOfShipCombo;
	}

	public String getTypeOfShip() {
		return typeOfShip;
	}

	public void setTypeOfShip(String typeOfShip) {
		this.typeOfShip = typeOfShip;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public int getNumberOfShip() {
		return numberOfShip;
	}

	public void setNumberOfShip(int numberOfShips) {
		this.numberOfShip = numberOfShips;
	}

	public void incNumberOfShip() {
		this.numberOfShip++;
	}

	public void resetNumberOfShip() {
		this.numberOfShip = 0;
	}

	public int getError() {
		return error;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setError(int error) {
		this.error = error;
	}

	/**
	 * tworzenie listy w ktorej sa elementy ktore sa dodawane do comboBoxa podczas ukladania statkow
	 */
	private static ObservableList<String> orientationList = FXCollections.observableArrayList("Horizontal", "Vertical");

	public ObservableList<String> getOrientationList() {
		return orientationList;
	}

	/**
	 * tworzenie listy w ktorej sa rodzaje typow statkow ktore sa dodawane do comboBoxa podczas ukladania statkow
	 */
	private static ObservableList<String> typeOfShipList = FXCollections.observableArrayList("1-flagstaff",
			"2-flagstaff", "3-flagstaff", "4-flagstaff");

	public ObservableList<String> typeOfShipList() {
		return typeOfShipList;
	}

	public int getLengthFlagstaff() {
		return lengthFlagstaff;
	}

	public void setLengthFlagstaff(int lengthFlagstaff) {
		this.lengthFlagstaff = lengthFlagstaff;
	}

	public String getIdButton() {
		return idButton;
	}

	public void setIdButton(String idButton) {
		this.idButton = idButton;
	}

	public int getPointX() {
		return pointX;
	}

	public void setPointX(int pointX) {
		this.pointX = pointX;
	}

	public int getPointY() {
		return pointY;
	}

	public void setPointY(int pointY) {
		this.pointY = pointY;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// ////////////////////////////////////////////////////
	///////////////////////////// OWN METHODS
	/////////////////////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////
	///////////////////////////// ////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * stworzenie obiektu typu Player w ktorym sa informacje dotyczace gracza
	 * @throws IOException
	 */
	public void createPlayer() throws IOException {
		player = new Player(0, Model.getOwnNick());
	}

	/**
	 * odswieza obrazki gracza, badz przeciwnika na podstawie parametrow
	 * @param map - referencja do obeiktu typu Map
	 * @param images - referancja do tablicy obiektow typu ImageView
	 */
	public void setImages(Map map, ImageView[][] images) {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				if (map.getMapXY(x, y) == Const.BLOCKED_FIELD) {
					images[x][y].setId("blockedField");
				} else if (map.getMapXY(x, y) == Const.EMPTY_FIELD) {
					images[x][y].setId("emptyField");
				} else if (map.getMapXY(x, y) == Const.HIT_FLAGSTAFF) {
					// images[x][y].setImage(image);
					images[x][y].setId("hitFlagstaff");
				} else if (map.getMapXY(x, y) == Const.MISS_FIELD) {
					images[x][y].setId("missField");
				} else if (map.getMapXY(x, y) == Const.SET_FLAGSTAFF) {
					images[x][y].setId("setFlagstaff");
				} else if (map.getMapXY(x, y) == Const.SUNK_FLAGSTAFF) {
					images[x][y].setId("sunkFlagstaff");
				}
				// System.out.println(y);

			}
			// System.out.println(x);

		}

	}

	/**
	 * odswieza widok statkow na mapie podczas ukladaniastatkow, badz rozgrywki
	 * @param images - okresla czy maja byc odswizone obrazki gracza, czy przeciwnika
	 */
	public void updateImages(int images) {
		Map map;
		ImageView[][] tabImages;
		if (images == Const.OWN_IMAGES) {
			map = player.getMap();
			tabImages = ownImages;
			setImages(map, tabImages);
		} else if (images == Const.ENEMY_IMAGES) {
			tabImages = enemyImages;
			map = enemyMap;
			setImages(map, tabImages);
		}
	}

	/**
	 * 
	 * @param x - wspolrzednia x na mapie
	 * @param y - wspolrzedna y na mapie
	 * przywraca obiektowi typu Button jego oryginalne ID
	 */
	public void setOriginalIDButton(int x, int y) {
		buttons[x][y].setId("ownShipButton" + String.valueOf(x) + String.valueOf(y));
	}

	/**
	 * przywraca oryginalne ID odpowiednim przyciskom gdy ukladamy statek poziomy i nie miesci sie on na mapie
	 */
	public void setHButtonsOriginalIDOutOfRange() {
		for (int x = getPointX(); x < 10; x++) {
			setOriginalIDButton(x, getPointY());
		}
	}

	/**
	 * przywraca oryginalne ID odpowiednim przyciskom gdy ukladamy statek pionowy i nie miesci sie on na mapie
	 */
	public void setVButtonsOriginalIDOutOfRange() {
		for (int y = getPointY(); y < 10; y++) {
			setOriginalIDButton(getPointX(), y);
		}
	}

	/**
	 * przywraca oryginalne ID odpowiednim przyciskom, gdy gracz moze ulozyc poziomy statek, lecz jednak go nie uklada
	 */
	public void setHButtonsOriginalID() {
		for (int x = getPointX(); x < getPointX() + getLengthFlagstaff(); x++) {
			setOriginalIDButton(x, getPointY());
		}
	}

	/**
	 * przywraca oryginalne ID odpowiednim przyciskom, gdy gracz moze ulozyc pionowy statek, lecz jednak go nie uklada
	 */
	public void setVButtonsOriginalID() {
		for (int y = getPointY(); y < getPointY() + getLengthFlagstaff(); y++) {
			setOriginalIDButton(getPointX(), y);
		}
	}

	/**
	 * na podstawie zminnej error okresla, ktorym przyciskom maja byc przypisane oryginalne ID
	 */
	public void setButtonsOriginalID() {

		int error = getError();
		if (error == Const.OUT_OF_RANGE_HORIZONTAL) {
			setHButtonsOriginalIDOutOfRange();
		} else if (error == Const.GOOD_AREA_HORIZONTAL) {
			setHButtonsOriginalID();
		} else if (error == Const.OUT_OF_RANGE_VERTICAL) {
			setVButtonsOriginalIDOutOfRange();
		} else if (error == Const.GOOD_AREA_VERTICAL) {
			setVButtonsOriginalID();
		} else if (error == Const.NOT_BLOCKED_HORIZONTAL) {
			setHButtonsOriginalID();
		} else if (error == Const.BLOCKED_HORIZONTAL) {
			setHButtonsOriginalID();
		} else if (error == Const.NOT_BLOCKED_VERTICAL) {
			setVButtonsOriginalID();
		} else if (error == Const.BLOCKED_VERTICAL) {
			setVButtonsOriginalID();
		}
	}

	/**
	 * Zmienia rodzaj statku z pionowy na poziomy i na odwrot, gdy klikniemy prawym przyciskiem myszy  i ponownie uruchamia sprawdzenie, czy w danym miejscu mozna ulozyc statek
	 * @param e - event myszy
	 * 
	 */
	public void changeOrientation(MouseEvent e) {
		if (e.getButton() == MouseButton.SECONDARY) {
			if (getOrientationCombo().getValue().equals("Horizontal")) {
				setButtonsOriginalID();
				setOrientation("Vertical");
				getOrientationCombo().setValue(getOrientation());
				isPossibleSetFlagstaff(getOrientation());
				return;
			} else if (getOrientationCombo().getValue().equals("Vertical")) {
				setButtonsOriginalID();
				setOrientation("Horizontal");
				getOrientationCombo().setValue(getOrientation());
				isPossibleSetFlagstaff(getOrientation());
				return;
			}
		}
	}

	/**
	 * ustawia przyciskom oryginalne ID, a potem zmienia rozmiar statku i sprawdza, czy w danym miejscu mozna ulozyc statek
	 * @param typeOfFlagstaff - dlugosc aktualnego statku
	 */
	public void thingsToDoAfterScroll(int typeOfFlagstaff) {
		setButtonsOriginalID();
		setTypeOfShip(String.valueOf(typeOfFlagstaff + "-flagstaff"));
		getTypeOfShipCombo().setValue(getTypeOfShip());
		isPossibleSetFlagstaff(getOrientation());
	}

	
	/**
	 * zwieksza rozmiar statku, gdy krecimy kolkiem w gore
	 * @param typeOfFlagstaff - dlugosc aktualnego statku
	 */
	public void incTypeOfFlagstaff(int typeOfFlagstaff) {
		typeOfFlagstaff++;
		if (typeOfFlagstaff > 4) {
			typeOfFlagstaff = 1;
		}
		thingsToDoAfterScroll(typeOfFlagstaff);
	}

	/**
	 * zmniejsza rozmiar statku, gdy krecimy kolkiem w gore
	 * @param typeOfFlagstaff - dlugosc aktualnego statku
	 */
	public void decTypeOfFlagstaff(int typeOfFlagstaff) {
		typeOfFlagstaff--;
		if (typeOfFlagstaff < 1) {
			typeOfFlagstaff = 4;
		}
		thingsToDoAfterScroll(typeOfFlagstaff);
	}

	/**
	 * Zmniejsza badz zwieksza rozmiar statku w zaleznosci od tego, czy aktualna orientacja statku jest pionowa badz pozioma
	 * @param e - informacje o tym, ze zostal wykonany event scrollowania myszka
	 */
	public void scrollChangeTypeOfShip(ScrollEvent e) {
		String typeAcutalElement;
		typeAcutalElement = typeOfShipCombo.getValue();
		int typeOfFlagstaff;
		typeOfFlagstaff = Character.getNumericValue(typeAcutalElement.charAt(0));

		// DOWN
		if (e.getDeltaY() < 0) {
			if (getOrientationCombo().getValue().equals("Horizontal")) {
				decTypeOfFlagstaff(typeOfFlagstaff);
			} else {
				incTypeOfFlagstaff(typeOfFlagstaff);
			}
		} else if (e.getDeltaY() > 0) {
			// UP
			if (getOrientationCombo().getValue().equals("Horizontal")) {
				incTypeOfFlagstaff(typeOfFlagstaff);
			} else {
				decTypeOfFlagstaff(typeOfFlagstaff);
			}
		}
	}

	/**
	 * ustawia odpowiedniemu przyciskowi odpowiednie ID, dzieki czemu wiemy, ze w danym miejscu nie mozna ustawic statku
	 * @param x - wspolrzedna X
	 * @param y - wspolrzedna Y
	 */
	public void setErrorOnView(int x, int y) {
		if (getError() == Const.OUT_OF_RANGE_HORIZONTAL) {
			labelSetErrorMessage(Const.BAD_AREA);
		} else if (getError() == Const.BLOCKED_HORIZONTAL) {
			labelSetErrorMessage(Const.BLOCKED);
		} else {
			labelSetErrorMessage(Const.MAX_NUMBER_SHIP);
		}
		buttons[x][y].setId("errorSetFlagstaff");
	}

	/**
	 * 
	 * @return info o tym, czy mozna w danym miejscu ustawic statek poziomy na podstawie dlugosci statku, czy nie
	 */
	public int isHOutOfRange() {
		if ((getPointX() + getLengthFlagstaff()) > 10) {
			return Const.OUT_OF_RANGE_HORIZONTAL;
		} else {
			return Const.GOOD_AREA_HORIZONTAL;
		}
	}

	/**
	 * 
	 * @return info o tym, czy mozna w danym miejscu ustawic statek pionowy na podstawie dlugosci statku, czy nie
	 */
	public int isVOutOfRange() {
		if ((getPointY() + getLengthFlagstaff()) > 10) {
			return Const.OUT_OF_RANGE_VERTICAL;
		} else {
			return Const.GOOD_AREA_VERTICAL;
		}
	}

	/**
	 * ustawia poziomym przyciskom odpowiednie ID, gdy statek wykracza poza obszar mapy
	 */
	public void setHButtonsIDErrorOutOfRange() {
		for (int x = getPointX(); x < 10; x++) {
			setErrorOnView(x, getPointY());
		}
	}

	/**
	 * ustawia pionowmy przyciskom odpowiednie ID, gdy statek wykracza poza obszar mapy
	 */
	public void setVButtonsIDErrorOutOfRange() {
		for (int y = getPointY(); y < 10; y++) {
			setErrorOnView(getPointX(), y);
		}
	}

	/**
	 * ustawia na labelu info o tym, ze mozna ustawic statek w danym miejscu
	 */
	public void labelSetReadyMessage() {
		getLabelMessage().setId("labelReady");
		getLabelMessage().setText("You can set a ship");
	}

	/**
	 * ustawia na labelu kolor czerwony informuajcy o bledzie oraz ustawia text, ktory informuje nas o rodzaju bledu
	 * @param type typ bledu
	 */
	public void labelSetErrorMessage(int type) {
		getLabelMessage().setId("labelError");
		if (type == Const.BAD_AREA) {
			getLabelMessage().setText("Ship on Land! :D");
		} else if (type == Const.MAX_NUMBER_SHIP) {
			getLabelMessage().setText("Enough of these ships!");
		} else if (type == Const.BLOCKED) {
			getLabelMessage().setText("Collision of ships!");
		}
	}

	/**
	 * ustawia danemu przyciskowi odpowienie ID na podstawie ktorego wiemy, ze w danym miejscu mozna ustawic statek
	 * @param x - wspolrzedne x
	 * @param y - wspolrzedne y
	 */
	public void setButtonIDReady(int x, int y) {
		labelSetReadyMessage();
		buttons[x][y].setId("shipIsReadyToSet");
	}

	/**
	 * ustawia poziomym przyciskom odpowienie ID, gdy mozna w danym miejscu ustawic statek
	 */
	public void setHButtonsIDReady() {
		for (int x = getPointX(); x < getPointX() + getLengthFlagstaff(); x++) {
			setButtonIDReady(x, getPointY());
		}
	}

	/**
	 * ustawia pionowym przyciskom odpowienie ID, gdy mozna w danym miejscu ustawic statek
	 */
	public void setVButtonsIDReady() {
		for (int y = getPointY(); y < getPointY() + getLengthFlagstaff(); y++) {
			setButtonIDReady(getPointX(), y);
		}
	}

	/**
	 * ustawia poziomym przyciskom odpowienie ID, gdy nie mozna w danym miejscu ustawic statek
	 */
	public void setHButtonsIDError() {
		for (int x = getPointX(); x < getPointX() + getLengthFlagstaff(); x++) {
			setErrorOnView(x, getPointY());
		}
	}

	/**
	 * ustawia pionowym przyciskom odpowienie ID, gdy nie mozna w danym miejscu ustawic statek
	 */
	public void setVButtonsIDError() {
		for (int y = getPointY(); y < getPointY() + getLengthFlagstaff(); y++) {
			setErrorOnView(getPointX(), y);
		}
	}

	/**
	 * 
	 * @return informacja o tym, czy w danym miejscu mozna ustawic poziomy statek i czy jest on zablokowany przez iny statek czy nie
	 */
	public int checkHBlockedShip() {
		for (int x = getPointX(); x < getPointX() + getLengthFlagstaff(); x++) {
			if ((player.getMap().getMapXY(x, getPointY()) == Const.SET_FLAGSTAFF)
					|| (player.getMap().getMapXY(x, getPointY()) == Const.BLOCKED_FIELD)) {
				return Const.BLOCKED_HORIZONTAL;
			}
		}
		return Const.NOT_BLOCKED_HORIZONTAL;
	}

	/**
	 * 
	 * @return informacja o tym, czy w danym miejscu mozna ustawic pionowy statek i czy jest on zablokowany przez iny statek czy nie
	 */
	public int checkVBlockedShip() {
		for (int y = getPointY(); y < getPointY() + getLengthFlagstaff(); y++) {
			if ((player.getMap().getMapXY(getPointX(), y) == Const.SET_FLAGSTAFF)
					|| (player.getMap().getMapXY(getPointX(), y) == Const.BLOCKED_FIELD)) {
				return Const.BLOCKED_VERTICAL;
			}
		}
		return Const.NOT_BLOCKED_VERTICAL;
	}

	/**
	 * Ustawia wybrany rodzaj statku w odpowiedniej tablicy obiektu typu player na podstawie parametrow oraz wybranych pol ktore zawiera klasa
	 * @param orientation - rodzaj statku (poziomy/pionowy)
	 * @param typeOfShip  - dlugosc statku
	 * @return informacja, ze w odpowiedniej tablicy gracza zostal ustawiony statek
	 */
	public boolean setFlagstaff(String orientation, String typeOfShip) {
		if (typeOfShip.equals("1-flagstaff")) {
			if (player.getOneFlagstaff(OneFlagstaff.getNumber1Flagstaff()).setFlagstaff(getPointX(), getPointY(),
					orientationCombo.getValue())) {
				return true;
			} else {
				labelSetErrorMessage(Const.MAX_NUMBER_SHIP);
			}
		} else if (typeOfShip.equals("2-flagstaff")) {
			if (player.getTwoFlagstaff(TwoFlagstaff.getNumber2Flagstaff()).setFlagstaff(getPointX(), getPointY(),
					orientation)) {

				return true;
			}

			else {
				labelSetErrorMessage(Const.MAX_NUMBER_SHIP);
			}
		}
		if (typeOfShip.equals("3-flagstaff")) {
			if (player.getThreeFlagstaff(ThreeFlagstaff.getNumber3Flagstaff()).setFlagstaff(getPointX(), getPointY(),
					orientationCombo.getValue())) {

				return true;
			} else {
				labelSetErrorMessage(Const.MAX_NUMBER_SHIP);
			}
		}
		if (typeOfShip.equals("4-flagstaff")) {
			if (player.getFourFlagstaff(FourFlagstaff.getNumber4Flagstaff()).setFlagstaff(getPointX(), getPointY(),
					orientationCombo.getValue())) {
				return true;
			} else {
				labelSetErrorMessage(Const.MAX_NUMBER_SHIP);
			}
		}
		return false;
	}

	/**
	 * Ustawia statek na tablicy ImageView oraz odswieza odpowiednie pola na widoku gracza, aby gracz wiedzial, ile statkow mu jeszcze zostalo do ulozenia
	 * @param orientation - rodzaj statku (poziomy/pionowy)
	 * @param typeOfShip  - dlugosc statku
	 * @return info, czy mozna jeszcze ulozyc jakis statek, czy nie
	 */
	public boolean setFlagstaffOnView(String orientation, String typeOfShip) {
		if (getNumberOfShip() >= 10) {
			// System.out.println("Nie mozna ustawic juz wiecej statkow!");
			return false;
		} else {
			if (isPossibleSetFlagstaff(orientation)) {
				if (setFlagstaff(orientation, typeOfShip)) {
					player.getMap().updateMap(getPointX(), getPointY(), getLengthFlagstaff(), orientation);
					updateImages(Const.OWN_IMAGES);
					incNumberOfShip();
					if (getNumberOfShip() == 10) {
						startGameButton.setDisable(false);
						getNickAndNumberOfFlagstaff().setText(Model.getOwnNick() + ", start Game!");
					}
					getRemainedShips().setText(String.valueOf(10 - getNumberOfShip()) + " ships to set.");
				}
			}
			return true;
		}
	}

	/**
	 * 
	 * @return informacja, czy jest juz maxymalna ilosc statkow na mapie danego typu
	 */
	public boolean isMaxNumberOfAnyTypeOfShip() {
		if ((FourFlagstaff.getNumber4Flagstaff() == 1) && (getTypeOfShip().equals("4-flagstaff"))
				|| (ThreeFlagstaff.getNumber3Flagstaff() == 2) && (getTypeOfShip().equals("3-flagstaff"))
				|| (TwoFlagstaff.getNumber2Flagstaff() == 3) && (getTypeOfShip().equals("2-flagstaff"))
				|| (OneFlagstaff.getNumber1Flagstaff() == 4) && (getTypeOfShip().equals("1-flagstaff"))) {
			return true;
		}
		return false;
	}

	/**
	 * sprawdza, czy w danum miejscu jest mozliwosc ustawienia poziomego statku
	 */
	public int isPossibleSetHFlagstaff() {
		setError(isHOutOfRange());
		if (getError() == Const.OUT_OF_RANGE_HORIZONTAL) {
			setHButtonsIDErrorOutOfRange();
			return Const.NOT_READY_TO_SET;
		} else if (getError() == Const.GOOD_AREA_HORIZONTAL) {
			setError(checkHBlockedShip());
			if ((getError() == Const.BLOCKED_HORIZONTAL) || isMaxNumberOfAnyTypeOfShip()) {
				setHButtonsIDError();
				return Const.NOT_READY_TO_SET;
			} else if (getError() == Const.NOT_BLOCKED_HORIZONTAL) {
				setHButtonsIDReady();
				return Const.READY_TO_SET;
			}
		}
		return Const.NOT_READY_TO_SET;
	}

	/**
	 * sprawdza, czy w danum miejscu jest mozliwosc ustawienia pionowego statku
	 */
	public int isPossibleSetVFlagstaff() {
		setError(isVOutOfRange());
		if (getError() == Const.OUT_OF_RANGE_VERTICAL) {
			setVButtonsIDErrorOutOfRange();
			return Const.NOT_READY_TO_SET;
		} else if (getError() == Const.GOOD_AREA_VERTICAL) {
			setError(checkVBlockedShip());
			if ((getError() == Const.BLOCKED_VERTICAL) || isMaxNumberOfAnyTypeOfShip()) {
				setVButtonsIDError();
				return Const.NOT_READY_TO_SET;
			} else if (getError() == Const.NOT_BLOCKED_VERTICAL) {
				setVButtonsIDReady();
				return Const.READY_TO_SET;
			}
		}
		return Const.NOT_READY_TO_SET;
	}

	/**
	 * 
	 * @param orientation - rodzaj statku (pionowy/poziomy)
	 * @return zwraca czy w danym miejscu mozna ustawic statek danego typu
	 */
	public boolean isPossibleSetFlagstaff(String orientation) {
		if ((orientation.equals("Horizontal")) && (isPossibleSetHFlagstaff() == Const.READY_TO_SET)) {
			return true;
		} else if ((orientation.equals("Vertical")) && (isPossibleSetVFlagstaff() == Const.READY_TO_SET)) {
			return true;
		}
		return false;
	}

	/**
	 * Metoda ta losuje dlugosc statku
	 * @param r obiekt klasy dzieki ktorej mozna losowac typy prymitywne
	 */
	public void randomSetTypeOfShip(Random r) {
		int random;
		String type;
		random = r.nextInt(5);
		type = String.valueOf(random);
		setTypeOfShip(type + "-flagstaff");
		getTypeOfShipCombo().setValue(getTypeOfShip());

	}

	/**
	 * metoda losuje orientacje statku
	 * @param r obiekt klasy dzieki ktorej mozna losowac typy prymitywne
	 */
	public void randomSetOrientation(Random r) {
		int random;
		random = (byte) r.nextInt(2);
		if (random % 2 == 0) {
			setOrientation("Horizontal");
		} else {
			setOrientation("Vertical");
		}
		getOrientationCombo().setValue(getOrientation());
	}

	/**
	 * metoda losuje wspolrzedne x i y miejsca, w ktorym bedzie sie staral ulozyc statek
	 * @param r obiekt klasy dzieki ktorej mozna losowac typy prymitywne
	 */
	public void randomSetXY(Random r) {
		int x, y;
		boolean correctPoint = true;
		do {
			x = r.nextInt(10);
			y = r.nextInt(10);
			if (player.getMap().getMapXY(x, y) == Const.EMPTY_FIELD) {
				correctPoint = false;
			}
		} while (correctPoint);
		setPointX(x);
		setPointY(y);
	}

	/**
	 * losowanie mapy ze statkami, jesli statki sie nie wylosuja poprawnie, to wyskakuje odpowiedni komunikat
	 */
	public void randomMap() {
		int loop = 0;
		if (getNumberOfShip() == 10) {
			resetMap();
			getLabelMessage().setText("Ships are setted!\n but order is a order!");
		}
		Random r = new Random();
		while (getNumberOfShip() < 10) {
			randomSetTypeOfShip(r);
			randomSetOrientation(r);
			randomSetXY(r);
			setFlagstaffOnView(getOrientationCombo().getValue(), getTypeOfShipCombo().getValue());
			setButtonsOriginalID();
			loop++;

			if (loop > 300) {
				getLabelMessage().setTextFill(Color.RED);
				getLabelMessage().setText("Not all ships are setted!");
				break;
			}
		}
		// System.out.println(loop);
		getLabelMessage().setText("All ships are setted!");
	}

	/**
	 * resetuje sie liczba statkow ktore pozostaly do ulozenia
	 */
	public void resetNumbers() {
		OneFlagstaff.resetNumber1Flagstaff();
		TwoFlagstaff.resetNumber2Flagstaff();
		ThreeFlagstaff.resetNumber3Flagstaff();
		FourFlagstaff.resetNumber4Flagstaff();
		resetNumberOfShip();
		resetRemainedShips();
	}

	/**
	 * typ statku jest przywracany na domyslny (poziomy)
	 */
	public void resetOrientation() {
		setOrientation("Horizontal");
		getOrientationCombo().setValue(getOrientation());
	}

	/**
	 * dlugosc statku jest przywracana na domyslna
	 */
	public void resetTypeOfShip() {
		setTypeOfShip("4-flagstaff");
		getTypeOfShipCombo().setValue(getTypeOfShip());
	}

	/**
	 * resetuje widok statkow na mapie (czysci go)
	 */
	public void resetMapOnView() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				player.getMap().setMapXY(x, y, Const.EMPTY_FIELD);
			}
		}
		updateImages(Const.OWN_IMAGES);
	}

	/**
	 * resetuje tablice ze wszystkimi statkami, ktore zawiera player
	 */
	public void resetShip() {
		player.resetTablesOfShip();
	}

	/**
	 * resetuje mape
	 */
	public void resetMap() {
		if (getNumberOfShip() == 0) {
			getLabelMessage().setText("Clear a empty Map?\n As you wish!");
		}
		resetOrientation();
		resetTypeOfShip();
		resetMapOnView();
		resetShip();
		resetNumbers();
		startGameButton.setDisable(true);
	}

	/**
	 * ustawia aktualna ture jako gracza
	 */
	public void tureSetYou() {
		Platform.runLater(() -> {
			getLabelTure().setFont(new Font("Arial", 28));
			labelTure.setTextFill(Color.GREEN);
			labelTure.setText("Your Ture");
		});
	}

	/**
	 * ustawia aktualna ture jako przciwnika
	 */
	public void tureSetEnemy() {
		Platform.runLater(() -> {
			getLabelTure().setFont(new Font("Arial", 28));
			labelTure.setTextFill(Color.RED);
			getLabelTure().setText("Enemy Ture");
		});
	}

	/**
	 * wylacza przyciski na ktorych sa statki rpzeciwnika, aby nie mozna bylo klikac, gdy jest tura przeciwnika
	 */
	public void setDisableEnemyButtons() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				enemyButtons[x][y].setDisable(true);
			}
		}
	}

	/**
	 * aktywuje przyciski, na ktorych sa statki przeciwnika, aby mozna bylo strzelac do niego
	 */
	public void setEnableEnemyButtons() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				enemyButtons[x][y].setDisable(false);
			}
		}
	}

	/**
	 * dodaje sie log informujacy o tym, ze przeciwnik spudlowal oraz austawia sie aktualna tura
	 * @param x - wsp x
	 * @param y - wsp y
	 */
	public void enemyShotMiss(int x, int y) {
		setEnableEnemyButtons();
		addLog(Const.ENEMY_TURE, x, y, Const.MISS);
		player.getMap().setMapXY(x, y, Const.MISS_FIELD);
		setActiveTure(Const.YOUR_TURE);

		Platform.runLater(() -> {
			labelTure.setTextFill(Color.GREEN);
			labelTure.setText("Your Ture");
		});
	}

	/**
	 * Dodaje odpowiedni wpis do panelu w trakcie trwania rozgrywki
	 * @param ture - typ tury (gracza/przeciwnika)
	 * @param x - wsp x
	 * @param y - wsp y
	 * @param status - czy statek trafiony, zatopiony, czy trafiony i zatopiony
	 */
	public void addLog(int ture, int x, int y, byte status) {
		Text text = new Text();
		Text line = new Text("\n----------------------------------------\n");

		text.setFont(Font.font("Arial", FontPosture.REGULAR, 16));

		int temp;
		temp = x;
		x = y;
		y = temp;
		y++;
		if (ture == Const.YOUR_TURE) {
			shipsLogic.addLogYourMove(text, x, y, status);
		} else {
			shipsLogic.addLogEnemyMove(text, x, y, status);
		}

		Platform.runLater(() -> {
			shipsLogic.getLogs().getChildren().addAll(text, line);
			ControllerDuel.setScrooling(true);
		});

	}

	/**
	 * ustawia odpowiednie informacje, gdy gracz spudluje, informacje te to: dodanie logu, zmiana aktywnej tury oraz uruchomienie watku, w ktorym gracz czeka na swoja ture 
	 * @param data - informacje pobrane z serwera
	 */
	public void yourShotMiss(ServerData data) {
		setDisableEnemyButtons();
		addLog(Const.YOUR_TURE, data.getX(), data.getY(), Const.MISS);
		enemyMap.setMapXY(data.getX(), data.getY(), Const.MISS_FIELD);
		updateImages(Const.ENEMY_IMAGES);
		setActiveTure(Const.ENEMY_TURE);

		Platform.runLater(() -> {
			labelTure.setTextFill(Color.RED);
			labelTure.setText("Enemy ture");
		});

		waitForYourTure();
	}

	/**
	 * dodanie wpisu, gdy przeciwnik trafil w statek gracza
	 * @param data dane z serwera
	 */
	public void enemyShotHit(ServerData data) {
		addLog(Const.ENEMY_TURE, data.getX(), data.getY(), Const.HIT);
		player.getMap().setMapXY(data.getX(), data.getY(), Const.HIT_FLAGSTAFF);
	}

	/**
	 * dodanie wpisu gdy gracz trafil w statek przeciwnika
	 * @param data - dane z serwera  o trafieniu
	 */
	public void yourShotHit(ServerData data) {
		addLog(Const.YOUR_TURE, data.getX(), data.getY(), Const.HIT);
		enemyMap.setMapXY(data.getX(), data.getY(), Const.HIT_FLAGSTAFF);
	}

	/**
	 * zwieksza ilosc zatopiopnych statkow przeciwnika w lewej gornej czesc mapy podczas rozgrywki
	 */
	public void incEnemySunkShips() {
		int drowned;
		drowned = Integer.parseInt(enemySunkShips.getText());
		drowned++;
		enemySunkShips.setText(String.valueOf(drowned));
	}

	/**
	 * dodaje wpis na mape oraz zmniejsza ilosc pozostalych statkow gracza, gdy przeciwnik zatopi statek
	 * @param data - dane z serwera
	 */
	public void enemyShotHitAndSunk(ServerData data) {
		addLog(Const.ENEMY_TURE, data.getX(), data.getY(), Const.HIT_AND_SUNK);
		if (data.getOrientation().equals("Horizontal")) {
			shipsLogic.player.getMap().setHSunkShipOnMap(data.getX(), data.getY(), data.getLength());
		} else {
			shipsLogic.player.getMap().setVSunkShipOnMap(data.getX(), data.getY(), data.getLength());
		}
		decOwnRemainedShips();

	}

	/**
	 * zmniejsza aktualna ilosc statkow gracza
	 */
	public void decOwnRemainedShips() {
		Label pozostale;
		pozostale = shipsLogic.ownRemainedShips;
		int remained = Integer.parseInt(pozostale.getText()) - 1;
		Platform.runLater(() -> {
			pozostale.setText(String.valueOf(remained));
		});
	}

	/**
	 * dodaje wpis do logow w trakcie rozgrywki oraz zwieksza ilosc zatopionych statkow przeciwnika
	 * @param data - dane z serwera
	 */
	public void yourShotHitAndSunk(ServerData data) {
		addLog(Const.YOUR_TURE, data.getX(), data.getY(), Const.HIT_AND_SUNK);
		if (data.getOrientation().equals("Horizontal")) {
			enemyMap.setHSunkShipOnMap(data.getX(), data.getY(), data.getLength());
		} else {
			enemyMap.setVSunkShipOnMap(data.getX(), data.getY(), data.getLength());
		}
		incEnemySunkShips();
	}

	/**
	 * wystartowanie gry, ktore odbywa sie w drugim watku
	 */
	public void startGame() {
		Runnable r = new WaitForSecondThread(player, enemyNick);
		Thread t = new Thread(r);
		t.start();
	}

	/**
	 * zamienia podana liczbe na odpowiednia litere
	 * @param x - wsp x
	 * @return wsp x zamieniona na litere
	 */
	public String getLetter(int x) {
		String letter;
		x += 65;
		letter = Character.toString((char) x);
		return letter;
	}

	/**
	 * dodaje wpis do logow, gdy gracz strzelil na mapie przeciwnika
	 * @param text  - zmienna z textem do dodania
	 * @param x - wsp x
	 * @param y - wsp y
	 * @param status info o trafieniu (hit, sunk, miss)
	 */
	public void addLogYourMove(Text text, int x, int y, byte status) {
		text.setText("You shot in: " + getLetter(x) + ":" + String.valueOf(y));
		if (status == Const.MISS) {
			text.setFill(Color.ORANGE);
			text.setText(text.getText() + "\nStatus: Miss");
		} else if (status == Const.HIT) {
			text.setFill(Color.BLUEVIOLET);
			text.setText(text.getText() + "\nStatus: Hit");
		} else if (status == Const.HIT_AND_SUNK) {
			text.setFill(Color.GREEN);
			text.setText(text.getText() + "\nStatus: Hit and Sunk");
		}
	}

	/**
	 * dodaje wpis do logow, gdy przeciwnik strzelil na mapie gracza
	 * @param text  - zmienna z textem do dodania
	 * @param x - wsp x
	 * @param y - wsp y
	 * @param status info o trafieniu (hit, sunk, miss)
	 */
	public void addLogEnemyMove(Text text, int x, int y, byte status) {
		text.setText("Enemy shot in: " + getLetter(x) + ":" + String.valueOf(y));
		if (status == Const.MISS) {
			text.setFill(Color.ORANGE);
			text.setText(text.getText() + "\nStatus: Miss");
		} else if (status == Const.HIT) {
			text.setFill(Color.CRIMSON);
			text.setText(text.getText() + "\nStatus: Hit");
		} else if (status == Const.HIT_AND_SUNK) {
			text.setFill(Color.RED);
			text.setText(text.getText() + "\nStatus: Hit and Sunk");
		}

	}

	/**
	 * tworzy w pamieci mape na ktorej beda umieszczane statki przeciwnika
	 */
	public void createEnemyMap() {
		enemyMap = new Map();
	}

	/**
	 * ustawia na wirtualnej mapie status mapy na puste pole
	 */
	public void removeBlockedFields() {
		player.getMap().removeBlockedFields();
	}

	/**
	 * ustawia przycisk na kolor czerwony, gdy w danym miejscu na mapie przeciwnika nie mozna strzelac
	 */
	public void setEnemyButtonID() {
		if (enemyMap.getMapXY(getPointX(), getPointY()) != Const.EMPTY_FIELD) {
			enemyButtons[getPointX()][getPointY()].setId("errorShot");
		}
	}

	
	/**
	 * wysyla na serwer info wspolrzednych x, y w ktore trafil gracz a potem dostaje odpowiedz z serwera, czy trafil w jakis statek czy nie i na podstawie tego jest potem dodawany wpis do logow oraz ustawiana mapa przeciwnika
	 */
	public void yourTure() {
		String coordXY;
		coordXY = Integer.toString(getPointX()) + ":" + Integer.toString(getPointY());
		Model.connect.sendData(coordXY);
		ServerData serverData = new ServerData("10:" + Model.connect.getData());

		if (serverData.getTypeOfShot() == Const.MISS) {
			yourShotMiss(serverData);
		} else if (serverData.getTypeOfShot() == Const.HIT) {
			yourShotHit(serverData);
		} else if (serverData.getTypeOfShot() == Const.HIT_AND_SUNK) {
			yourShotHitAndSunk(serverData);
		}
		updateImages(Const.ENEMY_IMAGES);
		if (isYouWin(serverData.getStatus())) {
			youWin();
		}
	}

	/**
	 * wyslakuje okienko z informacje o wygranej oraz przechodzi do tablicy najlepszych wynikow
	 */
	public void youWin() {
		Model.setPopUpData("popUpPaneYouWin", "Victory", "VICTORY!!");
		try {
			PopUp.display(Model.getPopUpData());
			ClientStart.mainWindow.changeStage("HighScore", "HighScore", 600, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Model.connect.disconnectWithServer();
	}

	/**
	 * 
	 * @param status informacja z serwera o tym, czy zatopione sa juz wszystkie statki przeciwnika czy nie
	 * @return info, czy gracz juz wygral, czy nie
	 */
	public boolean isYouWin(int status) {
		if (status == Const.VICTORY) {
			return true;
		}
		return false;

	}

	/**
	 * ustawienie odpowiedniego pola na mapie gracza, gdy przeciwnik spudluje
	 * @param data - dae z serwera
	 */
	public void enemyMissed(ServerData data) {
		enemyShotMiss(data.getX(), data.getY());
		updateImages(Const.OWN_IMAGES);
		setActiveTure(Const.YOUR_TURE);
	}

	/**
	 * wystartowanie watku w ktorym jest oczekiwanie na swoja ture
	 */
	public void waitForYourTure() {
		Runnable ref = new WaitPlayerThread(shipsLogic);
		Thread thread = new Thread(ref);
		thread.start();

	}

	/**
	 * 
	 * @param status info o tym, czy juz sie przegralo czy nie, info jest z serwera
	 * @return zwraca informacje o tym, czy sie rpzegralo czy nie
	 */
	public boolean isYouDefeated(int status) {
		if (status == Const.DEFEAT) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * wyskakuje okienko o przegranej oraz przechodzi potem do tablicy najlepszych wynikow
	 */
	public void youLose() {
		Model.setPopUpData("popUpPaneYouLose", "Lose", "You Lose...");
		Platform.runLater(() -> {
			try {
				PopUp.display(Model.getPopUpData());
				ClientStart.mainWindow.changeStage("HighScore", "HighScore", 600, 400);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		// Model.connect.disconnectWithServer();
	}

}