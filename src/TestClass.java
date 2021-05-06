import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestClass {

    public static void start(Class obj) throws InvocationTargetException, IllegalAccessException {
        List<Method> listMethods = new ArrayList<>();
        Method[] arrayMethods = obj.getDeclaredMethods();



        for (Method m : arrayMethods) {
            if (m.isAnnotationPresent(Test.class)) {
                listMethods.add(m);
            }
        }
        listMethods.sort((o1, o2) -> o2.getAnnotation(Test.class).priority()-o1.getAnnotation(Test.class).priority());

        for (Method m : arrayMethods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (listMethods.size() > 0 && listMethods.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("BeforeSuite больше 1");
                }
                listMethods.add(0, m);
            }
        }

        for (Method m : arrayMethods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (listMethods.size() > 0 && listMethods.get(listMethods.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("AfterSuite больше 1");
                }
                listMethods.add(m);
            }
        }

        for (Method m : listMethods) {
            m.invoke(null);
        }

    }
}