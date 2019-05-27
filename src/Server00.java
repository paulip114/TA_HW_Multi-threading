import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server00 implements Runnable {
	private ServerSocket SS;
	Server00(){
		this.initSS();
	}
	private void initSS() {
		try {
			SS = new ServerSocket(5000 + (int)(Math.random() * 1001));
			System.out.print("listening port: "+SS.getLocalPort());
		}catch(Exception e) {
			this.initSS();
		}
	}
	public void run () {
		while(true) {
			try {
				this.broadcast(SS.accept());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void broadcast (Socket s) {
		new Thread() {
			public void run() {
				try {
					DataOutputStream output = new DataOutputStream(s.getOutputStream());
					while(true) {
						output.writeUTF("Server anouncement\n");
						sleep(1000);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Server00()).start();
	}

}
