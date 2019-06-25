package home.hyywk.top;

import java.io.IOException;
import java.net.Socket;

public class Main {
	public static void main(String[] args)  {
		Receiver receiver = new Receiver( 8081 );
		IPParser ipParser = new IPParser();
		Sender sender = new Sender();
		while( true ) {
			Logger.log("监听ip获取准备就绪");
			try {
				Socket socket = receiver.receive();
				ProcessUtil processUtil = new ProcessUtil(socket, ipParser, sender);
				processUtil.start();
			} catch (IOException e) {
				e.printStackTrace();
				Logger.log("发生网络错误，等待30s后重新连接");
				receiver.reconnect();
			}
		}
	}
}
