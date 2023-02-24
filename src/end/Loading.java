package end;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;



public class Loading extends JFrame {
	
	Main_Frame id;
	
	public Main_Frame getId() {
		return id;
	}

	public void setId(Main_Frame id) {
		this.id = id;
	}

    public Loading(String cate) {
    	getContentPane().setBackground(new Color(255, 255, 255));
    	
    	String str = cate;
    	JPanel contentPane;
        JLabel imageLabel = new JLabel();
        
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.TOP);
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new BorderLayout());
        setUndecorated(true); 
        
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            contentPane.setLayout(new BorderLayout());
            setSize(new Dimension(300,300));
            setTitle("클릭하세요");
            
            //이미지 레이블
            ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/load.gif"));
            imageLabel.setIcon(ii);
            getContentPane().add(imageLabel);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            
            
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        
        JButton click = new JButton();
        JPanel click_p = new JPanel();
        click_p.setBackground(new Color(255, 255, 255));
        click_p.setLayout(new BorderLayout());
        click_p.add(click, BorderLayout.SOUTH);
       
        Image imgclick = new ImageIcon(Sub_Frame.class.getResource("/img/결과버튼.png")).getImage();
        Image imgclick2 = new ImageIcon(Sub_Frame.class.getResource("/img/결과마우스.png")).getImage();
        
        click.setIcon(new ImageIcon(imgclick.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
	    click.setRolloverIcon(new ImageIcon(imgclick2.getScaledInstance(81,32,Image.SCALE_SMOOTH)));
        click.setBorderPainted(false);
        click.setFocusPainted(false);
        click.setBackground(Color.BLACK);
        contentPane.add(click_p);
    
        click.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Sub_Frame.sub_Frame(str);
			}
    });

    }
}
