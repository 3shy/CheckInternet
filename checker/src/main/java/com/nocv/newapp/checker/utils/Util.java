package com.nocv.newapp.checker.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Util {
    private Util() {
    }

    public static <T> List<T> getSnapshot(Collection<T> other) {
        // toArray creates a new ArrayList internally and this way we can guarantee entries will not
        // be null. See #322.
        List<T> result = new ArrayList<>(other.size());
        for (T item : other) {
            result.add(item);
        }
        return result;
    }
}