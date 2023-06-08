package com.example.smartcity.pojo.housekeeping;

import java.util.List;

public class HPBannerData {


    /**
     * total : 3
     * rows : [{"searchValue":null,"createBy":"1","createTime":"2022-06-20 14:15:07","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"picUrl":"/prod-api/profile/upload/image/2022/06/20/fbe55291-6a34-4656-ae4c-0c78a5174a87.jpeg","relevancyType":0},{"searchValue":null,"createBy":"1","createTime":"2022-06-20 14:15:14","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"picUrl":"/prod-api/profile/upload/image/2022/06/20/3525f141-5337-4083-b1b8-9fa785035863.jpeg","relevancyType":0},{"searchValue":null,"createBy":"1","createTime":"2022-06-20 14:15:27","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"picUrl":"/prod-api/profile/upload/image/2022/06/20/7c17cbd8-975a-4dca-b07e-27c4dae7ebcd.jpeg","relevancyType":0}]
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
         * createBy : 1
         * createTime : 2022-06-20 14:15:07
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 13
         * picUrl : /prod-api/profile/upload/image/2022/06/20/fbe55291-6a34-4656-ae4c-0c78a5174a87.jpeg
         * relevancyType : 0
         */

        private Object searchValue;
        private String createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private String picUrl;
        private int relevancyType;

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

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public int getRelevancyType() {
            return relevancyType;
        }

        public void setRelevancyType(int relevancyType) {
            this.relevancyType = relevancyType;
        }

        public static class ParamsBean {
        }
    }
}
