import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class CountryTest01 {
 /*
    Given = ön hazirlik
      Kullanıcı veritabanına bağlanır
    When = eyleme gecme
      Kullanıcı, 'countries' tablosundan ülke adlarını almak üzere sorgu gönderir
    Then = Dogrulama (assertion)
      Kullanıcı, country_name sütununda en az bir ülke adı olduğunu doğrular
    And = önceki kullanilan anahtar kelimenin devami niteligindedir.
      Kullanıcı, Bağlantıyı kapatır
    */
    @Test
    public void countryTest() throws SQLException {
        // Kullanici veri tabanina baglanir
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");

        //Kullanıcı, 'countries' tablosundan ülke adlarını almak üzere sorgu gönderir
        Statement st = con.createStatement();

        String sgl = "select country_name from countries";
        ResultSet resultSet = st.executeQuery(sgl);

        //Kullanıcı, country_name sütununda en az bir ülke adı olduğunu doğrular
        int ulkesayisi = 0;
        while (resultSet.next()){
            System.out.println("ülke isimleri: \n"
                    +resultSet.getString("country_name"));
            ulkesayisi++;
        }

        Assert.assertTrue(ulkesayisi>0);

        // Kullanici baglantiyi kapatir
        st.close();
        con.close();
    }






}
