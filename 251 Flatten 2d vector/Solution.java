public class Vector2D implements Iterator<Integer> {
    
    int pos;
    int total;
    List<Iterator<Integer>> list;
    
    public Vector2D(List<List<Integer>> vec2d) {
        list = new ArrayList<>();
        pos = 0;
        total = vec2d.size();
        for (List<Integer> l : vec2d) {
            Iterator<Integer> itr = l.iterator();
            list.add(itr);
        }
    }

    @Override
    public Integer next() {
        return list.get(pos).next();
    }

    @Override
    public boolean hasNext() {
        if (pos == total)
            return false;
        if (list.get(pos).hasNext()) {
            return true;
        } else {
            pos++;
            return hasNext();
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */