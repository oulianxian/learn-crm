package com.kukuou.array.protocol;

import java.util.List;

/**
 * Produce
 *
 * @author olx
 * @date 2018/10/30/030
 */
public class Produce<E> {
    private int age;
    public Produce(int age) {
        this.age = age;
    }
    public Produce() {
    }
    public void add(int num){
        age++;
    }

    public void  product(List<? extends E> list){  //使用List<? extends E> list 来代替 list<E>  使得传入的对象可以是其子类
     for (E e : list) {
         System.out.println("我們能卖第一种"+list.get(0));
     }
 }

}
