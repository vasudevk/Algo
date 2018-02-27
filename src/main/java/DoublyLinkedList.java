/**
 * Created by amit.k.mannur on 9/1/2017.
 */

import java.util.Scanner;

/*  Class LinkedList.Node  */
class DoublyNode {
    protected int data;
    protected DoublyNode next, prev;

    /* Constructor */
    public DoublyNode() {
        next = null;
        prev = null;
        data = 0;
    }

    /* Constructor */
    public DoublyNode(int d, DoublyNode n, DoublyNode p) {
        data = d;
        next = n;
        prev = p;
    }

    /* Function to set link to next node */
    public void setLinkNext(DoublyNode n) {
        next = n;
    }

    /* Function to set link to previous node */
    public void setLinkPrev(DoublyNode p) {
        prev = p;
    }

    /* Funtion to get link to next node */
    public DoublyNode getLinkNext() {
        return next;
    }

    /* Function to get link to previous node */
    public DoublyNode getLinkPrev() {
        return prev;
    }

    /* Function to set data to node */
    public void setData(int d) {
        data = d;
    }

    /* Function to get data from node */
    public int getData() {
        return data;
    }
}

/* Class linkedList */
class linkedList {
    protected DoublyNode start;
    protected DoublyNode end;
    public int size;

    /* Constructor */
    public linkedList() {
        start = null;
        end = null;
        size = 0;
    }

    /* Function to check if list is empty */
    public boolean isEmpty() {
        return start == null;
    }

    /* Function to get size of list */
    public int getSize() {
        return size;
    }

    /* Function to insert element at begining */
    public void insertAtStart(int val) {
        DoublyNode nptr = new DoublyNode(val, null, null);
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            start.setLinkPrev(nptr);
            nptr.setLinkNext(start);
            start = nptr;
        }
        size++;
    }

    /* Function to insert element at end */
    public void insertAtEnd(int val) {
        DoublyNode nptr = new DoublyNode(val, null, null);
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            nptr.setLinkPrev(end);
            end.setLinkNext(nptr);
            end = nptr;
        }
        size++;
    }

    /* Function to insert element at position */
    public void insertAtPos(int val, int pos) {
        DoublyNode nptr = new DoublyNode(val, null, null);
        if (pos == 1) {
            insertAtStart(val);
            return;
        }
        DoublyNode ptr = start;
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                DoublyNode tmp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrev(ptr);
                nptr.setLinkNext(tmp);
                tmp.setLinkPrev(nptr);
            }
            ptr = ptr.getLinkNext();
        }
        size++;
    }

    /* Function to delete node at position */
    public void deleteAtPos(int pos) {
        if (pos == 1) {
            if (size == 1) {
                start = null;
                end = null;
                size = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(null);
            size--;
            return;
        }
        if (pos == size) {
            end = end.getLinkPrev();
            end.setLinkNext(null);
            size--;
        }
        DoublyNode ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                DoublyNode p = ptr.getLinkPrev();
                DoublyNode n = ptr.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                size--;
                return;
            }
            ptr = ptr.getLinkNext();
        }
    }

    /* Function to display status of list */
    public void display() {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (start.getLinkNext() == null) {
            System.out.println(start.getData());
            return;
        }
        DoublyNode ptr = start;
        System.out.print(start.getData() + " <-> ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null) {
            System.out.print(ptr.getData() + " <-> ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData() + "\n");
    }
}

/* Class DoublyLinkedList */
public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of linkedList */
        linkedList list = new linkedList();
        System.out.println("Doubly Linked List Test\n");
        char ch;
        /*  Perform list operations  */
        do {
            System.out.println("\nDoubly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    list.insertAtStart(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to insert");
                    list.insertAtEnd(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Enter integer element to insert");
                    int num = scan.nextInt();
                    System.out.println("Enter position");
                    int pos = scan.nextInt();
                    if (pos < 1 || pos > list.getSize())
                        System.out.println("Invalid position\n");
                    else
                        list.insertAtPos(num, pos);
                    break;
                case 4:
                    System.out.println("Enter position");
                    int p = scan.nextInt();
                    if (p < 1 || p > list.getSize())
                        System.out.println("Invalid position\n");
                    else
                        list.deleteAtPos(p);
                    break;
                case 5:
                    System.out.println("Empty status = " + list.isEmpty());
                    break;
                case 6:
                    System.out.println("Size = " + list.getSize() + " \n");
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /*  Display List  */
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }
}
