package com.csus.csc133;

//New Class is a list of the objects

public class GameObjectCollection {
    private Node head;

    class Node {
        GameObject data;
        Node next;
    }

    public void add(GameObject obj) {
        Node node = new Node();
        node.data = obj;

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private Node current;

        public Iterator() {
            this.current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public GameObject getNext() {
            if (hasNext()) {
                GameObject data = current.data;
                current = current.next;
                return data;
            }
            return null;
        }

		public void reset() {
			this.current = head;
			
		}
    }
}
