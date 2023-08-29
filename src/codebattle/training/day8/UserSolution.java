/*
package codebattle.training.day8;

import java.util.HashMap;

class UserSolution {
    HashMap<Integer, Pair> workers;

    static class Pair{
        int startTime;
        int endTime;

        public Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public void init() {
        workers = new HashMap<>();
    }

    public int add(int mId, int mStart, int mEnd) {
        workers.put(mId, new Pair(mStart, mEnd));
        return this.workers.size();
    }

    public int remove(int mId) {
        workers.remove(mId);
        return this.workers.size();
    }

    int announce(int mDuration, int M) {
        int cnt = 0;
        int[] timeline = new int[86401];
        for (Pair p : workers.values()){
            if (p.endTime - p.startTime + 1 < mDuration)
                continue;
            timeline[p.startTime]++;
            timeline[p.endTime - mDuration + 2]--;
        }

        for (int idx = 0; idx < 86401; idx++){
            cnt += timeline[idx];
            if (cnt >= M)
                return idx;
        }
        return -1;
    }
}*/
