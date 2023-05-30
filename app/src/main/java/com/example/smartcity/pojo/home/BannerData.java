package com.example.smartcity.pojo.home;

import java.util.List;

public class BannerData {

    /**
     * total : 6
     * rows : [{"searchValue":null,"createBy":"admin","createTime":"2021-05-06 15:40:17","updateBy":"1","updateTime":"2021-06-25 11:02:40","remark":null,"params":{},"id":25,"appType":"smart_city","status":"1","sort":2,"advTitle":"首页轮播","advImg":"/prod-api/profile/upload/image/2021/05/06/b9d9f081-8a76-41dc-8199-23bcb3a64fcc.png","servModule":"新闻详情","targetId":28,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2021-05-06 15:40:59","updateBy":"1111129","updateTime":"2021-06-25 11:02:51","remark":null,"params":{},"id":26,"appType":"smart_city","status":"1","sort":3,"advTitle":"首页轮播","advImg":"/prod-api/profile/upload/image/2021/05/06/e614cb7f-63b0-4cda-bf47-db286ea1b074.png","servModule":"新闻详情","targetId":29,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2021-05-06 15:41:20","updateBy":"1111129","updateTime":"2021-06-25 11:03:10","remark":null,"params":{},"id":27,"appType":"smart_city","status":"1","sort":4,"advTitle":"首页轮播","advImg":"/prod-api/profile/upload/image/2021/05/06/242e06f7-9fb0-4e16-b197-206f999c98f2.png","servModule":"新闻详情","targetId":30,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2022-06-21 08:56:38","updateBy":"1","updateTime":"2022-07-19 14:10:07","remark":null,"params":{},"id":34,"appType":"smart_city","status":"1","sort":5,"advTitle":"低代码技术","advImg":"/prod-api/profile/upload/image/2022/06/21/484d77ef-b2ce-4861-9d32-727f6be3079e.png","servModule":"新闻详情","targetId":264,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2022-06-21 08:56:53","updateBy":"1","updateTime":"2022-07-19 14:10:16","remark":null,"params":{},"id":35,"appType":"smart_city","status":"1","sort":6,"advTitle":"商务软件解决方案","advImg":"/prod-api/profile/upload/image/2022/06/21/16facfe3-64f1-4111-999a-9872bd87a44b.png","servModule":"新闻详情","targetId":265,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2022-06-21 08:57:05","updateBy":"1","updateTime":"2022-07-19 14:10:21","remark":null,"params":{},"id":36,"appType":"smart_city","status":"1","sort":7,"advTitle":"移动应用开发","advImg":"/prod-api/profile/upload/image/2022/06/21/76093837-7f8a-4c7b-a343-f540412f064a.png","servModule":"新闻详情","targetId":266,"type":"2"}]
     * code : 200
     * msg : 查询成功
     */

    private int total;
    private int code;
    private String msg;
    private List<RowsBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * searchValue : null
         * createBy : admin
         * createTime : 2021-05-06 15:40:17
         * updateBy : 1
         * updateTime : 2021-06-25 11:02:40
         * remark : null
         * params : {}
         * id : 25
         * appType : smart_city
         * status : 1
         * sort : 2
         * advTitle : 首页轮播
         * advImg : /prod-api/profile/upload/image/2021/05/06/b9d9f081-8a76-41dc-8199-23bcb3a64fcc.png
         * servModule : 新闻详情
         * targetId : 28
         * type : 2
         */

        private Object searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private String appType;
        private String status;
        private int sort;
        private String advTitle;
        private String advImg;
        private String servModule;
        private int targetId;
        private String type;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getAdvTitle() {
            return advTitle;
        }

        public void setAdvTitle(String advTitle) {
            this.advTitle = advTitle;
        }

        public String getAdvImg() {
            return advImg;
        }

        public void setAdvImg(String advImg) {
            this.advImg = advImg;
        }

        public String getServModule() {
            return servModule;
        }

        public void setServModule(String servModule) {
            this.servModule = servModule;
        }

        public int getTargetId() {
            return targetId;
        }

        public void setTargetId(int targetId) {
            this.targetId = targetId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public static class ParamsBean {
        }
    }
}
