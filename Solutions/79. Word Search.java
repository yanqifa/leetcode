class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean isExist = false;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(backtrace(board, i, j, word, 0, new boolean[row][col])){
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

    //退栈没退好！！！！！
    private boolean backtrace(char[][] board, int i, int j, String word, int start, boolean[][] visits){
        int row = board.length;
        int col = board[0].length;
        if(start == word.length())return true;
        if(i < 0 || i >= row || j < 0 || j >= col || visits[i][j]) return false;
        if(board[i][j] == word.charAt(start)){
            visits[i][j] = true;
            boolean isExist =  backtrace(board, i + 1, j, word, start + 1, visits) || backtrace(board, i, j + 1, word, start + 1, visits) || backtrace(board, i - 1, j, word, start + 1, visits) || backtrace(board, i, j - 1, word, start + 1, visits);
            //这里要注意退栈！！！！！恢复visits
            visits[i][j] = false;
            return isExist;
        }else{
            visits[i][j] = false;
            return false;
        }
    }
}