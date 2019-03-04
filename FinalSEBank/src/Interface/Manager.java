package Interface;
import VO.*;
import java.util.ArrayList;


public interface Manager {
	
	/**
	 * 계좌 정보가 등록된 ArrayList<Account> 객체를 반환
	 * @return 계좌 정보가 등록된 ArrayList 객체
	 * */
	public ArrayList<Account> getAllAccountList();
	
	/**
	 * 신규계좌 등록
	 * @param a 신규로 등록한 계좌 객체
	 * @return 정상적으로 등록되면 true를, 동일한 계좌번호가 이미 등록되어 있으면 false를 반환
	 * */
	public boolean insertAccount(Account a);
	
	/**
	 * 계좌번호로 등록된 계좌정보 조회
	 * @param accNo 검색할 계좌번호
	 * @return 검색된 계좌 객체, 검색 결과가 없을 시 null을 반환한다.
	 * */
	public Account searchAccount(String accNo);
	
	/**
	 * 계좌정보 수정, 수정 가능한 필드는 다음과 같다.
	 * - 소유주 이름, 이율 (적금계좌일 경우)
	 * @param newAccount 수정할 새로운 정보를 가지고 있는 Account 객체  
	 * */
	public void updateAccount(Account newAccount);
	
	/**
	 * 계좌번호로 등록된 계좌정보 삭제
	 * @param accNo 삭제할 계좌번호
	 * @return 정상적으로 삭제되면 true를, 삭제 실패하면(삭제할 계좌번호가 없으면) false를 반환
	 * */
	public boolean deleteAccount(String accNo);
	
	/**
	 * 입금처리
	 * @param a 입금처리 하고자 하는 계좌 객체
	 * @param amount 입금하고자 하는 금액
	 * */
	public void deposit(Account a, double amount);
	
	/**
	 * 출금처리, 입출금 계좌(Deposit Account)에 대해서만 출금이 가능하고 적금계좌(Saving Account)는 출금이 불가능
	 * @param a 출금처리 하고자 하는 계좌 객체
	 * @param amount 출금하고자 하는 금액
	 * @return 출금하고자 하는 금액이 잔고와 같거나 많으면 true를 결과로, 그렇지 않으면 false를 결과로 반환
	 * */
	public boolean withdraw(Account a, double amount);
	
	/**
	 * 이체처리, 입출금 계좌(Deposit Account)에 대해서만 이체가 가능하고 적금계좌(Saving Account)는 이체가 불가능
	 * 이체처리 계좌의 잔고는 이체하고자 하는 금액 만큼 차감하여 수정하고, 이체를 받는 계좌의 잔고는 이체받는 금액 만큼 더하여 수정한다.
	 * @param from 이체처리 하고자 하는 계좌 객체
	 * @param to 이체받을 계좌번호
	 * @param amount 이체하고자 하는 금액
	 * @return 이체하고자 하는 금액이 잔고와 같거나 많으면 true를 결과로, 그렇지 않으면 false를 결과로 반환. 또한 지급받을 계좌가 존재하지 않을 경우에도 false를 반환한다.
	 * */
	public boolean transfer(Account from, String to, double amount);
}
