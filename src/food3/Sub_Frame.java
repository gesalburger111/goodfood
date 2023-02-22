package food3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
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
	        JFrame f2 = new JFrame("오늘의 " + cate + " 추천 메뉴는 ?");
	        JPanel p2 = new JPanel();
	        
	        f2.setSize(800,700);
	        f2.setLocationRelativeTo(null);
	        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f2.getContentPane().setLayout(new BorderLayout());

//	        Container contentPane = f2.getContentPane();
//	        contentPane.setBackground(Color.WHITE);

	        p2.setBackground(Color.WHITE);
//	        contentPane.setLayout(new BorderLayout());
	       
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
//	        else if(cate == "리뷰") {
//	        	list.list();
//	        	for(int i=0; i<40; i++) {
//	        		double sum = ((double)(((main.list.get(i).getScore())*100/(main.list.get(i).getCount())))/100);
//	        		JLabel labellist = new JLabel("<html>"+main.list.get(i).getPlace()+sum+"<br><br></html>");
//	        		p2.add(labellist);
//	        	}
//	        }
//	        
	        JLabel label = new JLabel("<html><br><br><center>오늘의 추천 메뉴는 <strong>"+main.menu_list.get(main.random_data).getname()+"</strong> 입니다!"
	        		+ "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>" + "창원대 근처의 " + main.menu_list.get(main.random_data).getname()+" 맛집 추천<br><br>"
					+ main.menu_list.get(main.random_data).getPlace()+ "<br>주소 : " + main.menu_list.get(main.random_data).getAdress()
							+ "</center></html>");
	        label.setFont(label.getFont().deriveFont(15.0f));
//	        label.setFont(new Font("",Font.BOLD,15));
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
	        		main.menu_list.clear();
	        		main.main_Frame();
	        	}
	        });
	        
	        JPanel pnl = new JPanel();
	        
	        
	        
	        pnl.add(re);
	        pnl.add(back);
	        f2.add(p2);
	        f2.add(pnl,BorderLayout.SOUTH);
	        re.setBackground(Color.PINK);
	        back.setBackground(Color.PINK);
	        re.setFocusPainted(false);
	        back.setFocusPainted(false);
	        f2.setResizable(false);
//	        re.setBorderPainted(false);
//	        back.setBorderPainted(false);
	        
	        JLabel imgLabel = new JLabel();
	        ImageIcon icon = new ImageIcon("src/img/"+ main.menu_list.get(main.random_data).getIdx()+".jpg");
	        imgLabel.setIcon(icon);
	        imgLabel.setBounds(200,100,400,400);
//	        imgLabel.setSize(400, 400);
	        imgLabel.setHorizontalAlignment(JLabel.CENTER);
	        f2.add(imgLabel,BorderLayout.CENTER);
	        f2.add(p2);
//	        
	        f2.setVisible(true);
	        
	        

	    }

	
}
