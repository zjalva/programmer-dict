package com.ben.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页类
 * 
 * @author David
 * 
 * @param <E>
 *            实体泛型
 */
public class Pagination<E> implements Serializable {

	private static final long serialVersionUID = -7537767838766955930L;
	private int page;// 当前页数
    private int pageSize; // 每页包含的记录数
    private int record;// 记录总数
    private List<E> result;// 记录列表

    public Pagination() {
    }

    public Pagination(int page, int pageSize, int record, List<E> result) {
        this.page = page;
        this.pageSize = pageSize;
        this.record = record;
        this.result = result;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    /**
     * 计算总页数
     * 
     * @return 总页数
     */
    public int getTotal() {
        return (int) Math.ceil((double) record / (double) getPageSize());
    }

    public List<E> getResult() {
        return result;
    }

    public void setResult(List<E> result) {
        this.result = result;
    }
}
