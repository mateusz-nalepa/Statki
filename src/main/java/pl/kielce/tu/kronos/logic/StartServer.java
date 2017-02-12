package pl.kielce.tu.kronos.logic;

import java.io.IOException;

public class StartServer {

	public StartServer() {
	}
	
	public static void main(String... args) {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
		try {
            Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -cp server.jar pl.kielce.tu.kronos.logic.Server"});
		} catch (IOException e1) {
			e1.printStackTrace();
		}

        System.out.println("end");
	}

}
