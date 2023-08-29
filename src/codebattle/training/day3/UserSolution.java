package codebattle.training.day3;
 // 25개 테스트케이스에 대해 2초가 걸린다. Pro 시험은 50개의 테스트케이스를 시험하므로 많이 위험하다. 최적화를 해야한다.
 // 비용 계산 시, 비용에 대한 간선을 최저 비용 한개만 남기도록 하자.
 // 더 시간을 줄이고 싶다면 힙(PriorityQueue)도 직접 구현한다.
import java.util.ArrayList;
import java.util.PriorityQueue;

class UserSolution {
    ArrayList<Edge>[] edges;
    int n;

    public void init(int N) {
        this.n = N;
        edges = new ArrayList[N];
        for (int i = 0; i < edges.length; i++)
            edges[i] = new ArrayList<>();
    }

    public void add(int mStartAirport, int mEndAirport, int mStartTime, int mTravelTime, int mPrice) {
        edges[mStartAirport].add(new Edge(mEndAirport, mStartTime, mTravelTime, mPrice));
    }

    public int minTravelTime(int mStartAirport, int mEndAirport, int mStartTime) {
        int[] travelTimes = new int[n];
        for (int i = 0; i < n; i++)
            travelTimes[i] = Integer.MAX_VALUE;

        PriorityQueue<Pair<Edge>> pq = new PriorityQueue<>();
        travelTimes[mStartAirport] = mStartTime;
        pq.add(new Pair<>(mStartTime, new Edge(mStartAirport, mStartTime, 0, 0)));
        while (!pq.isEmpty()){
            Pair<Edge> front = pq.poll();
            int curTime = front.num;
            Edge curEdge = front.data;
            if (curEdge.endAirport == mEndAirport)
                return curTime - mStartTime;

            for(Edge e : edges[curEdge.endAirport]) {
                int nextNum = curTime + timeDiff(curTime, e.startTime) + e.travelTime;
                if (travelTimes[e.endAirport] > nextNum) {
                    travelTimes[e.endAirport] = nextNum;
                    pq.add(new Pair<>(nextNum, e));
                }
            }
        }
        return -1;
    }

    public int minPrice(int mStartAirport, int mEndAirport) {
        int[] price = new int[n];
        for (int i = 0; i < n; i++)
            price[i] = Integer.MAX_VALUE;

        PriorityQueue<Pair<Edge>> pq = new PriorityQueue<>();
        pq.add(new Pair<>(0, new Edge(mStartAirport, 0, 0, 0)));
        while (!pq.isEmpty()){
            Pair<Edge> front = pq.poll();
            int curPrice = front.num;
            Edge curEdge = front.data;
            if (curEdge.endAirport == mEndAirport)
                return curPrice;

            for (Edge e : edges[curEdge.endAirport]) {
                int nextPrice = curPrice + e.price;
                if (price[e.endAirport] > nextPrice) {
                    price[e.endAirport] = nextPrice;
                    pq.add(new Pair<>(nextPrice, e));
                }
            }
        }
        return -1;
    }

    public int timeDiff(int t1, int t2){
        while (t2 < t1)
            t2 += 24;
        return t2 -t1;
    }

    public static class Edge {
        int endAirport;
        int startTime;
        int travelTime;
        int price;

        public Edge(int endAirport, int startTime, int travelTime, int price) {
            this.endAirport = endAirport;
            this.startTime = startTime;
            this.travelTime = travelTime;
            this.price = price;
        }
    }

    public static class Pair<T> implements Comparable<Pair<T>>{
        int num;
        T data;

        public Pair(int num, T data) {
            this.num = num;
            this.data = data;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.num, o.num);
        }
    }
}
