package annotation;


public @interface Constraint {
    Class<MyValidator>[] validatedBy();
}