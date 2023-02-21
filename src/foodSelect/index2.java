package foodSelect;
//// SSH �뿰寃�
//import com.jcraft.jsch.JSch; 
//import com.jcraft.jsch.Session;	

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class index2 {
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
        JFrame f = new JFrame("�삤�뒛 萸� 癒뱀�?");
        f.setSize(500,200);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(null);

        JButton korea = new JButton("�븳�떇");
        JButton china = new JButton("以묒떇");
        JButton japan = new JButton("�씪�떇");
        JButton western = new JButton("�뼇�떇");
        JButton total = new JButton("�쟾泥� �옖�뜡");					// total : �쟾泥대옖�뜡
        
        

        Container contentPane = f.getContentPane();
        contentPane.setBackground(Color.pink);

        contentPane.setLayout(new GridLayout(1,4));           //

        f.getContentPane().add(korea);
        f.getContentPane().add(china);
        f.getContentPane().add(japan);
        f.getContentPane().add(western);
        f.getContentPane().add(total);						//

        f.setVisible(true);

        korea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if(btn.getText().equals("�븳�떇")){
                    cate = "�븳�떇";
                    sub_Frame(cate);
                    f.dispose();
                }
            }
        });
        china.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if(btn.getText().equals("以묒떇")){
                    cate = "以묒떇";
                    sub_Frame(cate);
                    f.dispose();
                }
            }
        });
        japan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if(btn.getText().equals("�씪�떇")){
                    cate = "�씪�떇";
                    sub_Frame(cate);
                    f.dispose();
                }
            }
        });
        western.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if(btn.getText().equals("�뼇�떇")){
                    cate = "�뼇�떇";
                    sub_Frame(cate);
                    f.dispose();
                }
            }
        });
        total.addActionListener(new ActionListener() {              //
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if(btn.getText().equals("�쟾泥� �옖�뜡")){
                    cate = "�쟾泥� �옖�뜡";
                    sub_Frame(cate);
                    f.dispose();
                }
            }
        });
    }
    

    public static void sub_Frame(String cate){
        JFrame f2 = new JFrame("�삤�뒛�쓽 " + cate + " 異붿쿇 硫붾돱�뒗 ??");
        JPanel p2 = new JPanel();
        f2.setSize(500,400);
        f2.setLocationRelativeTo(null);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.getContentPane().setLayout(null);

        Container contentPane = f2.getContentPane();
        contentPane.setBackground(Color.pink);

        contentPane.setLayout(new BorderLayout());

        if(cate == "�븳�떇"){
            changed = "korea";
            cate_name = "�븳�떇";
            select();
            JLabel label = new JLabel(menu_list.get(random_data).getname()+" �엯�땲�떎!");
            p2.add(label);
        }
        else if(cate == "以묒떇"){
            changed = "china";
            cate_name = "以묒떇";
            select();
            JLabel label = new JLabel(menu_list.get(random_data).getname()+" �엯�땲�떎!");
            p2.add(label);
        }
        else if(cate == "�씪�떇"){
            changed = "japan";
            cate_name = "�씪�떇";
            select();
            JLabel label = new JLabel(menu_list.get(random_data).getname()+" �엯�땲�떎!");
            p2.add(label);
        }
        else if(cate == "�뼇�떇"){
            changed = "western";
            cate_name = "�뼇�떇";
            select();
            JLabel label = new JLabel(menu_list.get(random_data).getname()+" �엯�땲�떎!");
            p2.add(label);
        }
        else if(cate == "�쟾泥� �옖�뜡"){													//
            changed = "Total";
            cate_name = "�쟾泥� �옖�뜡";
            select();
            JLabel label = new JLabel(menu_list.get(random_data).getname()+" �엯�땲�떎!");
            p2.add(label);
        }
        
        
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
                String sql = "select name from " + changed;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    UserBean bean = new UserBean();
                    bean.setname(rs.getString("name"));
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
