class Solution {
public:
    int evalRPN(vector<string>& tokens) {
	unordered_set<string> ops = {"+", "-", "*", "/"};
	stack<int> stk;
	for(string &t : tokens) {
		if(ops.count(t)) {
			int a = stk.top(); stk.pop();
			int b = stk.top(); stk.pop();
			stk.push(t == "+" ? b + a : t == "-" ? b - a : t == "*" ? b * a : b / a);
		} else stk.push(stoi(t));
	}
	return stk.top();
}
};
