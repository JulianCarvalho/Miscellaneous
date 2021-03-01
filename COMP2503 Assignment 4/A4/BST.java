import java.util.Iterator;
import java.lang.*;
public class BST<T extends Comparable<T>> 
{
    class BSTNode implements Comparable<BSTNode>
    {
        private T data;
        private int freq;
        private BSTNode left; 
        private BSTNode right; 

        public BSTNode( T d) 
        {
            setLeft( null);
            setRight( null);
            setData( d);
            setInitialFreq();
        }

        public T getData() { return data; }

        public void setData( T d) { data = d; }

        public void setLeft( BSTNode l) { left = l;}

        public void setRight( BSTNode r) { right = r;}

        public BSTNode getLeft()  { return left;}

        public BSTNode getRight()  { return right;}

        //added these methods for the frequency

        public void setInitialFreq() {freq = 1;}

        public int getFreq() {return freq;}

        public void incFreq() {freq++;}

        public boolean isLeaf() 
        { 
            return ( getLeft() == null) && ( getRight() == null);
        }

        public int compareTo( BSTNode o) 
        {
            return this.getData().compareTo( o.getData());
        }

    }

    // The different traversal types. 
    public static final int INORDER = 0;
    public static final int PREORDER = 1;
    public static final int POSTORDER = 2;
    public static final int LEVELORDER = 3;
    public static final int INORDERRETURN = 4;
    public static final int INORDERPRINT = 5;
    public static final int INORDERREVERSE = 6;

    private BSTNode root;
    private BSTNode temp;
    private SLL<String> stopSLL = new SLL<String>();
    private int size;
    private int stopwordcount;
    private int totalwordcount;
    private int avglength;
    private int maxlength;

    public BST()
    {
        root = null;
        size = 0;
        totalwordcount = 0;
        stopwordcount = 0;
        avglength = 0;
        maxlength = 0;
    }

    /** Return true if element d is present in the tree. 
     */
    public T find( T d) 
    {
        return find( d, root); 
    }

    /** Return the height of the tree. 
     */
    public int height() 
    {
        return height(root);
    }
    
    public int optimalHeight()
    {
        double opt = Math.log(size) / Math.log(2);
        return (int)opt;
    }

    /** Return the number of nodes in the tree. 
     */
    public int size() { 
        return size;
    }

    //methods to return variables for printing
    public int totalWord(){return totalwordcount;}
    public int stopWord(){return stopwordcount;}
    public int avgLen(){return avglength;}
    public int maxLen(){return maxlength;}

    
    public void inOrder() 
    {
        traverse( root, INORDER);
    }

    public void postOrder() 
    {
        traverse( root, POSTORDER);
    }

    public void preOrder() 
    {
        traverse( root, PREORDER);
    }

    public void levelOrder() 
    {
        traverse( root, LEVELORDER);
    }

    // inorder method variants that I created for various purposes
    // i used the first one to help populate the stop words tree
    public BSTNode inOrderReturn() {BSTNode r = traverseReturn(root, INORDERRETURN);return r;}
    // the second one was so I could the trees in order
    public void inOrderPrint(){traverse( root, INORDERPRINT);}
    // the third one was so I could print in reverse of inorder (20 least frequent)
    public void inOrderReverse(){traverse( root, INORDERREVERSE);}

    public void deleteStops(BST bst)
    {
        temp = bst.inOrderReturn();
        do
        {
            deleteNode(temp);
        }
        while(temp != null);
    }

    // method used to load the trees with previously made nodes
    public void loadBST(BST bst, int check)
    {
        // check is used to determine which add method they get, i also didnt want to rewrite this method
        temp = bst.inOrderReturn();
        do
        {
            if(temp.getFreq() > 0)
            {
                // the check is just an int sent in by A4 to determine which type of add to use
                if(check == 0)
                {
                    addByFreq(temp);
                }
                else
                {
                    // this if was used to sum up the length of each word
                    if(temp.getData().toString().length() >  maxlength)
                    {
                        maxlength = temp.getData().toString().length();
                    }
                    addByLength(temp);
                }
            }
        }
        while(temp != null);
        // this last if was added for the average length
        if(check == 1){avglength = avglength/size;}
    }

