package VO;
import java.io.Serializable;

/**
 * ���ݰ���
 * - ������ �Ⱓ���� ���������� �Ա��� �ϰ� ���� �Ⱓ�� ����Ǹ� ���� ������ŭ ������ �߻��Ǵ� ����
 * - ����� �Ұ���
 * */
public class SavingAccount extends Account implements Serializable {
	
	private double interest;

	public SavingAccount(String accNo, double balance, String owner, double interest, String accountType) {
		super(accNo, balance, owner, accountType);
		this.interest = interest;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	/**
	 * ������ ������ ���� �ݾ��� ������ �ܰ� ��ȸ�Ѵ�.
	 * @return ������ ���Ե� �ܰ�
	 * */
	@Override
	public double getBalance() {
		return super.getBalance()+super.getBalance()*(interest/100);
	}

	@Override
	public String toString() {
		return super.toString()+String.format(" ,����: %.1f", interest);
	}

}
