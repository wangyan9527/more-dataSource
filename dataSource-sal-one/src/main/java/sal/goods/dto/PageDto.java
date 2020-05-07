package sal.goods.dto;

import lombok.Data;

@Data
public class PageDto {

    private Integer pageSize;

    private Integer pageNum;

    private Integer totalPageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