    /* Private methods. */
    private void deleteNode(BSTNode n)
    {
        root = deleteNode(root, n);
    }

    private BSTNode deleteNode(BSTNode r, BSTNode n)
    {
        // this first if statement is for if the bst is empty, returns null
        if(root == null) 
        {
            return root;
        }
        //setting up an int so I can check the compareTo results
        int c = n.compareTo( r);
        // if n is less than r then we go left down the tree with recursion
        if(c < 0)
        {
            deleteNode(r.getLeft(), n);
        }
        // if n is greater than r then we go right down the tree with recursion
        else if(c > 0)
        {
            deleteNode(r.getRight(), n);
        }
        // else it's the node we need to delete
        else
        {
            //these lines are to keep track of the stop word count anf the total word count
            stopwordcount++;

            //this if else block is used when the there is only one child or its a leaf
            if(r.getLeft() == null)
            {
                return r.getRight();
            }
            else if(r.getRight() == null)
            {
                return r.getLeft();
            }

            //other wise the node to be deleted has 2 children
            // now we have to get the inorder
            r = inOrderOne(r.getRight());

            r.setRight(deleteNode(r.getRight(), r));
        }
        return root;
    }

    private BSTNode inOrderOne(BSTNode r)
    {
        temp = r;
        while(r.getLeft() != null)
        {
            temp = r.getLeft();
            r = r.getLeft();
        }
        return temp;
    }

    //this was implemented in the lab
    private T find( T d, BSTNode r) 
    {
        if ( r == null) 
            return null;
        int c = d.compareTo( r.getData()); 
        if ( c == 0) 
            return r.getData();
        else if ( c < 0) 
            return find( d, r.getLeft());
        else 
            return find( d, r.getRight());
    } 

    /* Add element d to the tree. */
    public void add( T d) 
    {
        BSTNode n = new BSTNode( d); 
        if ( root == null) {size++; root = n;}
        else {add( root, n); }
    }

    private void addByFreq(BSTNode n)
    {
        if ( root == null) {size++; root = n;}
        else {addByFreq( root, n); }
    }

    private void addByLength(BSTNode n)
    {
        if ( root == null) {size++; root = n;}
        else {addByLength( root, n); avglength += n.getData().toString().length();}
    }

    /* Do the actual add of node r to tree rooted at n */
    //this was implemented in the lab
    private void add( BSTNode r, BSTNode n) 
    {
        int c = n.compareTo( r);
        if ( c < 0) //if n less than  r
        {
            if(r.getLeft() == null){r.setLeft(n);size++;}
            else{add(r.getLeft(), n);}
        }
        else if(c > 0)//if n greater than r (allows duplicate enteries)
        {
            if(r.getRight() == null){r.setRight(n);size++;}
            else{add(r.getRight(), n);}
        }
        else {r.incFreq();}
    }

    // I copied most of the add method but I modified it so it compares the frequency
    private void addByFreq(BSTNode r, BSTNode n)
    {
        // if n's frequency is less than r's 
        if(n.getFreq() < r.getFreq())
        {
            // it checks if the left node is empty, is so it gets set there
            if(r.getLeft() == null){r.setLeft(n);size++;}
            // else, recursion down the tree
            else{addByFreq(r.getLeft(), n);}
        }
        // if n's frequency is greater than r's 
        else if (n.getFreq() > r.getFreq())
        {
            // it checks if the right node is empty, is so it gets set there
            if(r.getRight() == null){r.setRight(n);size++;}
            // else, recursion down the tree
            else{addByFreq(r.getRight(), n);}
        }
        // if the frequencies sre equal
        else
        {
            //this was copied from the regular add method
            //it just recurses back onto itself rather than the plain add method
            int c = n.compareTo( r);
            if ( c < 0) //if n less than  r
            {
                if(r.getLeft() == null){r.setLeft(n);size++;}
                else{addByFreq(r.getLeft(), n);}
            }
            else //else n greater than r (allows duplicate enteries)
            {
                if(r.getRight() == null){r.setRight(n);size++;}
                else{addByFreq(r.getRight(), n);}
            }
        }
    }

