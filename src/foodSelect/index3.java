package foodSelect;
//// SSH 연결
//import com.jcraft.jsch.JSch; 
//import com.jcraft.jsch.Session;	
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// 수정
public class index3 {
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

    public static void main_Frame(){
    	 JFrame f = new JFrame("창원대 뭐 먹지?");
         f.setSize(500,300);
         f.setLocationRelativeTo(null);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.setLayout(new GridLayout(1,1));
//         f.getContentPane().setLayout(new GridLayout(1,2));
//         f.setLayout(new GridLayout(1,2));
         JButton korea = new JButton("한식");
         JButton china = new JButton("중식");
         JButton japan = new JButton("일식");
         JButton western = new JButton("양식");
         JButton total = new JButton("전체 랜덤");			
         JButton review = new JButton("맛집 보기");			
         
         JPanel j1 = new JPanel();
         JPanel j2 = new JPanel();
         JPanel j3 = new JPanel();
         j1.setLayout(new GridLayout(1,5));
         j1.setSize(500,200);
         j3.setLayout(new BorderLayout());
         j2.setLayout(new FlowLayout(FlowLayout.CENTER));
//         Container contentPane = f.getContentPane();
//         contentPane.setBackground(Color.white);

//         contentPane.setLayout(new GridLayout(1,5,10,10));           //
         j3.setBackground(Color.BLACK);
         j1.add(korea);
         j1.add(china);
         j1.add(japan);
         j1.add(western);
         j1.add(total);						//
         j2.add(review);						//
         f.add(j3);
         j3.add(j1,BorderLayout.CENTER);
         j3.add(j2,BorderLayout.SOUTH);
         f.setVisible(true);				//
         korea.setContentAreaFilled(false);
         china.setContentAreaFilled(false);
         japan.setContentAreaFilled(false);
         western.setContentAreaFilled(false);
         total.setContentAreaFilled(false);
         review.setContentAreaFilled(false);
        korea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if(btn.getText().equals("한식")){
                    cate = "한식";
                    sub_Frame(cate);
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
                    sub_Frame(cate);
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
                    sub_Frame(cate);
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
                    sub_Frame(cate);
                    f.dispose();
                }
            }
        });
        total.addActionListener(new ActionListener() {              //
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if(btn.getText().equals("전체 랜덤")){
                    cate = "전체 랜덤";
                    sub_Frame(cate);
                    f.dispose();
                }
            }
        });
        review.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   sub_Frame(cate);
                   f.dispose();
                
            }
        });
    }
    

    public static void sub_Frame(String cate){
        JFrame f2 = new JFrame("오늘의 " + cate + " 추천 메뉴는 ??");
        JPanel p2 = new JPanel();
        
        f2.setSize(800,700);
        f2.setLocationRelativeTo(null);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.getContentPane().setLayout(new BorderLayout());

//        Container contentPane = f2.getContentPane();
//        contentPane.setBackground(Color.WHITE);

        p2.setBackground(Color.WHITE);
//        contentPane.setLayout(new BorderLayout());
       
        if(cate == "한식"){
            changed = "where id = \"korea\"";
            cate_name = "한식";
            select();
            
        }
        else if(cate == "중식"){
            changed = "where id = \"china\"";
            cate_name = "중식";
            select();

        }
        else if(cate == "일식"){
            changed = "where id = \"japan\"";
            cate_name = "일식";
            select();
       
        }
        else if(cate == "양식"){
            changed = "where id = \"western\"";
            cate_name = "양식";
            select();
          
        }
        else if(cate == "전체 랜덤"){													//
            changed = "";
            cate_name = "전체 랜덤";
            select();
         
        }
        
        JLabel label = new JLabel("<html><br><br><br><br><center>오늘의 추천 메뉴는 "+menu_list.get(random_data).getname()+" 입니다!"
        		+ "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>" + "창원대 근처의 " + menu_list.get(random_data).getname()+" 맛집 추천<br><br>"
				+ menu_list.get(random_data).getPlace()+"</center></html>");
        p2.add(label);
        
        JButton re = new JButton("다시하기");
        re.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		f2.dispose();
        		sub_Frame(cate);
        	}
        });
        JButton back = new JButton("뒤로가기");
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		f2.dispose();
        		menu_list.clear();
        		main_Frame();
        	}
        });
        
        JPanel pnl = new JPanel();
        
        
        pnl.add(re);
        pnl.add(back);
        f2.add(p2);
        f2.add(pnl,BorderLayout.SOUTH);
        re.setBackground(Color.WHITE);
        back.setBackground(Color.WHITE);
//        re.setBorderPainted(false);
//        back.setBorderPainted(false);
        
        JLabel imgLabel = new JLabel();
        ImageIcon icon = new ImageIcon("src/img/"+ menu_list.get(random_data).getIdx()+".jpg");
        imgLabel.setIcon(icon);
        imgLabel.setBounds(200,100,400,400);
//        imgLabel.setSize(400, 400);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        f2.add(imgLabel,BorderLayout.CENTER);
        f2.add(p2);
        
        f2.setVisible(true);
        
        

    }

    
    

    public static void select() {
       
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
            	    "jdbc:mysql://222.119.100.81:3382/foodseldb",
            	    "goodfood",
            	    "foodgood"
            	    );
            System.out.println("연결 성공");
            try {
                Statement st = conn.createStatement();
                ResultSet rs = null;
                String sql = "select name, place, idx from total " + changed ;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    UserBean bean = new UserBean();
                    bean.setname(rs.getString("name"));
                    bean.setPlace(rs.getString("place"));
                    bean.setIdx(rs.getInt("idx"));
                    menu_list.add(bean);
                }

                random_data = random.nextInt(menu_list.size());

            } catch (SQLException s) {
                System.out.println("SQL statement is not executed!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        main_Frame();
    }
}

