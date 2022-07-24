package com.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoNode<T> {

    private class Node<T> {
        private T data;
        private Node<T> next; // 指向下一个结点的引用
        private Node<T> prev; // 指向前一个结点的引用

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head; // 头结点
    private Node<T> last; // 尾部节点
    private Node<T> other; // 临时结点
    private int length;

    public DemoNode() {
        head = new Node<T>(null);
        head.prev = null;
        last = head;
        last.next = null;
        length = 0;
    }

    public DemoNode(T data) {
        head = new Node<T>(data);
        head.prev = null;
        last = head;
        last.next = null;
        length = 0;
    }

    /**
     * 链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * 普通添加，往链表尾部添加
     *
     * @param data
     */
    public void add(T data) {
        if (isEmpty()) { // 链表为空，新创建一个链表
            head = new Node<T>(data);
            last = head;
            length++;
        } else {
            other = new Node<T>(data);
            other.prev = last;
            last.next = other; // 将新的节点与原来的尾部节点进行结构上的关联
            last = other; // other将成为最后一个节点
            length++;
        }
    }

    /**
     * 在选定的元素后添加新元素
     *
     * @param data       选定元素
     * @param insertData 新添加元素
     */
    public void add(T data, T insertData) {
        if (isEmpty()) {
            throw new RuntimeException("链表无结点");
        }
        //other先等于头结点，再一步一步遍历
        other = head;
        //other遍历链表，找有没有选定的data
        while (other != null) {
            if (other.data.equals(data)) {
                Node<T> insertNode = new Node<>(insertData);
                //如果other==尾结点
                if (other == last) {
                    insertNode.prev = other;
                    other.next = insertNode;
                    last = insertNode;
                } else {
                    insertNode.prev = other;
                    insertNode.next = other.next;
                    other.next.prev = insertNode;
                    other.next = insertNode;
                }
                length++;
            }
            //other指向下一个结点
            other = other.next;
        }
    }

    /**
     * 删除指定的数据
     *
     * @param data
     */
    public void remove(T data) {
        boolean flag = false;
        //other先等于头结点，再一步一步遍历
        other = head;
        while (other != null) {
            //3种情况：other删头结点，other删尾结点，other删中间结点
            if (other.data.equals(data)) {
                flag = true;
                if (other == head) {
                    head = other.next;
                    head.prev = null;
                    length--;
                } else if (other == last) {
                    last = last.prev;
                    last.next = null;
                    length--;
                } else {
                    other.prev.next = other.next;
                    other.next.prev = other.prev;
                    length--;
                }

            }
            other = other.next;
        }
        if (!flag) {
            throw new IllegalArgumentException("删除的节点不存在");
        }

    }

    //翻转
    public List reverser(DemoNode node) {
        DemoNode<String>.Iterator iterator = node.iterator();
        List<Object> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        Collections.reverse(list);
        return list;
    }

    //获取值
    public T get(int index) {
        Node<T> node = nodeOf(index);
        return node.data;
    }

    public Node<T> nodeOf(int index) {
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("下标越界:" + index);
        }
        Node<T> node = head;
        int count = 0;
        while (count < index) {
            node = node.next;
            count++;
        }
        return node;
    }


    public int size() {
        return length;
    }

    //遍历链表
    public Iterator iterator() {
        return new Iterator();
    }

    public class Iterator {
        private int length;
        private Node<T> node = head;

        public boolean hasNext() {
            if (node == null) {
                return false;
            } else {
                return true;
            }
        }

        public T next() {
            T data = node.data;
            node = node.next;
            return data;
        }


    }

}
