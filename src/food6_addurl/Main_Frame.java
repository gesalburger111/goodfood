package food6_addurl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



// 메인 프레임
public class Main_Frame extends JFrame{
	static Random random = new Random();		// 랜덤 객체
    static int random_data = 0;
    static Scanner menu = new Scanner(System.in);
    static String cate;							// 카테고리
    static int lport;							////
    static String rhost;						////
    static int rport;							////
    static String changed;
    static ArrayList<UserBean> menu_list = new ArrayList<UserBean>();	// UserBean타입의 배열 menu_list
    static String cate_name;					////
    static ArrayList<UserBean> list = new ArrayList<UserBean>();		// UserBean타입의 배열 list
	
    static Main_Frame id; 						// id
    
    
	 public static void main_Frame(){
		 Sub_Frame sub = new Sub_Frame();				// 서브프레임 : sub
 		 Review_Frame review_f = new Review_Frame();   	// 리뷰프레임 : review_f
		
 		 
    	 JFrame f = new JFrame("창원대 뭐 먹지?");			// JFrame : f
         f.setSize(1000,700);
         f.setLocationRelativeTo(null);					// 화면 가운데
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.getContentPane().setLayout(new GridLayout(1,1));
         f.getContentPane().setLayout(new GridLayout(1,2));
         f.setLayout(new GridLayout(1,2));
         f.setBackground(Color.WHITE);
         f.setUndecorated(true); 			// 타이틀바 삭제
         
         // 각 카테고리 버튼
         JButton korea = new JButton();
         korea.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/korea.png")));
         JButton china = new JButton();
         china.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/china.png")));
         JButton japan = new JButton();
         japan.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/japan.png")));
         JButton western = new JButton();
         western.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/western.png")));
         JButton total = new JButton();
         total.setIcon(new ImageIcon(Main_Frame.class.getResource("/img/total.png")));		
         JButton review = new JButton();
         
         JButton url = new JButton();

        

	     // 카테고리 호버
	     korea.setRolloverIcon(new ImageIcon(Main_Frame.class.getResource("/img/한식마우스.png")));
	     japan.setRolloverIcon(new ImageIcon(Main_Frame.class.getResource("/img/일식마우스.png")));
	     china.setRolloverIcon(new ImageIcon(Main_Frame.class.getResource("/img/중식마우스.png")));
	     western.setRolloverIcon(new ImageIcon(Main_Frame.class.getResource("/img/양식마우스.png")));
	     total.setRolloverIcon(new ImageIcon(Main_Frame.class.getResource("/img/랜덤마우스.png")));

	     
	     
	     
         JPanel j1 = new JPanel();	// 카테고리 버튼 판넬
         JPanel j2 = new JPanel();  // 제일 밑 판넬
         JPanel j3 = new JPanel();	// 창원대 뭐먹지, X 줄 판넬
         j1.setLayout(new GridLayout(1,5));
         j1.setSize(500,200);
         j3.setLayout(new BorderLayout());
         

         /////
//         korea.setContentAreaFilled(false);			// 버튼 내용 false
//         china.setContentAreaFilled(false);
//         japan.setContentAreaFilled(false);
//         western.setContentAreaFilled(false);
//         total.setContentAreaFilled(false);
//         review.setContentAreaFilled(false);

         //////
         korea.setFocusPainted(false);				// 포커스 표시
         china.setFocusPainted(false);
	     japan.setFocusPainted(false);
	     western.setFocusPainted(false);
	     total.setFocusPainted(false);
	     
	     korea.setBorderPainted(false);				// 테두리 
	     china.setBorderPainted(false);
	     japan.setBorderPainted(false);
	     western.setBorderPainted(false);
	     total.setBorderPainted(false);
	     
	     j3.setBackground(Color.BLACK);			////
	     j1.add(korea);
	     j1.add(china);
	     j1.add(japan);
	     j1.add(western);
	     j1.add(total);						
	     j2.add(review);	
	     j2.add(url);
	     j2.setBackground(Color.BLACK);
	     f.getContentPane().add(j3);
	     
	     
	     
	     // 타이틀 만들기
	     JPanel title = new JPanel();

	     title.setBackground(Color.BLACK);
	     j3.add(title,BorderLayout.NORTH);
	     
	     // X 버튼
	     JButton esc = new JButton();
	     esc.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);
	            }
	        });
	     esc.setPreferredSize(new Dimension(40, 40));			// Dimension을 인자로 기본 사이즈 설정
	     
	     JPanel title_p = new JPanel();			// x버튼 올릴 판넬
	     title_p.setLayout(new FlowLayout(FlowLayout.RIGHT));
	     title.setLayout(new GridLayout(1,3));
	     title_p.add(esc);
	     title_p.setBackground(null);
	     
	     Image rice = new ImageIcon(Main_Frame.class.getResource("/img/rice.png")).getImage();
	     JLabel title_j = new JLabel("<html><center>창원대 뭐 먹지?</center></html>");		// 타이틀 텍스트 올릴 레이블
	     
	     title_j.setIcon(new ImageIcon(rice.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
	     title_j.setForeground(Color.WHITE);				// 텍스트 색상 변경
	     title_j.setFont(title_j.getFont().deriveFont(17.0f));
	     title.add(title_j);
	     title.add(title_p);
	     // 타이틀 만들기
	     j3.add(j1,BorderLayout.CENTER);
	     j3.add(j2,BorderLayout.SOUTH);
	     f.setVisible(true);				//
	    
	     esc.setBackground(null);
	     esc.setFocusPainted(false);
	     esc.setBorderPainted(false);
	     review.setBackground(null);
	     review.setBorderPainted(false);
	     review.setFocusPainted(false);
	     url.setBackground(null);
	     url.setBorderPainted(false);
	     url.setFocusPainted(false);
	     
	     Image imgrev = new ImageIcon(Sub_Frame.class.getResource("/img/맛집버튼.png")).getImage();
	     Image imgesc = new ImageIcon(Sub_Frame.class.getResource("/img/X버튼.png")).getImage();
	     Image imgesc2 = new ImageIcon(Sub_Frame.class.getResource("/img/X마우스1.png")).getImage();
	     Image imgrev2 = new ImageIcon(Sub_Frame.class.getResource("/img/맛집마우스.png")).getImage();
	     Image imgurl = new ImageIcon(Sub_Frame.class.getResource("/img/학식버튼.png")).getImage();
	     Image imgurl2 = new ImageIcon(Sub_Frame.class.getResource("/img/학식마우스.png")).getImage();
	     
	     
	     esc.setIcon(new ImageIcon(imgesc.getScaledInstance(32,32,Image.SCALE_SMOOTH)));
	     review.setIcon(new ImageIcon(imgrev.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
	     esc.setRolloverIcon(new ImageIcon(imgesc2.getScaledInstance(32,32,Image.SCALE_SMOOTH)));
	     review.setRolloverIcon(new ImageIcon(imgrev2.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
	     url.setIcon(new ImageIcon(imgurl.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
	     url.setRolloverIcon(new ImageIcon(imgurl2.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
	     
	     
	     // 카테고리 클릭시 액션 
	     korea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    cate = "한식";
          //        sub.sub_Frame(cate);
                    new Loading("한식");
                    
                    f.dispose();
            }
        });
        china.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    cate = "중식";
//                    sub.sub_Frame(cate);
                    new Loading("중식");
                    f.dispose();
            }
        });
        japan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    cate = "일식";
//                    sub.sub_Frame(cate);
                    new Loading("일식");
                    f.dispose();
            }
        });
        western.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    cate = "양식";
//                    sub.sub_Frame(cate);
                    new Loading("양식");
                    f.dispose();
            }
        });
        total.addActionListener(new ActionListener() {              //
            @Override
            public void actionPerformed(ActionEvent e) {
                    cate = "전체 랜덤";                    
                    new Loading("전체 랜덤");
                    f.dispose();
            }
        });
        review.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                      review_f.Review_Frame();
                      f.dispose();
            }
        });
        url.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String url = "https://www.changwon.ac.kr/kor/di/diView/dietView.do";
               
               try {
                  Desktop.getDesktop().browse(new URI(url));
               }catch(IOException e2) {
                  e2.printStackTrace();
               }catch(URISyntaxException e2) {
                  e2.printStackTrace();                  
               }
            }
        });
    }
	
}
