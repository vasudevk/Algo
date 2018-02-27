package annotation;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        System.out.println(application.validate1());
        System.out.println(application.validate2());
    }

    @MyAnnotation(message = "msg1")
    public boolean validate1() {
        return false;
    }

    @MyAnnotation(message = "msg")
    public boolean validate2() {
        return true;
    }
}