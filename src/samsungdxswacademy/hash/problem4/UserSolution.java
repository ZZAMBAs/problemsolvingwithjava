/*
package samsungdxswacademy.hash.problem4;

import java.util.ArrayList;

class UserSolution {
    CustomHashMap[] dataHashMap;

    void InitDB() {
        dataHashMap = new CustomHashMap[5];
        for (int i = 0; i < 5; i++) {
            dataHashMap[i] = new CustomHashMap();
            dataHashMap[i].init();
        }
    }

    void Add(String name, String number, String birthday, String email, String memo) {
        Data newData = new Data(name, number, birthday, email, memo);
        for (int i = 0; i < 5; i++){
            switch (i){
                case 0: dataHashMap[i].insert(name, newData); break;
                case 1: dataHashMap[i].insert(number, newData); break;
                case 2: dataHashMap[i].insert(birthday, newData); break;
                case 3: dataHashMap[i].insert(email, newData); break;
                case 4: dataHashMap[i].insert(memo, newData); break;
            }
        }
    }

    int Delete(int field, String str) {
        int ret = 0;
        ArrayList<Data> deletedData = dataHashMap[field].search(str);
        for (Data d : deletedData){
            boolean sw = checkingCollision(field, str, d);
            if (!sw || d.isDeleted)
                continue;

            ret++;
            d.isDeleted = true;
        }

        return ret;
    }

    int Change(int field, String str, int changefield, String changestr) {
        ArrayList<Data> searched = dataHashMap[field].search(str);
        int ret = 0;

        String original = "";
        for (int i = searched.size() - 1; i >= 0; i--) {
            Data d = searched.get(i);
            boolean sw = checkingCollision(field, str, d);
            if (!sw || d.isDeleted)
                continue;

            ret++;
            switch (changefield){
                case 0: original = d.name; d.name = changestr; break;
                case 1: original = d.number; d.number = changestr; break;
                case 2: original = d.birthday; d.birthday = changestr; break;
                case 3: original = d.email; d.email = changestr; break;
                case 4: original = d.memo; d.memo = changestr; break;
            }

            dataHashMap[changefield].change(original, changestr, changefield);
        }

        return ret;
    }

    Solution.Result Search(int field, String str, int returnfield) {
        Solution.Result result = new Solution.Result();
        ArrayList<Data> searched = dataHashMap[field].search(str);

        for (Data d : searched) {
            boolean sw = checkingCollision(field, str, d);
            if (!sw || d.isDeleted)
                continue;

            result.count++;
            switch (returnfield) {
                case 0:
                    result.str = d.name;
                    break;
                case 1:
                    result.str = d.number;
                    break;
                case 2:
                    result.str = d.birthday;
                    break;
                case 3:
                    result.str = d.email;
                    break;
                case 4:
                    result.str = d.memo;
                    break;
            }
        }

        return result;
    }

    static boolean checkingCollision(int field, String str, Data d){
        switch (field) {
            case 0:
                if (str.equals(d.name))
                    return true;
                break;
            case 1:
                if (str.equals(d.number))
                    return true;
                break;
            case 2:
                if (str.equals(d.birthday))
                    return true;
                break;
            case 3:
                if (str.equals(d.email))
                    return true;
                break;
            case 4:
                if (str.equals(d.memo))
                    return true;
        }
        return false;
    }
    static int djb2(String s){
        int hash = 5381;
        for (int i = 0; i < s.length(); i++)
            hash = (hash << 5) + hash + s.charAt(i);
        return hash;
    }

    static class CustomHashMap{
        static int TABLE_SIZE = 50021;
        ArrayList<Data>[] hashTable;

        void init(){
            hashTable = new ArrayList[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++) {
                hashTable[i] = new ArrayList<>();
            }
        }

        void insert(String s, Data data){
            int idx = (djb2(s) & Integer.MAX_VALUE) % TABLE_SIZE;
            hashTable[idx].add(data);
        }

        ArrayList<Data> search(String s){
            int idx = (djb2(s) & Integer.MAX_VALUE) % TABLE_SIZE;
            return hashTable[idx];
        }

        void change(String original, String now, int field){
            int originalIdx = (djb2(original) & Integer.MAX_VALUE) % TABLE_SIZE;
            int nowIdx = (djb2(now) & Integer.MAX_VALUE) % TABLE_SIZE;

            int size = hashTable[originalIdx].size();
            for (int i = size - 1; i >= 0; i--) {
                Data d = hashTable[originalIdx].get(i);
                boolean sw = checkingCollision(field, now, d);
                if(!sw || d.isDeleted)
                    continue;

                hashTable[originalIdx].remove(i);
                hashTable[nowIdx].add(d);
            }
        }
    }

    static class Data{
        String name, number, birthday, email, memo;
        boolean isDeleted;

        public Data(String name, String number, String birthday, String email, String memo) {
            this.name = name;
            this.number = number;
            this.birthday = birthday;
            this.email = email;
            this.memo = memo;
            this.isDeleted = false;
        }
    }
}
*/
