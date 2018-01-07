package com.gj.dp.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface PersonBean {
    String getName();

    String getGender();

    String getInterests();

    int getHotOrNotRating();

    void setName(String name);

    void setGender(String gender);

    void setInterests(String interests);

    void setHotOrNotRating(int rating);
}

class PersonBeawnImpl implements PersonBean {
    String name;
    String gender;
    String interests;
    int rating = 0;
    int ratingCount = 0;

    public PersonBeawnImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0)
            return 0;
        return rating / ratingCount;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }
}

class OwnerInvocationHandler implements InvocationHandler {

    private PersonBean personBean;

    public OwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try {

            if (method.getName().equals("setHotOrNotRating")) {
                throw new IllegalAccessError("不能篡改自己评分");
            } else if (method.getName().startsWith("get") || method.getName().startsWith("set")) {
                return method.invoke(personBean, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}

class NonOwnerInvocationHandler implements InvocationHandler {

    private PersonBean personBean;

    public NonOwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try {

            if (method.getName().startsWith("get") || method.getName().equals("setHotOrNotRating")) {
                return method.invoke(personBean, args);
            } else if (method.getName().startsWith("set")) {
                throw new IllegalAccessError("不能修改对方资料");
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}

class PersonProxy {

    public static PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new OwnerInvocationHandler(personBean));
    }

    public static PersonBean getNonOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(personBean));
    }
}

public class DynamicProxyMain {
    public static void main(String[] args) {
        PersonBean zhangSan = new PersonBeawnImpl("张三");

        PersonBean ownerPersonBean = PersonProxy.getOwnerProxy(zhangSan);
        ownerPersonBean.setInterests("football,running");
        try {
            ownerPersonBean.setHotOrNotRating(10);
        } catch (IllegalAccessError e) {
            System.out.println("faild:" + e.getMessage());
        }
        System.out.println(ownerPersonBean.getName() + ":" + ownerPersonBean.getInterests());

        PersonBean nonOwnerProxy = PersonProxy.getNonOwnerProxy(zhangSan);

        try {
            nonOwnerProxy.setInterests("swiming");
        } catch (IllegalAccessError e) {
            System.out.println("faild:" + e.getMessage());
        }

        nonOwnerProxy.setHotOrNotRating(10);

        System.out.println("HotOrNotRating:" + nonOwnerProxy.getHotOrNotRating());

    }
}
