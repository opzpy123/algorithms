package cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU（least recently used）
 * 最近最少使用，首先淘汰最长时间未被使用的页面。
 * @param <k>
 * @param <v>
 */
public class LRU<k, v> extends LinkedHashMap<k, v> {

    private final int MAX_SIZE;

    public LRU(int capcity) {
        super(8, 0.75f,true);
        this.MAX_SIZE = capcity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        if (size() > MAX_SIZE) {
            System.out.println("移除的元素为：" + eldest.getValue());
        }
        return size() > MAX_SIZE;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new LRU<>(5);
        for (int i = 1; i <= 11; i++) {
            map.put(i, i);
            System.out.println("cache的容量为：" + map.size());
            if (i == 4) {
                map.get(1);
            }
        }

        System.out.println("=-=-=-=-=-=-=-map元素:");
        map.forEach((key, value) -> System.out.println(value));

    }

}
