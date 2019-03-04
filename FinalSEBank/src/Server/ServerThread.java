package Server;
import java.net.*;

import VO.Account;

import java.io.*;

public class ServerThread implements Runnable{
	private SEBankServerManager manager;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Object[] obj;
	
	public ServerThread(ObjectOutputStream oos, ObjectInputStream ois) {
		manager=new SEBankServerManager();
		this.oos=oos;
		this.ois=ois;
	}
	
	@Override
	public void run() {
		while(true)
		{
			try
			{
				while(true)
				{
					obj=(Object[])ois.readObject();
					String caseString=(String)obj[0];
					Object caseObject=obj[1];
					
					switch(caseString)
					{
					case "insert":
						oos.writeObject(manager.insertAccount((Account)caseObject));
						break;
					case "get":
						oos.writeObject(manager.getAllAccountList());
						break;
					case "search":
						oos.writeObject(manager.searchAccount((String)caseObject));
						break;
					case "update":
						manager.updateAccount((Account)caseObject);
						oos.writeObject(null);
						break;
					case "delete":
						oos.writeObject(manager.deleteAccount((String)caseObject));
						break;
					case "deposit":
						double amountD=(double)obj[2];
						manager.deposit((Account)caseObject, amountD);
						oos.writeObject(null);
						break;
					case "withdraw":
						double amountW=(double)obj[2];
						oos.writeObject(manager.withdraw((Account)caseObject, amountW));
						break;
					case "transfer":
						String to=(String)obj[2];
						double amountT=(double)obj[3];
						oos.writeObject(manager.transfer((Account)caseObject, to, amountT));
						break;
					}
				}
			}
			catch(Exception e)
			{
				continue;
			}
		}
	}
}
