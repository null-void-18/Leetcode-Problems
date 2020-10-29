class Solution {
public:
   int tribonacci(int n) {
        int a1=0,a2=0,a3=1,a4;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(int i=1;i<n;i++)
        {
            a4 = a3 + a2 + a1;
            a1 = a2;
            a2 = a3;
            a3 = a4;
        }
        return a4;
    }
};
