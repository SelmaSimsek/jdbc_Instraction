import Utils.JdbcLocalDBUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static Utils.JdbcLocalDBUtils.closeConnection;
import static Utils.JdbcLocalDBUtils.executeQuery;

public class CountryTest04 {
     /*
    Given
      Kullanıcı veritabanına bağlanır

    When
      Kullanıcı, 'countries' table'dan region id'leri almak üzere query gönderir

    Then
      Kullanıcı, 1'den büyük region id'lerin sayısının 17 olduğunu doğrular

    And
      Kullanıcı, bağlantıyı kapatır
    */

    @Test
    public void countryTest01() throws SQLException {

    String sql ="select count(*) from countries where region_id>1";
    ResultSet resultSet = executeQuery(sql);

    resultSet.next();
    int toplamRegion = resultSet.getInt("count"); //17
        Assert.assertEquals(17,toplamRegion);

       closeConnection();

    }

    @Test
    public void countryTest02() throws SQLException {
        String sql ="select region_id from countries where region_id>1";
        ResultSet resultSet = executeQuery(sql);
        int toplamRegion1 = 0;
        while (resultSet.next()){
            toplamRegion1++;
        }
        Assert.assertEquals(17, toplamRegion1);
        closeConnection();
    }






}
