import java.io.DataInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client00 {
	public void connect() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ip:");
		String ip = scanner.nextLine();
		System.out.print("port:");
		int port = scanner.nextInt();
		InetSocketAddress inetScoketAddress = new InetSocketAddress(ip,port);
		try {
			Socket s = new Socket();
			s.connect(inetScoketAddress);
			this.receive(s);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void receive(Socket s) {
		try {
			DataInputStream input = new DataInputStream(s.getInputStream());
			while(true){
				System.out.print(input.readUTF());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client00().connect();
	}
}
