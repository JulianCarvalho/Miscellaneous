public class Node<T extends Comparable<T>>
{
    private T data;
    private Node<T> next = null;
    
    public Node() 
    { 
    }
    
    public Node(T data) 
    { 
        this.data=data; 
    }
    
    public T getData() 
    { return data; 
    }
        
    public void setData(T value) 
    { 
        data = value; 
    }
           
    public void setNext(Node<T> other)
    { 
        next = other; 
    }
    
    public Node<T> getNext() 
    { 
        return next; 
    }
}