package com.example.smartcity.pojo.sport;

import java.util.List;

public class SportLabelData {

    /**
     * total : 12
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2022-03-25 14:17:06","updateBy":null,"updateTime":"2022-06-20 14:30:48","remark":null,"params":{},"id":1,"sportMenu":"篮球","iconUrl":"/prod-api/profile/upload/image/2022/06/20/ca3868b7-bff6-49d1-9077-7feafaf55a49.png"},{"searchValue":null,"createBy":null,"createTime":"2022-03-25 14:22:16","updateBy":null,"updateTime":"2022-06-20 14:31:45","remark":null,"params":{},"id":2,"sportMenu":"乒乓球","iconUrl":"/prod-api/profile/upload/image/2022/06/20/9eed969b-9917-4e9a-912c-41da7b1ce3cb.png"},{"searchValue":null,"createBy":null,"createTime":"2022-03-25 14:22:29","updateBy":null,"updateTime":"2022-06-20 14:31:13","remark":null,"params":{},"id":3,"sportMenu":"足球","iconUrl":"/prod-api/profile/upload/image/2022/06/20/8d3e6813-807e-4fef-bad9-d21d7c78debe.png"},{"searchValue":null,"createBy":null,"createTime":"2022-03-25 14:22:36","updateBy":null,"updateTime":"2022-06-20 14:29:29","remark":null,"params":{},"id":4,"sportMenu":"羽毛球","iconUrl":"/prod-api/profile/upload/image/2022/06/20/8b80132e-22ba-462d-9fe1-fc1f312ea352.png"},{"searchValue":null,"createBy":null,"createTime":"2022-06-20 11:55:12","updateBy":null,"updateTime":"2022-06-20 14:30:00","remark":null,"params":{},"id":5,"sportMenu":"游泳","iconUrl":"/prod-api/profile/upload/image/2022/06/20/62b9fd5c-a151-4ca1-ac30-e7ba5495b989.png"},{"searchValue":null,"createBy":null,"createTime":"2022-06-20 11:55:18","updateBy":null,"updateTime":"2022-06-20 14:30:24","remark":null,"params":{},"id":6,"sportMenu":"格斗","iconUrl":"/prod-api/profile/upload/image/2022/06/20/12e3e41d-0133-40b0-a6d6-ac736ae36106.png"},{"searchValue":null,"createBy":null,"createTime":"2022-06-20 14:31:53","updateBy":null,"updateTime":"2022-06-20 14:32:11","remark":null,"params":{},"id":7,"sportMenu":"瑜伽","iconUrl":"/prod-api/profile/upload/image/2022/06/20/b59676f3-ec2e-474c-82ea-0176da086f26.png"},{"searchValue":null,"createBy":null,"createTime":"2022-06-20 14:32:19","updateBy":null,"updateTime":"2022-06-20 14:32:49","remark":null,"params":{},"id":8,"sportMenu":"马术","iconUrl":"/prod-api/profile/upload/image/2022/06/20/95e54f0d-0fd3-4179-9783-b981ee9d97b1.png"},{"searchValue":null,"createBy":null,"createTime":"2022-06-20 15:32:17","updateBy":null,"updateTime":"2022-06-20 15:32:39","remark":null,"params":{},"id":9,"sportMenu":"网球","iconUrl":"/prod-api/profile/upload/image/2022/06/20/0ba642f4-91fb-4da6-afae-b53694e54308.png"},{"searchValue":null,"createBy":null,"createTime":"2022-06-20 15:33:14","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"sportMenu":"台球","iconUrl":"/prod-api/profile/upload/image/2022/06/20/32b6db34-f793-4817-98b3-ae398f881313.png"},{"searchValue":null,"createBy":null,"createTime":"2022-06-20 15:33:51","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"sportMenu":"排球","iconUrl":"/prod-api/profile/upload/image/2022/06/20/f4c83c02-22ec-418a-b970-de8318d9d495.png"},{"searchValue":null,"createBy":null,"createTime":"2022-06-20 15:35:38","updateBy":null,"updateTime":"2022-06-20 15:35:57","remark":null,"params":{},"id":12,"sportMenu":"长跑","iconUrl":"/prod-api/profile/upload/image/2022/06/20/c19e8713-ec4a-4721-996f-55b46816268b.png"}]
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
         * createTime : 2022-03-25 14:17:06
         * updateBy : null
         * updateTime : 2022-06-20 14:30:48
         * remark : null
         * params : {}
         * id : 1
         * sportMenu : 篮球
         * iconUrl : /prod-api/profile/upload/image/2022/06/20/ca3868b7-bff6-49d1-9077-7feafaf55a49.png
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private String updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private String sportMenu;
        private String iconUrl;

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

        public String getSportMenu() {
            return sportMenu;
        }

        public void setSportMenu(String sportMenu) {
            this.sportMenu = sportMenu;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public static class ParamsBean {
        }
    }
}
