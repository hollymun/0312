import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSocket {

	public static void main(String[] args) {
		//DatagramSocket 생성 - 받는 쪽은 포트 번호를 설정 
		DatagramSocket ds = null; 
		
		try {
			//소켓 생성 
			ds = new DatagramSocket(8888);
			
			while(true) {
				//데이터를 저장할 배열 생성 - 128 이상으로 
				byte [] b = new byte[256];
				//UDP 데이터를 전송 받아서 저장하기 위한 DatagramPacket 생성 
				DatagramPacket dp = new DatagramPacket(b, b.length);
				//데이터 전송이 왔을 때 전송 받기 
				ds.receive(dp);
				//전송한 컴퓨터의 주소정보를 출력 
				System.out.printf("전송한 곳:%s\n", dp.getAddress());
				//전송받은 데이터를 읽어서 출력 - trim 공백 제거 
				String msg = new String(b).trim();
				System.out.printf("전송 받은 메시지:%s\n", msg);
			}
			
		}
		catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				ds.close();
			}
			catch(Exception e) {
				System.out.printf("%s\n", e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
