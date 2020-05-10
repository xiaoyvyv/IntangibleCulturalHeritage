package com.blankj.mine;

import com.blankj.utilcode.util.GsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author svs:
 * @version 创建时间：2016-12-16 下午02:28:23
 * 类说明
 */
public class ListPageUtil {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        for(int i=1;i<7;i++){
            list.add(i);
        }
        List<List<Integer>> lists = splitList(list, 20);
        System.out.println("分页大小" + lists.size()+"\n\n"+ GsonUtils.toJson(lists));
    }

    public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
        int listSize = list.size();
        int page = (listSize + (pageSize - 1)) / pageSize;

        List<List<T>> listArray = new ArrayList<>();
        for (int i = 0; i < page; i++) {
            List<T> subList = new ArrayList<>();
            for (int j = 0; j < listSize; j++) {
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
                if (pageIndex == (i + 1)) {
                    subList.add(list.get(j));
                }
                if ((j + 1) == ((j + 1) * pageSize)) {
                    break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }


}