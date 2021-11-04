class Solution {
    // map: email -> Name
    // union find email
    // traversal all accounts, get the root name as key 
    // map<Name, List<email>>
    // O(n)
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        
        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                emailToName.putIfAbsent(list.get(i), name);
                parents.putIfAbsent(list.get(i), list.get(i));
                union(parents, list.get(1), list.get(i));
            }
        }
        
        Map<String, Set<String>> res = new HashMap<>();
        for (String str : parents.keySet()) {
            String root = find(parents, str);
            res.putIfAbsent(root, new HashSet<>());
            res.get(root).add(str);
        }
        
        List<List<String>> resList = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : res.entrySet()) {
            List<String> tmp = new LinkedList<>(entry.getValue());
            Collections.sort(tmp);
            tmp.add(0, emailToName.get(entry.getKey()));
            resList.add(tmp);
        }
        return resList;
    }
    
    void union(Map<String, String> parents, String a, String b) {
        String pa = find(parents, a);
        String pb = find(parents, b);
        if (!pa.equals(pb)) parents.put(pa, pb);
    }
    
    String find(Map<String, String> parents, String a) {
        if (parents.get(a) != a) {
            parents.put(a, find(parents, parents.get(a)));
        }
        return parents.get(a);
    }
}