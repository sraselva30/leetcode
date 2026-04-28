class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                char[] words = curr.toCharArray();

                for (int j = 0; j < words.length; j++) {
                    char originalChar = words[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (words[j] == c) continue;
                        words[j] = c;
                        String nextWord = String.valueOf(words);

                        if (nextWord.equals(endWord)) return level + 1;

                        if (dict.contains(nextWord)) {
                            queue.add(nextWord);
                            dict.remove(nextWord);
                        }
                    }
                    words[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}
