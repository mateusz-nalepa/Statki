package pl.kielce.tu.kronos.logic;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * watek, w ktorym gra juz wystartowala i jest oczekiwanie az drugi gracz sie do niej dolaczy
 * @author Nalepa Mateusz & Olesinski Patryk
 *
 */
public class WaitForSecondThread implements Runnable {
	Player player;
	Label enemyNick;
	ShipsLogic shipsLogic;
	public WaitForSecondThread(Player player, Label enemyNick) {
		super();
		this.player = player;
		this.enemyNick=enemyNick;
		this.shipsLogic = ShipsLogic.getInstance();
	}

	/**
	 * wystartowanie watku
	 */
	@Override
	public void run() {
		String data="";
		final String nick;
		String[] tab = new String[3];
		data = Model.connect.getData();
		tab = data.split(":");
		nick = tab[1];
		player.setId(Integer.parseInt(tab[0]));
		Platform.runLater(() -> {
			enemyNick.setText(nick);
		});
		shipsLogic.setActiveTure(Integer.parseInt(tab[2]));
		
		Model.connect.sendPlayer(player);

		if (shipsLogic.getActiveTure() == Const.YOUR_TURE) {
			// Gra
			shipsLogic.setEnableEnemyButtons();
			shipsLogic.tureSetYou();
		} else {
			// Czeka
			shipsLogic.tureSetEnemy();
			shipsLogic.setDisableEnemyButtons();
			shipsLogic.waitForYourTure();
		}

	}
}
