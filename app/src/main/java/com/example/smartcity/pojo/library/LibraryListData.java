package com.example.smartcity.pojo.library;

import java.util.List;

public class LibraryListData {

    /**
     * total : 50
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"name":"贵港市图书馆","address":"广西壮族自治区贵港市港北区民主路185号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/3971d94c-68ee-4744-8ae0-3c1b66aa953e.jpeg","mapUrl":"","businessHours":"每天 09:00-21:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"贺州市图书馆","address":" 贺州市八步区八步镇体育路67号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/60380c09-2098-4258-a584-85e99109980e.jpeg","mapUrl":"","businessHours":"周一至周四,周六至周日 08:30-17:30","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"name":"长沙图书馆","address":"新河三角洲滨江文化园","imgUrl":"/prod-api/profile/upload/image/2022/03/13/0157758f-f206-467c-9bed-6c40a6290789.jpeg","mapUrl":"","businessHours":"周二至周六 09:00-21:00 周日 09:00-17:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"name":"普宁市图书馆","address":"流沙西街道广南路教育局西100米","imgUrl":"/prod-api/profile/upload/image/2022/03/13/1ecfaaa9-0bc7-403f-8562-3573866790af.jpeg","mapUrl":"","businessHours":"工作日08:00-15:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"name":"潮州市潮安区图书馆","address":" 潮州市潮安区庵埠镇廉泉街4号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/50f0f872-2908-4f8f-97bb-0ca785d61f33.jpeg","mapUrl":"","businessHours":"工作日08:00-18:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"name":"云浮市图书馆","address":"云浮市云城区世纪大道中(市政府旁边)","imgUrl":"/prod-api/profile/upload/image/2022/03/13/9935ba69-a24a-46bb-90e1-a3190a60be45.jpeg","mapUrl":"","businessHours":"每天09:00 - 21:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":16,"name":"广州从化图书馆","address":" 广州市从化区河滨北路616号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/5dccf512-56c5-4cf4-8cb0-8b63b3a7a988.jpeg","mapUrl":"","businessHours":"08:30-18:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"name":"昆山市图书馆","address":"江苏省苏州市昆山市前进中路353号瑞士大酒店旁边","imgUrl":"/prod-api/profile/upload/image/2022/03/13/2fe439b6-9b8b-4c46-a088-6f50907bf2fb.jpeg","mapUrl":"","businessHours":"周二至周日 09:00-20:30","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":18,"name":"南方医科大学","address":"广州市白云区广州大道北1838号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/308c645b-40c9-43d3-bfbe-dba716cdc954.jpeg","mapUrl":"","businessHours":"08:00-22:00","businessState":"1","description":""},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":19,"name":"安徽省图书馆","address":"合肥市包河区芜湖路74号","imgUrl":"/prod-api/profile/upload/image/2022/03/13/17b83907-188d-468b-bbd3-1748bd6d0907.jpeg","mapUrl":"","businessHours":"周二至周日 08:30-18:20","businessState":"1","description":""}]
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
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 10
         * name : 贵港市图书馆
         * address : 广西壮族自治区贵港市港北区民主路185号
         * imgUrl : /prod-api/profile/upload/image/2022/03/13/3971d94c-68ee-4744-8ae0-3c1b66aa953e.jpeg
         * mapUrl :
         * businessHours : 每天 09:00-21:00
         * businessState : 1
         * description :
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
