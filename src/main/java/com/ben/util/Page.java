package com.ben.util;

/**
 * @Title: Page.java Copyright: Copyright (c) 2013 Company:安融科技有限公司
 * @author tong 2013-4-1 下午12:35:17
 * @version V1.0
 */
public class Page implements java.io.Serializable {
    /** */
    private static final long serialVersionUID = 8997559113549468234L;
    /** 第几页,从1开始 */
    private int page;
    /** 每页的记录数 */
    private int rows;
    /** 按什么属性排 */
    private String sidx;
    /** <code>"asc"</code> or <code>"desc"</code> */
    private String sord;

    public Page() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

}
