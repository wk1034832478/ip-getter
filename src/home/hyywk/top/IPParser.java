package home.hyywk.top;

import java.net.InetAddress;
import java.net.Socket;

public class IPParser {
	public String parse( Socket socket ) {
		InetAddress ip = socket.getInetAddress();
		String address = ip.getHostAddress();
		if (!ip.isSiteLocalAddress()
                && !ip.isLoopbackAddress()
                && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
			
			Logger.log( "外网ip：" + ip.getHostAddress() );
        } else if (ip.isSiteLocalAddress()
                && !ip.isLoopbackAddress()
                && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
            Logger.log( "内网ip：" + ip.getHostAddress() );
        	
        } 
		return address;
	}
	
}
