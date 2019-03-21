class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null && words2 == null) return true;
        if (words1 == null || words2 == null) return false;
        if (words1.length != words2.length) return false;
        
        UF uf = new UF();
        for (int i = 0; i < pairs.length; i++) {
            int index1 = pairs[i][0].hashCode();
            int index2 = pairs[i][1].hashCode();
            uf.union(index1, index2);
        }
        // System.out.println(uf.map);
        
        for (int i = 0; i < words1.length; i++) {
            int index1 = words1[i].hashCode();
            int index2 = words2[i].hashCode();
            if (index1 == index2) continue;
            if (!uf.isConnected(index1, index2)) {
                return false;
            }
        }
        return true;
    }
    
    class UF {
        Map<Integer, Integer> map;
        
        public UF() {
            map = new HashMap();
        }
        
        public void union(int s1, int s2) {
            int p1 = find(s1);
            int p2 = find(s2);
            if (p1 != p2) 
            map.put(p1, p2);
        }
        
        public boolean isConnected(int s1, int s2) {
            int p1 = find(s1);
            int p2 = find(s2);
            if (p1 == p2) return true;
            return false;
        }
        
        public int find(int index) {
            // int index = s.hashCode();
            map.putIfAbsent(index, index);
            if (map.get(index) != index) {
                map.put(index, find(map.get(index)));
            }
            return map.get(index);
        }
        
    }
    
    
}