class Solution {
    // construct a directed graph using list
    // dfs queries
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<String, Double>());
            graph.putIfAbsent(b, new HashMap<String, Double>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }
        
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>(), 1.0);
        }
        return result;
    }
    
    
    private double dfs(String a, String b, Map<String, Map<String, Double>> graph, Set<String> set, double val) {
        if (set.contains(a)) return -1.0;
        if (!graph.containsKey(a)) return -1.0;
        if (a.equals(b)) return 1.0;
        set.add(a);
        for (String n : graph.get(a).keySet()) {
            double d = dfs(n, b, graph, set, val * graph.get(a).get(n));
            if (d > 0) return d * graph.get(a).get(n);
        }

        set.remove(a);
        return -1.0;
    }
}