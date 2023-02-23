package food4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_Frame {
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
	 /**
	  * @wbp.parser.entryPoint
	  */
	 public static void main_Frame(){
		 Sub_Frame sub = new Sub_Frame();
 		 Review_Frame review_f = new Review_Frame();   
		
 		 
    	 JFrame f = new JFrame("창원대 뭐 먹지?");
         f.setSize(1000,700);
         f.setLocationRelativeTo(null);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.getContentPane().setLayout(new GridLayout(1,1));
//         f.getContentPane().setLayout(new GridLayout(1,2));
//         f.setLayout(new GridLayout(1,2));
         JButton korea = new JButton("한식");
         JButton china = new JButton("중식");
         JButton japan = new JButton("일식");
         JButton western = new JButton("양식");
         JButton total = new JButton("전체 랜덤");			
         JButton review = new JButton("식당 리뷰");			
         
         JPanel j1 = new JPanel();
         JPanel j2 = new JPanel();
         JPanel j3 = new JPanel();
         j1.setLayout(new GridLayout(1,5));
         j1.setSize(500,200);
         j3.setLayout(new BorderLayout());
         
//         j2.setLayout(new FlowLayout(FlowLayout.CENTER));
//         Container contentPane = f.getContentPane();
//         contentPane.setBackground(Color.white);

//         contentPane.setLayout(new GridLayout(1,5,10,10));           //
         
         f.setBackground(Color.WHITE);
         korea.setContentAreaFilled(false);
         china.setContentAreaFilled(false);
         japan.setContentAreaFilled(false);
         western.setContentAreaFilled(false);
         total.setContentAreaFilled(false);
         review.setContentAreaFilled(false);
//         korea.setBackground(Color.PINK);
//         korea.setFocusPainted(false);
//         china.setBackground(Color.PINK);
//         china.setFocusPainted(false);
//	     japan.setBackground(Color.PINK);
//	     japan.setFocusPainted(false);
//	     western.setBackground(Color.PINK);
//	     western.setFocusPainted(false);
//	     total.setBackground(Color.PINK);
//	     total.setFocusPainted(false);
//	     review.setBackground(Color.PINK);
//	     review.setFocusPainted(false);

	     j3.setBackground(Color.BLACK);
	     j1.add(korea);
	     j1.add(china);
	     j1.add(japan);
	     j1.add(western);
	     j1.add(total);						//
	     j2.add(review);						//
	     f.getContentPane().add(j3);
	     // 타이틀 만들기
	     JPanel title = new JPanel();
	     title.setLayout(new FlowLayout(FlowLayout.RIGHT));
	     title.setBackground(Color.pink);
	     f.setUndecorated(true); 
	     j3.add(title,BorderLayout.NORTH);
	     JButton esc = new JButton("X");
	     title.add(esc);
	     esc.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);
	            }
	        });
	     esc.setPreferredSize(new Dimension(50, 30));
	     // 타이틀 만들기
	     j3.add(j1,BorderLayout.CENTER);
	     j3.add(j2,BorderLayout.SOUTH);
	     f.setVisible(true);				//
	    
	     
        korea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    cate = "한식";
                    sub.sub_Frame(cate);
                    f.dispose();
            }
        });
        china.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    cate = "중식";
                    sub.sub_Frame(cate);
                    f.dispose();
            }
        });
        japan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    cate = "일식";
                    sub.sub_Frame(cate);
                    f.dispose();
            }
        });
        western.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    cate = "양식";
                    sub.sub_Frame(cate);
                    f.dispose();
            }
        });
        total.addActionListener(new ActionListener() {              //
            @Override
            public void actionPerformed(ActionEvent e) {
                    cate = "전체 랜덤";
                    sub.sub_Frame(cate);
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
