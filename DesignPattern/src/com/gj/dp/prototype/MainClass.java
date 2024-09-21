package com.gj.dp.prototype;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args){

        List<String> friends = new ArrayList<>();

        friends.add("Yuwen");
        friends.add("Shuxue");

        Person person1 = new Person();

        person1.setAge(10);
        person1.setSubjects(friends);
        person1.setName("zhangsan");
        person1.setSex(new Sex(1));

        Person person2 = person1.clone();

        person1.setName("lisi");
        person1.getSubjects().add("UNKnown");
        person1.getSex().setValue(10);

        System.out.println("person1:"+person1);
        System.out.println("person2:"+person2);

        System.out.println("MainClass ---");
    }
}
