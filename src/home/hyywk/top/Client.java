package home.hyywk.top;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		Socket socket;
		try {
			socket = new Socket("0.0.0.0", 8081);
			InputStream inputSteam = socket.getInputStream();
			while ( true ) {
				if ( inputSteam.available() == 0) {
					continue;
				}
				byte[] bs = new byte[inputSteam.available()];
				inputSteam.read(bs);
				Logger.log( "服务端信息信息：");
				Logger.log( new String(bs, 0, bs.length) );
				break;
			}
			inputSteam.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
