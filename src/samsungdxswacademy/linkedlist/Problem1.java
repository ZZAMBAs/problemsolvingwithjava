/*
package samsungdxswacademy.linkedlist;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, x, y;
        String original, cmd, s;
        for (int i = 1; i <= 10; i++){
            N = sc.nextInt();
            SinglyLinkedList list = new SinglyLinkedList();
            for (int j = 0; j < N; j++){
                original = sc.next();
                list.insert(original);
            }
            M = sc.nextInt();
            for (int j = 0; j < M; j++){
                cmd = sc.next();
                if (cmd.equals("I")){
                    x = sc.nextInt();
                    y = sc.nextInt();
                    list.move(x);
                    while (y-- > 0){
                        s = sc.next();
                        list.insert(s);
                    }
                }else if (cmd.equals("A")){
                    y = sc.nextInt();
                    while (y-- > 0){
                        s = sc.next();
                        list.append(s);
                    }
                }else{ // D
                    x = sc.nextInt();
                    y = sc.nextInt();
                    list.move(x);
                    while (y-- > 0)
                        list.delete();
                }
            }
            System.out.print("#" + i + " ");
            list.print();
        }
    }

    static class Node{
        String data;
        Node nextNode;
    }

    static class SinglyLinkedList{
        Node head, tail, nowNode;

        public SinglyLinkedList() {
            this.head = new Node();
            this.tail = new Node();
            head.nextNode = tail;
            this.nowNode = head;
        }

        void move(int x){
            nowNode = head;
            while (x-- > 0)
                nowNode = nowNode.nextNode;
        }

        void moveToTailBefore(){
            while (nowNode.nextNode != tail)
                nowNode = nowNode.nextNode;
        }

        void insert(String newData){ // 삽입하려는 노드에서
            Node newNode = new Node();
            newNode.data = newData;
            newNode.nextNode = nowNode.nextNode;
            nowNode.nextNode = newNode;
            nowNode = newNode;
        }

        void delete(){ // 삭제 전 노드에서
            if(nowNode.nextNode == tail)
                return;
            Node delNode = nowNode.nextNode;
            nowNode.nextNode = delNode.nextNode;
            delNode.nextNode = null;
        }

        void append(String newData){
            moveToTailBefore();
            insert(newData);
        }

        void print(){
            nowNode = head.nextNode;
            for (int i = 0; i < 10; i++){
                System.out.print(nowNode.data + " ");
                nowNode = nowNode.nextNode;
            }
            System.out.println();
        }
    }
}
*/
