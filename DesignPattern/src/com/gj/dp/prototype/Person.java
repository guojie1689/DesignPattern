package com.gj.dp.prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person implements Cloneable {

    private String name;
    private int age;
    private List<String> subjects;
    private Sex sex;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Person clone(){
        try {
            return deepClone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected Person deepClone() throws CloneNotSupportedException {
        Person person =  (Person)super.clone();

        List<String> dest = new ArrayList<>(person.getSubjects());
        Sex sex = new Sex(person.getSex().getValue());

        person.setSubjects(dest);
        person.setSex(sex);

        return person;
    }

    @Override
    public String toString() {
        return this.name+":"+this.age+":"+sex.getValue()+":"+subjects;
    }
}
