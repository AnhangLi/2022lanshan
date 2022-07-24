package com.linkedlist;

import org.junit.Test;

public class Test2 {

    /**
     * 插入
     */
    @Test
    public void add(){
        DemoNode<String> node=new DemoNode<>();
        node.add("aaa");
        node.add("bbb");
        node.add("ccc");
        node.add("ddd");
        System.out.println(node.size());
    }

    /**
     * 遍历
     */
    @Test
    public void printAll(){
        DemoNode<String> node=new DemoNode<>();
        node.add("aaa");
        node.add("bbb");
        node.add("ccc");
        node.add("ddd");
        DemoNode<String>.Iterator iterator = node.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 查找
     */
    @Test
    public void find(){
        DemoNode<String> node=new DemoNode<>();
        node.add("aaa");
        node.add("bbb");
        node.add("ccc");
        node.add("ddd");
        System.out.println(node.get(2));
    }

    /**
     * 删除
     */
    @Test
    public void remove(){
        DemoNode<String> node=new DemoNode<>();
        node.add("aaa");
        node.add("bbb");
        node.add("ccc");
        node.add("ddd");
        node.remove("ddd");
        //node.remove("aaaaa");//测试删除的不存在节点
        DemoNode<String>.Iterator iterator = node.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 翻转
     */
    @Test
    public void reverser(){
        DemoNode<String> node=new DemoNode<>();
        node.add("aaa");
        node.add("bbb");
        node.add("ccc");
        node.add("ddd");
        System.out.println(node.reverser(node));
    }

}
