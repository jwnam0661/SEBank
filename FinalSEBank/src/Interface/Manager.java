package Interface;
import VO.*;
import java.util.ArrayList;


public interface Manager {
	
	/**
	 * ���� ������ ��ϵ� ArrayList<Account> ��ü�� ��ȯ
	 * @return ���� ������ ��ϵ� ArrayList ��ü
	 * */
	public ArrayList<Account> getAllAccountList();
	
	/**
	 * �ű԰��� ���
	 * @param a �űԷ� ����� ���� ��ü
	 * @return ���������� ��ϵǸ� true��, ������ ���¹�ȣ�� �̹� ��ϵǾ� ������ false�� ��ȯ
	 * */
	public boolean insertAccount(Account a);
	
	/**
	 * ���¹�ȣ�� ��ϵ� �������� ��ȸ
	 * @param accNo �˻��� ���¹�ȣ
	 * @return �˻��� ���� ��ü, �˻� ����� ���� �� null�� ��ȯ�Ѵ�.
	 * */
	public Account searchAccount(String accNo);
	
	/**
	 * �������� ����, ���� ������ �ʵ�� ������ ����.
	 * - ������ �̸�, ���� (���ݰ����� ���)
	 * @param newAccount ������ ���ο� ������ ������ �ִ� Account ��ü  
	 * */
	public void updateAccount(Account newAccount);
	
	/**
	 * ���¹�ȣ�� ��ϵ� �������� ����
	 * @param accNo ������ ���¹�ȣ
	 * @return ���������� �����Ǹ� true��, ���� �����ϸ�(������ ���¹�ȣ�� ������) false�� ��ȯ
	 * */
	public boolean deleteAccount(String accNo);
	
	/**
	 * �Ա�ó��
	 * @param a �Ա�ó�� �ϰ��� �ϴ� ���� ��ü
	 * @param amount �Ա��ϰ��� �ϴ� �ݾ�
	 * */
	public void deposit(Account a, double amount);
	
	/**
	 * ���ó��, ����� ����(Deposit Account)�� ���ؼ��� ����� �����ϰ� ���ݰ���(Saving Account)�� ����� �Ұ���
	 * @param a ���ó�� �ϰ��� �ϴ� ���� ��ü
	 * @param amount ����ϰ��� �ϴ� �ݾ�
	 * @return ����ϰ��� �ϴ� �ݾ��� �ܰ�� ���ų� ������ true�� �����, �׷��� ������ false�� ����� ��ȯ
	 * */
	public boolean withdraw(Account a, double amount);
	
	/**
	 * ��üó��, ����� ����(Deposit Account)�� ���ؼ��� ��ü�� �����ϰ� ���ݰ���(Saving Account)�� ��ü�� �Ұ���
	 * ��üó�� ������ �ܰ�� ��ü�ϰ��� �ϴ� �ݾ� ��ŭ �����Ͽ� �����ϰ�, ��ü�� �޴� ������ �ܰ�� ��ü�޴� �ݾ� ��ŭ ���Ͽ� �����Ѵ�.
	 * @param from ��üó�� �ϰ��� �ϴ� ���� ��ü
	 * @param to ��ü���� ���¹�ȣ
	 * @param amount ��ü�ϰ��� �ϴ� �ݾ�
	 * @return ��ü�ϰ��� �ϴ� �ݾ��� �ܰ�� ���ų� ������ true�� �����, �׷��� ������ false�� ����� ��ȯ. ���� ���޹��� ���°� �������� ���� ��쿡�� false�� ��ȯ�Ѵ�.
	 * */
	public boolean transfer(Account from, String to, double amount);
}
