package VO;
import java.io.Serializable;

/**
 * 입출금 계좌
 * - 자유로운 입금 및 출금이 가능한 계좌
 * */
public class DepositAccount extends Account implements Serializable {

	public DepositAccount(String accNo, double balance, String owner, String accountType) {
		super(accNo, balance, owner, accountType);
	}
	
}
