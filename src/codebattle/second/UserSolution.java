package codebattle.second;

class UserSolution {
    int mCharge;

    void init(int mCharge) {
        this.mCharge = mCharge;
    }

    int stock(int mType, int mPrice, int mPerformance, int mPosition) {
        return 0;
    }

    Solution.Result order(int mBudget) {
        Solution.Result res = new Solution.Result();
        res.mPerformance = 0;
        res.mPrice = 0;


        return res;
    }
}