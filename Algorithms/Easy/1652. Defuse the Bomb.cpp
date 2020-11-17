class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        int sum,n=code.size();
        vector<int> a(n,0);
        
        for(int i=0;i<n;i++){
            sum=0;
            if(k>0){
                for(int j=1;j<=k;j++){
                    sum+=code[(i+j)%n];
                }
            }
            if(k<0){
                for(int j=1;j<=-k;j++){
                    sum+=code[(i-j+n)%n];
                }
            }
            a[i]=sum;
        }
        return a;
    }
};
