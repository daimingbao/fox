package cn.supfox.rest;

import com.google.common.collect.Lists;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;

import java.util.*;

public class GetParamMultiValueMap<K,V> implements MultiValueMap<K, V> {


    private final Map<K, List<V>> map;

    public GetParamMultiValueMap(Map<K, V> paramMap) {
        Assert.notNull(paramMap, "'map' must not be null");

        this.map = new HashMap<>();
        paramMap.forEach((k, v) -> {
            if (v instanceof  List) {
                map.put(k, (List<V>) v);
            } else {
                map.put(k, Lists.newArrayList(v));
            }
        });
    }

    @Override
    @Nullable
    public V getFirst(K key) {
        List<V> values = this.map.get(key);
        return (values != null ? values.get(0) : null);
    }

    @Override
    public void add(K key, @Nullable V value) {
        List<V> values = this.map.computeIfAbsent(key, k -> new LinkedList<>());
        values.add(value);
    }

    @Override
    public void addAll(K key, List<? extends V> values) {
        List<V> currentValues = this.map.computeIfAbsent(key, k -> new LinkedList<>());
        currentValues.addAll(values);
    }

    @Override
    public void addAll(MultiValueMap<K, V> values) {
        for (Entry<K, List<V>> entry : values.entrySet()) {
            addAll(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void set(K key, @Nullable V value) {
        List<V> values = new LinkedList<>();
        values.add(value);
        this.map.put(key, values);
    }

    @Override
    public void setAll(Map<K, V> values) {
        values.forEach(this::set);
    }

    @Override
    public Map<K, V> toSingleValueMap() {
        LinkedHashMap<K, V> singleValueMap = new LinkedHashMap<>(this.map.size());
        this.map.forEach((key, value) -> singleValueMap.put(key, value.get(0)));
        return singleValueMap;
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    @Override
    public List<V> get(Object key) {
        return this.map.get(key);
    }

    @Override
    public List<V> put(K key, List<V> value) {
        return this.map.put(key, value);
    }

    @Override
    public List<V> remove(Object key) {
        return this.map.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends List<V>> map) {
        this.map.putAll(map);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public Set<K> keySet() {
        return this.map.keySet();
    }

    @Override
    public Collection<List<V>> values() {
        return this.map.values();
    }

    @Override
    public Set<Entry<K, List<V>>> entrySet() {
        return this.map.entrySet();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return this.map.equals(other);
    }

    @Override
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override
    public String toString() {
        return this.map.toString();
    }
}
