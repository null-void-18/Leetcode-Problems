
class Solution {
    
    int recurse(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        
        return recurse(n-1) + recurse(n-2);
    }
    
    
    int countWays(int n) {
        int stairs[] = new int[n + 1];
        stairs[0] = 1;
        stairs[1] = 1;
        
        for(int i = 2;i <= n;i++) {
            stairs[i] = stairs[i-1] + stairs[i-2];
        }
        
        return stairs[n];
    }
}
