package food5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Main_Frame extends JFrame{
	static Random random = new Random();
    static int random_data = 0;
    static Scanner menu = new Scanner(System.in);
    static String cate;
    static int lport;
    static String rhost;
    static int rport;
    static String changed;
    static ArrayList<UserBean> menu_list = new ArrayList<UserBean>();
    static String cate_name;
    static ArrayList<UserBean> list = new ArrayList<UserBean>();
	
    static Main_Frame id; 
    
    
	 public static void main_Frame(){
		 Sub_Frame sub = new Sub_Frame();
 		 Review_Frame review_f = new Review_Frame();   
		
 		 
    	 JFrame f = new JFrame("창원대 뭐 먹지?");
         f.setSize(1000,700);
         f.setLocationRelativeTo(null);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.getContentPane().setLayout(new GridLayout(1,1));
         f.getContentPane().setLayout(new GridLayout(1,2));
         f.setLayout(new GridLayout(1,2));
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
         Image imgreview = new ImageIcon(Sub_Frame.class.getResource("/img/제목 없음1.png")).getImage();
	     review.setIcon(new ImageIcon(imgreview.getScaledInstance(81,32,Image.SCALE_SMOOTH)));

	     
	     korea.setRolloverIcon(new ImageIcon(Main_Frame.class.getResource("/img/한식마우스.png")));
	     japan.setRolloverIcon(new ImageIcon(Main_Frame.class.getResource("/img/일식마우스.png")));
	     china.setRolloverIcon(new ImageIcon(Main_Frame.class.getResource("/img/중식마우스.png")));
	     western.setRolloverIcon(new ImageIcon(Main_Frame.class.getResource("/img/양식마우스.png")));
	     total.setRolloverIcon(new ImageIcon(Main_Frame.class.getResource("/img/랜덤마우스.png")));
	     
	     
	     
         JPanel j1 = new JPanel();
         JPanel j2 = new JPanel();
         JPanel j3 = new JPanel();
         j1.setLayout(new GridLayout(1,5));
         j1.setSize(500,200);
         j3.setLayout(new BorderLayout());
         

         f.setBackground(Color.WHITE);
         korea.setContentAreaFilled(false);
         china.setContentAreaFilled(false);
         japan.setContentAreaFilled(false);
         western.setContentAreaFilled(false);
         total.setContentAreaFilled(false);
         review.setContentAreaFilled(false);

         korea.setFocusPainted(false);
         china.setFocusPainted(false);
	     japan.setFocusPainted(false);
	     western.setFocusPainted(false);
	     total.setFocusPainted(false);
	     
	     korea.setBorderPainted(false);
	     china.setBorderPainted(false);
	     japan.setBorderPainted(false);
	     western.setBorderPainted(false);
	     total.setBorderPainted(false);
	     
	     j3.setBackground(Color.BLACK);
	     j1.add(korea);
	     j1.add(china);
	     j1.add(japan);
	     j1.add(western);
	     j1.add(total);						//
	     j2.add(review);						//
	     j2.setBackground(Color.BLACK);
	     f.getContentPane().add(j3);
	     // 타이틀 만들기
	     JPanel title = new JPanel();
	     title.setLayout(new FlowLayout(FlowLayout.RIGHT));

	     title.setBackground(Color.BLACK);
	     f.setUndecorated(true); 
	     j3.add(title,BorderLayout.NORTH);
	     JButton esc = new JButton();
	     title.add(esc);
	     esc.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);
	            }
	        });
	     esc.setPreferredSize(new Dimension(40, 40));
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
	     
	     Image imgrev = new ImageIcon(Sub_Frame.class.getResource("/img/맛집버튼.png")).getImage();
	     Image imgesc = new ImageIcon(Sub_Frame.class.getResource("/img/X버튼.png")).getImage();
	     Image imgesc2 = new ImageIcon(Sub_Frame.class.getResource("/img/X마우스1.png")).getImage();
	     Image imgrev2 = new ImageIcon(Sub_Frame.class.getResource("/img/맛집마우스.png")).getImage();
	     
	     esc.setIcon(new ImageIcon(imgesc.getScaledInstance(32,32,Image.SCALE_SMOOTH)));
	     review.setIcon(new ImageIcon(imgrev.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
	     esc.setRolloverIcon(new ImageIcon(imgesc2.getScaledInstance(32,32,Image.SCALE_SMOOTH)));
	     review.setRolloverIcon(new ImageIcon(imgrev2.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
        
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
    }
	
}
