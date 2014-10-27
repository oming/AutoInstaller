import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * 트레커 서버에 접속하여 피어들의 정보를 얻어옴
 * 
 * @author An
 *
 */
public class TrackerRequest {
	public TrackerRequest() {
		try {
			String serverIp = "127.0.0.1";

			// 소켓을 생성하여 연결을 요청한다.
			System.out.println("서버에 연결중입니다. 서버IP : " + serverIp);
			Socket socket = new Socket(serverIp, 7777);
			// 소켓의 입력스트림을 얻는다.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			// 소켓으로부터 받은 데이터를 출력한다.
			System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
			System.out.println("연결을 종료합니다.");

			dis.close();
			socket.close();
			System.out.println("연결이 종료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
