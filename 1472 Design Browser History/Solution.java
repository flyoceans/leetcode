class BrowserHistory {

    Node curNode;

    public BrowserHistory(String homepage) {
        this.curNode = new Node(homepage);
    }
    
    public void visit(String url) {
        Node v = new Node(url);
        curNode.next = v;
        v.prev = curNode;
        curNode = v;
    }
    
    public String back(int steps) {
        while (curNode.prev != null) {
            curNode = curNode.prev;
            steps--;
            if (steps == 0) break;
        }
        return curNode.url;
    }
    
    public String forward(int steps) {
        while (curNode.next != null) {
            curNode = curNode.next;
            steps--;
            if (steps == 0) break;
        }
        return curNode.url;
    }


    class Node {
        String url;
        Node next;
        Node prev;
        public Node(String url) {
            this.url = url;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */