package home.hyywk.top;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Sender {
	public void send( Socket socket, String msg) {
		try {
			OutputStream outputStream = socket.getOutputStream();
			byte[] bs = msg.getBytes();
			outputStream.write(bs, 0, bs.length);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
