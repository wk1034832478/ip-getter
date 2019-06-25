package home.hyywk.top;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author 王凯
 *
 */
public class Receiver {
	private ServerSocket socket;
	private int port;
	public Receiver(int port) {
		this.port = port;
		try {
			this.socket = new ServerSocket(this.port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	   * 接受  
	 * @return
	 * @throws IOException
	 */
	public Socket receive() throws IOException {
		Socket socket = this.socket.accept();
		Logger.log("接受到新的请求");
		InputStream inputSteam = socket.getInputStream();
		byte[] bs = new byte[inputSteam.available()];
		inputSteam.read(bs);
		Logger.log( "客户端请求信息：");
		Logger.log( new String(bs, 0, bs.length) );
		return socket;
	}
	
	public void reconnect() {
		// 如果未关闭，直接返回
		if (!this.socket.isClosed()) {
			return;
		}
		try {
			this.socket = new ServerSocket(this.port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
