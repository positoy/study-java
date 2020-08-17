package Annotation;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationClassTest extends TestCase {

    @Test
    public void testDoRepeat100Times() {

        AnnotationClass annotationClass = new AnnotationClass();

        // default
        annotationClass.printHello();

        // process annotation
        Method m = null;
        try {
            m = annotationClass.getClass().getDeclaredMethod("printHello");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return;
        }

        int count = m.isAnnotationPresent(DoRepeat100Times.class) ? 100 : 1;
        while (count-- != 0) {
            try {
                m.invoke(annotationClass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testInsertIntData() {

        AnnotationClass annotationClass = new AnnotationClass();

        // default
        assertEquals(annotationClass.getAge(), -1);
        assertEquals(annotationClass.getDefaultAge(), -1);

        // process annotation
        for (Field field : annotationClass.getClass().getDeclaredFields()) {
            if (field != null && field.getType() == int.class && field.isAnnotationPresent(InsertIntData.class)) {
                field.setAccessible(true);
                InsertIntData insertIntData = field.getAnnotation(InsertIntData.class);
                try {
                    field.set(annotationClass, insertIntData.data());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(annotationClass.getAge());
        assertEquals(annotationClass.getAge(), 30);

        System.out.println(annotationClass.getDefaultAge());
        assertEquals(annotationClass.getDefaultAge(), 0);
    }


}