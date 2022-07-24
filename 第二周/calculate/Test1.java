package com.calculate;

import org.junit.Test;

import java.math.BigDecimal;

public class Test1 {

    /**
     * 简单计算
     */
    @Test
    public void simpleCalculate() {
        String str = "(1+2*(3-5))*(2-1)";
        BigDecimal caculate = new Calculate().caculate(str);
        System.out.println(caculate);
    }

    /**
     * 浮点计算
     */
    @Test
    public void doubleCalculate() {
        String str = "(1.3+2.2*(3-5))*(2-1)";
        BigDecimal caculate = new Calculate().caculate(str);
        System.out.println(caculate);
    }

    /**
     * 错误表达式
     */
    @Test
    public void error() {
        String str = "(1.3+2.2*(3-5))*(2-1";
        BigDecimal caculate = new Calculate().caculate(str);
        System.out.println(caculate);
    }

    /**
     * 溢出测试
     */
    @Test
    public void overflow() {
        String str = "10/3"; //设置了精度为32，所以溢出也不会抛出异常
        BigDecimal caculate = new Calculate().caculate(str);
        System.out.println(caculate);
    }


}

