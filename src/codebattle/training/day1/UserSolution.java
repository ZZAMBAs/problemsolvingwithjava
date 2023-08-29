/*
package codebattle.training.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class UserSolution {
    HashMap<Integer, ArrayList<Stock>> sold;
    HashMap<Integer, Stock> stocks;
    HashMap<Integer, Product> products;

    public void init() {
        this.sold = new HashMap<>();
        this.stocks = new HashMap<>();
        this.products = new HashMap<>();
    }

    public int buy(int bId, int mProduct, int mPrice, int mQuantity) {
        Stock stock;
        products.putIfAbsent(mProduct, new Product());
        Product product = products.get(mProduct);

        if (stocks.get(bId) == null) {
            stock = new Stock(bId, mQuantity, mPrice, mProduct);
            stocks.put(bId, stock);
        }else{
            stock = stocks.get(bId);
            stock.quantity += mQuantity;
            stock.isCanceled = false;
        }
        product.stockPQ.add(stock);
        product.quantity += mQuantity;

        return product.quantity;
    }

    public int cancel(int bId) {
        Stock stock = stocks.get(bId);
        if (stock == null || stock.isCanceled || stock.firstBuyQuantity > stock.quantity)
            return -1;

        Product product = products.get(stock.mProduct);
        product.quantity -= stock.quantity;
        stock.quantity = 0;
        stock.isCanceled = true;

        return product.quantity;
    }

    public int sell(int sId, int mProduct, int mPrice, int mQuantity) {
        int ret = 0;
        Product product = products.get(mProduct);
        if (product.quantity < mQuantity)
            return -1;

        sold.putIfAbsent(sId, new ArrayList<>());
        ArrayList<Stock> soldStocks = sold.get(sId);
        PriorityQueue<Stock> pq = product.stockPQ;
        while (mQuantity > 0){
            Stock stock;
            while (pq.peek().isCanceled)
                pq.poll();
            stock = pq.peek();

            if (stock.quantity <= mQuantity){
                ret += (mPrice - stock.price) * stock.quantity;
                mQuantity -= stock.quantity;
                products.get(stock.mProduct).quantity -= stock.quantity;
                soldStocks.add(new Stock(stock.bId, stock.quantity, stock.price, stock.mProduct));
                stock.quantity = 0;
                pq.poll();
            }
            else{
                ret += (mPrice - stock.price) * mQuantity;
                products.get(stock.mProduct).quantity -= mQuantity;
                stock.quantity -= mQuantity;
                soldStocks.add(new Stock(stock.bId, mQuantity, stock.price, stock.mProduct));
                mQuantity = 0;
            }
        }

        return ret;
    }

    public int refund(int sId) {
        int ret = 0;
        ArrayList<Stock> soldStocks = sold.get(sId);
        if (soldStocks == null || soldStocks.isEmpty())
            return -1;
        for (Stock stock : soldStocks) {
            ret += stock.quantity;
            buy(stock.bId, stock.mProduct, stock.price, stock.quantity);
        }
        soldStocks.clear();
        return ret;
    }

    public static class Product{
        int quantity;
        PriorityQueue<Stock> stockPQ;

        public Product() {
            this.stockPQ = new PriorityQueue<>();
        }

        public Product(int quantity) {
            this.quantity = quantity;
            this.stockPQ = new PriorityQueue<>();
        }
    }

    public static class Stock implements Comparable<Stock>{
        int bId;
        int quantity;
        int price;
        int firstBuyQuantity;
        int mProduct;
        boolean isCanceled;

        public Stock(int bId, int quantity, int price, int mProduct) {
            this.bId = bId;
            this.quantity = this.firstBuyQuantity = quantity;
            this.price = price;
            this.mProduct = mProduct;
            this.isCanceled = false;
        }

        @Override
        public int compareTo(Stock o) {
            if (this.price == o.price)
                return Integer.compare(this.bId, o.bId);
            return Integer.compare(this.price, o.price);
        }
    }

}*/
