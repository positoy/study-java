package Annotation;

public class AnnotationClass {

    @InsertIntData
    int defaultAge;

    @InsertIntData(data = 30)
    int age;

    public AnnotationClass() {
        defaultAge = -1;
        age = -1;
    }

    public int getDefaultAge() {
        return defaultAge;
    }

    public int getAge() {
        return age;
    }

    @DoRepeat100Times
    public void printHello() {
        System.out.println("Hello");
    }
}
