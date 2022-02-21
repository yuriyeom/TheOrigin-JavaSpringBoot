package dev.glassym.mission1.basic;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Week2BasicApplication {

    public static void main(String[] args) {
        Person lecturer = new Lecturer("Lee", 50);

        Person studentKim = new Student("Kim", 25);
        Person studentPark = new Student("Park", 24);
        Person studentYeom = new Student("Yeom", 23);

        List<Person> everyone = new ArrayList<>();
        everyone.add(studentKim);
        everyone.add(studentPark);
        everyone.add(studentYeom);
        everyone.add(lecturer);

        for(Person person:everyone){
            person.speak();
        }
    }
}