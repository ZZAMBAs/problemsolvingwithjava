/*
package codebattle.training.day11;

class UserSolution {
    private static Solution mainSolution = new Solution();
    boolean[][] visited;
    int subTaskCount;
    int curR, curC, curDir; // curDir: 상 좌 하 우 0 1 2 3
    static int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};

    void init(int N, int subTaskCount) {
        visited = new boolean[60][60];
        this.subTaskCount = subTaskCount;
    }

    void cleanHouse(int mLimitMoveCount) {
        this.curDir = 0;
        this.curR = this.curC = 30;
        for (int i = 0; i < visited[0].length; i++)
            for (int j = 0; j < visited[0].length; j++)
                visited[i][j] = false;

        dfs(30, 30);
    }

    void dfs(int r, int c){
        visited[r][c] = true;

        int initDir = curDir;
        int[][] floorState = new int[3][3];
        mainSolution.scanFromRobot(floorState);
        for (int i = 0; i < 4; i++){
            int nextDir = (initDir + i) % 4;
            int nextFloorR = dr[i] + 1;
            int nextFloorC = dc[i] + 1;
            int realNextR = r + dr[nextDir];
            int realNextC = c + dc[nextDir];
            if (floorState[nextFloorR][nextFloorC] != 1 && !visited[realNextR][realNextC]){
                mainSolution.moveRobot((nextDir - curDir + 4) % 4);
                curDir = nextDir;
                dfs(realNextR, realNextC);
                mainSolution.moveRobot((nextDir - curDir + 6) % 4);
                curDir = (nextDir + 2) % 4;
            }
        }

    }
}
*/
