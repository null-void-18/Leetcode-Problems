static const auto speedup = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 0;
}();

class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        unordered_map<int,int> m;
        for(int i=0;i<A.size();++i){
            for(int j=0;j<B.size();++j){
                ++m[A[i]+B[j]];
            }
        }
        
        int ans=0;
        
        for(int i=0;i<C.size();++i){
            for(int j=0;j<D.size();++j){
                if(m.find(-C[i]-D[j])!=m.end()){
                    ans+=m[-C[i]-D[j]];
                }
            }
        }
        return ans;
    }
};
