package LeetCodeExercise;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int count) {
        if (i<0 || j<0 || i>=board.length || j >= board[0].length || board[i][j] != words[count]){
            return false;
        }
        if (count == words.length-1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '.';
        boolean result = dfs(board, words, i-1, j, count+1) || dfs(board, words, i+1, j, count+1) || dfs(board, words, i, j-1, count+1) || dfs(board, words, i, j+1, count+1);
        board[i][j] = temp;
        return result;
    }
}
