package com.kukuou.designmodules.templatemethod.demo1;

/**
 * @author olx
 * @date 2018/10/28/028
 */
public class Start {
    public static void main(String[] args) {
        AbstractLearnEnglishMethod abstractLearnEnglishMethod = new StudentOne();
        abstractLearnEnglishMethod.learnEnglish();
    }
}
