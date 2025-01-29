//N meetings in one room


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        
        int n = start.length;
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = end[i];
            meetings[i][1] = start[i];
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        if(n == 0) {
            return 0;
        }
        int count = 1;
        int last = meetings[0][0];
        
        for(int i = 1;i < n;i++) {
            if(meetings[i][1] <= last) {
                continue;
            }
            else {
                last = meetings[i][0];
                count += 1;
            }
        }
        return count;
    }
}
