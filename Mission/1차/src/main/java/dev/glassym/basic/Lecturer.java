package dev.glassym.basic;

public class Lecturer extends AbstractPerson{
    public Lecturer(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("저는 강사입니다.");
    }
}
