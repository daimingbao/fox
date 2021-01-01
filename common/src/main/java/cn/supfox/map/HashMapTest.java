package cn.supfox.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapTest {

    public static void main(String[] args) {
        Map map = new HashMap<HashMapKey, Integer>(5);
        HashMapKey hashMapKey = new HashMapKey();
        map.put(hashMapKey, 1);
        map.put(hashMapKey, 2);
        System.out.println(map.get(hashMapKey));
        System.out.println(hashMapKey.hashCode());
        hashMapKey.setId(2);
        System.out.println(hashMapKey.hashCode());
        System.out.println(map.get(hashMapKey));
    }

    public static class HashMapKey {
        private int id ;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object obj) {
//            if (obj == this) {
//                return true;
//            }

            return Objects.equals(((HashMapKey) obj).getId(), id);
        }
    }
}
