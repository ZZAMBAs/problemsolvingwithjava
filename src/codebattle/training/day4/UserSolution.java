/*
package codebattle.training.day4;

import java.util.Arrays;

public class UserSolution {
    int[] arr;
    int[] dpMax;
    int[] dpMin;
    int size;

    void init(int N, int mValue[]){
        this.arr = new int[200101];
        this.dpMax = new int[200101];
        this.dpMin = new int[200101];
        this.size = N;
        Arrays.fill(dpMax, Integer.MIN_VALUE);
        Arrays.fill(dpMin, Integer.MAX_VALUE);
        for (int i = size - 1; i >= 0; i--){
            dpMax[i] = Math.max(mValue[i], dpMax[i + 1]);
            dpMin[i] = Math.min(mValue[i], dpMin[i + 1]);
            arr[i] = mValue[i];
        }
    }

    void add(int M, int mValue[]){
        int addLen = M;
        while (--addLen >= 0){
            dpMax[size + addLen] = Math.max(mValue[addLen], dpMax[size + addLen + 1]);
            dpMin[size + addLen] = Math.min(mValue[addLen], dpMin[size + addLen + 1]);
            arr[size + addLen] = mValue[addLen];
        }
        updateMaxMinFrom(this.size - 1, 1);
        this.size += M;
    }

    void erase(int mFrom, int mTo){
        int subCnt = mTo - mFrom + 1;
        for (int i = mFrom - 1; i <= this.size; i++){
            dpMax[i] = dpMax[i + subCnt];
            dpMin[i] = dpMin[i + subCnt];
            arr[i] = arr[i + subCnt];
        }
        this.size -= subCnt;
        updateMaxMinFrom(mFrom - 2, 0);
    }

    int find(int K){
        return dpMax[size - K] - dpMin[size - K];
    }

    void updateMaxMinFrom(int from, int method){
        for (int i = from; i >= 0; i--){
            if ((method == 2 && arr[i] > dpMax[i + 1]) || (method == 1 && dpMax[i] >= dpMax[i + 1]))
                break;
            dpMax[i] = Math.max(arr[i], dpMax[i + 1]);
        }
        for (int i = from; i >= 0; i--){
            if ((method == 2 && arr[i] <= dpMin[i + 1]) || (method == 1 && dpMin[i] <= dpMin[i + 1]))
                break;
            dpMin[i] = Math.min(arr[i], dpMin[i + 1]);
        }
    }
}
*/
