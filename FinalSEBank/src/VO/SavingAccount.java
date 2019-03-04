package VO;
import java.io.Serializable;

/**
 * 적금계좌
 * - 지정된 기간동안 정기적으로 입금을 하고 지정 기간이 만료되면 약정 이율만큼 수익이 발생되는 계좌
 * - 출금은 불가능
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
	 * 약정된 이율에 대한 금액을 포함한 잔고를 조회한다.
	 * @return 이율이 포함된 잔고
	 * */
	@Override
	public double getBalance() {
		return super.getBalance()+super.getBalance()*(interest/100);
	}

	@Override
	public String toString() {
		return super.toString()+String.format(" ,이율: %.1f", interest);
	}

}
