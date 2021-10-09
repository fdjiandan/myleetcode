package annotationdemo;

import com.sun.xml.internal.rngom.ast.builder.Annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyTest {

    @MyAnnotation(value = "test")
    public void myName(String name) {
        System.out.println(name);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        MyTest myTest = new MyTest();
        Class<MyTest> myTestClass = MyTest.class;
        Method method = myTestClass.getMethod("myName", String.class);
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        String value = annotation.value();
        System.out.println(value);
    }
}
