import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "techpro","password");

        Statement st = con.createStatement();
        System.out.println("success");

        //ÖRNEK 1:id'si 5 ile 10 arasında olan ülkelerin "country_name" bilgisini listeleyiniz.
        boolean sgl1 = st.execute("SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10" );
        System.out.println("sgl1 = " + sgl1);

        //kayıtları görmek için executeQuery()
        ResultSet resultSet =st.executeQuery("SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10");
      //  resultSet.next(); //bir sonraki satira gecmeyi saglar
       // System.out.println("Ülke ismi : " +resultSet.getString("country_name"));

        while(resultSet.next()){
            System.out.println("Ülke ismi : " +resultSet.getString("country_name"));
         //   System.out.println("Ülke ismi : " +resultSet.getString(1)); // index kullanilabilir ancak tercih edilmez
        }

        System.out.println("----------------------ÖRNEK 2----------------------------");
        //ÖRNEK 2: phone_code'u 600 den büyük olan ülkelerin "phone_code" ve "country_name" bilgisini listeleyiniz.

        ResultSet rs2 =st.executeQuery("SELECT phone_code, country_name FROM countries WHERE phone_code>600");
        while (rs2.next()){
            System.out.println("Tel_kodu" + rs2.getInt("phone_code")+
                                "--Ülke ismi  : " + rs2.getString("country_name"));

        }

        System.out.println("------------------------örnek3--------------------------");
        //ÖRNEK 3:it_persons tablosunda "salary" değeri en düşük salary olan developerların tüm bilgilerini gösteriniz.


        ResultSet rs3 =st.executeQuery("SELECT * FROM it_persons WHERE salary = (SELECT MIN(salary) FROM it_persons)");
        while (rs3.next()){
            System.out.println(rs3.getInt("id")+"--"+rs3.getString("name")
                    + "--"+ rs3.getDouble("salary")+ "--"+rs3.getString("prog_lang"));
        }

        System.out.println("--------------ÖRNEK 4------------------------------");
        //ÖRNEK 4:Puanı bölümlerin taban puanlarının ortalamasından yüksek olan öğrencilerin
        // isim ve puanlarını listeleyiniz.ÖDEVVV

       //String query4 = st.executeQuery("SELECT isim, puan FROM ogrenciler WHERE puan>(SELECT AVG(taban_puani)FROM bölümler");
       // ResultSet rs4=st.executeQuery(query4);

       /* String query5= "SELECT bolum, puan FROM bolumler WHERE taban_puani = " +
                "(SELECT MAX(taban_puani) FROM bolumler " +
                "WHERE taban_puani<(SELECT MAX(taban_puani) FROM bolumler))";
        ResultSet rs5= st.executeQuery(query5);
        while (rs5.next()){
            System.out.println(rs5.getString("bolum")+"---"+rs5.getInt("taban_puani"));

        }*/

        st.close();
        con.close();
    }
}
