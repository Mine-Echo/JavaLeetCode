//机器人的运动范围

public class JZ13 {

    private int[][] visit;
    private int cnt=0;//cnt不必须，可以让dfs返回int值
    public int movingCount(int threshold, int rows, int cols) {
        //这题是能够到达的范围，如果后面的方块符合threshold限制但是没有路径能到达那里的话也算是不能到达
        //可以用BFS或者DFS
        visit=new int[rows][cols];//默认都是0
        dfs(threshold,0,0);
        return cnt;
    }

    private boolean isLegal(int threshold, int row,int col) {
        int r=row;
        int sum_row=0;
        while(r!=0){
            sum_row+=r%10;
            r/=10;
        }
        int c=col;
        int sum_col=0;
        while(c!=0){
            sum_col+=c%10;
            c/=10;
        }
        if(sum_col+sum_row<=threshold)
            return true;
        return false;
    }

    private void dfs(int threshold, int row, int col){
        if(visit[row][col]==1)
            return;
        if(isLegal(threshold, row, col)){
            visit[row][col]=1;
            cnt+=1;
            if(row>0)
                dfs(threshold,row-1,col);
            if(col>0)
                dfs(threshold,row,col-1);
            if(row<visit.length-1)
                dfs(threshold,row+1,col);
            if(col<visit[0].length-1)
                dfs(threshold,row,col+1);
        }
    }

}