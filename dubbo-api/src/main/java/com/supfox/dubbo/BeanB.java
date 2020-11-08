package com.supfox.dubbo;

import java.io.Serializable;

public class BeanB implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private BeanA beanA;

    public BeanA getBeanA() {
        return beanA;
    }

//    @Override
//    public String toString() {
//        return "BeanB{" +
//                "name='" + name + '\'' +
//                ", beanA=" + beanA +
//                '}';
//    }

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }
}
