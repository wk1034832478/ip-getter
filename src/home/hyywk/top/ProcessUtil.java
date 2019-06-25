package home.hyywk.top;

import java.net.Socket;


public class ProcessUtil extends Thread {
	private Socket socket;
	private IPParser ipParser;
	private Sender sender;
	
	public ProcessUtil(Socket socket, IPParser ipParser, Sender sender) {
		super();
		this.socket = socket;
		this.ipParser = ipParser;
		this.sender = sender;
	}

	public void run() {
		String ip = ipParser.parse( socket );
		Logger.log("½âÎöipµØÖ·Îª£º" + ip );
		sender.send(socket, ip);
	}
}
