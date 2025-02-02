//Fractional Knapsack


class Solution {
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        List<Integer> fraction = new ArrayList<Integer>();
        int n = val.size();
        double[][] jobs = new double[n][3];
        for(int i =0; i < n;i++) {
            jobs[i][0] = (double) val.get(i)/wt.get(i);
            jobs[i][1] = val.get(i);
            jobs[i][2] = wt.get(i);
        }
        
        Arrays.sort(jobs, (a,b) -> Double.compare(b[0],a[0]));
        double total = 0;
        for(int i =0; i < n;i++) {
            if(jobs[i][2] <= capacity) {
                capacity -= jobs[i][2];
                total += jobs[i][1];
            }
            else if(capacity > 0) {
                total += ((jobs[i][0] * capacity));
                capacity = 0;
            }
            else {
                continue;
            }
        }
        return total;
    }
}
