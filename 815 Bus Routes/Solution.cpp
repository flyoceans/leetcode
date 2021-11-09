class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        if (source == target) return 0;
        
        unordered_map<int, vector<int>> map;
        for (int i = 0; i < routes.size(); ++i)
            for (int stop : routes[i])
                map[stop].push_back(i);
        
        set<int> visited;
        queue<int> q;
        q.push(source);
        int steps = 0;
        
        while (!q.empty()) {
            int size = q.size();
            
            while (size-- > 0) {
                int cur = std::move(q.front());
                if (cur == target) return steps;
                q.pop();
                for (int bus : map[cur]) {
                    if (!visited.count(bus)) {
                        visited.insert(bus);
                        for (int stop : routes[bus]) {
                            q.push(stop);
                        }
                    }
                }
            }
            ++steps;
        }
        return -1;
    }
};