package com.supfox.dubbo;

import java.io.Serializable;

public class BeanA implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private BeanB beanB;

    public BeanB getBeanB() {
        return beanB;
    }

    public void setBeanB(BeanB beanB) {
        this.beanB = beanB;
    }

//    @Override
//    public String toString() {
//        return "BeanA{" +
//                "name='" + name + '\'' +
//                ", beanB=" + beanB +
//                '}';
//    }
}
