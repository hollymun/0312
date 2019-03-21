import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		//클라이언트에 연결하기 위한 소켓
		ServerSocket ss = null;
		//클라이언트와 데이터를 주고 받기 위한 소켓 - 클라이언트 개수만큼 있어야 함 
		Socket socket = null;

		try {
			//서버소켓 생성 
			ss = new ServerSocket(9999);
			System.out.printf("서버 대기 중...\n");
			while(true) {
				//클라이언트 접속 대기 - 접속할 때까지 대기 
				socket = ss.accept();
				//접속자 정보를 출력 
				System.out.printf("%s\n", socket);
				//클라이언트가 전송한 데이터를 출력 
				BufferedReader br = new BufferedReader(
										new InputStreamReader(
												socket.getInputStream()));
				String msg = br.readLine();
				System.out.printf("전송된 메시지:%s\n", msg);
				br.close();
				socket.close();
	
			}
		}
		catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.getStackTrace();
		}
		finally {
			try {
				ss.close();
				socket.close();
			}
			catch(Exception e) {
				System.out.printf("%s\n", e.getMessage());
				e.getStackTrace();
			}
		}
		
		
		
	}

}
