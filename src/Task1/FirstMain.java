package Task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FirstMain {
    public static void main(String[] args) {
        Class<?> cls = FirstTask.class;
        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            if(method.isAnnotationPresent(FirstAnnotation.class)){
                try {
                    method.invoke(null, 13, 17);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class FirstTask {
        @FirstAnnotation
        public static void test(int a, int b){
            System.out.println(a + b);
        }
    }
}