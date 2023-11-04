import org.junit.Assert;
import org.junit.Test;

public class JUnitTest {
    //Assertion : Test sonuclarini dogrulamak icin yaptigimiz islemlerdir
    // Testin kaldigini ya da gectigini anlamak icin assertion methodlarini kullaniriz

        //ASSERTION TÜRLERI.
        //1.assertEquals()--> icerisine eklenen parametreler esitse test gecer, degilse kalir

        @Test
        public void test01 () {
            String expectedData ="Selam";
            String actualData ="Selam";

            Assert.assertEquals(expectedData,actualData);
        }

        // 2. assertTrue() --> icerisine eklenen islemin sonucu true ise test gecer , false ise test kalir

         @Test
         public void test02 () {
            int sayi=5;
            Assert.assertTrue(sayi>5);
    }

    // 3.assertNotEquals() --> icerisine eklenen parametreler esit degilse gecer, esitse kalir.
    @Test
    public void test3(){
            int sayi1 = 5;
            int sayi2 = 6;
            Assert.assertNotEquals(sayi1,sayi2);
    }
    // 4. assertFalse() --> icerisine eklenen islemin sonucu false ise test gecer , true ise test kalir

    @Test
    public void test04 () {
        int sayi=5;
        Assert.assertFalse(sayi>5);
    }

}
