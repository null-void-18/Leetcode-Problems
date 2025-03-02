
//BFS Approach


class Solution {

    class Pair {
        String word;
        ArrayList<String> path;

        Pair(String word, ArrayList<String> path) {
            this.word = word;
            this.path = path;
        }
    }

    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList)); 
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        if (!wordSet.contains(targetWord)) return result;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWord, new ArrayList<>(List.of(startWord))));
        
        Set<String> visited = new HashSet<>();
        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                String word = pair.word;
                ArrayList<String> path = pair.path;

                char[] wordArr = word.toCharArray();

                for (int j = 0; j < wordArr.length; j++) {
                    char originalChar = wordArr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;

                        wordArr[j] = c;
                        String newWord = String.valueOf(wordArr);

                        if (newWord.equals(targetWord)) {
                            ArrayList<String> newPath = new ArrayList<>(path);
                            newPath.add(newWord);
                            result.add(newPath);
                            found = true;
                        }

                        if (wordSet.contains(newWord)) {
                            ArrayList<String> newPath = new ArrayList<>(path);
                            newPath.add(newWord);
                            queue.add(new Pair(newWord, newPath));
                            levelVisited.add(newWord);
                        }
                    }
                    wordArr[j] = originalChar;
                }
            }

            if (found) break;

            for (String w : levelVisited) {
                wordSet.remove(w);
            }
        }

        return result;
    }
}
