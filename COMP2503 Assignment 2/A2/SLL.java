import java.util.*;
public class SLL<T extends Comparable<T>>
{
    private Node<T> head;
    private Word word;

    public SLL()
    {
        head = null;
    }

    public boolean isEmpty()
    { 
        return (head == null); 
    }

    public int size(){
        Node<T> curr = head;
        int length = 0;

        while(curr != null)
        {
            length++;
            curr = curr.getNext();
        }

        return length;
    }

    public void addHead(T data) 
    { 
        Node<T> nodeToAdd = new Node(data); 
        if(isEmpty())
            head = nodeToAdd;
        else
        {
            nodeToAdd.setNext(head);
            head = nodeToAdd;
        }
    }

    public void addTail(T data) {
        //without the if and else you will get a null pointer 
        //expection when adding the first element.
        Node<T> nodeToAdd = new Node(data); 

        if(head != null)
        {
            Node<T> curr = head;

            while(curr.getNext() != null){
                curr = curr.getNext();
            }
            curr.setNext(nodeToAdd);
        }
        else
        {
            head = nodeToAdd;
        }
    }

    public void addToN (T data, int index){
        Node<T> nodeToAdd = new Node(data); 
        int length = size();
        Node<T> curr = head;

        if(isEmpty())
        { 
            head = nodeToAdd;
        }
        else if (index == 0)
        {
            addHead(data);
        }
        else if(index <= length && index >=0){
            curr = head;
            for (int count = 0; count < index - 1; count++)
            {
                curr = curr.getNext();
            }
        }

        nodeToAdd.setNext (curr.getNext());
        curr.setNext(nodeToAdd);  
    }

    public void addAlpha(T data)
    {
        Node<T> nodeToAdd = new Node(data); 
        Node<T> curr = head;
        int result;
        int count = 0;

        if(isEmpty())
        { 
            //if if list is empty
            head = nodeToAdd;
        }
        else 
        {
            while(curr.getData() != null)
            {
                result = curr.getData().compareTo(data);
                if(result > 0)
                {
                    addToN(data, count);
                }
                else if(result < 0 && result > curr.getNext().getData().compareTo(data))
                {
                    addToN(data, count +1);
                }
                count++;
            }
        }
    }

    public void printFull()
    {
        Node<T> curr = head;

        System.out.println("10 Most Frequent");
        while(curr != null)
        {
            System.out.println(curr.getData());
            curr = curr.getNext();
        }

    }

    public int countList()
    {
        Node<T> curr = head;
        int count = 0;
        
        while(curr.getData() != null)
        {
            count++;
        }
        
        return count;
    }
}