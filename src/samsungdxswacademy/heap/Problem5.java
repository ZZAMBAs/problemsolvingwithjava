/*
package samsungdxswacademy.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem5 { // UserSolution 부분만.
    ArrayList<Post>[] userPosts;
    ArrayList<Integer>[] following;
    HashMap<Integer, Post> posts;

    public void init(int N) {
        this.userPosts = new ArrayList[N + 1];
        this.following = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            userPosts[i] = new ArrayList<>();
            following[i] = new ArrayList<>();
            following[i].add(i);
        }
        this.posts = new HashMap<>();
    }

    public void follow(int uID1, int uID2, int timestamp) {
        following[uID1].add(uID2);
    }

    public void makePost(int uID, int pID, int timestamp) {
        Post post = new Post(pID, timestamp);
        userPosts[uID].add(post);
        posts.put(pID, post);
    }

    public void like(int pID, int timestamp) {
        this.posts.get(pID).like++;
    }

    public void getFeed(int uID, int timestamp, int pIDList[]) {
        PriorityQueue<ForPQ> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int followId : following[uID]){
            for (Post p : userPosts[followId]){
                pq.add(new ForPQ(p, timestamp));
            }
        }
        int listIdx = 0;
        while (!pq.isEmpty() && listIdx < 10){
            pIDList[listIdx++] = pq.poll().post.pId;
        }

    }

    static class Post{
        int pId, like, timestamp;

        public Post(int pId, int timestamp) {
            this.pId = pId;
            this.like = 0;
            this.timestamp = timestamp;
        }

    }

    static class ForPQ implements Comparable<ForPQ>{
        Post post;
        int timestamp;

        public ForPQ(Post post, int timestamp) {
            this.post = post;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(ForPQ o) {
            if (this.timestamp - this.post.timestamp > 1000 && o.timestamp - o.post.timestamp <= 1000)
                return -1;
            if (this.timestamp - this.post.timestamp <= 1000 && o.timestamp - o.post.timestamp > 1000)
                return 1;
            if (this.timestamp - this.post.timestamp > 1000)
                return this.post.timestamp - o.post.timestamp;

            if (this.post.like != o.post.like)
                return this.post.like - o.post.like;
            return this.post.timestamp - o.post.timestamp;
        }
    }
}
*/
