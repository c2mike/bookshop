package Dao;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
    private int currentpagenum;
    private int startnum;
    private int endnum;
    private int pagesize = 2;
    private int totalcount;
    private int totalpage;
    List<T> data = new ArrayList<T>();

    public Page(int currentpagenum, int totalpage,List<T> data) {
    this.currentpagenum = currentpagenum;
    this.totalcount = totalpage;
    this.totalpage = totalcount%pagesize==0?totalcount/pagesize:totalcount/pagesize+1;
    this.data = data;
    if(currentpagenum==1)
    {
        startnum = 1;
        endnum = 5 > this.totalpage ? this.totalpage:5;
    }
    else
    {
        startnum = this.currentpagenum - 2 > 1? this.currentpagenum -2:1;
        endnum = this.currentpagenum+2>this.totalpage?this.totalpage:this.currentpagenum+2;
    }
    }

    public int getCurrentpagenum() {
        return currentpagenum;
    }

    public void setCurrentpagenum(int currentpagenum) {
        this.currentpagenum = currentpagenum;
    }

    public int getStartnum() {
        return startnum;
    }

    public void setStartnum(int startnum) {
        this.startnum = startnum;
    }

    public int getEndnum() {
        return endnum;
    }

    public void setEndnum(int endnum) {
        this.endnum = endnum;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
