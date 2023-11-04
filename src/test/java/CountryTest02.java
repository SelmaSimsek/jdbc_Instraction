import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class CountryTest02 {
      /*
    Given
      Kullanıcı veritabanına bağlanır
    When
      Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını
      almak üzere sorgu gönderir
    Then
      Kullanıcı, 1 nolu bölgeye ait ülkelerin sayısının 8 oldugunu doğrular
    And
      Kullanıcı, bağlantıyı kapatır
    */




    @Test
    public void countryTest () throws SQLException {
        // Kullanıcı veritabanına bağlanır
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");

        //  Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını
        //      almak üzere sorgu gönderir
        Statement st = con.createStatement();
        String sql = "select country_name from countries where region_id = 1";
        ResultSet resultSet = st.executeQuery(sql);

         // Kullanıcı, 1 nolu bölgeye ait ülkelerin sayısının 8 oldugunu doğrular
        int actualData = 0;
        while (resultSet.next()){
            actualData++;
        }
        System.out.println("actualData :"+actualData);
        int expectedData = 8;
        Assert.assertEquals(8,actualData);

       // Kullanıcı, bağlantıyı kapatır
        con.close();
        st.close();
    }


}
