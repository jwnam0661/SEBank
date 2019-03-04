package Server;

import java.util.*;
import VO.*;
import java.io.*;
import java.net.*;
import Interface.Manager;

public class SEBankServerManager implements Manager {
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ArrayList<Account> al;
	
	public SEBankServerManager() {
		if(new File("Account.dat").exists())
		{
			al=this.getFile();
		}
		else
		{
			al=new ArrayList<Account>();
			this.setFile(al);
		}
	}
	
	@Override
	public ArrayList<Account> getAllAccountList() {
		ArrayList<Account> result=new ArrayList<Account>();
		result=this.getFile();
		return result;
	}

	@Override
	public boolean insertAccount(Account a) {
		boolean result=false;
		for(int i=0; i<al.size(); i++)
		{
			if(al.get(i).getAccNo().equals(a.getAccNo()))
			{
				return false;
			}
		}
		result=true;
		al.add(a);
		this.setFile(al);
		return result;
	}

	@Override
	public Account searchAccount(String accNo) {
		Account result=null;
		al=this.getFile();
		for(int i=0; i<al.size(); i++)
		{
			if(al.get(i).getAccNo().equals(accNo))
			{
				result=al.get(i);
			}
		}
		return result;
	}

	@Override
	public void updateAccount(Account newAccount) {
		al=this.getFile();
		for(int i=0; i<al.size(); i++)
		{
			if(al.get(i).getAccNo().equals(newAccount.getAccNo()))
			{
				if(al.get(i) instanceof DepositAccount)
				{
					al.get(i).setOwner(newAccount.getOwner());
				}
				else if(al.get(i) instanceof SavingAccount)
				{	
					SavingAccount s=(SavingAccount)al.get(i);
					SavingAccount n=(SavingAccount)newAccount;
					s.setOwner(newAccount.getOwner());
					s.setInterest(n.getInterest());
				}
			}
		}
		this.setFile(al);
	}

	@Override
	public boolean deleteAccount(String accNo) {
		boolean result=false;
		al=this.getFile();
		for(int i=0; i<al.size(); i++)
		{
			if(al.get(i).getAccNo().equals(accNo))
			{
				al.remove(i);
				result=true;
			}
		}
		this.setFile(al);
		return result;
	}

	@Override
	public void deposit(Account a, double amount) {
		al=this.getFile();
		for(int i=0; i<al.size(); i++)
		{
			if(al.get(i).getAccNo().equals(a.getAccNo()))
			{
				al.get(i).setBalance(a.getBalance()+amount);
			}
		}
		this.setFile(al);
	}

	@Override
	public boolean withdraw(Account a, double amount) {
		boolean result=false;
		al=this.getFile();
		if(a.getBalance() >= amount)
		{
			for(int i=0; i<al.size(); i++)
			{
				if(al.get(i).getAccNo().equals(a.getAccNo()))
				{
					al.get(i).setBalance(a.getBalance()-amount);
					result=true;
				}
			}
		}
		this.setFile(al);
		return result;
	}

	@Override
	public boolean transfer(Account from, String to, double amount) {
		boolean result=false;
		al=this.getFile();
		Account toAcc=this.searchAccount(to);
		if(from.getBalance() >= amount)
		{
			toAcc.setBalance(toAcc.getBalance()+amount);
			for(int i=0; i<al.size(); i++)
			{
				if(al.get(i).getAccNo().equals(from.getAccNo()))
				{
					al.get(i).setBalance(from.getBalance()-amount);
					result=true;
				}
			}
		}
		this.setFile(al);
		return result;
	}
	
	public boolean setFile(ArrayList<Account> al)
	{
		boolean result=false;
		try
		{
			fos=new FileOutputStream("Account.dat");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(al);
			result=true;
			oos.close();
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Account> getFile()
	{
		ArrayList<Account> result=new ArrayList<Account>();
		try
		{
			fis=new FileInputStream("Account.dat");
			ois=new ObjectInputStream(fis);
			result=(ArrayList<Account>)ois.readObject();
			ois.close();
			fis.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
