package linkedlist;

public class Node {
	long tc;
	String data;
	Node next;

	public Node() {
		tc = 0;
		next = null;
		data = null;
	}

	public Node(long tclLong, String d, Node n) {
		tc = tclLong;
		data = d;
		next = n;

	}

	public void setLink(Node n) {
		next = n;
	}

	public Node getLink() {
		return next;
	}

	public void setTc(long tcLong) {
		tc = tcLong;
	}

	public long getTc() {
		return tc;
	}

	public void setData(String d) {
		data = d;
	}

	public String getData() {
		return data;
	}
}
