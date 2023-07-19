package come.home.prec0719.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import come.home.prec0719.model.Member2;
import come.home.prec0719.model.Member2DAO;

public class JoinPage extends Page implements ActionListener{
	JTextField t_id;
	JPasswordField t_pass;
	JTextField t_name;
	JTextField t_email;
	JButton bt_join;
	JButton bt_login;
	MainFrame main;
	Member2DAO member2DAO;
	
	public JoinPage(MainFrame main) {
		t_id=new JTextField();
		t_pass=new JPasswordField();
		t_name=new JTextField();
		t_email=new JTextField();
		bt_join=new JButton("Sign-up");
		bt_login=new JButton("Sign-in");
		this.main=main;
		member2DAO=new Member2DAO();
		
		Dimension d=new Dimension(480, 40);
		t_id.setPreferredSize(d);
		t_pass.setPreferredSize(d);
		t_name.setPreferredSize(d);
		t_email.setPreferredSize(d);
		
		add(t_id);
		add(t_pass);
		add(t_name);
		add(t_email);
		add(bt_join);
		add(bt_login);
		
		setPreferredSize(new Dimension(500, 300));
		setBackground(Color.PINK);
		
		bt_join.addActionListener(this);
		bt_login.addActionListener(this);
	}
	
	public void regist() {
		//아이디, 패스워드 등 입력폼의 데이터를 하나의 DTO에 담아서
		//insert 메서드로 전달하자 -> call by reference
		Member2 member2=new Member2();
		
		//비어있는 DTO안에 입력폼의 데이터들을 채워넣기 setter이용
		member2.setId(t_id.getText()); //아이디 채우기
		member2.setPass(new String(t_pass.getPassword()));
		member2.setName(t_name.getText());
		member2.setEmail(t_email.getText());
		
		int result=member2DAO.insert(member2);
		
		if(result>=1) { //성공
			JOptionPane.showMessageDialog(this, "가입 성공");
		}else {
			JOptionPane.showMessageDialog(this, "가입 실패");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==bt_join) {
			//회원가입 처리
			regist();
		}else if(obj==bt_login) {
			//로그인 페이지 보여주기
			main.showHide(MainFrame.LOGIN);
		}
		
	}
}
