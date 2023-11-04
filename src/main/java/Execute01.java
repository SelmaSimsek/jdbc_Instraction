import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1-ADIM: driver göster
        Class.forName("org.postgresql.Driver"); // java 7 ile birlikte gerek kalmadi

        //2.ADIM: Database e baglanma
        Connection connection =  DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/jdbc_db",
                        "techpro","password");

        //3.ADIM: Statement olusturma: SQL sorgularini olusturma ve DB ye göndermek icin
        Statement st = connection.createStatement();

        System.out.println("Connection is sccess");

        //4.ADIM: Query i yazip calistirma

//ÖRNEK 1:"workers" adında bir tablo oluşturup
// "worker_id,worker_name,salary" sütunlarını ekleyiniz.

   boolean sql1 =  st.execute("CREATE TABLE IF NOT EXISTS workers(worker_id INT,worker_name VARCHAR(50),salary REAL)");
   System.out.println("sql1 : " +sql1 );
        //execute metodu DQL veya DDL komutları için kullanılır
        //DQL için kullanılırsa:ResultSet nesnesi alırsa TRUE döndürür, aksi halde false döndürür
        //DDL için kullanılırsa:geriye FALSE döndürür.

//ÖRNEK 2:"workers" tablosuna VARCHAR(20) tipinde "city" sütununu ekleyiniz.

     //   boolean sql2 =  st.execute("ALTER TABLE workers ADD COLUMN city VARCHAR(20)");
     //   System.out.println("sql2 = " + sql2);

        //ÖRNEK 3:"workers" tablosunu SCHEMAdan siliniz.
        boolean sql3 = st.execute("DROP TABLE workers");
        System.out.println("sql3 = " + sql3);


//5.ADIM: baglantiyi ve statement kapatma
        st.close();
        connection.close();



    }
}
