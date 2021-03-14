package com.lzc.pojo;

/**
 * @author : Lzc
 * @Class : SelectCondition
 * @description : ��ѯ����
 * @date : 2021-03-13 20:54
 */
public class SelectCondition {

    int page;
    int limit;
    String name;
    String sort;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void caculateStart() {
        // ����������50�����ܹ���5�����ģ���ô���һҳ�Ŀ�ʼ����45
        this.setPage((this.getPage()-1)*this.getLimit());

    }

    @Override
    public String toString() {
        return "SelectCondition{" +
                "page=" + page +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
