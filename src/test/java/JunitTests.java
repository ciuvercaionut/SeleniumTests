import org.junit.*;

public class JunitTests {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("In before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("In after class");
    }

    @Before
    public  void before(){
        System.out.println("In before ");
    }

    @After
    public  void after(){
        System.out.println("In after ");
    }

    @Test
    public  void test(){
        System.out.println("In test ");
    }

    @Test
    public void test2(){
        System.out.println("in tesssssssst");
    }

    @Ignore
    public static void ignoreTest(){
        System.out.println("In ignore ");
    }

}
