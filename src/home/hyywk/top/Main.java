package home.hyywk.top;

import java.io.IOException;
import java.net.Socket;

public class Main {
	public static void main(String[] args)  {
		Receiver receiver = new Receiver( 8081 );
		IPParser ipParser = new IPParser();
		Sender sender = new Sender();
		while( true ) {
			Logger.log("����ip��ȡ׼������");
			try {
				Socket socket = receiver.receive();
				ProcessUtil processUtil = new ProcessUtil(socket, ipParser, sender);
				processUtil.start();
			} catch (IOException e) {
				e.printStackTrace();
				Logger.log("����������󣬵ȴ�30s����������");
				receiver.reconnect();
			}
		}
	}
}
