package pl.kielce.tu.kronos.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import pl.kielce.tu.kronos.database.HighScores;
import pl.kielce.tu.kronos.logic.Logs;
import pl.kielce.tu.kronos.logic.Player;

/**
 * <pre>
 * @author Patryk Olesiñski
 * @author Mateusz Nalepa
 *</pre>
 */
public class ClientConnection {
	private Socket s;

	/**
	 * Funkcja inicjujaca polaczenie klienta z serverem
	 * @param serverHost - Gniazdo servera
	 * @return True jesli sie udalo polaczyc, false jesli nie
	 */
	public boolean connectWithServer(String serverHost) {
		try {
			s = new Socket(serverHost, ServerRun.SERVER_PORT);
			return true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logs.LOGGER.warning("Connect problem");
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Zamkniecie gniazda, zamkniecie polaczenia z serverem
	 */
	public void disconnectWithServer() {
		try {
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			Logs.LOGGER.warning("Disconnect problem");
			e.printStackTrace();
		}
	}
	/**
	 * Wyslanie danych typu string przez gniazdo
	 * @param data - tekst do wyslania
	 */
	public void sendData(String data) {
		OutputStream outStream;
		try {
			outStream = s.getOutputStream();
			PrintWriter out = new PrintWriter(outStream, true);
			out.println(data);
		} catch (IOException e) {
			Logs.LOGGER.warning("Send data problem");
			e.printStackTrace();
		}

	}
	/**
	 * Odebranie danych z gniazda
	 * @return - odebrane dane
	 */
	public String getData() {
		String data = null;
		InputStream inStream;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			data = in.readLine();
			return data;
		} catch (IOException e1) {
			Logs.LOGGER.warning("Get data problem");
			e1.printStackTrace();
		}
		return data;
	}
	/**
	 * Wyslanie zserializowanego obiektu typu player
	 * @param player - obiekt typu Player do wyslania przez siec
	 */
	public void sendPlayer(Player player) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(player);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	/**
	 * Odebranie obiektu typu player z gniazda
	 * @return Obiekt typu Player
	 * @throws IOException
	 */
	public Player getPlayer() throws IOException {
		Player player = null;
		ObjectInputStream ois;
		ois = new ObjectInputStream(s.getInputStream());
		try {
			player = (Player) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}
	/**
	 * Pobranie obiektu typu HighScores z gniazda
	 * @return Obiekt typu HighScores odebrany z sieci
	 * @throws IOException
	 */
	public HighScores getHighScores() throws IOException {
		HighScores hs = null;
		ObjectInputStream ois;
		ois = new ObjectInputStream(s.getInputStream());
		try {
			hs = (HighScores) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hs;
	}
	/**
	 * Wyslanie zserializowanego obiektu typu HighScores przez siec
	 * @param hs - Obiekt typu HighScores do wyslania
	 */
	public void sendHighScores(HighScores hs) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(hs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
