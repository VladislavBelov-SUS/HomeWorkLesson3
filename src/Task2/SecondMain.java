package Task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SecondMain {
    public static void main(String[] args) {
        Class<?> cls = Container.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                System.out.println(method.getName());
                try {
                    SaveTo saveTo = cls.getAnnotation(SaveTo.class);
                    method.invoke(new Container(), saveTo.filePath());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @SaveTo(filePath = "E:\\StringFile.txt")
    static class Container {
        String str = "Run once, debug everywhere";

        public Container() {
        }

        @Saver
        public void save(String pathToFile) {
            File file = new File(pathToFile);
            try (var writer = new FileWriter(file, true)) {
                writer.write(str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
