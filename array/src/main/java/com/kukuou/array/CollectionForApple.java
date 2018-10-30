package com.kukuou.array;


import com.kukuou.array.protocol.AppleProtocol;
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author olx
 * @date 2018/10/30/030
 */
public class CollectionForApple {

    public static void main(String[] args) {
        // arrayList 四种初始化方法
        //1没有任何定义，默认长度是10
        ArrayList<AppleProtocol> objects = new ArrayList<>();//对应public ArrayList(){}

        //2定义默认长度是10
        ArrayList<Object> objects1 = new ArrayList<>(10);// public ArrayList(int initialCapacity) {}

        //2定义默认长度是10   Arrays.asList 把数组转换成集合
        List intlist = Arrays.asList(new AppleProtocol("1", "1"),new AppleProtocol("1", "1"));
        ArrayList<Object> obj = new ArrayList<Object>(intlist);


        //3 匿名内部类
        ArrayList<Object> dd = new ArrayList<Object>() {{
            add(new String());
            add(new String());
        }};


        //循环
        //修改使用foreach（），删除使用iterator（）

        // 第一种，通过迭代器遍历。即通过Iterator去遍历。
        Iterator<Object> iterator = dd.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // 第二种，随机访问，通过索引值去遍历。由于ArrayList实现了RandomAccess接口，它支持通过索引值去随机访问元素。

        int size = dd.size();
        for (int i=0; i<size; i++) {
            System.out.println(  dd.get(i));
        }

        //第三种，for循环遍历。
        for (Object protocol : dd) {
            System.out.println();

        }

        //注意：遍历ArrayList时，使用随机访问(即，通过索引序号访问)效率最高，而使用迭代器的效率最低！


        // toArray()异常 java对象转换不支持对象转型


        ArrayList newList = new ArrayList();

  //（指定位置）新增，移除，长度，更改
        newList.add("1");
        newList.add("2");
        newList.add("3");
        newList.add("4");

        newList.add(0, "5");   // 将下面的元素添加到第1个位置

        // 获取第1个元素
        System.out.println("the first element is: " + newList.get(0));
        // 删除“3”
        newList.remove("3");
        // 获取ArrayList的大小
        System.out.println("Arraylist size=: " + newList.size());
        // 判断list中是否包含"3"
        System.out.println("ArrayList contains 3 is: " + newList.contains(3));
        // 设置第2个元素为10
        newList.set(1, "10");

        // 通过Iterator遍历ArrayList
        for (Iterator iter = newList.iterator(); iter.hasNext(); ) {
            System.out.println("next is: " + iter.next());
        }

        // 将ArrayList转换为数组
        String[] arr = (String[]) newList.toArray(new String[0]);
        for (String str : arr){
            System.out.println("str: " + str);
        }


        // 清空ArrayList
        newList.clear();
        // 判断ArrayList是否为空
        System.out.println("ArrayList is empty: " + newList.isEmpty());

    }

}
