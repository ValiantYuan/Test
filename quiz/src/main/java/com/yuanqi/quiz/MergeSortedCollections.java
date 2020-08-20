package com.yuanqi.quiz;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author : yuanqi
 */
public class MergeSortedCollections {
    private static MergeSortedCollections instance = new MergeSortedCollections();

    /**
     * to simplify the question, I specify the collection as ArrayList
     * and it is sorted in the ascending way
     */
    public <T extends Comparable<T>> List<T> merge(List<T> collectionA,
                                                   List<T> collectionB) {
        // special cases
        if (null == collectionA || collectionA.isEmpty()) {
            return collectionB;
        }
        if (null == collectionB || collectionB.isEmpty()) {
            return collectionA;
        }
        // compare and generate new collections
        int sizeA = collectionA.size();
        int sizeB = collectionB.size();
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0, indexA = 0, indexB = 0; indexA < sizeA || indexB < sizeB; i++) {
            if (indexA == sizeA) {
                result.add(i, collectionB.get(indexB++));
            } else if (indexB == sizeB) {
                result.add(i, collectionA.get(indexA++));
            } else if (collectionA.get(indexA).compareTo(collectionB.get(indexB)) >= 0) {
                result.add(i, collectionB.get(indexB++));
            } else {
                result.add(i, collectionA.get(indexA++));
            }
        }
        return result;
    }

    @Test
    public void normalCase() {
        List<Integer> list1 = Arrays.asList(1, 12, 23, 121);
        List<Integer> list2 = Arrays.asList(11, 22, 24, 111);
        List<Integer> expected = Arrays.asList(1, 11, 12, 22, 23, 24, 111, 121);
        List<Integer> actual = instance.merge(list1, list2);
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void emptyCase() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = Arrays.asList(11, 22, 24, 111);
        List<Integer> expected = list2;
        List<Integer> actual = instance.merge(list1, list2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nullCase() {
        List<Integer> list1 = null;
        List<Integer> list2 = null;
        List<Integer> expected = null;
        List<Integer> actual = instance.merge(list1, list2);
        Assert.assertEquals(expected, actual);
    }


}
