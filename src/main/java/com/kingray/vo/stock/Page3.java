package com.kingray.vo.stock;

/**
 * Created by YAN on 2014/7/25.
 */
public class Page3 {
    private static String DEFAUL_PAGE_SIZE = "50";
    private static String DEFAULT_PAGE_NATION = "true";
    private static String DEFAULT_START_PAGE = "1";
    private static String DEFAULT_SQL_ID = "COMMON_SSE_ZQPZ_GPLB_MCJS_SSAG_L";
    private String pageSize;//页面大小
//    private String jsonCallBack;//浏览器上jsonCallBack是时刻在变的，测试时jsonCallBack一直为null
    private String isPagenation;//page显示状态
    private String beginPage;//起始页面
    private String sqlId;//上海股票类型，分为四类：A股、B股

    public Page3(String pageSize, String isPagenation, String beginPage, String sqlId) {
        this.pageSize=pageSize;
        this.isPagenation =isPagenation;
        this.beginPage = beginPage;
        this.sqlId = sqlId;
    }
    public Page3(Page3 page){
        this.pageSize = page.pageSize;
        this.isPagenation = page.isPagenation;
        this.beginPage = page.beginPage;
        this.sqlId = page.sqlId;
    }
    public Page3(){
        this(DEFAUL_PAGE_SIZE,DEFAULT_PAGE_NATION,DEFAULT_START_PAGE,DEFAULT_SQL_ID);
    }
    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getIsPagenation() {
        return isPagenation;
    }

    public void setIsPagenation(String isPagenation) {
        this.isPagenation = isPagenation;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(String beginPage) {
        this.beginPage = beginPage;
    }


}
