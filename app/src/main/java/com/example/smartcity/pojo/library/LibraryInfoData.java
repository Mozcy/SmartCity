package com.example.smartcity.pojo.library;

public class LibraryInfoData {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"name":"贵港市图书馆","address":"广西壮族自治区贵港市港北区民主路185号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/3971d94c-68ee-4744-8ae0-3c1b66aa953e.jpeg","mapUrl":"/dev-api/profile/upload/image/2022/03/13/1c01fdfc-7bd7-4ded-aaa5-6c5a095e485c.png","businessHours":"每天 09:00-21:00","businessState":"1","description":"贵港市图书馆座落于贵港市行政中心背后的文华街与民主路的交叉点,占地面积10亩,于2018年4月被中华人民共和国文化部评估定级为国家一级公共图书馆。"}
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
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 10
         * name : 贵港市图书馆
         * address : 广西壮族自治区贵港市港北区民主路185号
         * imgUrl : /prod-api/profile/upload/image/2022/03/13/3971d94c-68ee-4744-8ae0-3c1b66aa953e.jpeg
         * mapUrl : /dev-api/profile/upload/image/2022/03/13/1c01fdfc-7bd7-4ded-aaa5-6c5a095e485c.png
         * businessHours : 每天 09:00-21:00
         * businessState : 1
         * description : 贵港市图书馆座落于贵港市行政中心背后的文华街与民主路的交叉点,占地面积10亩,于2018年4月被中华人民共和国文化部评估定级为国家一级公共图书馆。
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private String name;
        private String address;
        private String imgUrl;
        private String mapUrl;
        private String businessHours;
        private String businessState;
        private String description;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getMapUrl() {
            return mapUrl;
        }

        public void setMapUrl(String mapUrl) {
            this.mapUrl = mapUrl;
        }

        public String getBusinessHours() {
            return businessHours;
        }

        public void setBusinessHours(String businessHours) {
            this.businessHours = businessHours;
        }

        public String getBusinessState() {
            return businessState;
        }

        public void setBusinessState(String businessState) {
            this.businessState = businessState;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public static class ParamsBean {
        }
    }
}
