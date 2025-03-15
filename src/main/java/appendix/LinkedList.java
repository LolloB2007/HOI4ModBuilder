package appendix;

/**
 * @author lorenzobarbagelata
 * COMPLETE class with Node within (single file)
 * Working methods:
    setHead
    getHead
    addNodeAfterHead
    add --> adds after Node given as param
    add --> adds at end
    toString
    backwardsToString
    sum
    product
    size
    average
    equals
    getNext
    resetNext
    remove
    set
    get
    sort
    indexOf
    find
    toArray
    toLinkedList
    getNode
    contains
    isEmpty
 * @param <T>
 */
public class LinkedList<T> {
    
    /**
     * Java equivalent of Node
     */
    public class Node
    {
    
        private T data;
        private Node next;

        public Node(T data)
        {
            this.data = data;
            next = null;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public Node getNext()
        {
            return next;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }

        public String toString()
        {
            return "" + data;
        }
        
    }
    
    private Node head;
    private Node current = null;
    
    /**
     * Constructor
     */
    public LinkedList()
    {
        head = null;
    }
    
    /**
     * Constructor
     * @param head 
     */
    public LinkedList(Node head)
    {
        this.head = head;
    }
    
    /**
     * Sets head of the LinkedList
     * @param head 
     */
    public void setHead(Node head)
    {
        if(head==null)
        {
            this.head = head;
        }
        
        else
        {
            Node temp = head;
            head.setNext(this.head);
            this.head = temp;
        }
    }
    
    /**
     * Sets head of the LinkedList
     * @param data 
     */
    public void setHead(T data)
    {
        Node temp = new Node(data);
        
        if(head==null)
        {
            this.head = temp;
        }
        
        else
        {
            Node tempp = temp;
            temp.setNext(this.head);
            this.head = tempp;
        }
    }
    
    /**
     * Returns head
     * @return Node
     */
    public Node getHead()
    {
        return head;
    }
    
    /**
     * Adds a node after the head
     * @param data (T)
     */
    public void addNodeAfterHead(T data)
    {
        if(head==null){head=new Node(data);}
        
        else{
            Node temp = new Node(data);
            temp.setNext(head.getNext());
            head.setNext(temp);
        }
        
    }
    
    /**
     * Adds the node after the head
     * @param node (Node)
     */
    public void addNodeAfterHead(Node node)
    {
        if(head==null){head=node;}
        
        else{
            node.setNext(head.getNext());
            head.setNext(node);
        }
        
    }
    
    /**
     * Adds a node after the given Node
     * @param prev
     * @param data 
     */
    public void add(Node prev, T data)
    {
        if(head==null){head=new Node(data);}
        
        else
        {
            Node temp = new Node(data);
            temp.setNext(prev.getNext());
            prev.setNext(temp);
        }
    }
    
    /**
     * Adds a Node after the given index
     * @param prevv
     * @param data 
     */
    public void add(int prevv, T data)
    {
        if(prevv>=size()){System.out.println("Error: index out of bounds"); return;}
        
        Node prev = getNode(prevv);
        
        if(head==null){head=new Node(data);}
        
        else
        {
            Node temp = new Node(data);
            temp.setNext(prev.getNext());
            prev.setNext(temp);
        }
    }
    
    /**
     * Adds a node after the given node
     * @param prev
     * @param theNew 
     */
    public void add(Node prev, Node theNew)
    {
        if(head==null){head=theNew;}
        
        else
        {
            theNew.setNext(prev.getNext());
            prev.setNext(theNew);
        }
    }
    
    /**
     * Adds a node at the end
     * @param data 
     */
    public void add(T data)
    {
        if(head==null)
        {
            head = new Node(data);
            return;
        }
        
        Node temp = new Node(data);
        Node current = head;
        
        boolean notEnd = true;
        
        while(notEnd)
        {
            if(current.getNext()==null){notEnd=false;}
            
            else
            {
                current = current.getNext();
            }
        }
        
        current.setNext(temp);
        
    }
    
