/*
package codebattle.training.day13;

import java.util.HashMap;
import java.util.HashSet;

class UserSolution {
    int curRoomIdx;
    HashMap<String, Integer> strToIdx;
    HashSet<String> isDie;
    Room[] rooms;
    Trie pre, mid, post2, post4;

    void init() {
        curRoomIdx = 0;
        isDie = new HashSet<>();
        strToIdx = new HashMap<>();
        rooms = new Room[33001];
        pre = new Trie();
        mid = new Trie();
        post2 = new Trie();
        post4 = new Trie();
    }

    void addRoom(int mID, char mWord[], int mDirLen[]) {
        String word = charToStr(mWord);
        Room room = new Room(word, mDirLen);
        strToIdx.put(word, mID);
        rooms[mID] = room;
        pre.add(word);
        mid.add(room.dirWord[1] + word);
        post2.add(word.substring(9) + word);
        post4.add(word.substring(7) + word);
    }

    void setCurrent(char mWord[]) {
        String word = charToStr(mWord);
        curRoomIdx = strToIdx.get(word);
    }

    int moveDir(int mDir) {
        Room curRoom = rooms[curRoomIdx];
        String s = "";
        if (mDir == 0){
            if (curRoom.dirWord[0].length() == 2)
                s = post2.find(curRoom.dirWord[0], curRoom.word);
            else
                s = post4.find(curRoom.dirWord[0], curRoom.word);
        }else if (mDir == 1)
            s = mid.find(curRoom.dirWord[1], curRoom.word);
        else if (mDir == 2)
            s = pre.preFind(curRoom.dirWord[2], curRoom.word);

        if (!s.isEmpty()){
            curRoomIdx = strToIdx.get(s);
            return curRoomIdx;
        }

        return 0;
    }

    void changeWord(char mWord[], char mChgWord[], int mChgLen[]) {
        String word = charToStr(mWord);
        isDie.add(word);
        Integer oldIdx = strToIdx.get(word);
        addRoom(oldIdx, mChgWord, mChgLen);
    }

    String charToStr(char[] c){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; c[i] != '\0'; i++)
            sb.append(c[i]);
        return sb.toString();
    }

    static class Room{
        String word;
        String[] dirWord;

        public Room(String word, int[] dirLen) {
            this.word = word;
            this.dirWord = new String[3];
            this.dirWord[0] = word.substring(0, dirLen[0]);
            this.dirWord[1] = word.substring(4, 4 + dirLen[1]);
            this.dirWord[2] = word.substring(11 - dirLen[2]);
        }
    }

    class Trie{
        boolean isEnd;
        Trie[] next;

        public Trie() {
            this.next = new Trie[26];
            this.isEnd = false;
        }

        public void add(String str){
            Trie curTrie = this;
            for (int i = 0; i < str.length(); i++){
                int idx = str.charAt(i) - 97;
                if (curTrie.next[idx] == null)
                    curTrie.next[idx] = new Trie();
                curTrie = curTrie.next[idx];
            }
            curTrie.isEnd = true;
        }

        public String find(String prefix, String exclusion){
            Trie curTrie = this;
            for (int i = 0; i < prefix.length(); i++) {
                if (curTrie.next[prefix.charAt(i) - 97] == null)
                    return "";
                curTrie = curTrie.next[prefix.charAt(i) - 97];
            }
            return dfs(curTrie, exclusion, "");
        }

        public String preFind(String prefix, String exclusion){
            Trie curTrie = this;
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < prefix.length(); i++) {
                if (curTrie.next[prefix.charAt(i) - 97] == null)
                    return "";
                curTrie = curTrie.next[prefix.charAt(i) - 97];
                str.append(prefix.charAt(i));
            }
            return dfs(curTrie, exclusion, str.toString());
        }

        public String dfs(Trie curTrie, String exclusion, String curStr){
            if (curTrie.isEnd){
                if (exclusion.equals(curStr) || isDie.contains(curStr))
                    return "";
                return curStr;
            }

            for (int i = 0; i < 26; i++){
                if (curTrie.next[i] == null)
                    continue;
                String ret = dfs(curTrie.next[i], exclusion, curStr + (char)(97 + i));
                if (!ret.isEmpty()) return ret;
            }
            return "";
        }
    }
}*/
