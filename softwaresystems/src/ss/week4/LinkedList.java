package ss.week4;

public class LinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node first;

    //@ ensures \result.size == 0;
    public LinkedList () {
        size = 0;
        first = null;
    }

    public void add(int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index-1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }

    //@ ensures this.size == \old(size) - 1;
    public void remove(Element element) {
        Node prevNode = findBefore(element);
        Node nextNode;
        if (prevNode == null){
        	first = first.next;
        } else {
        	nextNode = prevNode.next.next;
        	prevNode.next = nextNode;
        }
        
        this.size--;
    }

    public Node findBefore(Element element) {
    	int i = 0;
    	Node result = null;
    	if (get(0) == element) {
    		result = null;
    	} else {
    		while (i < this.size()) {
    			result = getNode(i);
        		if (result.next.element == element) {
        			break;
        		}
        		i++;
    		}
    		
    		
    	}
    	return result;
    	
    }

    //@ requires 0 <= index && index < this.size();
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }
    
    public Node find(Element element) {
    	int i = 0;
    	Node result = getNode(i);
    	while (result.element != element && i < this.size()) {
    		i++;
    		result = getNode(i);
    	}
    	if (result.element != element) {
    		result = null;
    	}
    	return result;
    	
    }
    
    
    //@ requires 0 <= i && i < this.size();
    private /*@ pure @*/ Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    //@ ensures \result >= 0;
    public /*@ pure @*/ int size() {
        return size;
    }

    public class Node {
        private Element element;
        public Node next;

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }

        public Element getElement() {
            return element;
        }
    }
}
