package entity;

import com.pinyougou.pojo.TbBrand;


import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable{

    public long total; //数据总数
    public List rows; //当前页内容

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
