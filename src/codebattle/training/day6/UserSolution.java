/*
// 힙은 필요할 때만 쓰는 것이 좋다.
// 캐시 성질을 이용하면 더 빠른 풀이가 가능하다. ArrayList는 보통 배열 구현이라 아마 아래 풀이도 거의 그런 식으로 풀었을 것이다.
package codebattle.training.day6;

import java.util.*;

class UserSolution {
    HashMap<Integer, ArrayList<Integer>> newsChannelUsers;  // {뉴스채널Id, 유저id들}
    HashMap<Integer, ArrayList<NewsAlert>> userNewsAlert; // {유저id, 뉴스알림}
    HashSet<Integer> canceledAlert; // {취소된 뉴스알림 id}
    PriorityQueue<NewsAlert> delayQueue; // 이벤트 큐


    void init(int N, int K) {
        this.userNewsAlert = new HashMap<>(N);
        this.newsChannelUsers = new HashMap<>(K);
        this.canceledAlert = new HashSet<>();
        this.delayQueue = new PriorityQueue<>();
    }

    void registerUser(int mTime, int mUID, int mNum, int mChannelIDs[]) {
        sendAlert(mTime);

        for (int idx = 0; idx < mNum; idx++){
            int channelId = mChannelIDs[idx];
            newsChannelUsers.putIfAbsent(channelId, new ArrayList<>());
            userNewsAlert.putIfAbsent(mUID, new ArrayList<>());
            ArrayList<Integer> users = newsChannelUsers.get(channelId);
            users.add(mUID);
        }
    }

    int offerNews(int mTime, int mNewsID, int mDelay, int mChannelID) {
        delayQueue.add(new NewsAlert(mNewsID, mTime + mDelay, mChannelID));
        return newsChannelUsers.get(mChannelID).size();
    }

    void cancelNews(int mTime, int mNewsID) {
        canceledAlert.add(mNewsID);
    }

    int checkUser(int mTime, int mUID, int mRetIDs[]) {
        sendAlert(mTime);
        ArrayList<NewsAlert> newsAlerts = userNewsAlert.get(mUID);

        PriorityQueue<NewsAlert> temp = new PriorityQueue<>(Comparator.reverseOrder());
        int cnt = 0;
        for (NewsAlert newsAlert : newsAlerts){
            if (canceledAlert.contains(newsAlert.id)) continue;

            temp.add(newsAlert);
            cnt++;
        }
        int i = 0;
        while (i < 3 && !temp.isEmpty()){
            mRetIDs[i++] = temp.poll().id;
        }
        newsAlerts.clear();

        return cnt;
    }

    void sendAlert(int mTime){
        while (!delayQueue.isEmpty() && delayQueue.peek().time <= mTime){
            NewsAlert newsAlert = delayQueue.poll();
            int channelId = newsAlert.channelId;

            if (canceledAlert.contains(newsAlert.id)) continue;

            for (Integer userid : newsChannelUsers.get(channelId)){
                ArrayList<NewsAlert> newsAlerts = userNewsAlert.get(userid);
                newsAlerts.add(newsAlert);
            }
        }
    }

    static class NewsAlert implements Comparable<NewsAlert>{
        int id;
        int time;
        int channelId;

        public NewsAlert(int id, int time, int channelId) {
            this.id = id;
            this.time = time;
            this.channelId = channelId;
        }

        @Override
        public int compareTo(NewsAlert o) {
            if (this.time != o.time)
                return this.time - o.time;
            return this.id - o.id;
        }
    }
}*/
