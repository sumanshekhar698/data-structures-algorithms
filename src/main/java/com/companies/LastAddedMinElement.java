package com.companies;

import java.util.ArrayList;
import java.util.List;

public class LastAddedMinElement {

    public static void main(String[] args) {
        CustomList cList = new CustomList();
        cList.addNum(6);
        cList.addNum(5);
        cList.addNum(4);
        cList.addNum(3);
        cList.addNum(2);
        cList.addNum(1);
        cList.addNum(8);
        cList.addNum(7);
        cList.addNum(10);

        for (int i = 1; i <= 6; i++) {
            System.out.println(cList.viewMin());
            cList.removeLastNum();
        }
    }


}

class CustomList {

    List<Integer> list;
    List<Integer> prefixSmallestTrackList;
    //4 7 2 8 0

    CustomList() {
        this.list = new ArrayList();
        this.prefixSmallestTrackList = new ArrayList();
    }

    void addNum(int num) {
        list.add(num);

        if (prefixSmallestTrackList.isEmpty())
            prefixSmallestTrackList.add(num);
        else
            prefixSmallestTrackList.add(Integer.min(num, prefixSmallestTrackList.get(prefixSmallestTrackList.size() - 1)));

    }

    int removeLastNum() {
        prefixSmallestTrackList.remove(prefixSmallestTrackList.size() - 1);
        return list.remove(list.size() - 1);


    }


    int viewMin() {
        return prefixSmallestTrackList.get(prefixSmallestTrackList.size() - 1);
    }

    int viewLastNum() {
        if (!list.isEmpty())
            return list.get(list.size() - 1);
        return -1;
    }


}
