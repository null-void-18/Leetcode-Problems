class StockSpanner {
public:
    stack<pair<int,int>> s;
    int i;
    StockSpanner() {
        i=0;
    }
    
    int next(int price) {
        while(!s.empty() and s.top().first<=price) s.pop();
        ++i;
        int k=s.empty()?i:(i-s.top().second);
        s.push({price,i});
        return k;
    }
};
