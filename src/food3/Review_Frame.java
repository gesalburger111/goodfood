package food3;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Review_Frame {
   
	
   static JPanel p3;
   static JPanel p4;
   /**
    * @wbp.parser.entryPoint
    */
   public static void Review_Frame() {
    
	   Main_Frame main = new Main_Frame();
	   JFrame f3 = new JFrame("리뷰");
	   list list = new list();
      p3 = new JPanel();
      p4 = new JPanel();
      
      f3.setSize(800, 700);
      f3.setLocationRelativeTo(null);
      f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f3.getContentPane().setLayout(new GridLayout(1,2));
      f3.setTitle("리뷰");
      
      
         

      list.list();
      JLabel labellist1;
      JLabel labellist2;
      labellist1 = new JLabel("<html>");
      labellist2 = new JLabel("<html>");
  	for(int i=0; i<20; i++) {
  		double sum = ((double)(((main.list.get(i).getScore())*100/(main.list.get(i).getCount())))/100);
  		labellist1.setText(labellist1.getText()+"<p>"+(i+1) +". " +main.list.get(i).getPlace()+"&nbsp;&nbsp;&nbsp;("+sum+" / 5.0)</p><br>");
  		}
//      
  	labellist1.setText(labellist1.getText()+"</html>");
  	p3.add(labellist1);
  	for(int i=20; i<40; i++) {
  		double sum = ((double)(((main.list.get(i).getScore())*100/(main.list.get(i).getCount())))/100);
  		labellist2.setText(labellist2.getText()+"<p>"+(i+1) +". " +main.list.get(i).getPlace()+"&nbsp;&nbsp;&nbsp;("+sum+" / 5.0)</p><br>");
  		}
//      
  	labellist2.setText(labellist2.getText()+"</html>");
  	p4.add(labellist2);
  	
  	f3.getContentPane().add(p3);
  	f3.getContentPane().add(p4);
    f3.setVisible(true);
       }
   

}