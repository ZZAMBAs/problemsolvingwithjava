/*
package samsungdxswacademy.hash.problem5;
 // 9/10 시간초과 코드.
// HashMap은 결국 반드시 키값에 따른 해싱 과정을 거친다. 따라서 정적 배열로 접근하도록 한다면 더 빨라질 것으로 예상한다.
// 예를들어 a[1]이 HashMap h의 h.get(1)보다 빠르다. 둘 다 O(1)이지만(충돌 없다 가정) 결국 해싱 과정을 거치기 때문.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UserSolution {
    User[] users;
    int mailLimit;
    HashMap<Long, ArrayList<Long>> hashToWords;

    void init(int N, int K){
        users = new User[N];
        for (int i = 0; i < N; i++)
            users[i] = new User();
        mailLimit = K;
        hashToWords = new HashMap<>();
    }

    void sendMail(char subject[], int uID, int cnt, int rIDs[]){
        Long subjectHash = hashForSubject(subject);
        ArrayList<Long> wordsHash = makeWordsHash(subject);
        hashToWords.putIfAbsent(subjectHash, wordsHash);

        for (int i = 0; i < cnt; i++){
            User curUser = users[rIDs[i]];
            while (curUser.mails.size() >= mailLimit) {
                Long deleteMail = curUser.mails.get(0);
                ArrayList<Long> deleteWords = hashToWords.get(deleteMail);
                curUser.subjects.replace(deleteMail, curUser.subjects.get(deleteMail) - 1);
                for (Long hash : deleteWords) {
                    curUser.words.replace(hash, curUser.words.get(hash) - 1);
                }
                curUser.mails.remove(0);
            }
            curUser.mails.add(subjectHash);
            curUser.subjects.putIfAbsent(subjectHash, 0);
            curUser.subjects.replace(subjectHash, curUser.subjects.get(subjectHash) + 1);
            HashSet<Long> alreadyExist = new HashSet<>();
            for(Long hash : wordsHash){
                if (alreadyExist.contains(hash))
                    continue;
                alreadyExist.add(hash);
                curUser.words.putIfAbsent(hash, 0);
                curUser.words.replace(hash, curUser.words.get(hash) + 1);
            }
        }
    }

    int getCount(int uID){
        return users[uID].mails.size();
    }

    int deleteMail(int uID, char subject[]){
        User curUser = users[uID];
        Long subjectHash = hashForSubject(subject);
        ArrayList<Long> wordsHash = hashToWords.get(subjectHash);
        int cnt = 0;

        Integer getValue = curUser.subjects.get(subjectHash);
        if (getValue == null || getValue == 0)
            return cnt;

        for (int i = 0; i < curUser.mails.size(); i++){
            if (curUser.mails.get(i).equals(subjectHash)){
                cnt++;
                curUser.mails.remove(i--);
            }
        }
        curUser.subjects.replace(subjectHash, getValue - cnt);
        for (Long hash : wordsHash) {
            curUser.words.replace(hash, curUser.words.get(hash) - cnt);
        }

        return cnt;
    }

    int searchMail(int uID, char text[]){
        return users[uID].words.getOrDefault(hash(text), 0);
    }

    static class User{
        ArrayList<Long> mails;
        HashMap<Long, Integer> subjects;
        HashMap<Long, Integer> words;

        public User() {
            this.mails = new ArrayList<>();
            this.subjects = new HashMap<>();
            this.words = new HashMap<>();
        }
    }

    static Long hash(char[] s){
        Long ret = 0L;
        for (int i = 0; s[i] != '\0'; i++){
            ret = ret << 5;
            ret |= s[i] - 65;
        }
        return ret;
    }

    static Long hashForSubject(char[] subject){
        Long ret = 0L;
        Long exp = 31L;
        Long mul = 1L;
        for(int i = 0; subject[i] != '\0'; i++) {
            ret = ret + mul * (long)(subject[i] - 'a');
            mul *= exp;
        }
        return ret;
    }

    ArrayList<Long> makeWordsHash(char[] subject){
        ArrayList<Long> ret = new ArrayList<>();
        char[] c = new char[11];
        int cIdx = 0;
        for (int i = 0; subject[i] != '\0'; i++){
            if (subject[i] == ' '){
                c[cIdx] = '\0';
                ret.add(hash(c));
                cIdx = 0;
                continue;
            }
            c[cIdx++] = subject[i];
        }
        c[cIdx] = '\0';
        ret.add(hash(c));
        return ret;
    }
}
*/
