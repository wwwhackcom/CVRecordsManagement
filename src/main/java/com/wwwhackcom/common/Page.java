package com.wwwhackcom.common;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Page<E> implements Serializable {

    public static final int DEFAULT_PAGE_SIZE = 10;


    private int pageSize;

    private int start;

    private List<E> data;

    public int getStart() {
        return start;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }


    private long totalCount;

    public Page() {
        this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<E>());
    }

    public Page(int pageSize) {
        this(0, 0, pageSize, new ArrayList<E>());
    }

    public Page(int start, long totalSize, int pageSize, List<E> data) {
//        if (pageSize <= 0 || start < 0 || totalSize < 0) {
//            logger.error("pageSize <= 0 is " + (pageSize <= 0) + "\tstart < 0 is " + (start < 0) + "\ttotalSize < 0 is " + (totalSize < 0));
//            throw new BaseUncheckedException(ERR_MSG_KEY_ILLEGAL_ARGUMENTS, "Illegal Arguments to Initiate Page Object");
//        }
        this.pageSize = pageSize;
        this.start = start;
        this.totalCount = totalSize;
        this.data = data;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public long getTotalPageCount() {
        long pc = totalCount / pageSize;
        return totalCount % pageSize == 0 ? pc : pc + 1;
    }

    public int getPageSize() {
        return pageSize;
    }


    public void setResult(List<E> data) {
        this.data = data;
    }

    public List<E> getResult() {
        return data;
    }


    public int getCurrentPageNo() {
        return start / pageSize + 1;
    }


    public boolean hasNextPage() {
        return this.getCurrentPageNo() < this.getTotalPageCount();
    }

    public boolean hasPreviousPage() {
        return this.getCurrentPageNo() > 1;
    }

    public boolean isEmpty() {
        return data == null || data.isEmpty();
    }

    public int getStartIndex() {
        return (getCurrentPageNo() - 1) * pageSize;
    }

    public int getEndIndex() {
        int endIndex = getCurrentPageNo() * pageSize - 1;
        return endIndex >= totalCount ? (int) totalCount - 1 : endIndex;
    }

    protected static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    public static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }

}
