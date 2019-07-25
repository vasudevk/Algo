/**
 * Created by amit.k.mannur on 4/18/2018.
 */

public interface MyFuncInterface2 {
     void functionalMethod2();

     default String isPresent() {
         return "i m from FunctionaalInterface2 is present ";
    }
     default String isPresenty() {
         return "i m from FunctionaalInterface2 is presenty ";
    }
}
