package com.lzc.pojo;

/**
 * @author : Lzc
 * @Class : ListData
 * @description : TODO
 * @date : 2021-03-14 0:03
 */
public class ListData {
    int total;
    Object list;

    public ListData(Object object, int total) {
        this.total = total;
        this.list = object;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ListData{" +
                "total=" + total +
                ", object=" + list +
                '}';
    }
}
