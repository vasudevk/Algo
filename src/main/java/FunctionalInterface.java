/**
 * Created by amit.k.mannur on 4/18/2018.
 */

public class FunctionalInterface implements  MyFuncInterface3,MyFuncInterface2 {
    public static void main(String[] args) {
        FunctionalInterface functionalInterface = new FunctionalInterface();
        System.out.println(functionalInterface.isPresent());
        System.out.println(functionalInterface.isPresenty());
    }

    public void functionalMethod2() {

    }

    public String isPresent() {
        return "i m from FunctionaalInterface";
    }
}

