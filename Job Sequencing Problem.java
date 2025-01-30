//Job Sequencing Problem


//ChatGPT solution
class Solution {
    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        int n = profit.length;
        int jobs[][] = new int[n][3]; // Store {profit, deadline, id}
        
        // Step 1: Store jobs in 2D array
        for (int i = 0; i < n; i++) {
            jobs[i][0] = profit[i];
            jobs[i][1] = deadline[i];
            jobs[i][2] = id[i]; // Just for reference (optional)
        }
        
        // Step 2: Sort jobs by descending order of profit
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[0], a[0]));

        // Step 3: Find the max deadline to create time slots
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][1]);
        }
        
        // Step 4: Create an array to track available time slots
        boolean[] slot = new boolean[maxDeadline + 1]; // 1-based index
        int jobCount = 0, maxProfit = 0;

        // Step 5: Schedule the jobs
        for (int i = 0; i < n; i++) {
            int deadline = jobs[i][1];
            
            // Find the latest available slot from deadline to 1
            for (int j = deadline; j > 0; j--) {
                if (!slot[j]) { // If the slot is free
                    slot[j] = true; // Mark slot as occupied
                    jobCount++;
                    maxProfit += jobs[i][0];
                    break; // Move to next job
                }
            }
        }

        // Step 6: Return the results
        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobCount);
        result.add(maxProfit);
        return result;
    }
}



//My first solution


class Solution {

    Set<Integer> s = new HashSet<Integer>();
    
    
    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        int n = profit.length;
        int jobs[][] = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            jobs[i][0] = profit[i];
            jobs[i][1] = deadline[i];
        }
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[0], a[0]));
        int ans = 0;
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if(s.contains(jobs[i][1])) {
                int x = jobs[i][1];
                while(x > 0) {
                    if(s.contains(x) == false) {
                        s.add(x);
                        ans += jobs[i][0];
                        count += 1;
                        break;
                    }
                    x--;
                }
            }else {
                s.add(jobs[i][1]);
                count += 1;
                ans += jobs[i][0];
            }
        }
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        revArrayList.add(count);
        revArrayList.add(ans);
        return revArrayList;
    }
}
