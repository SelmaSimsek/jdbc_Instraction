import Utils.JdbcMedunnaDBUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static Utils.JdbcMedunnaDBUtils.closeConnection;
import static Utils.JdbcMedunnaDBUtils.executeQuery;

public class MedunnaTest {
    /*
    Given

    Kullanici veri tabanina bagllanir
    (Host name: medunna.com, Database name: medunna_db-v2, Username: select_user, Password: Medunna_pass_@6)

    When
    Kullanici, olusturulan odayi getirmek icin room_number ile sorgu gönderir.

    Then
    Kullanici, oda bilgilerinin dogru kaydedildigini dogrular

    And
    Kullanici, baglantiyi kapatir
     */


    @Test
    public void medunnaTest() throws SQLException {
        // Expected Datalar
        int expectedRoomNumer = 461982;
        String expectedRoomType = "SUITE";
        boolean expectedStatus = true;
        double expectedPrice = 5000;
        String expectedDescription = "Database testi selma";


        String sql = "SELECT * FROM room WHERE room_number=461982";
        ResultSet resultSet = executeQuery(sql);
        resultSet.next();

        int actualRoomNumer = resultSet.getInt("room_number");
        String actualRoomType = resultSet.getString("room_type");
        boolean actualStatus = resultSet.getBoolean("status");
        double actualPrice = resultSet.getDouble("price");
        String actualDescription = resultSet.getString("description");

        Assert.assertEquals(expectedRoomNumer, actualRoomNumer);
        Assert.assertEquals(expectedRoomType, actualRoomType);
        Assert.assertEquals(expectedStatus, actualStatus);
        Assert.assertEquals(expectedPrice, actualPrice,0.01);
        Assert.assertEquals(expectedDescription, actualDescription);

        closeConnection();
    }

    @Test
    public void medunnaTest02() throws SQLException {
        String sql = "SELECT * FROM room WHERE room_number=461982";
        ResultSet resultSet = executeQuery(sql);
        resultSet.next();

        Assert.assertEquals(461982, resultSet.getInt("room_number"));
        Assert.assertEquals("SUITE", resultSet.getString("room_type"));
        Assert.assertTrue(resultSet.getBoolean("status"));
        Assert.assertEquals(5000.00, resultSet.getDouble("price"),0.01);
        Assert.assertEquals("Database testi selma",resultSet.getString("description"));

        closeConnection();
    }
}

