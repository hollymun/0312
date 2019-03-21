import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceive {

	public static void main(String[] args) {
		//멀티캐스트 소켓 변수 
		MulticastSocket ms = null;
		try {
			//멀티캐스트 소켓 생성 
			ms = new MulticastSocket(3000);
			//멀티캐스트 주소 설정 - 대역 안에서 쓰면 됨 
			ms.joinGroup(InetAddress.getByName("230.100.50.5"));
			while(true) {
				byte [] b = new byte[1024];
				DatagramPacket dp = new DatagramPacket(b, b.length);
				ms.receive(dp);
				String msg = new String(dp.getData()).trim();
				System.out.printf("%s:%s\n", dp.getAddress(), msg);
			}
			
		}
		catch(Exception e){
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				ms.close();
				
				
			}
			catch(Exception e){
				System.out.printf("%s\n", e.getMessage());
				e.printStackTrace();
			}
		}
	
		
		
		
	}
}