    /**
     * Adds a Node at the end
     * @param data 
     */
    public void add(Node data)
    {
        if(head==null)
        {
            head = data;
            return;
        }
        
        Node temp = data;
        Node current = head;
        
        boolean notEnd = true;
        
        while(notEnd)
        {
            if(current.getNext()==null){notEnd=false;}
            
            else
            {
                current = current.getNext();
            }
        }
        
        current.setNext(temp);
        
    }
    
    /**
     * Adds node before the given one
     * @param after
     * @param value 
     */
    public void addBefore(Node after, Node value)
    {
        if(head==null){head = value;}
        
        if(indexOf(after)==-1){System.out.println("Error: invalid position."); return;}
        
            int loc = indexOf(after);
            Node temp = getNode(loc-1);
            
            value.setNext(after);
            temp.setNext(value);
        
    }
    
    /**
     * Adds node before the given one
     * @param after
     * @param valu 
     */
    public void addBefore(Node after, T valu)
    {
        Node value = new Node(valu);
        
        if(head==null){head = value;}
        
        if(indexOf(after)==-1){System.out.println("Error: invalid position.");return;}

            int loc = indexOf(after);
            Node temp = getNode(loc-1);
            
            value.setNext(after);
            temp.setNext(value);

    }
    
    /**
     * Adds node before the given index
     * @param afte
     * @param value 
     */
    public void addBefore(int afte, Node value)
    {
        Node after = getNode(afte);
        
        if(head==null){head = value;}
        
        if(indexOf(after)==-1){System.out.println("Error: invalid position."); return;}
        
            int loc = indexOf(after);
            Node temp = getNode(loc-1);
            
            value.setNext(after);
            temp.setNext(value);
        
    }

    /**
     * toString method
     * @return \n String
     */
    public String toString()
    {
        if(head==null){return "Linked List is empty";}
        if(head.getNext()==null){return "" + head.getData();}
        
        Node temp = head;
        
        String answer = "" + temp.getData();
        
        while(temp.getNext() != null)
        {
            temp = temp.getNext();
            
            answer += "\n" + temp.getData();
        }
        
        return answer;
    }
    
    /**
     * backwardsToString method
     * @return \n String
     */
    public String backwardsToString()
    {
        if(head == null){return "Linked List is empty";}
        
        if(head.getNext()==null){return "" + head.getData();}
        
        return (backwardsToString(head.getNext())) + "\n" + head.getData();
    }
    
    private String backwardsToString(Node node) //aids backwards toString
    {
        if(node.getNext()==null){return "" + node.getData();}
        
        return (backwardsToString(node.getNext())) + " " + node.getData();
    }

    /**
     * Method that returns the size
     * @return int
     */
    public int size()
    {
        if(head==null){return 0;}
        
        if(head.getNext()==null){return 1;}
        
        return 1 + size(head.getNext());
    }
    
    private int size(Node node) //aids size w/ no param
    {
        if(node.getNext()==null){return 1;}
        
        return 1 + size(node.getNext());
    }
  
    /**
     * Returns whether a LinkedList is equals to another
     * @param other
     * @return boolean
     */
    public boolean equals(LinkedList other)
    {
        if(size()!=other.size()){return false;}
        
        if(head.getData()==other.getHead().getData() && equals(head.getNext(), other.getHead().getNext())){return true;}
        
        return false;
    }
    
