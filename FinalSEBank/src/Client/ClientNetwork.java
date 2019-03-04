package Client;
import java.io.*;
import java.net.*;
public class ClientNetwork {
	protected Socket s;
	protected OutputStream os;
	protected InputStream is;
	protected ObjectOutputStream oos;
	protected ObjectInputStream ois;
	
	public ClientNetwork() {
		try
		{
			s=new Socket("localhost",5555);
			System.out.println("∞Ì∞¥¿Ã ¡¢º”");
			os=s.getOutputStream();
			is=s.getInputStream();
			oos=new ObjectOutputStream(os);
			ois=new ObjectInputStream(is);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Object sendRequest(Object[] request)
	{
		Object result=null;
		try
		{
			oos.writeObject(request);
			result=ois.readObject();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
