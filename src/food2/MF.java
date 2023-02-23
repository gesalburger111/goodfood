package food2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.border.EmptyBorder;

import foodSelect.UserBean;
import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.ImageIcon;

public class MF extends JFrame {
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
    
    public static void main(String[] args) {
        new MF();
    }
	public MF() {
		Sub_Frame sub = new Sub_Frame();
   	 JFrame f = new JFrame("창원대 뭐 먹지?");
        f.setSize(1541,880);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new GridLayout(1,1));
//        f.getContentPane().setLayout(new GridLayout(1,2));
//        f.setLayout(new GridLayout(1,2));
        JButton korea = new JButton("한식");
        korea.setIcon(new ImageIcon(MF.class.getResource("/img/한식.png")));
        korea.setFont(new Font("문체부 훈민정음체", Font.BOLD, 30));
        JButton china = new JButton("중식");
        china.setIcon(new ImageIcon(MF.class.getResource("/img/중식.png")));
        china.setFont(new Font("문체부 훈민정음체", Font.BOLD, 30));
        JButton japan = new JButton("일식");
        japan.setIcon(new ImageIcon(MF.class.getResource("/img/japan.png")));
        japan.setFont(new Font("문체부 훈민정음체", Font.BOLD, 30));
        JButton western = new JButton("양식");
        western.setIcon(new ImageIcon(MF.class.getResource("/img/양식.png")));
        western.setFont(new Font("문체부 훈민정음체", Font.BOLD, 30));
        JButton review = new JButton("맛집 보기");			
        review.setFont(new Font("문체부 훈민정음체", Font.BOLD, 30));
        
        JPanel j1 = new JPanel();
        JPanel j2 = new JPanel();
        JPanel j3 = new JPanel();
        j1.setSize(500,200);
        j3.setLayout(new BorderLayout());
        j2.setLayout(new FlowLayout(FlowLayout.CENTER));
//        Container contentPane = f.getContentPane();
//        contentPane.setBackground(Color.white);

//        contentPane.setLayout(new GridLayout(1,5,10,10));           //
        j3.setBackground(Color.BLACK);
        j1.setLayout(new GridLayout(0, 5, 0, 0));
        j1.add(korea);
        j1.add(china);
        j1.add(japan);
        j1.add(western);
        j2.add(review);						//
        f.getContentPane().add(j3);
        j3.add(j1,BorderLayout.CENTER);
        j3.add(j2,BorderLayout.SOUTH);
        f.setVisible(true);				//
        korea.setContentAreaFilled(false);
        china.setContentAreaFilled(false);
        japan.setContentAreaFilled(false);
        western.setContentAreaFilled(false);
        JButton total = new JButton("전체 랜덤");
        total.setIcon(new ImageIcon(MF.class.getResource("/img/랜덤.png")));
        j1.add(total);
        total.setFont(new Font("문체부 훈민정음체", Font.BOLD, 30));
        total.setContentAreaFilled(false);
        total.addActionListener(new ActionListener() {              //
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if(btn.getText().equals("전체 랜덤")){
                    cate = "전체 랜덤";
                    sub.sub_Frame(cate);
                    f.dispose();
                }
            }
        });
        review.setContentAreaFilled(false);
       korea.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JButton btn = (JButton) e.getSource();
               if(btn.getText().equals("한식")){
                   cate = "한식";
                   sub.sub_Frame(cate);
                   f.dispose();
               }
           }
       });
       china.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JButton btn = (JButton) e.getSource();
               if(btn.getText().equals("중식")){
                   cate = "중식";
                   sub.sub_Frame(cate);
                   f.dispose();
               }
           }
       });
       japan.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JButton btn = (JButton) e.getSource();
               if(btn.getText().equals("일식")){
                   cate = "일식";
                   sub.sub_Frame(cate);
                   f.dispose();
               }
           }
       });
       western.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JButton btn = (JButton) e.getSource();
               if(btn.getText().equals("양식")){
                   cate = "양식";
                   sub.sub_Frame(cate);
                   f.dispose();
               }
           }
       });
       review.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           		sub.sub_Frame(cate);
                   f.dispose();
               
           }
       });
	}
	public static void main(String[] args) {
	        Main_Frame main = new Main_Frame();
			main.main_Frame();
	    }
	
}
