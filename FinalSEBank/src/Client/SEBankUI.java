package Client;
import VO.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JRadioButton;

import java.awt.GridLayout;

import javax.swing.JTextField;

import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class SEBankUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lbl_title;
	private JPanel p_west;
	private JPanel p_west_north;
	private JRadioButton rb_depositAccount;
	private JRadioButton rb_savingAccount;
	private JPanel p_west_center;
	private JPanel p_west_center1;
	private JPanel p_west_center2;
	private JPanel p_west_center3;
	private JPanel p_west_center4;
	private JLabel lbl_accountNo;
	private JTextField tf_accountNo;
	private JLabel lbl_balance;
	private JTextField tf_balance;
	private JLabel lbl_owner;
	private JTextField tf_owner;
	private JLabel lbl_interest;
	private JTextField tf_interest;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane sp_list;
	private JList li_list;
	private JPanel p_south;
	private JButton btn_insert;
	private JButton btn_search;
	private JButton btn_update;
	private JButton btn_delete;
	private JButton btn_ok;
	private JButton btn_cancel;
	private JPanel p_east;
	private JComboBox cb_action;
	private JPanel p_east_1;
	private JPanel p_east_2;
	private JPanel p_east_3;
	private JPanel p_east_4;
	private JPanel p_east_5;
	private JLabel lbl_amount;
	private JTextField tf_amount;
	private JLabel lbl_targetAccNo;
	private JTextField tf_targetAccNo;
	private JPanel p_east_0;
	private JButton btn_action;
	private JButton btn_actionCancel;
	private String preAction;
	private String accountType;
	//private Manager manager = new SEBankClientManager();
	private Account selectedValue;
	private SEBankClientManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SEBankUI frame = new SEBankUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SEBankUI() {
		manager=new SEBankClientManager();
		setTitle("\u25A0\u25A0 \uC18C\uD504\uD2B8 \uC5D4\uC9C0\uB2C8\uC5B4 \uC740\uD589 \uC2DC\uC2A4\uD15C \u25A0\u25A0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(2, 2));
		setContentPane(contentPane);
		
		lbl_title = new JLabel("Soft Engineer Bank System");
		lbl_title.setOpaque(true);
		lbl_title.setBackground(new Color(0, 153, 0));
		lbl_title.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(102, 204, 51), null, null, null));
		lbl_title.setFont(new Font("����", Font.BOLD, 28));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl_title, BorderLayout.NORTH);
		
		p_west = new JPanel();
		contentPane.add(p_west, BorderLayout.WEST);
		p_west.setLayout(new BorderLayout(0, 2));
		
		p_west_north = new JPanel();
		p_west_north.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		p_west.add(p_west_north, BorderLayout.NORTH);
		
		rb_depositAccount = new JRadioButton("\uC785\uCD9C\uAE08 \uACC4\uC88C", true);
		rb_depositAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearTextField();
				if(rb_depositAccount.isSelected())
				{
					initTextField("����� ����", true);
					tf_interest.setEditable(false);
				}
			}
		});
		rb_depositAccount.setActionCommand("����� ����");
		buttonGroup.add(rb_depositAccount);
		p_west_north.add(rb_depositAccount);
		
		rb_savingAccount = new JRadioButton("\uC801\uAE08 \uACC4\uC88C");
		rb_savingAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearTextField();
				if(rb_savingAccount.isSelected())
				{
					initTextField("", true);
				}
			}
		});
		rb_savingAccount.setActionCommand("���� ����");
		buttonGroup.add(rb_savingAccount);
		p_west_north.add(rb_savingAccount);
		
		p_west_center = new JPanel();
		p_west_center.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		p_west.add(p_west_center, BorderLayout.CENTER);
		p_west_center.setLayout(new GridLayout(4, 1, 0, 0));
		
		p_west_center1 = new JPanel();
		p_west_center.add(p_west_center1);
		
		lbl_accountNo = new JLabel("\uACC4\uC88C\uBC88\uD638");
		lbl_accountNo.setHorizontalAlignment(SwingConstants.CENTER);
		p_west_center1.add(lbl_accountNo);
		
		tf_accountNo = new JTextField();
		p_west_center1.add(tf_accountNo);
		tf_accountNo.setColumns(10);
		
		p_west_center2 = new JPanel();
		p_west_center.add(p_west_center2);
		
		lbl_balance = new JLabel("\uC794\uACE0");
		lbl_balance.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_balance.setPreferredSize(new Dimension(48, 15));
		p_west_center2.add(lbl_balance);
		
		tf_balance = new JTextField();
		tf_balance.setColumns(10);
		p_west_center2.add(tf_balance);
		
		p_west_center3 = new JPanel();
		p_west_center.add(p_west_center3);
		
		lbl_owner = new JLabel("\uC18C\uC720\uC8FC");
		lbl_owner.setPreferredSize(new Dimension(48, 15));
		lbl_owner.setHorizontalAlignment(SwingConstants.CENTER);
		p_west_center3.add(lbl_owner);
		
		tf_owner = new JTextField();
		tf_owner.setColumns(10);
		p_west_center3.add(tf_owner);
		
		p_west_center4 = new JPanel();
		p_west_center.add(p_west_center4);
		
		lbl_interest = new JLabel("\uC774\uC728");
		lbl_interest.setPreferredSize(new Dimension(48, 15));
		lbl_interest.setHorizontalAlignment(SwingConstants.CENTER);
		p_west_center4.add(lbl_interest);
		
		tf_interest = new JTextField();
		tf_interest.setColumns(10);
		p_west_center4.add(tf_interest);
		
		sp_list = new JScrollPane();
		sp_list.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(sp_list, BorderLayout.CENTER);
		
		li_list = new JList();
		li_list.setBorder(new TitledBorder(null, "\uACC4\uC88C\uB4F1\uB85D\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		li_list.setBackground(new Color(153, 153, 153));
		sp_list.setViewportView(li_list);
		li_list.addMouseListener(new ListSelectionEvent());
		
		p_south = new JPanel();
		p_south.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(p_south, BorderLayout.SOUTH);
		
		btn_insert = new JButton("\uB4F1\uB85D");
		btn_insert.addActionListener(this);
		p_south.add(btn_insert);
		
		btn_search = new JButton("\uAC80\uC0C9");
		btn_search.addActionListener(this);
		p_south.add(btn_search);
		
		btn_update = new JButton("\uC218\uC815");
		btn_update.addActionListener(this);
		p_south.add(btn_update);
		
		btn_delete = new JButton("\uC0AD\uC81C");
		btn_delete.addActionListener(this);
		p_south.add(btn_delete);
		
		btn_ok = new JButton("\uD655\uC778");
		btn_ok.addActionListener(this);
		p_south.add(btn_ok);
		
		btn_cancel = new JButton("\uCDE8\uC18C");
		btn_cancel.addActionListener(this);
		p_south.add(btn_cancel);
		
		p_east = new JPanel();
		p_east.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(p_east, BorderLayout.EAST);
		p_east.setLayout(new GridLayout(6, 1, 0, 0));
		
		p_east_0 = new JPanel();
		p_east.add(p_east_0);
		
		cb_action = new JComboBox();
		cb_action.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cb_action.getSelectedIndex()==0)
				{
					btn_insert.setEnabled(true);
					btn_search.setEnabled(true);
					btn_update.setEnabled(true);
					btn_delete.setEnabled(true);
					btn_ok.setEnabled(false);
					btn_cancel.setEnabled(false);
					tf_amount.setText(null);
					tf_targetAccNo.setText(null);
					tf_amount.setEditable(false);
					tf_targetAccNo.setEditable(false);
					btn_action.setEnabled(false);
					btn_actionCancel.setEnabled(false);
				}
				else if(cb_action.getSelectedIndex()==3)
				{
					btn_insert.setEnabled(false);
					btn_search.setEnabled(false);
					btn_update.setEnabled(false);
					btn_delete.setEnabled(false);
					btn_ok.setEnabled(false);
					btn_cancel.setEnabled(false);
					tf_amount.setText(null);
					tf_targetAccNo.setText(null);
					tf_amount.setEditable(true);
					tf_targetAccNo.setEditable(true);
					btn_action.setEnabled(true);
					btn_actionCancel.setEnabled(true);
				}
				else
				{
					btn_insert.setEnabled(false);
					btn_search.setEnabled(false);
					btn_update.setEnabled(false);
					btn_delete.setEnabled(false);
					btn_ok.setEnabled(false);
					btn_cancel.setEnabled(false);
					tf_amount.setText(null);
					tf_targetAccNo.setText(null);
					tf_amount.setEditable(true);
					tf_targetAccNo.setEditable(false);
					btn_action.setEnabled(true);
					btn_actionCancel.setEnabled(true);
				}
				li_list.clearSelection();
				clearTextField();
				initTextField("All", false);
			}
		});
		p_east_0.add(cb_action);
		cb_action.setModel(new DefaultComboBoxModel(new String[] {"\uC5C5\uBB34\uC120\uD0DD", "\uC785\uAE08", "\uCD9C\uAE08", "\uC774\uCCB4"}));
		
		p_east_1 = new JPanel();
		p_east.add(p_east_1);
		
		lbl_amount = new JLabel("\uAE08\uC561");
		lbl_amount.setOpaque(true);
		lbl_amount.setBackground(new Color(204, 204, 204));
		lbl_amount.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_amount.setPreferredSize(new Dimension(76, 15));
		p_east_1.add(lbl_amount);
		
		tf_amount = new JTextField();
		p_east_1.add(tf_amount);
		tf_amount.setColumns(10);
		
		p_east_2 = new JPanel();
		p_east.add(p_east_2);
		
		lbl_targetAccNo = new JLabel("\uC9C0\uAE09\uBC1B\uC744 \uACC4\uC88C");
		lbl_targetAccNo.setOpaque(true);
		lbl_targetAccNo.setBackground(new Color(204, 204, 204));
		p_east_2.add(lbl_targetAccNo);
		
		tf_targetAccNo = new JTextField();
		p_east_2.add(tf_targetAccNo);
		tf_targetAccNo.setColumns(10);
		
		p_east_3 = new JPanel();
		p_east.add(p_east_3);
		
		btn_action = new JButton("\uC2E4\uD589");
		btn_action.addActionListener(this);
		p_east_3.add(btn_action);
		
		btn_actionCancel = new JButton("\uCDE8\uC18C");
		btn_actionCancel.addActionListener(this);
		p_east_3.add(btn_actionCancel);
		
		p_east_4 = new JPanel();
		p_east.add(p_east_4);
		
		p_east_5 = new JPanel();
		p_east.add(p_east_5);
		
		initButton(true);
		initTextField("All", false);
		showList(manager.getAllAccountList());
		tf_amount.setEditable(false);
		tf_targetAccNo.setEditable(false);
		btn_action.setEnabled(false);
		btn_actionCancel.setEnabled(false);
		rb_depositAccount.setEnabled(false);
		rb_savingAccount.setEnabled(false);
	}
	
	/**
	 * ���, �˻�, ����, ����, Ȯ��, ��� ��ư�� Ȱ��ȭ �� ��Ȱ��ȭ ������ �ϰ� ó��
	 * @param status ��ư�� Ȱ��ȭ ��Ȱ��ȭ�� ���� ���� ��
	 * */
	public void initButton(boolean status){
		btn_insert.setEnabled(status);
		btn_search.setEnabled(status);
		btn_update.setEnabled(status);
		btn_delete.setEnabled(status);
		btn_ok.setEnabled(!status);
		btn_cancel.setEnabled(!status);
	}
	
	/**
	 * �Է� �ؽ�Ʈ �ʵ��� Ȱ��ȭ �� ��Ȱ��ȭ�� �ϰ� ó�� (�����ؾ� ��)
	 * @param type ���õ� ������ Ÿ��, ���� ���� ���Ƿ� ����
	 * @param status �ؽ�Ʈ �ʵ��� Ȱ��ȭ ��Ȱ��ȭ�� ���� ���� ��
	 * */
	public void initTextField(String type, boolean status){
		tf_accountNo.setEditable(status);
		tf_balance.setEditable(status);
		tf_owner.setEditable(status);
		tf_interest.setEditable(status);
		if(type.equals("����� ����"))
		{
			tf_interest.setEditable(!status);
		}
	}
	
	/**
	 * �Է� �ؽ�Ʈ �ʵ��� �ϰ� ����
	 * */
	public void clearTextField(){
		tf_accountNo.setText("");
		tf_balance.setText("");
		tf_owner.setText("");
		tf_interest.setText("");
		tf_targetAccNo.setText("");
		tf_amount.setText("");
	}
	
	/**
	 * ���µ������ ����Ʈ�� ����� ������
	 * */
	public void showList(ArrayList<Account> accountList){
		Object oa [] = accountList.toArray();
		li_list.setListData(oa);
	}

	/**
	 * ���� ��ư�� ���� ActionEvent ó�� ������ �޼���
	 * */
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		
		if(source==btn_insert) ///////////////////////////////////////////////////////////////��� ��ư
		{
			rb_depositAccount.setEnabled(true);
			rb_savingAccount.setEnabled(true);
			initButton(false);
			clearTextField();
			
			if(rb_depositAccount.isSelected())
			{
				initTextField("����� ����", true);
			}
			else
			{
				initTextField("", true);
			}
			preAction="���";
		}
		else if(source==btn_search) //////////////////////////////////////////////////////////�˻� ��ư
		{
			initButton(false);
			clearTextField();
			tf_accountNo.setEditable(true);
			preAction="�˻�";
		}
		else if(source==btn_update)///////////////////////////////////////////////////////////���� ��ư
		{
			
			if(li_list.isSelectionEmpty())
			{
				JOptionPane.showMessageDialog(null, "������ ����Ʈ�� Ŭ���ϼ���.");
			}
			else
			{
				initButton(false);
				tf_owner.setEditable(true);
				if(selectedValue instanceof SavingAccount)
				{
					tf_interest.setEditable(true);
				}
				preAction="����";
			}
			
		}
		else if(source==btn_delete)///////////////////////////////////////////////////////////���� ��ư
		{
			if(li_list.isSelectionEmpty())
			{
				JOptionPane.showMessageDialog(null, "������ ����Ʈ�� Ŭ���ϼ���.");
			}
			else
			{
				Account delete=selectedValue;
				String dele=delete.getAccNo();
				if(manager.deleteAccount(dele))
				{
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
				}
			}
			clearTextField();
			showList(manager.getAllAccountList());
		}
		else if(source==btn_action)///////////////////////////////////////////////////////////���� ��ư
		{
			if(li_list.isSelectionEmpty())
			{
				JOptionPane.showMessageDialog(null, "���¸� Ŭ���ϼ���.");
			}
			else
			{
				Account a=selectedValue;
				String g=tf_amount.getText();
				if(g.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "�ݾ��� �Է��ϼ���.");
				}
				else
				{
					double amount=Double.parseDouble(tf_amount.getText());
					if(cb_action.getSelectedIndex()==1)///////////////////////////////////////////�Ա�
					{
						manager.deposit(a, amount);
					}
					else if(cb_action.getSelectedIndex()==2)//////////////////////////////////////���
					{
						if(a instanceof SavingAccount)
						{
							JOptionPane.showMessageDialog(null, "���ݰ��´� ��ݺҰ�");
						}
						else
						{
							if(!manager.withdraw(a, amount))
							{
								JOptionPane.showMessageDialog(null, "�ܰ� �����մϴ�.");
							}
						}
						
					}
					else if(cb_action.getSelectedIndex()==3)//////////////////////////////////////��ü
					{
						String to=tf_targetAccNo.getText();
						if(a instanceof SavingAccount)
						{
							JOptionPane.showMessageDialog(null, "���ݰ��´� ��ü�Ұ�");
						}
						else
						{
							if(!manager.transfer(a, to, amount))
							{
								JOptionPane.showMessageDialog(null, "�ܰ� �����մϴ�.");
							}
						}
					}
				}
			}
			selectedValue=null;
			clearTextField();
			showList(manager.getAllAccountList());
		}
		else if(source==btn_actionCancel)//////////////////////////////////////////////////////������� ��ư
		{
			cb_action.setSelectedIndex(0);
			btn_ok.setEnabled(false);
			btn_cancel.setEnabled(false);
		}
		else if(source==btn_cancel)///////////////////////////////////////////////////////////��� ��ư
		{
			clearTextField();
			initButton(true);
			initTextField("ALL", false);
			cb_action.setSelectedIndex(0);
			btn_ok.setEnabled(false);
			btn_cancel.setEnabled(false);
		}
		else if(source==btn_ok) //////////////////////////////////////////////////////////////Ȯ�� ��ư
		{
			switch(preAction)
			{
			case "���":
				if(rb_depositAccount.isSelected())
				{
					String accNo=tf_accountNo.getText();
					String g=tf_balance.getText();
					String owner=tf_owner.getText();
					if(accNo.isEmpty() || g.isEmpty() || owner.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "������ ������ �ֽ��ϴ�.");
					}
					else
					{
						double balance=Double.parseDouble(tf_balance.getText());
						accountType="����� ����";
						DepositAccount deposit=new DepositAccount(accNo, balance, owner, accountType);
						if(!manager.insertAccount(deposit))
						{
							JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���¹�ȣ�Դϴ�.");
						}
					}
				}
				else
				{
					String accNo=tf_accountNo.getText();
					String g=tf_balance.getText();
					String s=tf_interest.getText();
					String owner=tf_owner.getText();
					if(accNo.isEmpty() || g.isEmpty() || owner.isEmpty() || s.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "������ ������ �ֽ��ϴ�.");
					}
					else
					{
						double balance=Double.parseDouble(tf_balance.getText());
						double interest=Double.parseDouble(tf_interest.getText());
						accountType="���ݰ���";
						SavingAccount saving=new SavingAccount(accNo, balance, owner, interest, accountType);
						if(!manager.insertAccount(saving))
						{
							JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���¹�ȣ�Դϴ�.");
						}
					}
				}
				clearTextField();
				break;
			case "�˻�":
				String find=tf_accountNo.getText();
				Account finded=manager.searchAccount(find);
				if(finded == null)
				{
					JOptionPane.showMessageDialog(null, "��ġ�ϴ� ���¹�ȣ�� �����ϴ�.");
				}
				else
				{
					tf_accountNo.setEditable(false);
					if(finded instanceof DepositAccount)
					{
						tf_accountNo.setText(finded.getAccNo());
						tf_balance.setText(String.valueOf(finded.getBalance()));
						tf_owner.setText(finded.getOwner());
					}
					else
					{
						tf_accountNo.setText(finded.getAccNo());
						tf_balance.setText(String.valueOf(finded.getBalance()));
						tf_owner.setText(finded.getOwner());
						tf_interest.setText(String.valueOf(finded.getBalance()));
					}
				}
				li_list.clearSelection();////////////////////////////////////?////���õ� ������ ���,,,,,
				selectedValue=null;
				break;
			case "����":
				if(selectedValue instanceof DepositAccount)
				{
					String accNo=tf_accountNo.getText();
					double balance=Double.parseDouble(tf_balance.getText());
					String owner=tf_owner.getText();
					accountType="����� ����";
					DepositAccount deposit=new DepositAccount(accNo, balance, owner, accountType);
					manager.updateAccount(deposit);
				}
				else
				{
					String accNo=tf_accountNo.getText();
					double balance=Double.parseDouble(tf_balance.getText());
					String owner=tf_owner.getText();
					double interest=Double.parseDouble(tf_interest.getText());
					accountType="���ݰ���";
					SavingAccount saving=new SavingAccount(accNo, balance, owner, interest, accountType);
					manager.updateAccount(saving);
				}
				clearTextField();
				break;
			}
			initButton(true);
			initTextField("", false);
			rb_depositAccount.setEnabled(false);
			rb_savingAccount.setEnabled(false);
			showList(manager.getAllAccountList());
		}
	}
	
	/**
	 * ���µ������ ����Ʈ�� ���콺 Ŭ�� �̺��� ó�� ������ Ŭ����
	 * */
	private class ListSelectionEvent extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			selectedValue=(Account)li_list.getSelectedValue();
			clearTextField();
			if(selectedValue instanceof DepositAccount)
			{
				tf_accountNo.setText(selectedValue.getAccNo());
				tf_balance.setText(String.valueOf(selectedValue.getBalance()));
				tf_owner.setText(selectedValue.getOwner());
			}
			else
			{
				SavingAccount sav=(SavingAccount)selectedValue;
				tf_accountNo.setText(selectedValue.getAccNo());
				tf_balance.setText(String.valueOf(selectedValue.getBalance()));
				tf_owner.setText(selectedValue.getOwner());
				tf_interest.setText(String.valueOf(sav.getInterest()));
			}
			
			if((cb_action.getSelectedIndex()==2 || cb_action.getSelectedIndex()==3) && selectedValue instanceof SavingAccount)
			{
				JOptionPane.showMessageDialog(null, "���ݰ��´� �Ա� ���񽺸� �̿밡���մϴ�.");
				cb_action.setSelectedIndex(0);
			}
		}
		
	}
}
