import Utils.JdbcLocalDBUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Deneme {
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


        String sql = "select country_name from countries Where region_id = 1";
        ResultSet rs = JdbcLocalDBUtils.executeQuery(sql);

        List<String> actualData = new ArrayList<>();
        while (rs.next()) {
            String ulkeAdi = rs.getString("country_name");
            actualData.add(ulkeAdi);
        }

        List<String> expectedData = List.of("Belgium", "Switzerland",
                "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom");

        List<String> mixedData = List.of("Switzerland", "Belgium", "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom");
        List<String> someData = List.of("Belgium", "Switzerland", "Germany");

        Assert.assertEquals(expectedData, actualData);
        Assert.assertTrue(actualData.containsAll(mixedData));
        Assert.assertTrue(actualData.contains("Germany") && actualData.contains("Denmark"));
        Assert.assertTrue(actualData.containsAll(someData));



        //baglantiyi kapatma
        JdbcLocalDBUtils.closeConnection();

    }
}