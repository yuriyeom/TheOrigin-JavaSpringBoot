package dev.glassym.mission1.basic;

public class Student extends AbstractPerson{
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("저는 학생입니다.");
    }
}
