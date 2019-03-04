package Server;
import java.io.*;
import java.net.*;
public class ServerNetwork {
	protected ServerSocket ss;
	protected Socket s;
	protected OutputStream os;
	protected InputStream is;
	protected ObjectOutputStream oos;
	protected ObjectInputStream ois;
	
	public ServerNetwork() {
		try
		{
			System.out.println("서버 가동 시작");
			ss=new ServerSocket(5555);
			while(true)
			{
				s=ss.accept();
				System.out.println("고객이 접속");
				os=s.getOutputStream();
				is=s.getInputStream();
				oos=new ObjectOutputStream(os);
				ois=new ObjectInputStream(is);
				ServerThread thread=new ServerThread(oos, ois);
				Thread t=new Thread(thread);
				t.start();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
