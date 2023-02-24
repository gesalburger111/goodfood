package food6_addurl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;




public class Review_Frame extends JFrame{

   
   private static int num=0;
      private static int score=0;
         static JPanel p3;
         static JPanel p4;

         
      public static void Review_Frame() {
       
         Main_Frame main = new Main_Frame();
           JFrame f3 = new JFrame("리뷰");
           list list = new list();
           Update update = new Update();
            
            p3 = new JPanel();
            p4 = new JPanel();
            
            
            JPanel p5 = new JPanel();   //별점 버튼
            JPanel p6 = new JPanel();   //리뷰 판(그리드)
            JPanel p7 = new JPanel();   //뒤로가기 버튼
            
            JPanel p_back = new JPanel();   

            p_back.setLayout(new BorderLayout());
            p6.setLayout(new GridLayout(1,2));
            


         // JTextField restaurant_num = new JTextField();
         // restaurant_num.setPreferredSize(new Dimension(50,30));

         NumberFormatter num_range1 = new NumberFormatter();
         num_range1.setValueClass(Integer.class);
         num_range1.setMinimum(new Integer(1));      // 식당 번호 1~40까지만 입력
         num_range1.setMaximum(new Integer(40));
         JFormattedTextField restaurant_num = new JFormattedTextField(num_range1);
         restaurant_num.setPreferredSize(new Dimension(50,30));
         JLabel label = new JLabel("식당번호: ");
         Image imgreview = new ImageIcon(Review_Frame.class.getResource("/img/placeicon.png")).getImage();

         label.setIcon(new ImageIcon(imgreview.getScaledInstance(30,30,Image.SCALE_SMOOTH)));
         p5.add(label);
         p5.add(restaurant_num);
         p_back.add(p5);   //
         NumberFormatter num_range2 = new NumberFormatter();
         num_range2.setValueClass(Integer.class);
         num_range2.setMinimum(new Integer(1));      // 별점 1~ 5
         num_range2.setMaximum(new Integer(5));

         JFormattedTextField score_write = new JFormattedTextField(num_range2);
         
         restaurant_num.setPreferredSize(new Dimension(50,30));
         score_write.setPreferredSize(new Dimension(50,30));
         
         JLabel label2 = new JLabel("<html>별점(1~5): ");
         Image imgreview2 = new ImageIcon(Review_Frame.class.getResource("/img/star.png")).getImage();

         label2.setIcon(new ImageIcon(imgreview2.getScaledInstance(30,30,Image.SCALE_SMOOTH)));
         label.setForeground(Color.WHITE);
         label2.setForeground(Color.WHITE);
         p5.add(label2);
         p5.add(score_write);
         p_back.add(p5);//
        
//         f3.add(p_back);
         
         //
//         p5.add(new JLabel("별점(1~5): "));
//         p5.add(score_write);
//         f3.add(p5);


         
         
//         JTextField restaurant_num = new JTextField();
//         JTextField score_write = new JTextField ();

         
         f3.setSize(800, 800);
         f3.setLocationRelativeTo(null);
         f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f3.getContentPane().setLayout(new BorderLayout());
         f3.setTitle("리뷰");
         
         p_back.add(p6,BorderLayout.CENTER);
         f3.setUndecorated(true); 

         list.list();
         JLabel labellist1;
         JLabel labellist2;
         labellist1 = new JLabel("<html><br>");
         labellist2 = new JLabel("<html><br>");
        for(int i=0; i<20; i++) {
             double sum = ((double)(((main.list.get(i).getScore())*100/(main.list.get(i).getCount())))/100);
             if(i+1==num) {
                labellist1.setText(labellist1.getText()+"<p><font color='red'>"+(i+1) +". " +main.list.get(i).getPlace()+"&nbsp;&nbsp;&nbsp;("+sum+" / 5.0)</font></p><br>");
             }else {
                 labellist1.setText(labellist1.getText()+"<p>"+(i+1) +". " +main.list.get(i).getPlace()+"&nbsp;&nbsp;&nbsp;("+sum+" / 5.0)</p><br>");
                 labellist1.setText(labellist1.getText());
             }

              
        }
        JButton btn = new JButton();   
        JButton back = new JButton();
        
        
        
        
        
        
        
        Image imgbtn = new ImageIcon(Sub_Frame.class.getResource("/img/별점버튼.png")).getImage();
        Image imgback = new ImageIcon(Sub_Frame.class.getResource("/img/뒤로.png")).getImage();
        Image imgbtn2 = new ImageIcon(Sub_Frame.class.getResource("/img/별점마우스.png")).getImage();
        Image imgback2 = new ImageIcon(Sub_Frame.class.getResource("/img/뒤로마우스.png")).getImage();
        btn.setIcon(new ImageIcon(imgbtn.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
        back.setIcon(new ImageIcon(imgback.getScaledInstance(81,32,Image.SCALE_SMOOTH)));

	     
	    btn.setRolloverIcon(new ImageIcon(imgbtn2.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
	    back.setRolloverIcon(new ImageIcon(imgback2.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
        
        btn.setBackground(null);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);

        back.setBackground(null);
        back.setBorderPainted(false);
        back.setFocusPainted(false);

        
        
        
        
        
        p5.add(btn);
        p7.add(back);
        btn.addActionListener(new ActionListener() {              //
           @Override
            public void actionPerformed(ActionEvent e) {
              if(!restaurant_num.getText().equals("")) {
                 num = Integer.parseInt(restaurant_num.getText());
              }else num =0;
              if(!score_write.getText().equals("")) {
                 score = Integer.parseInt(score_write.getText());
              }else score =0;
             
             if(num<=40 && num>=0 && score>=1 && score<=5) {
                 JButton btn = (JButton) e.getSource();
                 f3.dispose();
                 main.list.clear();
//                String num = restaurant_num.getText();
//                String score = score_write.getText();
                 JOptionPane.showMessageDialog(null, "별점 주기가 완료되었습니다.", "알림 메세지", JOptionPane.PLAIN_MESSAGE);
             }else {
                JOptionPane.showMessageDialog(null, "식당번호: 1~40, 별점 1~5를 입력하세요.");
                num=0;
                score=0;
                f3.dispose();
             }
              update.update(num,score);
           }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               f3.dispose();
               main.main_Frame();
            }
        });
      //      
        labellist1.setText(labellist1.getText()+"</html>");
        p3.add(labellist1);
        for(int i=20; i<40; i++) {
           
           double sum = ((double)(((main.list.get(i).getScore())*100/(main.list.get(i).getCount())))/100);
           if(i+1==num) {
              labellist2.setText(labellist2.getText()+"<p><font color='red'>"+(i+1) +". " +main.list.get(i).getPlace()+"&nbsp;&nbsp;&nbsp;("+sum+" / 5.0)</font></p><br>");
           }else {
              labellist2.setText(labellist2.getText()+"<p>"+(i+1) +". " +main.list.get(i).getPlace()+"&nbsp;&nbsp;&nbsp;("+sum+" / 5.0)</p><br>");
           }
           
        }
      //      
        labellist2.setText(labellist2.getText()+"</html>");
        p4.add(labellist2);
           
        p6.add(p3);
        p6.add(p4);
        p_back.add(p5,BorderLayout.NORTH);
        p_back.add(p7,BorderLayout.SOUTH);
        p3.setBackground(null);
        p4.setBackground(null);
        p5.setBackground(Color.BLACK);
//        p6.setBackground(null);
        p7.setBackground(Color.BLACK);
        p6.setBackground(new Color(253, 219, 232));
        

        

        
        f3.getContentPane().add(p_back);
        f3.setVisible(true);

      }
}