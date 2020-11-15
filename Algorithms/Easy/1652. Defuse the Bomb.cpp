class Solution {
public:
	vector<int> decrypt(vector<int>& code, int k) {
		int n = code.size(), i, j;
		vector<int> a(n, 0);
		for (i = 0; i < n; i++) {
			if (k > 0) {
				for (j = 1; j <= k; j++) 
          a[i] += code[(i + j) % n];
			}
			if (k < 0) {
				for (j = 1; j <= -k; j++) 
          a[i] += code[(i - j + n) % n];
			}
		}
		return a;
	}
};
