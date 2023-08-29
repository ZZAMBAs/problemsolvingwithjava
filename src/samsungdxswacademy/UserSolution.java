package samsungdxswacademy;

import java.util.ArrayList;
import java.util.Comparator;

import static java.lang.Math.max;
import static java.lang.Math.min;

class UserSolution {
    int N;
    char[] ret;
    ArrayList<Integer>[] hashTable = new ArrayList[200003];
    int[] idxToHash;
    void init(int N, char[] init_string){
        this.N = N;
        this.idxToHash = new int[N - 2];
        ret = init_string;
        for (int i = 0; i < 200003; i++)
            hashTable[i] = new ArrayList<>();
        for (int i = 0; i <= N - 3; i++){
            int hash = 31 * 31 * ret[i] + 31 * ret[i + 1] + ret[i + 2];
            hashTable[hash % 200003].add(i);
            idxToHash[i] = hash;
        }
    }

    int change(char[] string_A, char[] string_B){
        int hashA = hash(string_A, 0);
        int cnt = 0;
        hashTable[hashA].sort(Comparator.comparingInt(o -> o));
        int preIdx = -3;
        for (int i = 0; i < hashTable[hashA].size();){
            int idx =hashTable[hashA].get(i);
            if (idx >= preIdx + 3){
                preIdx = idx;
                ret[idx] = string_B[0];
                ret[idx + 1] = string_B[1];
                ret[idx + 2] = string_B[2];
                rehash(idx);
                cnt++;
            }
            else i++;
        }

        return cnt;
    }

    void result(char[] ret){
        for (int i = 0; i < ret.length; i++)
            ret[i] = this.ret[i];
    }

    int hash(char[] str, int start){
        return (31 * 31 * str[start] + 31 * str[start + 1] + str[start + 2]) % 200003;
    }

    void rehash(int idx){
        for (int i = max(0, idx - 2); i <= min(idx + 2, N - 3); i++){
            int preHash = idxToHash[i];
            int newHash = hash(ret, i);
            hashTable[preHash].remove((Integer)i);
            hashTable[newHash].add(i);
            idxToHash[i] = newHash;
        }
    }
}
