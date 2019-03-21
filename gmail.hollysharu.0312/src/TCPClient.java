import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		
		Socket socket = null;

		try {
			//메시지 전송 
			Scanner sc = new Scanner(System.in);

			while(true){
				//로컬 컴퓨터의 9999번 포트에 연결 
				//socket = new Socket("127.0.0.1", 9999);
				socket = new Socket("192.168.0.100", 9999);
				
				System.out.printf("전송할 메시지:");
				String msg = sc.nextLine();
				
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println(msg);
				pw.flush();
				pw.close();
				}
		}
		catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.getStackTrace();
		}
		finally {
			try {
				socket.close();
			}
			catch(Exception e) {
				System.out.printf("%s\n", e.getMessage());
				e.getStackTrace();
			}
		}

		
		
		
		
	}

}
