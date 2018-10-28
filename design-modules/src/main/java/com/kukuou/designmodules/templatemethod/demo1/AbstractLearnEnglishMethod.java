package com.kukuou.designmodules.templatemethod.demo1;

/**
 * 学习英语方法
 * @author olx
 * @date 2018/10/28/028
 */
public abstract class AbstractLearnEnglishMethod {
    /**
     * 了解获悉学生使用的书本
     */
    abstract String getStudentBook();

    public void learnEnglish(){
        System.out.println("打开" + getStudentBook() + "课本");
    }

}
