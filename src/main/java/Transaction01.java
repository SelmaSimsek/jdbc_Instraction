import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
        Transaction:DB de en küçük(parçalanamaz,atomik) işlemdir.
        Birden fazla işlemi gruplayarak tek bir transaction oluşturabiliriz.
        Bu işlemlerden en az biri başarısız olursa ROLLBACK ile diğer işlemler de iptal edilerek veri tutarlılığı sağlanır.
        Bu işlemlerin tamamı başarılı olursa değişiklikler COMMIT ile onaylanarak DBde kalıcı hale getirilir.
        */
public class Transaction01 {
    public static void main(String[] args) throws Exception {
//olmaması gereken senaryo!
        //hesap no:1234 ten hesap no:5678 e 1000$ para transferi olsun.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcnt_db","techpront","password");


        String sql="UPDATE hesaplar SET bakiye=bakiye+? WHERE hesap_no=?";
        PreparedStatement prst =con.prepareStatement(sql);
        //1-para transferi yapan hesabın bakiyesini güncelleme
        prst.setInt(1,-1000);
        prst.setInt(2,1234);
        prst.executeUpdate();

        //sistemsel hata oluştu
        if(true){
            throw new Exception();//burada uygulama duracak
        }


        //2-para transferi alan hesabın bakiyesini güncelleme
        prst.setInt(1,1000);
        prst.setInt(2,5678);
        prst.executeUpdate();

        //her iki işlem ayrı transactionlarda yapılınca veri tutarsızlığı


    }
}