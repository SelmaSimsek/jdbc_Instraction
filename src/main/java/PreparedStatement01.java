
/* PreparedStatement Statement i extend eder( Statementin gelismis hali)
PreparedStatement ile önceden derlenmis tekrar tekrar kullanilabilen
parametreli sorgular olusturup calistirilabilir
 */


import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "techpro","password");
        Statement st = con.createStatement();

        //ÖRNEK1:(Prepared Statement kullanarak) bolumler tablosunda
        // Matematik bölümünün taban_puani'nı 475 olarak güncelleyiniz.

       //st.executeUpdate( "UPDATE bolumler SET taban_puani=475 WHERE bolum='Matematik'");

        //sorguyu parametreli olarak olustur
        String query = "UPDATE bolumler SET taban_puani=? WHERE bolum=?";
        PreparedStatement prst = con.prepareStatement(query);
        //parametreleri verelim
        prst.setInt(1,475);
        prst.setString(2,"Matematik");
        //sorguyu calistiralim
        int updated = prst.executeUpdate();
        System.out.println("updated= "+updated);


        System.out.println("-------------------2--------------");
//ÖRNEK2:(Prepared Statement kullanarak) bolumler tablosunda Edebiyat bölümünün
// taban_puanı'nı 455 olarak güncelleyiniz.

    String query1= "UPDATE bolumler SET taban_puani=? WHERE bolum=?";
    prst.setInt(1,455);
    prst.setString(2, "Edebiyat");
    int updated1 = prst.executeUpdate();
        System.out.println("updated1 = "+updated1);

        System.out.println("------------------3-----------");

        //ÖRNEK3:Prepared Statement kullanarak ogrenciler tablosundan Matematik bölümünde okuyanları siliniz.
        PreparedStatement prst2 = con.prepareStatement("DELETE FROM ogrenciler WHERE bolum ILIKE ?");
        prst2.setString(1, "Matematik");
        //calistiralim
        int deleted = prst2.executeUpdate();
        System.out.println("deleted = "+deleted);

        System.out.println("---------------4------------------");
        //ÖRNEK4:Prepared Statement kullanarak bolumler tablosuna
        // Yazılım Mühendisliği(id=5006,taban_puanı=475, kampus='Merkez') bölümünü ekleyiniz.

        String sql = "INSERT INTO bolumler VALUES(?,?,?,?)";
        PreparedStatement prst3 = con.prepareStatement(sql);
        prst3.setInt(1,5006);
        prst3.setString(2, "Yazilim Mühendisligi");
        prst3.setInt(3,475);
        prst3.setString(4,"Merkez");

        int inserted = prst3.executeUpdate();
        System.out.println("inserted = "+inserted);

        System.out.println("-----------5-----------");
        System.out.println("-------------ÖDEVV---------------");
        //1-Bölüm isimlerini, kampüslerini ve
        //her bir bölümde okuyan öğrencilerin en yüksek puanlarını listeleyiniz.
        String str2 ="SELECT bolum, kampus, (SELECT MAX(taban_puani) FROM bolumler)";




        //2-it_persons tablosundan prog_lang css olanları siliniz.
        String str5 = "DELETE FROM it_persons WHERE prog_lang ? ";
        PreparedStatement prst5 = con.prepareStatement(str5);
        prst5.setString(1,"css");
        int deleted5 = prst5.executeUpdate();
        System.out.println("deleted5 : "+ deleted5);


        //3-it_persons tablosundan prog_lang java olanları siliniz.

        String str6 = "DELETE FROM it_persons WHERE prog_lang ? ";
        prst5.setString(1,"java");
        int deleted6 = prst5.executeUpdate();
        System.out.println("deleted6 : "+ deleted6);











        st.close();
        prst.close();
        con.close();






    }
}
