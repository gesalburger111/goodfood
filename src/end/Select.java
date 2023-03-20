package end;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Select {
    public static void select() {
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
                String sql = "select name, place, idx, adress, score, count, url from total " + main.changed ;
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    UserBean bean = new UserBean();
                    bean.setname(rs.getString("name"));
                    bean.setPlace(rs.getString("place"));
                    bean.setScore(rs.getInt("score"));
                    bean.setCount(rs.getInt("count"));
                    bean.setIdx(rs.getInt("idx"));
                    bean.setAdress(rs.getString("adress"));
                    bean.setUrl(rs.getString("url"));
                    main.menu_list.add(bean);
                }

                main.random_data = main.random.nextInt(main.menu_list.size());

            } catch (SQLException s) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
