package com.example.smartcity.pojo.library;

import java.util.List;

public class LibraryCommentData {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":"2022-04-20 15:46:56","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":36,"userId":1111134,"libraryId":10,"content":"真的很喜欢这个图书馆","myLikeState":false,"userName":"sudo"},{"searchValue":null,"createBy":null,"createTime":"2022-04-20 15:45:40","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":35,"userId":1111134,"libraryId":10,"content":"6666","myLikeState":false,"userName":"sudo"},{"searchValue":null,"createBy":null,"createTime":"2022-04-20 10:58:16","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":34,"userId":1111134,"libraryId":10,"content":"这个图书馆很不错, 我表示很喜欢.","myLikeState":false,"userName":"sudo"}]
     */

    private String msg;
    private int code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2022-04-20 15:46:56
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 36
         * userId : 1111134
         * libraryId : 10
         * content : 真的很喜欢这个图书馆
         * myLikeState : false
         * userName : sudo
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private int remark;
        private ParamsBean params;
        private int id;
        private int userId;
        private int libraryId;
        private String content;
        private boolean myLikeState;
        private String userName;

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

        public int getRemark() {
            return remark;
        }

        public void setRemark(int remark) {
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

        public int getLibraryId() {
            return libraryId;
        }

        public void setLibraryId(int libraryId) {
            this.libraryId = libraryId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public boolean isMyLikeState() {
            return myLikeState;
        }

        public void setMyLikeState(boolean myLikeState) {
            this.myLikeState = myLikeState;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public static class ParamsBean {
        }
    }
}
