/**
 * Created by amit.k.mannur on 4/18/2018.
 */

public interface MyFuncInterface3 extends MyFuncInterface2{
     void functionalMethod2();
    default String isPresent() {
        return "i m from FunctionaalInterface3 is present ";
    }
    default String isPresenty() {
        return "i m from FunctionaalInterface3 is presenty ";
    }
}
