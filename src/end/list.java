package end;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class list {
    public static void list() {
    	Main_Frame main = new Main_Frame();
        
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
            	    "jdbc:mysql://222.119.100.81:3382/foodseldb",
            	    "goodfood",
            	    "foodgood"
            	    );
            try {
                Statement st = conn.createStatement();
                ResultSet rs = null;
                String sql = "select place, score, count, url from total";
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    UserBean bean = new UserBean();
                    
                    bean.setScore(rs.getInt("score"));
                    bean.setPlace(rs.getString("place"));
                    bean.setCount(rs.getInt("count"));
                    bean.setUrl(rs.getString("url"));
                    main.list.add(bean);
                }
                
            } catch (SQLException s) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

