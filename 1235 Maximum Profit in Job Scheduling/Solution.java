class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

// 定义状态：
// dp[i] 表示前 i 个工作（按 endTime 排序后）可以获得的最大利润

// 状态转移：
//  •   两种选择：
//  •   不选第 i 个工作：dp[i] = dp[i-1]
//  •   选第 i 个工作：找出最后一个在它开始之前结束的工作 j → dp[i] = dp[j] + profit[i]
//  •   j = binarySearch(endTime[j] <= startTime[i])
//  •   加上当前的 profit[i]
        
        int n = startTime.length;

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));

        // dp[i] = max profit till ith job
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int incl = jobs[i].profit;
            int l = binarySearch(jobs, i);
            if (l != -1) {
                incl += dp[l];
            }

            dp[i] = Math.max(dp[i - 1], incl);
        }

        return dp[n - 1];
    }

    // Find the latest job that doesn't conflict
    private int binarySearch(Job[] jobs, int index) {
        int lo = 0, hi = index - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end <= jobs[index].start) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    static class Job {
        int start, end, profit;
        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }
}