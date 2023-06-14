package com.example.smartcity.pojo.gov;

import java.util.List;

public class GovListData {

    /**
     * total : 2
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2022-03-12 07:41:28","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"userId":1,"appealCategoryId":10,"title":"路灯损坏","content":"您好，火炬路和黄浦路的交汇处红绿灯已经有两天没有亮了，请相关部门处理一下","undertaker":"交通部门","state":"0","detailResult":null,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/714e8318-988d-4b0b-9731-cf0ff4dbbdac.jpeg","appealCategoryName":"道路设施"},{"searchValue":null,"createBy":null,"createTime":"2022-03-12 07:42:48","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"userId":1,"appealCategoryId":10,"title":"路灯问题","content":"您好，我发现东快路香炉礁出口附近的红绿灯所有的灯全部都凉了，不知道是什么原因，请检修一下","undertaker":"交通部门","state":"1","detailResult":"收到，我们会尽快安排相关技术人员进行处理。","imgUrl":"/prod-api/profile/upload/image/2022/03/12/b1f76c88-79f6-47c5-9790-6b28d9a20d1b.jpg","appealCategoryName":"道路设施"}]
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
         * createBy : null
         * createTime : 2022-03-12 07:41:28
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 11
         * userId : 1
         * appealCategoryId : 10
         * title : 路灯损坏
         * content : 您好，火炬路和黄浦路的交汇处红绿灯已经有两天没有亮了，请相关部门处理一下
         * undertaker : 交通部门
         * state : 0
         * detailResult : null
         * imgUrl : /prod-api/profile/upload/image/2022/03/12/714e8318-988d-4b0b-9731-cf0ff4dbbdac.jpeg
         * appealCategoryName : 道路设施
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private int userId;
        private int appealCategoryId;
        private String title;
        private String content;
        private String undertaker;
        private String state;
        private Object detailResult;
        private String imgUrl;
        private String appealCategoryName;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
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

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getAppealCategoryId() {
            return appealCategoryId;
        }

        public void setAppealCategoryId(int appealCategoryId) {
            this.appealCategoryId = appealCategoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUndertaker() {
            return undertaker;
        }

        public void setUndertaker(String undertaker) {
            this.undertaker = undertaker;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Object getDetailResult() {
            return detailResult;
        }

        public void setDetailResult(Object detailResult) {
            this.detailResult = detailResult;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getAppealCategoryName() {
            return appealCategoryName;
        }

        public void setAppealCategoryName(String appealCategoryName) {
            this.appealCategoryName = appealCategoryName;
        }

        public static class ParamsBean {
        }
    }
}
