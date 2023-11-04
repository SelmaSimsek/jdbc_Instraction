import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class CountryTestÖdev {
     /*
    Given
      Kullanıcı veritabanına bağlanır
    When
      Kullanıcı, 'countries' table'dan region id'leri almak üzere query gönderir
    Then
      Kullanıcı, 1'den büyük region id'lerin sayısının 17 olduğunu doğrula
    And
      Kullanıcı, bağlantıyı kapatır
    */

    @Test
    public void countryTest() throws SQLException {

    // Kullanıcı veritabanına bağlanır
    Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/jdbc_db", "techpro", "password");
    Statement st = con.createStatement();
    String sql = "select region_id from countries where region_id>1";
    ResultSet resultSet = st.executeQuery(sql);

    int expectedData = 0;
    while (resultSet.next()){
        expectedData++;
    }
        System.out.println("regionSayisi :" +expectedData);
    int actualData=17;
        Assert.assertEquals(expectedData,actualData);

    st.close();
    con.close();
    }

}
