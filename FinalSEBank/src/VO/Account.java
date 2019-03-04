package VO;
import java.io.Serializable;

/**
 * ���� Ŭ������ �θ� Ŭ����
 * */
public class Account implements Serializable {
	private String accNo; //���¹�ȣ
	private double balance; //�ܰ�
	private String owner; //���� ������ �̸�
	private String accountType; //�������� "����� ����", "���� ����" �� �� �ϳ��� ���� ����
	
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
		return String.format("[%s] ���¹�ȣ: %s, �ܰ�: %.2f, ������: %s", accountType, accNo, getBalance(), owner);
	}
	
}
