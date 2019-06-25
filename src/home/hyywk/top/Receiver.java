package home.hyywk.top;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author ����
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
	   * ����  
	 * @return
	 * @throws IOException
	 */
	public Socket receive() throws IOException {
		Socket socket = this.socket.accept();
		Logger.log("���ܵ��µ�����");
		InputStream inputSteam = socket.getInputStream();
		byte[] bs = new byte[inputSteam.available()];
		inputSteam.read(bs);
		Logger.log( "�ͻ���������Ϣ��");
		Logger.log( new String(bs, 0, bs.length) );
		return socket;
	}
	
	public void reconnect() {
		// ���δ�رգ�ֱ�ӷ���
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
