class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        backtrack(ans,currentList,s,0);
        return ans;        
    }

    void backtrack(List<List<String>> ans,List<String> currentList,String s,int start) {
        if(start == s.length()) {
            ans.add(new ArrayList<>(currentList));
            return;
        }

        for(int end = start + 1;end <= s.length(); end++) {
            String temp = s.substring(start,end);
            if(isPalindrome(temp)) {
                currentList.add(temp);
                backtrack(ans,currentList,s,end);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    boolean isPalindrome(String temp) {
        int start = 0;
        int end = temp.length() - 1;

        while(start < end) {
            if(temp.charAt(start) != temp.charAt(end)) return false;
            start += 1;
            end -= 1;
        }
        return true;
    }


}
