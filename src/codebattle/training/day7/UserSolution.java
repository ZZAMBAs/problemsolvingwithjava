/*
package codebattle.training.day7;

class UserSolution {
    long[] segmentTreeMax, segmentTreeMin;
    int[] lazy;
    int maxSize;
    int size;
    long counting;

    void init(int C) {
        this.size = C;
        int pow2 = 1;
        for (int i = 0; i < 21; i++){
            if (C < pow2){
                this.maxSize = pow2 * 2;
                break;
            }
            pow2 *= 2;
        }
        lazy = new int[maxSize];
        segmentTreeMax = new long[maxSize];
        segmentTreeMin = new long[maxSize];
        for (int i = maxSize / 2 - size; i > 0; i--)
            segmentTreeMin[maxSize - i] = 10001;
        for (int i = maxSize / 2 - 1; i > 0; i--){
            segmentTreeMin[i] = Math.min(segmentTreeMin[i * 2], segmentTreeMin[i * 2 + 1]);
        }
        this.counting = 0;
    }

    Solution.Result dropBlocks(int mCol, int mHeight, int mLength) {
        Solution.Result ret = new Solution.Result();
        this.counting += (long)mHeight * (long)mLength;
        dropIt(1, 0, maxSize / 2 - 1, mCol, mCol + mLength - 1, mHeight);
        ret.top = (int)(segmentTreeMax[1] - segmentTreeMin[1]);
        ret.count = (int)((this.counting - (this.size * segmentTreeMin[1] + lazy[1])) % 1000000);
        return ret;
    }

    void dropIt(int idx, int nodeL, int nodeR, int left, int right, int height){
        lazyPropagation(idx);

        if (nodeL > right || nodeR < left) return;
        if (nodeL >= left && nodeR <= right){
            lazy[idx] += height;
            lazyPropagation(idx);
            return;
        }
        int mid = (nodeL + nodeR) / 2;

        dropIt(idx * 2, nodeL, mid, left, right, height);
        dropIt(idx * 2 + 1, mid + 1, nodeR, left, right, height);

        segmentTreeMax[idx] = Math.max(segmentTreeMax[idx * 2] + lazy[idx * 2], segmentTreeMax[idx * 2 + 1] + lazy[idx * 2 + 1]);
        segmentTreeMin[idx] = Math.min(segmentTreeMin[idx * 2] + lazy[idx * 2], segmentTreeMin[idx * 2 + 1] + lazy[idx * 2 + 1]);
    }

    private void lazyPropagation(int idx) {
        segmentTreeMax[idx] += lazy[idx];
        segmentTreeMin[idx] += lazy[idx];
        if (idx < maxSize / 2) {
            lazy[idx * 2] += lazy[idx];
            lazy[idx * 2 + 1] += lazy[idx];
        }
        lazy[idx] = 0;
    }
}*/
