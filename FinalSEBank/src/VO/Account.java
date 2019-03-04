package VO;
import java.io.Serializable;

/**
 * 계좌 클래스의 부모 클래스
 * */
public class Account implements Serializable {
	private String accNo; //계좌번호
	private double balance; //잔고
	private String owner; //계좌 소유주 이름
	private String accountType; //계좌유형 "입출금 계좌", "적금 계좌" 둘 중 하나의 값을 취함
	
	public Account(String accNo, double balance, String owner, String accountType) {
		this.accNo = accNo;
		this.balance = balance;
		this.owner = owner;
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAccNo() {
		return accNo;
	}
	
	public String getAccountType() {
		return accountType;
	}

	@Override
	public String toString() {
		return String.format("[%s] 계좌번호: %s, 잔고: %.2f, 소유주: %s", accountType, accNo, getBalance(), owner);
	}
	
}
