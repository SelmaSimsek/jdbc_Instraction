package Utils;

import java.sql.*;

public class JdbcLocalDBUtils {
    /*
    Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/jdbc_db", "techpro", "password");
     */
    private static Connection connection ;
    private static Statement statement ;

    public static Connection connectToDatabase (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/jdbc_db", "techpro", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    //Statement st = connection.createStatement();
    public static Statement createStatement (){


        try {
            statement = connectToDatabase().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    //ResultSet resultSet = st.executeQuery(sql);
    public static ResultSet  executeQuery(String sql){
        try {
            return createStatement ().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