    private void addByLength(BSTNode r, BSTNode n)
    {
        int rLen = r.getData().toString().length();
        int nLen = n.getData().toString().length();
        // if n's frequency is less than r's 
        if(nLen < rLen)
        {
            // it checks if the left node is empty, is so it gets set there
            if(r.getLeft() == null){r.setLeft(n);size++;}
            // else, recursion down the tree
            else{addByLength(r.getLeft(), n);}
        }
        // if n's frequency is greater than r's 
        else if (nLen > rLen)
        {
            // it checks if the right node is empty, is so it gets set there
            if(r.getRight() == null){r.setRight(n);size++;}
            // else, recursion down the tree
            else{addByLength(r.getRight(), n);}
        }
        // if the frequencies sre equal
        else
        {
            //this was copied from the regular add method
            //it just recurses back onto itself rather than the plain add method
            int c = n.compareTo( r);
            if ( c < 0) //if n less than  r
            {
                if(r.getLeft() == null){r.setLeft(n);size++;}
                else{addByLength(r.getLeft(), n);}
            }
            else //else n greater than r (allows duplicate enteries)
            {
                if(r.getRight() == null){r.setRight(n);size++;}
                else{addByLength(r.getRight(), n);}
            }
        }
    }

    /* Implement a height method. */
    //this was implemented in the lab
    private int height( BSTNode r) 
    {
        int h = 0;
        if (r != null)
        {
            int rh = height(r.getRight());
            int lh = height(r.getLeft());
            h =(rh > lh ? 1+ rh : 1 +lh);
        }
        return h;
    } 

    /* Traverse the tree.  travtype determines the type of traversal to perform. */
    //this was implemented in the lab
    private void traverse( BSTNode r, int travType) 
    {
        if ( r != null) 
        {
            switch ( travType) 
            {
                case INORDER: 
                traverse(r.getLeft(), travType);visit(r);
                traverse(r.getRight(), travType);break;

                case PREORDER: 
                visit(r);traverse(r.getLeft(), travType);
                traverse(r.getRight(), travType);break;

                case POSTORDER: 
                traverse(r.getLeft(), travType);
                traverse(r.getRight(), travType);
                visit(r);break;

                case LEVELORDER: levelOrder( r);break;

                case INORDERPRINT:
                traverse(r.getLeft(), travType);visitPrint(r);
                traverse(r.getRight(), travType);break;

                case INORDERREVERSE:
                traverse(r.getRight(), travType);visitPrint(r);
                traverse(r.getLeft(), travType);break;
            }
        }
    }
    //this was implemented in the lab
    private void visit( BSTNode r) 
    {if ( r != null) System.out.println( r.getData());}
    // traverse the subtree r using level order. */
    //this was implemented in the lab
    private void levelOrder( BSTNode r) 
    {BSTNode currNode = r;Queue<BSTNode> q = new Queue<BSTNode>();}

    private void visitPrint(BSTNode r)
    { 
        if ( r != null) 
            System.out.println(r.getData() + " : " + r.getData().toString().length() + " : " + r.getFreq());
    }

    //these next two methods were added
    //these methods are almost the exact same as the methods above
    // but they are being used for the deletion
    private BSTNode traverseReturn( BSTNode r, int travType)
    {
        if ( r != null) 
        {
            switch ( travType) 
            {
                case INORDERRETURN: 
                traverse(r.getLeft(), travType);
                visitReturn(r);
                traverse(r.getRight(), travType);
                break;
            }
        }
        return r;
    }

    private BSTNode visitReturn(BSTNode r){return r;}
}
