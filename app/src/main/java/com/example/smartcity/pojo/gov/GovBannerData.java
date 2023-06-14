package com.example.smartcity.pojo.gov;

import java.util.List;

public class GovBannerData {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":5,"title":"打通业务流、数据流\u201c最后一公里\u201d \u201c一线通达\u201d引发热线\u201c数治新变革\u201d","sort":1,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/b7dc5d2a-feb2-4b4b-97cc-a7f853f49476.jpeg"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":6,"title":"市司法局赴12345市民热线办开展调研座谈","sort":2,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/f7881a0d-45fd-4d48-84c2-64edd7415adf.jpeg"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":7,"title":"\u201c生态环境局长接热线\u201d活动连续第七年启动","sort":3,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/708b1ae8-5030-47dc-8eaa-c75345dd6d8a.jpeg"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":8,"title":"群策群力抓落实 联防联控战疫情","sort":null,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/a7c0a787-c82d-4dbe-b5af-948a597226d4.jpeg"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"title":"一条解忧热线：倾听、答疑，开掘\u201c民意金矿\u201d","sort":5,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/b24dc9ee-c0f7-4529-846a-a76df5a964d2.jpeg"}]
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
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 5
         * title : 打通业务流、数据流“最后一公里” “一线通达”引发热线“数治新变革”
         * sort : 1
         * imgUrl : /prod-api/profile/upload/image/2022/03/12/b7dc5d2a-feb2-4b4b-97cc-a7f853f49476.jpeg
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private String title;
        private int sort;
        private String imgUrl;

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

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public static class ParamsBean {
        }
    }
}
