package food6_addurl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Update {
    public static void update(int i, int a) {
    	Main_Frame main = new Main_Frame();
        Review_Frame review = new Review_Frame();
    	//update total set score = (score - a) where idx = i;
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
            	    "jdbc:mysql://222.119.100.81:3382/foodseldb",
            	    "goodfood",
            	    "foodgood"
            	    );
            try {
                PreparedStatement pstmt = null;
                
                
                String sql = "update total set score = (score + " + a + ") where idx = " + i ;
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate(sql);
                sql = "update total set count = (count + 1) where idx = " + i ;
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate(sql);
               
                review.Review_Frame();
            } catch (SQLException s) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
