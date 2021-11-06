class Solution {
public:
    int minMutation(string start, string end, vector<string>& bank) {
        queue<string> queue;
        queue.push(start);
        
        unordered_set<string> set;
        set.insert(start);
        int steps = 0;
        
        while (!queue.empty()) {
            int size = queue.size();
            while (size-- > 0) {
                string gene = std::move(queue.front());
                queue.pop();
                if (gene == end) return steps;
                for (const auto& str : bank) {
                    if (set.count(str) || !ValidMutation(gene, str)) continue;
                    queue.push(str);
                    set.insert(gene);
                }
                
            }
            ++steps;
        }
        
        return -1;
    }
    
private:
    bool ValidMutation(const string& s1, const string& s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i)
            if (s1[i] != s2[i] && count++) return false;
        return true;
    }
};