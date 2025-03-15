
class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        boolean[] visited = new boolean[leaves + 1];

        for (int i = 0; i < N; i++) {
            int jump = frogs[i];
            if (jump <= leaves && !visited[jump]) {
                for (int j = jump; j <= leaves; j += jump) {
                    visited[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= leaves; i++) {
            if (!visited[i]) {
                count++;
            }
        }
        return count;
    }
}
