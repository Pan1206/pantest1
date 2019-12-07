package com.pan.al.line;

/**
 * 单向链表节点
 */
public class ListNode {
    private Object data;
    private ListNode next;

    public ListNode(int data)
    {
      this.data=data;
    }

    public Object getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
