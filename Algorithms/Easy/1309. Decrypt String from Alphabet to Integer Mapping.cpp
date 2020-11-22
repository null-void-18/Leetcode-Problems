class Solution {
public:
    string freqAlphabets(string s) {
        map<string,char> mp;
        int k = 1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch < 'j')
                mp[to_string(k)] = ch;
            else
                mp[to_string(k)+'#'] = ch;
            k++;
        }
        string ans = "";
        int n = s.size();
        for(int i=0;i<n;i++)
        {
            if(i+2<n and s[i+2]=='#')
            {
                ans += mp[s.substr(i,3)];
                i+=2;
            }
            else
            {
                string k(1,s[i]);
                ans += mp[k];
            }
        }
        return ans;
    }
};
