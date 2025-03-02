//BFS Approach


class Solution {
    
    class Pair{
        String st;
        int i;
        Pair(String st,int i) {
            this.st = st;
            this.i = i;
        }
    }
    
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList)); 
        if (!wordSet.contains(targetWord)) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWord,1));
        while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                String word = pair.st;
                int steps = pair.i;
                char[] wordArr = word.toCharArray();

                for (int j = 0; j < wordArr.length; j++) {
                    char originalChar = wordArr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue; 

                        wordArr[j] = c;
                        String newWord = new String(wordArr);

                        if (newWord.equals(targetWord)) return steps + 1; 

                        if (wordSet.contains(newWord)) {
                            queue.add(new Pair(newWord,steps + 1));
                            wordSet.remove(newWord);
                        }
                    }
                    wordArr[j] = originalChar; 
                }
            steps++;
        }

        return 0;
    }
}
