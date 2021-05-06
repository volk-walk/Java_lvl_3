public class FirstTest {
    @Test
    public static void test1(){
        System.out.println("Test1 без приоритета");
    }
    @Test(priority = 3)
    public static void test2(){
        System.out.println("Test2 с приоритетом 3");
    }
    @Test(priority = 7)
    public static void test3(){
        System.out.println("Test3 с приоритетом 7");
    }
    @Test(priority = 1)
    public static void test4(){
        System.out.println("Test4 с приоритетом 1");
    }
    @Test(priority = 10)
    public static void test5(){
        System.out.println("Test5 с приоритетом 10");
    }

    @BeforeSuite
    public static void testWithBeforeSuite(){
        System.out.println("Тест с BeforeSuite");
    }


    @AfterSuite
    public static void testWithAfterSuite(){
        System.out.println("Тест с AfterSuite");
    }


}
