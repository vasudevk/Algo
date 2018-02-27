package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.k.mannur on 9/1/2017.
 */


public class LinkedListMain {

    public static void main(String args[])
    {
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        SinglyLinkedList myLinkedlist = new SinglyLinkedList();
      /*  myLinkedlist.insertFirst(5);
        myLinkedlist.insertFirst(6);
        myLinkedlist.insertFirst(7);
        myLinkedlist.insertFirst(1);
        myLinkedlist.insertLast(2);*/

      myLinkedlist.insertFirst(1);
      myLinkedlist.insertLast(2);
      myLinkedlist.insertLast(3);
        // Linked list will be
        // 1 ->  7 -> 6 -> 5 -> 2
     /*   Node node=new Node();
        node.data=1;

        myLinkedlist.deleteAfter(node);
        // After deleting node after 1,Linked list will be
        // 2 -> 1 -> 6 -> 5*/
        myLinkedlist.printLinkedList();
    }
}
