package codebattle.training.day12;
// 아래는 STL 사용 및 Union-Find를 사용하지 않은 풀이이다. 힙을 직접 구현하고 Union-find까지 사용하면 더 빠른 실행시간이 나온다.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class UserSolution {
    static int[] hotelBrands;
    ArrayList<ArrayList<Pair>> adj;

    static class Pair implements Comparable<Pair>{
        int weight, dest;

        public Pair(int weight, int dest) {
            this.weight = weight;
            this.dest = dest;
        }

        @Override
        public int compareTo(Pair p){
            if (this.weight != p.weight)
                return this.weight - p.weight;
            return this.dest - p.dest;
        }
    }

    void init(int N, int mBrands[]) {
        hotelBrands = new int[N];
        adj = new ArrayList<>(N);
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < mBrands.length; i++)
            hotelBrands[i] = mBrands[i];
    }

    void connect(int mHotelA, int mHotelB, int mDistance) {
        adj.get(mHotelA).add(new Pair(mDistance, mHotelB));
        adj.get(mHotelB).add(new Pair(mDistance, mHotelA));
    }

    int merge(int mHotelA, int mHotelB) {
        int ret = 0;
        int brandA = hotelBrands[mHotelA];
        int brandB = hotelBrands[mHotelB];
        for (int i = 0; i < hotelBrands.length; i++){
            if (hotelBrands[i] == brandA)
                ret++;
            else if (hotelBrands[i] == brandB) {
                hotelBrands[i] = brandA;
                ret++;
            }
        }
        return ret;
    }

    int move(int mStart, int mBrandA, int mBrandB) {
        int ret = 0, cnt = 0;
        int[] dist = new int[hotelBrands.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(mBrandA, 1);
        if (mBrandB == mBrandA)
            map.replace(mBrandA, map.get(mBrandA) + 1);
        else
            map.put(mBrandB, 1);

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Pair(0, mStart));
        while (!priorityQueue.isEmpty() && cnt != 2){
            Pair front = priorityQueue.poll();
            if(front.weight > dist[front.dest])
                continue;

            if (mStart != front.dest){
                int destBrand = hotelBrands[front.dest];
                Integer mappedNum = map.get(destBrand);

                if (mappedNum != null && mappedNum != 0){
                    cnt++;
                    ret += front.weight;
                    map.replace(destBrand, map.get(destBrand) - 1);
                }
            }

            for (Pair p : adj.get(front.dest)){
                int w = front.weight + p.weight;

                if (w < dist[p.dest]){
                    dist[p.dest] = w;
                    priorityQueue.add(new Pair(w, p.dest));
                }
            }
        }

        return ret;
    }
}