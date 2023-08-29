/*
package codebattle.training.day9;

import java.util.Arrays;
import java.util.HashMap;

class UserSolution
{
    int[][] ancestors;
    HashMap<String, Integer> hashToIdx;
    int[] segmentTree, depth;
    int count;

    void init(char mAncestor[], int mDeathday) {
        ancestors = new int[12002][15];
        hashToIdx = new HashMap<>();
        segmentTree = new int[2097153];
        depth = new int[12002];
        Arrays.fill(depth, -1);
        count = 0;

        String initAncestor = covertToStr(mAncestor);
        hashToIdx.put(initAncestor, ++count);
        segUpdate(0, mDeathday, 0, 1048575, 1);
        depth[1] = 0;
    }

    int add(char mName[], char mParent[], int mBirthday, int mDeathday) {
        String name = covertToStr(mName);
        String parent = covertToStr(mParent);
        Integer parentIdx = hashToIdx.get(parent);

        hashToIdx.put(name, ++this.count);
        ancestors[this.count][0] = parentIdx;
        depth[this.count] = depth[parentIdx] + 1;


        for (int k = 1; k < 15; k++)
            ancestors[this.count][k] = ancestors[ancestors[this.count][k - 1]][k - 1];

        segUpdate(mBirthday, mDeathday, 0, 1048575, 1);

        return depth[this.count];
    }

    int distance(char mName1[], char mName2[]) {
        int ret = 0;
        String n1 = covertToStr(mName1);
        String n2 = covertToStr(mName2);
        Integer n1Idx = hashToIdx.get(n1);
        Integer n2Idx = hashToIdx.get(n2);

        int a, b;
        if (depth[n1Idx] > depth[n2Idx]) {
            a = n1Idx;
            b = n2Idx;
        }else {
            b = n1Idx;
            a = n2Idx;
        }
        ret += depth[a] - depth[b];
        int pCnt = ret, num = 0;
        while (pCnt > 0){
            if ((pCnt & 1) == 1)
                a = ancestors[a][num];
            pCnt = pCnt >> 1;
            num++;
        }

        for (int k = 14; k >= 0; k--){
            if (ancestors[a][k] != ancestors[b][k]){
                ret += (depth[a] - depth[ancestors[a][k]]) * 2;
                a = ancestors[a][k];
                b = ancestors[b][k];
            }
        }

        if (a != b)
            ret += 2;
        return ret;
    }

    int count(int mDay) {
        return segPrint(mDay);
    }

    void segUpdate(int l, int r, int nodeL, int nodeR, int idx){
        if (nodeR < l || nodeL > r) return;
        if (nodeL >= l && nodeR <= r){
            segmentTree[idx]++;
            return;
        }
        int mid = (nodeL + nodeR) / 2;
        segUpdate(l, r, nodeL, mid, idx * 2);
        segUpdate(l, r, mid + 1, nodeR, idx * 2 + 1);
    }

    int segPrint(int mDay){
        int idx = mDay + 1048576;
        int ret = 0;
        while (idx > 0){
            ret += segmentTree[idx];
            idx /= 2;
        }
        return ret;
    }

    String covertToStr(char[] c){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; c[i] != '\0'; i++)
            sb.append(c[i]);
        return sb.toString();
    }
}*/
