class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        Point l1 = new Point(A, B);
        Point r1 = new Point(C, D);
        Point l2 = new Point(E, F);
        Point r2 = new Point(G, H);
        if (A > E) {
            Point tmp = l1;
            l1 = l2;
            l2 = tmp;
            Point t = r1;
            r1 = r2;
            r2 = t;
        }
        
        int s1 = (r1.x - l1.x)*(r1.y - l1.y);
        int s2 = (r2.x - l2.x)*(r2.y - l2.y);
        // overlap
        if (r1.x <= l2.x || r1.y <= l2.y || l1.y >= r2.y)
            return s1 + s2;
        else {
            Point p1 = new Point(Math.max(l1.x, l2.x), Math.max(l1.y, l2.y));
            Point p2 = new Point(Math.min(r1.x, r2.x), Math.min(r1.y, r2.y));
            return s1 + s2 - (p2.x - p1.x)*(p2.y - p1.y);
        }
    }
    
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}