package come.home.prec0719.client.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	Page[] pages; //현재 프레임에서 사용할 페이지들을 담을 배열
	LoginPage loginPage;
	public static final int LOGIN=0;
	public static final int JOIN=1;

	public MainFrame() {
		pages=new Page[2];
		pages[0]=new LoginPage(this);
		pages[1]=new JoinPage(this);
		
		setLayout(new FlowLayout());
		
		for(int i=0; i<pages.length; i++) {
			add(pages[i]);
		}
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		
		showHide(LOGIN);
		
		
	}
	
	//화면 전환 메서드
	//pages[0] : 로그인
	//pages[1] : 회원 가입
	//showHide(0); 로그인페이지만 보여짐 -> showHide(LOGIN);
	//showHide(1); 가입페이지만 보여짐 -> showHide(JOIN);
	public void showHide(int n) {
		for(int i=0; i<pages.length; i++) {
			if(i==n) {
				pages[i].setVisible(true);
				
			}else {
				pages[i].setVisible(false);
				
			}
		}
		pack();
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}

/*
 cmd > mySQL 접속
 mysql -h localhost -u root -p
 show databases;
 use javase;
 show tables;
 */
