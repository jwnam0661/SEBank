package VO;
import java.io.Serializable;

/**
 * ����� ����
 * - �����ο� �Ա� �� ����� ������ ����
 * */
public class DepositAccount extends Account implements Serializable {

	public DepositAccount(String accNo, double balance, String owner, String accountType) {
		super(accNo, balance, owner, accountType);
	}
	
}
