import java.net.InetAddress;

public class InetAddressMain {

	public static void main(String[] args) {
		try {
			//자신의 컴퓨터 주소 정보를 출력 
			InetAddress local = InetAddress.getLocalHost();
			System.out.printf("로컬 정보:%s\n", local);
			
			//www.daum.net의 주소 정보를 출력 
			InetAddress daum = InetAddress.getByName("www.daum.net");
			System.out.printf("다음의 주소 정보:%s\n", daum);
			
			//google은 여러 개의 주소를 사용함 
			//이런 경우 모든 주소 정보를 확인하고자 할 때는 배열로 받아야 함 
			InetAddress [] naver = InetAddress.getAllByName("www.naver.com");
			for(InetAddress addr : naver) {
				System.out.printf("구글의 모든 주소 정보:%s\n", addr);				
			}
			
			//IP주소 정보를 가지고 직접 생성 가능 
			InetAddress ip = InetAddress.getByName("192.168.0.100");
			System.out.printf("ip를 이용한 방법:%s\n", ip);
			
			
		}
		catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.getStackTrace();
		}
		
		
		
		
		
	}

}
