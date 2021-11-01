class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPair.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuesPair.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }
        
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) result[i] = -1.0;
        }
        return result;

    }
    
    public double dfs(String q1, String q2, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> valuePairs, HashSet<String> set, double val) {
        if (set.contains(q1)) return 0.0;
        if (!pairs.containsKey(q1)) return 0.0;
        if (q1.equals(q2)) return val;
        set.add(q1);
        ArrayList<String> list = pairs.get(q1);
        double tmp = 0.0;
        for (int i = 0; i < list.size(); i++) {
            
            tmp = dfs(list.get(i), q2, pairs, valuePairs, set, val * valuePairs.get(q1).get(i));
            if (tmp != 0.0) break;
        }
        set.remove(q1);
        return tmp;
        
    }
}