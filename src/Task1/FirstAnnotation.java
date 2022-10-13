package Task1;

import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstAnnotation {
    int param1() default 0;
    int param2() default 0;
}
