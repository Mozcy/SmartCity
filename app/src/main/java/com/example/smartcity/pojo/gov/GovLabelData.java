package com.example.smartcity.pojo.gov;

import java.util.List;

public class GovLabelData {

    /**
     * total : 16
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":8,"name":"积分落户","sort":1,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/9309591d-8b30-471b-8495-7a0269022add.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"name":"市政维修","sort":2,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/64cf7331-3a14-46b6-8b56-2bbebbf4aa96.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"name":"道路设施","sort":3,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/66b7611c-75f2-47e1-9820-19c33012ae7c.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"name":"便民设施","sort":4,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/9a6b8f06-b803-4073-bbd9-dd72ae3b783e.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"name":"物价问题","sort":5,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/8aa632bb-5ffe-41f3-932f-748b0317705d.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"name":"教育相关","sort":6,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/8e2793bf-c799-4874-b08f-b76db3d3e931.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"name":"疫情问题","sort":7,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/9b33cf3e-f8a0-48de-b12e-5c289c74acf4.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"name":"公共交通问题","sort":8,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/2cafa0fb-10f4-421b-88eb-4eed1ab223a0.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":16,"name":"人才招聘问题","sort":9,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/03e678e4-5be2-40c8-8d4f-bb12f29a5ba1.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"name":"生育政策","sort":10,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/488f6982-505a-4350-9514-c3f6841def52.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":18,"name":"企业政策咨询","sort":11,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/aed9c69d-5c8d-44a6-ab88-6ace896c70ff.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":19,"name":"购房政策咨询","sort":12,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/1268727b-a77a-487c-b5f2-7bb38810d893.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":20,"name":"市政规划咨询","sort":13,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/1b392552-d917-4359-8361-5e34df586dab.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":21,"name":"黑恶势力举报","sort":14,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/e1c7f0ee-e985-41b0-9b5c-2275ddf8d590.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":22,"name":"传销诈骗举报","sort":15,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/36a41dc9-2fa5-4764-a5fc-b7e0ca4ba2b4.png"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":23,"name":"其他诉求","sort":16,"imgUrl":"/prod-api/profile/upload/image/2022/03/12/4368fbaa-9584-46d5-a074-f4daf190e97d.png"}]
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
         * id : 8
         * name : 积分落户
         * sort : 1
         * imgUrl : /prod-api/profile/upload/image/2022/03/12/9309591d-8b30-471b-8495-7a0269022add.png
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
