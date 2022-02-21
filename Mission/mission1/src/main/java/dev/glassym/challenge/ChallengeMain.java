package dev.glassym.challenge;

import dev.glassym.basic.Lecturer;
import dev.glassym.basic.Person;
import dev.glassym.basic.Student;

import java.util.*;

public class ChallengeMain {
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

        printItems(everyone);
    }

    public static <T> void printItems(Iterable<T> iterable){
        Iterator<T> iterator = iterable.iterator();
        if(!iterator.hasNext()){
            System.out.println("No Elements");
            return;
        }
        StringBuilder sb = new StringBuilder();

        sb.append("idx\t\titem\n");
        for(int i=0; iterator.hasNext(); i++){
            T item = iterator.next();
            sb.append(String.format("%d\t\t%s\n", i, item));
        }
        System.out.println(sb);
    }
}
