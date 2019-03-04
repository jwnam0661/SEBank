package Client;

import java.util.ArrayList;

import Interface.Manager;
import VO.Account;

public class SEBankClientManager implements Manager {
	ClientNetwork cNet;
	
	public SEBankClientManager() {
		cNet=new ClientNetwork();
	}
	
	@Override
	public ArrayList<Account> getAllAccountList() {
		ArrayList<Account> result=new ArrayList<Account>();
		Object[] request={"get",null};
		result=(ArrayList<Account>)cNet.sendRequest(request);
		return result;
	}

	@Override
	public boolean insertAccount(Account a) {
		boolean result=false;
		Object[] request={"insert",a};
		result=(boolean)cNet.sendRequest(request);
		return result;
	}

	@Override
	public Account searchAccount(String accNo) {
		Account result=null;
		Object[] request={"search",accNo};
		result=(Account)cNet.sendRequest(request);
		return result;
	}

	@Override
	public void updateAccount(Account newAccount) {
		Object[] request={"update",newAccount};
		cNet.sendRequest(request);
	}

	@Override
	public boolean deleteAccount(String accNo) {
		boolean result=false;
		Object[] request={"delete",accNo};
		result=(boolean)cNet.sendRequest(request);
		return result;
	}

	@Override
	public void deposit(Account a, double amount) {
		Object[] request={"deposit",a,amount};
		cNet.sendRequest(request);

	}

	@Override
	public boolean withdraw(Account a, double amount) {
		boolean result=false;
		Object[] request={"withdraw",a,amount};
		result=(boolean)cNet.sendRequest(request);
		return result;
	}

	@Override
	public boolean transfer(Account from, String to, double amount) {
		boolean result=false;
		Object[] request={"transfer",from,to,amount};
		result=(boolean)cNet.sendRequest(request);
		return result;
	}

}
