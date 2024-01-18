package ass4;

class node {
    node prev;
    int data;
    node next;


    node(int value)
    {


        prev = null;


        data = value;

        // By default next pointer is pointed
        // to NULL
        next = null;
    }
}
public class DLL {
    static node head = null;
    static node tail = null;

    public void insertAtBeginning(int data)
    {
        node temp = new node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        }
        else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public void insertAtEnd(int data)
    {
        node temp = new node(data);
        if (tail == null) {
            head = temp;
            tail = temp;
        }
        else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    public void insertAtPosition(int data, int position)
    {
        node temp = new node(data);
        if (position == 1) {
            insertAtBeginning(data);
        }
        else {
            node current = head;
            int currPosition = 1;
            while (current != null
                    && currPosition < position) {
                current = current.next;
                currPosition++;
            }
            if (current == null) {
                insertAtEnd(data);
            }
            else {
                temp.next = current;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = temp;
            }
        }
    }

    public void deleteAtBeginning()
    {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    public void deleteAtEnd()
    {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    public void deleteAtSpecificPosition(int pos)
    {
        if (head == null) {
            return;
        }

        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        node current = head;
        int count = 1;

        while (current != null && count != pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position wrong");
            return;
        }

        if (current == tail) {
            deleteAtEnd();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
    }

     void display()
    {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    void reverse()
    {
        node temp = null;
        node current = head;

        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        /* Before changing head, check for the cases like
         empty list and list with only one node */
        if (temp != null) {
            head = temp.prev;
        }}
    public void searchNode(int value) {
        int i = 1;
        boolean flag = false;
        //Node current will point to head
        node current = head;

        //Checks whether the list is empty
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        while(current != null) {
            //Compare value to be searched with each node in the list
            if(current.data == value) {
                flag = true;
                break;
            }
            current = current.next;
            i++;
        }
        if(flag)
            System.out.println("Node is present in the list at the position : " + i);
        else
            System.out.println("Node is not present in the list");
    }

    public static void main(String[] args) {
        DLL ll=new DLL();
        ll.insertAtBeginning(15);
        ll.insertAtPosition(45,2);
        ll.insertAtEnd(41);
        ll.display();
        ll.deleteAtBeginning();
        ll.display();
        ll.reverse();
        ll.display();
    }
}