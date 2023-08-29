/*
package codebattle.training.day10;

// Hash를 직접 구현하여 이 코드의 시간복잡도를 더 빠르게 줄일 수 있다.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

class UserSolution {
    static class Player{
        HashMap<Integer, Integer> cardMap;
        HashMap<String, HashMap<String, TreeSet<String>>> topicAndPrefixMap; // {주제어, {접두어, 단어 트리셋}
        int score;
        boolean isLeaved;

        public Player() {
            this.cardMap = new HashMap<>();
            this.topicAndPrefixMap = new HashMap<>();
            this.score = 0;
            this.isLeaved = false;
        }
    }

    static class Card{
        String topic;
        String word;

        public Card(String topic, String word) {
            this.topic = topic;
            this.word = word;
        }
    }

    final static int MAXL	= 10;
    int[] cardPlayerCnt;
    HashMap<String, Integer> wordToIdx;
    Player[] players;
    Card[] cards;

    public void init(int N, char[][] mWordList, char[][] mSubjectList) {
        this.cardPlayerCnt = new int[N + 1];
        this.wordToIdx = new HashMap<>();
        this.players = new Player[51];
        this.cards = new Card[N + 1];

        for (int i = 1; i <= N; i++){
            String topic = charToStr(mSubjectList[i - 1]);
            String word = charToStr(mWordList[i - 1]);
            Card card = new Card(topic, word);
            cards[i] = card;
            wordToIdx.put(card.word, i);
            cardPlayerCnt[i] = 0;
        }
    }

    public void join(int mID, int M, int[] mCardList) {
        this.players[mID] = new Player();
        Player nowPlayer = this.players[mID];
        for (int i = 0; i < M; i++){
            if(nowPlayer.cardMap.get(mCardList[i]) == null){
                nowPlayer.cardMap.put(mCardList[i], 0);
                cardPlayerCnt[mCardList[i]]++;
            }
            nowPlayer.cardMap.replace(mCardList[i], nowPlayer.cardMap.get(mCardList[i]) + 1);

            Card card = cards[mCardList[i]];
            StringBuilder sb = new StringBuilder();

            nowPlayer.topicAndPrefixMap.putIfAbsent(card.topic, new HashMap<>());
            HashMap<String, TreeSet<String>> topicMap = nowPlayer.topicAndPrefixMap.get(card.topic);
            sb.append(card.word.charAt(0));
            topicMap.putIfAbsent(sb.toString(), new TreeSet<>());
            topicMap.get(sb.toString()).add(card.word);
            sb.append(card.word.charAt(1));
            topicMap.putIfAbsent(sb.toString(), new TreeSet<>());
            topicMap.get(sb.toString()).add(card.word);
        }

    }

    public int playRound(char[] mBeginStr, char[] mSubject) {
        int ret = 0;
        int idx = 0;
        int[] selectCardNum = new int[51];
        HashMap<Integer, Integer> selectedCnt = new HashMap<>();
        ArrayList<Integer> deleteList = new ArrayList<>();
        String beginStr = charToStr(mBeginStr);
        String topicStr = charToStr(mSubject);

        while (idx + 1 < 51 && players[++idx] != null){
            if (players[idx].isLeaved)
                continue;

            int playerNum = 0;
            int selectedCardNum = 0;
            String selectedWord = "";
            Player curPlayer = players[idx];
            HashMap<String, TreeSet<String>> topicMap = curPlayer.topicAndPrefixMap.get(topicStr);
            if (topicMap == null || topicMap.isEmpty())
                continue;

            StringBuilder sb = new StringBuilder();
            sb.append(beginStr);
            TreeSet<String> strSet = topicMap.get(beginStr);
            if (strSet == null || strSet.isEmpty())
                continue;

            Iterator<String> iterator = strSet.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                Integer curCardNum = wordToIdx.get(next);
                if(playerNum < cardPlayerCnt[curCardNum]){
                    selectedCardNum = curCardNum;
                    playerNum = cardPlayerCnt[curCardNum];
                    selectedWord = next;
                }
            }
            curPlayer.cardMap.replace(selectedCardNum, curPlayer.cardMap.get(selectedCardNum) - 1);
            selectCardNum[idx] = selectedCardNum;
            selectedCnt.putIfAbsent(selectedCardNum, 0);
            selectedCnt.replace(selectedCardNum, selectedCnt.get(selectedCardNum) + 1);

            if (curPlayer.cardMap.get(selectedCardNum) == 0) {
                StringBuilder tempSb = new StringBuilder();
                tempSb.append(selectedWord.charAt(0));
                topicMap.get(tempSb.toString()).remove(selectedWord);
                tempSb.append(selectedWord.charAt(1));
                topicMap.get(tempSb.toString()).remove(selectedWord);

                deleteList.add(selectedCardNum);
            }
            ret += selectedCardNum;
        }
        for (Integer cardNumber : deleteList)
            cardPlayerCnt[cardNumber]--;

        for (int i = 1; i < 51; i++){
            if (selectCardNum[i] == 0)
                continue;
            Integer playerCnt = selectedCnt.get(selectCardNum[i]);
            players[i].score += (playerCnt - 1) * (playerCnt - 1);
        }
        return ret;
    }

    public int leave(int mID) {
        Player player = this.players[mID];
        player.isLeaved = true;
        for (Integer i : player.cardMap.keySet())
            if (player.cardMap.get(i) != 0)
                cardPlayerCnt[i]--;
        return player.score;
    }

    public String charToStr(char[] c){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; c[i] != '\0'; i++)
            sb.append(c[i]);
        return sb.toString();
    }
}*/
