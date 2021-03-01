
public class Test2 {
    public void testMethod() {
        testMethod2();
    }

    public void testMethod2() {
        System.out.println("Here");
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        t.testMethod();
    }
}