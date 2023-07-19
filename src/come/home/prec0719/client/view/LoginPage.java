package come.home.prec0719.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import come.home.prec0719.model.Member2;
import come.home.prec0719.model.Member2DAO;

public class LoginPage extends Page implements ActionListener{
	JTextField t_id;
	JPasswordField t_pass;
	JButton bt_login;
	JButton bt_join;
	MainFrame main; //null
	Member2DAO member2DAO;
	
	public LoginPage(MainFrame main) {
		t_id=new JTextField();
		t_pass=new JPasswordField();
		bt_login=new JButton("Sign-in");
		bt_join=new JButton("Sign-up");
		this.main=main;
		member2DAO=new Member2DAO();
		
		Dimension d=new Dimension(280, 40);
		t_id.setPreferredSize(d);
		t_pass.setPreferredSize(d);
		
		setLayout(new FlowLayout());
		
		add(t_id);
		add(t_pass);
		add(bt_login);
		add(bt_join);
		
		setPreferredSize(new Dimension(300, 140));
		setBackground(Color.PINK);
		
		bt_login.addActionListener(this);
		bt_join.addActionListener(this);
	}
	
	public void login() {
		//입력폼에서 입력한 데이터를 이용해, DAO의 메서드를 호출
		Member2 member2=new Member2();
		member2.setId(t_id.getText());
		member2.setPass(new String(t_pass.getPassword()));
		
		Member2 dto=member2DAO.login(member2);
		
		if(dto==null) {
			JOptionPane.showMessageDialog(this, "로그인 정보가 올바르지않음");
		}else {
			JOptionPane.showMessageDialog(this, "인증 성공");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==bt_login) {
			//로그인 처리★
			login();
		}else if(obj==bt_join) {
			main.showHide(MainFrame.JOIN); //가입폼 보여주기
		}
		
	}
}