    private boolean equals(Node theThis, Node theOther)//completes .equals
    {
        if(theThis.getData()==theOther.getData() && theThis.getNext()==null && theOther.getNext()==null)
        {
            return true;
        }
        
        if(theThis.getData()==theOther.getData() && equals(theThis.getNext(), theOther.getNext()))
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * Returns the next Node
     * @return Node
     */
    public Node getNext()
    {
        if(current == null){current = head; return current;}
        
        current = current.getNext();
        return current;
    }
    
    /**
     * Resets the next node pointer
     */
    public void resetNext()
    {
        current = null;
    }
    
    /**
     * Gets the data stored in the Node at index i
     * @param i
     * @return T
     */
    public T get(int i)
    {
        resetNext();
        
        Node temp = null;
        
        for(int j = -1; j<i; j++)
        {
            temp = getNext();
        }
        
        if(temp==null)
            return null;
        
        if(temp.getData()==null)
            return null;
        
        return temp.getData();
    }
    
    /**
     * Returns the node at index i
     * @param i
     * @return Node
     */
    public Node getNode(int i)
    {
        resetNext();
        
        Node temp = null;
        
        for(int j = -1; j<i; j++)
        {
            temp = getNext();
        }
        
        return temp;
    }
    
    /**
     * Removes the node at index i
     * @param i 
     */
    public void remove(int i)
    {
        if(i == 0)
        {
            head = getNode(1);
            return;
        }
        
        Node toRem = getNode(i);
        Node prev = getNode(i-1);
        Node after = getNode(i+1);
        
        prev.setNext(after);
    }
    
    /**
     * Sets the data of the node at position i equal to data
     * @param i
     * @param data 
     */
    public void set(int i, T data)
    {
        getNode(i).setData(data);
    }
   
    /**
     * Returns true if x is present, false if it's not
     * @param x
     * @return boolean
     */
    public boolean find(T x)
    {
        resetNext();
        
        Node current = head;
        boolean isFound = false;
        
        while(current.getNext()!=null && !isFound)
        {
            if(current.getData()==x)
            {
                isFound = true;
            }
            
            current = current.getNext();
        }
        
        return isFound;
    }
    
    /**
     * Returns the index of x or -1 if it's not present
     * @param x
     * @return int
     */
    public int indexOf(T x)
    {
        resetNext();
        
        Node current = head;
        boolean isFound = false;
        int i = 0;
        
        while(!isFound)
        {
            if(current.getData().equals(x))
            {
                isFound = true;
            }
            else
            {
                current = current.getNext();
                i++;
            }
            
            if(current == null)
            {
                break;
            }
        }
        
        if(!isFound)
        {
            return -1;
        }
        
        return i;
        
    }
    
    /**
     * Returns the index of the node or -1 if the node is not present
     * @param x
     * @return int
     */
    public int indexOf(Node x)
    {
        resetNext();
        
        Node current = head;
        boolean isFound = false;
        int i = -1;
        
        while(current.getNext()!=null && !isFound)
        {
            i++;
            if(current.getData()==x.getData())
            {
                isFound = true;
            }
            
            current = current.getNext();
        }
        
        if(!isFound)
        {
            return -1;
        }
        
        return i;
        
    }
    
    /**
     * Returns whether e is present in the LinkedList
     * @param e
     * @return boolean
     */
    public boolean contains(T e)
    {
        for(int i = 0; i<size(); i++)
        {
            T temp = get(i);
            
            if(temp.equals(e)){return true;}
        }
        
        return false;
    }
    
    /**
     * Returns whether the LinkedList is empty
     * @return boolean
     */
    public boolean isEmpty()
    {
        if(size()==0){return true;}
        else{
            return false;
        }
    }
    
    /**
     * Eliminates double elements in the LinkedList
     */
    public void eliminateDoubles() //dry-run tested
    {
        for(int i = 0; i<size()-1; i++)
        {
            for(int j = i+1; j<size(); j++)
            {
                if(get(i).equals(get(j)))
                {
                    remove(j);
                    j--;
                }
            }
        }
    }
    
    /**
     * Merges this LinkedList with another
     * @param temp 
     */
    public void merge(LinkedList<T> temp)
    {
        for(int i = 0; i<temp.size(); i++)
        {
            add(temp.get(i));
        }

    }
    
    /**
     * Adds the second LinkedList at the end of the first and returns the merged output as a single LinkedList
     * @param one
     * @param two
     * @return LinkedList
     */
    public static LinkedList merge(LinkedList one, LinkedList two)
    {
        for(int i = 0; i<two.size(); i++) {
            one.add(two.get(i));
        }
        
        return one;
    }
    
    /**
     * Returns the toString on the same line
     * @return " " String
     */
    public String inlineToString()
    {
        String ret = "";
        
        for(int i = 0; i<size()-1; i++)
        {
            ret += get(i) + " ";
        }
        
        ret += get(size()-1);
        
        return ret;
    }
    
}
