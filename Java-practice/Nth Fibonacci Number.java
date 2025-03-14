
class Solution {
    
    int recurse(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        return recurse(n-1) + recurse(n-2);
    }
    
    
    public int nthFibonacci(int n) {
        if(n == 0) return 0;
        int fibonacci[] = new int[n+1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        
        for(int i = 2; i <= n;i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        
        return fibonacci[n];
        
    }
}
