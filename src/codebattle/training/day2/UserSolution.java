package codebattle.training.day2;
// 왜 연결리스트 코드가 더 실행시간이 느릴까?
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class UserSolution {
    public static ArrayList<Node> alliance;
    public static ArrayList<Node> enemy;
    public static HashMap<String, Integer> idx;
    public static HashMap<Integer, Pair> loc; // {idx, Pair}
    public static HashSet<Integer> dieIdx;
    public static int[][] board;
    public static String[][] boardMonarch;
    public static int[] dr = {-1, 0, 1, 1, 1, 0, -1, -1}, dc = {1, 1, 1, 0, -1, -1, -1, 0};
    public static int size;

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class NodeList{
        NodeList nextNodeList;
        Integer value;

        public NodeList(Integer value) {
            this.value = value;
            this.nextNodeList = null;
        }
    }

    static class Node{
        int parent;
        NodeList childrenHead;
        NodeList childrenTail;

        public Node() {
            this.parent = -1;
            this.childrenHead = new NodeList(-1);
            this.childrenTail = childrenHead;
        }
    }

    void init(int N, int[][] mSoldier, char[][][] mMonarch) {
        alliance = new ArrayList<>();
        enemy = new ArrayList<>();
        idx = new HashMap<>();
        dieIdx = new HashSet<>();
        loc = new HashMap<>();
        board = new int[N][N];
        boardMonarch = new String[N][N];
        size = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                board[i][j] = mSoldier[i][j];
                alliance.add(new Node());
                enemy.add(new Node());
                idx.put(charToStr(mMonarch[i][j]), size);
                boardMonarch[i][j] = charToStr(mMonarch[i][j]);
                loc.put(size++, new Pair(i, j));
            }
    }
    void destroy() {
    }
    int ally(char[] mMonarchA, char[] mMonarchB) {
        Integer AIdx = idx.get(charToStr(mMonarchA));
        Integer BIdx = idx.get(charToStr(mMonarchB));

        return union(AIdx, BIdx);
    }
    int attack(char[] mMonarchA, char[] mMonarchB, char[] mGeneral) {
        Integer par1 = find(idx.get(charToStr(mMonarchA)), alliance);
        Integer BIdx = idx.get(charToStr(mMonarchB));
        Pair BPair = loc.get(BIdx);
        Integer par2 = find(BIdx, alliance);
        String general = charToStr(mGeneral);

        if (par1.equals(par2))
            return -1;

        boolean sw = false;
        for (int i = 0; i < 8; i++){
            int nextR = BPair.x + dr[i];
            int nextC = BPair.y + dc[i];
            if (nextR >= 0 && nextR < board.length && nextC >= 0 && nextC < board.length){
                if(find(idx.get(boardMonarch[nextR][nextC]), alliance).equals(par1)){
                    sw = true;
                    int soldierNum = board[nextR][nextC] / 2;
                    board[nextR][nextC] -= soldierNum;
                    board[BPair.x][BPair.y] -= soldierNum;
                }

            }
        }
        if (!sw)
            return -2;

        for (int i = 0; i < 8; i++){
            int nextR = BPair.x + dr[i];
            int nextC = BPair.y + dc[i];
            if (nextR >= 0 && nextR < board.length && nextC >= 0 && nextC < board.length){
                if(find(idx.get(boardMonarch[nextR][nextC]), alliance).equals(par2)){
                    int soldierNum = board[nextR][nextC] / 2;
                    board[nextR][nextC] -= soldierNum;
                    board[BPair.x][BPair.y] += soldierNum;
                }

            }
        }
        Node par1NodeE = enemy.get(par1);
        Node par2NodeE = enemy.get(par2);
        NodeList par2NextNodeList = new NodeList(par2);
        par1NodeE.childrenTail.nextNodeList = par2NextNodeList;
        par1NodeE.childrenTail = par2NextNodeList;

        NodeList par1NextNodeList = new NodeList(par1);
        par2NodeE.childrenTail.nextNodeList = par1NextNodeList;
        par2NodeE.childrenTail = par1NextNodeList;

        if (board[BPair.x][BPair.y] >= 0)
            return 0;
        dieIdx.add(BIdx);
        board[BPair.x][BPair.y] *= -1;
        boardMonarch[BPair.x][BPair.y] = general;
        alliance.add(new Node());
        enemy.add(new Node());
        idx.put(general, size);
        loc.put(size, new Pair(BPair.x, BPair.y));
        union(par1, size++);
        return 1;
    }
    int recruit(char[] mMonarch, int mNum, int mOption) {
        Integer index = idx.get(charToStr(mMonarch));
        if (mOption == 0){
            Pair pair = loc.get(index);
            if (!dieIdx.contains(index))
                board[pair.x][pair.y] += mNum;
            return board[pair.x][pair.y];
        }
        int ret = 0;

        Integer par = find(index, alliance);
        Node parNode = alliance.get(par);
        Pair pair = loc.get(par);
        if (!dieIdx.contains(par)) {
            board[pair.x][pair.y] += mNum;
            ret += board[pair.x][pair.y];
        }
        NodeList head = parNode.childrenHead.nextNodeList;
        while (head != null) {
            if (!dieIdx.contains(head.value)) {
                pair = loc.get(head.value);
                board[pair.x][pair.y] += mNum;
                ret += board[pair.x][pair.y];
            }
            head = head.nextNodeList;
        }
        return ret;
    }

    static String charToStr(char[] c){
        StringBuilder st = new StringBuilder();
        for (int i = 0; c[i] != '\0'; i++)
            st.append(c[i]);
        return st.toString();
    }

    static Integer find(int idx, ArrayList<Node> arr){
        Node node = arr.get(idx);
        if (node.parent == -1)
            return idx;
        node.parent = find(node.parent, arr);
        return node.parent;
    }

    static Integer union(int idx1, int idx2){
        Integer idx1ParA = find(idx1, alliance);
        Integer idx2ParA = find(idx2, alliance);

        if (idx1ParA.equals(idx2ParA))
            return -1;
        NodeList head = enemy.get(find(idx2ParA, enemy)).childrenHead.nextNodeList;
        while (head != null){
            if(find(head.value, alliance).equals(idx1ParA))
                return -2;
            head = head.nextNodeList;
        }
        head = enemy.get(find(idx1ParA, enemy)).childrenHead.nextNodeList;
        while (head != null){
            if(find(head.value, alliance).equals(idx2ParA))
                return -2;
            head = head.nextNodeList;
        }
        alliance.get(idx2ParA).parent = idx1ParA;
        NodeList AChildrenTail = alliance.get(idx1ParA).childrenTail;
        NodeList idx2ParANodeList = new NodeList(idx2ParA);
        AChildrenTail.nextNodeList = idx2ParANodeList;
        alliance.get(idx1ParA).childrenTail = idx2ParANodeList;

        if (alliance.get(idx2ParA).childrenHead.nextNodeList != null) {
            alliance.get(idx1ParA).childrenTail.nextNodeList = alliance.get(idx2ParA).childrenHead.nextNodeList;
            alliance.get(idx1ParA).childrenTail = alliance.get(idx2ParA).childrenTail;
            alliance.get(idx2ParA).childrenHead.nextNodeList = null;
            alliance.get(idx2ParA).childrenTail = alliance.get(idx2ParA).childrenHead;
        }

        if (enemy.get(idx2ParA).childrenHead.nextNodeList != null) {
            enemy.get(idx1ParA).childrenTail.nextNodeList = enemy.get(idx2ParA).childrenHead.nextNodeList;
            enemy.get(idx1ParA).childrenTail = enemy.get(idx2ParA).childrenTail;
            enemy.get(idx2ParA).childrenHead.nextNodeList = null;
            enemy.get(idx2ParA).childrenTail = enemy.get(idx2ParA).childrenHead;
        }
        return 1;
    }
}
