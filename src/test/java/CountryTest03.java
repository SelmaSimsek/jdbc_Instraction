import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryTest03 {
     /*
    Given
      Kullanıcı veritabanına bağlanır
    When
      Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını
      almak üzere sorgu gönderir
    Then
      Kullanıcı, ülke isimlerini doğrular: "Belgium", "Switzerland",
      "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom"
    And
      Kullanıcı, bağlantıyı kapatır
    */

    @Test
    public void countryTest3() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "techpro", "password");
        Statement st = con.createStatement();
        String sql = "select country_name from countries Where region_id = 1";

        ResultSet resultSet = st.executeQuery(sql);

        List<String> actualData = new ArrayList<>();
        while (resultSet.next()) {
           String ulkeAdi = resultSet.getString("country_name");
           actualData.add(ulkeAdi);
        }

        List<String> expectedData = List.of("Belgium", "Switzerland",
                "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom");

        Assert.assertEquals(expectedData, actualData);

    }
}
