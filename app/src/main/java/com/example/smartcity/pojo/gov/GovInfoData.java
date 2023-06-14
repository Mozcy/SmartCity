package com.example.smartcity.pojo.gov;

public class GovInfoData {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":null,"createTime":"2022-03-12 07:40:23","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"userId":1,"appealCategoryId":9,"title":"井盖丢失","content":"您好，育红小学学校门口附近的下水井井盖丢失，希望能赶紧处理一下，学生们上学放学很危险。","undertaker":"城管","state":"1","detailResult":"您好，我们已收到您的反馈，我们会尽快派相关人员前往维修","imgUrl":"/prod-api/profile/upload/image/2022/03/12/f7299b5e-c62f-4595-8d97-8bbc09bec439.jpeg","appealCategoryName":"市政维修"}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2022-03-12 07:40:23
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 10
         * userId : 1
         * appealCategoryId : 9
         * title : 井盖丢失
         * content : 您好，育红小学学校门口附近的下水井井盖丢失，希望能赶紧处理一下，学生们上学放学很危险。
         * undertaker : 城管
         * state : 1
         * detailResult : 您好，我们已收到您的反馈，我们会尽快派相关人员前往维修
         * imgUrl : /prod-api/profile/upload/image/2022/03/12/f7299b5e-c62f-4595-8d97-8bbc09bec439.jpeg
         * appealCategoryName : 市政维修
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
        private String detailResult;
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

        public String getDetailResult() {
            return detailResult;
        }

        public void setDetailResult(String detailResult) {
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
