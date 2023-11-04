public class IlkTest {

        /*
        Expected Data: Beklenen Data
        Actual DAta: Gercek Data
        Test, beklenen Data ile gercek datanin karsilastirilmasidir.
         */

        public static void main(String[] args) {
            String expectedData = "Selam";
            String actualData = "Selam";

            System.out.println("-------test01------");
            if(expectedData.equals(actualData)){
                System.out.println("Test PASSED");
            }else {
                System.out.println("Test FAILED");
            }

            System.out.println("-------test02------");
            int expectedNumber = 5;
            int actualNumber = 5;
            if (expectedNumber == actualNumber){
                System.out.println("Test PASSED");
            }else {
                System.out.println("Test FAILED");
            }

            System.out.println("-------test03------");
            if (expectedNumber > actualNumber){
                System.out.println("Test PASSED");
            }else {
                System.out.println("Test FAILED");
            }

            // Otomasyon testleri yapabilmek icin bir test framework'üne ihtiyacimiz vardir
            // (JUnit, TestNG, Cucumber)




    }
}
