package food5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sub_Frame {
	public static void sub_Frame(String cate){
		Main_Frame main = new Main_Frame();
		Select sel = new Select();
		list list = new list();
	        JFrame f2 = new JFrame("오늘의 " + cate + " 추천 메뉴는 ??");
	        JPanel p2 = new JPanel();
	        p2.setBackground(new Color(253, 219, 232));
	        
	        f2.setSize(800,700);
	        f2.setLocationRelativeTo(null);
	        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f2.getContentPane().setLayout(new BorderLayout());

	       
	        if(cate == "한식"){
	        	main.changed = "where id = \"korea\"";
	        	main.cate_name = "한식";
	        	sel.select();
	            
	        }
	        else if(cate == "중식"){
	        	main.changed = "where id = \"china\"";
	        	main.cate_name = "중식";
	        	sel.select();

	        }
	        else if(cate == "일식"){
	        	main.changed = "where id = \"japan\"";
	        	main.cate_name = "일식";
	        	sel.select();
	       
	        }
	        else if(cate == "양식"){
	        	main.changed = "where id = \"western\"";
	            main.cate_name = "양식";
	            sel.select();
	          
	        }
	        else if(cate == "전체 랜덤"){													//
	        	main.changed = "";
	            main.cate_name = "전체 랜덤";
	            sel.select();
	         
	        }
	        
	        JLabel label = new JLabel("<html><br><br><center>오늘의 추천 메뉴는 <font color='red'>"+main.menu_list.get(main.random_data).getname()+"</font> 입니다!"
	              + "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>" + "창원대 근처의 " + main.menu_list.get(main.random_data).getname()+" 맛집 추천<br><br>["
	              + main.menu_list.get(main.random_data).getPlace()+"]<br>평점("+getAvg()+"/5)"+"<br>주소 : " + main.menu_list.get(main.random_data).getAdress()
	              + "</center></html>");
	        
	        label.setFont(label.getFont().deriveFont(15.0f));
	        p2.add(label);
	        
	        JButton re = new JButton();
	        re.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
//	        		f2.dispose();
//	        		sub_Frame(cate);
	                new Loading(cate);
	                f2.dispose();   //서브 프레임을 없애 바로 닫히는 것을 막음
	        	}
	        });
	        JButton back = new JButton();
	        back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		f2.dispose();
	        		main.menu_list.clear();
	        		main.main_Frame();
	        	}
	        });
	        
	        JPanel pnl = new JPanel();
	        
	        
	        
	        pnl.setBackground(Color.BLACK);
	        pnl.add(re);
	        pnl.add(back);
	        f2.setResizable(false);
	        f2.getContentPane().add(p2);
	        f2.getContentPane().add(pnl,BorderLayout.SOUTH);
	        
	        re.setBackground(null);
	        re.setBorderPainted(false);
	        re.setFocusPainted(false);
	        back.setBackground(null);
	        back.setBorderPainted(false);
	        back.setFocusPainted(false);

	        
	        Image imgre = new ImageIcon(Sub_Frame.class.getResource("/img/다시버튼.png")).getImage();
	        Image imgback = new ImageIcon(Sub_Frame.class.getResource("/img/뒤로.png")).getImage();
	        Image imgre2 = new ImageIcon(Sub_Frame.class.getResource("/img/다시마우스.png")).getImage();
	        Image imgback2 = new ImageIcon(Sub_Frame.class.getResource("/img/뒤로마우스.png")).getImage();
	        re.setIcon(new ImageIcon(imgre.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
	        back.setIcon(new ImageIcon(imgback.getScaledInstance(81,32,Image.SCALE_SMOOTH)));

		     
		    re.setRolloverIcon(new ImageIcon(imgre2.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
		    back.setRolloverIcon(new ImageIcon(imgback2.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
	        
	        
	        
	        JLabel imgLabel = new JLabel();
	        ImageIcon icon = new ImageIcon("src/img/"+ main.menu_list.get(main.random_data).getIdx()+".jpg");
	        imgLabel.setIcon(icon);
	        imgLabel.setBounds(200,100,400,400);
	        imgLabel.setHorizontalAlignment(JLabel.CENTER);
	        f2.add(imgLabel,BorderLayout.CENTER);
	        f2.add(p2);
	        f2.setUndecorated(true);
	        f2.setVisible(true);
	        
	        

	    }

	   private static double getAvg() {
		      Main_Frame main = new Main_Frame();
		      int score = main.menu_list.get(main.random_data).getScore();
		      int count = main.menu_list.get(main.random_data).getCount();
		      double avg = score/(double)count;
		      return Math.round(avg*100)/100.0;
		   }
}
