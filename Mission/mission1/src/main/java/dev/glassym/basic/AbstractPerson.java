package dev.glassym.basic;

public abstract class AbstractPerson implements Person {
    private String name;
    private int age;

    public AbstractPerson(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void speak() {
        System.out.println("이름 : " + this.name);
    }

    @Override
    public String toString() {
        return "AbstractPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
