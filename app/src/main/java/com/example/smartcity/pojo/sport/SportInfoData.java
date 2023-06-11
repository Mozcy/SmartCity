package com.example.smartcity.pojo.sport;

import java.util.List;

public class SportInfoData {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":null,"createTime":"2022-06-20 11:47:20","updateBy":null,"updateTime":"2022-07-20 09:09:56","remark":null,"params":{},"id":19,"sportVenueName":"中体腾辉游泳健身","money":"600","address":"通州 -  马驹桥  - 中体腾辉健身房","openTime":"8:00-17:00","sportMenuId":null,"sportContent":"<p><span style=\"color: rgb(0, 0, 0);\">健身、游泳、儿童游泳、舞蹈、瑜伽<\/span><\/p><p><img src=\"/prod-api/profile/upload/image/2022/06/20/7f30e58d-0093-416b-95d5-7963fd8df823.jpg\"><\/p><p><img src=\"/prod-api/profile/upload/image/2022/06/20/59756de9-59c4-4f3e-9129-b3e7ec4a01c2.jpg\"><\/p>","likeNum":4562,"sportMenus":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":680,"sportId":19,"menuId":7,"menuName":"瑜伽"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":679,"sportId":19,"menuId":6,"menuName":"格斗"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":678,"sportId":19,"menuId":5,"menuName":"游泳"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":677,"sportId":19,"menuId":4,"menuName":"羽毛球"}],"makeNum":346,"hot":1}
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
         * createTime : 2022-06-20 11:47:20
         * updateBy : null
         * updateTime : 2022-07-20 09:09:56
         * remark : null
         * params : {}
         * id : 19
         * sportVenueName : 中体腾辉游泳健身
         * money : 600
         * address : 通州 -  马驹桥  - 中体腾辉健身房
         * openTime : 8:00-17:00
         * sportMenuId : null
         * sportContent : <p><span style="color: rgb(0, 0, 0);">健身、游泳、儿童游泳、舞蹈、瑜伽</span></p><p><img src="/prod-api/profile/upload/image/2022/06/20/7f30e58d-0093-416b-95d5-7963fd8df823.jpg"></p><p><img src="/prod-api/profile/upload/image/2022/06/20/59756de9-59c4-4f3e-9129-b3e7ec4a01c2.jpg"></p>
         * likeNum : 4562
         * sportMenus : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":680,"sportId":19,"menuId":7,"menuName":"瑜伽"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":679,"sportId":19,"menuId":6,"menuName":"格斗"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":678,"sportId":19,"menuId":5,"menuName":"游泳"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":677,"sportId":19,"menuId":4,"menuName":"羽毛球"}]
         * makeNum : 346
         * hot : 1
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private String updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private String sportVenueName;
        private String money;
        private String address;
        private String openTime;
        private Object sportMenuId;
        private String sportContent;
        private int likeNum;
        private int makeNum;
        private int hot;
        private List<SportMenusBean> sportMenus;

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

        public String getSportVenueName() {
            return sportVenueName;
        }

        public void setSportVenueName(String sportVenueName) {
            this.sportVenueName = sportVenueName;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public Object getSportMenuId() {
            return sportMenuId;
        }

        public void setSportMenuId(Object sportMenuId) {
            this.sportMenuId = sportMenuId;
        }

        public String getSportContent() {
            return sportContent;
        }

        public void setSportContent(String sportContent) {
            this.sportContent = sportContent;
        }

        public int getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(int likeNum) {
            this.likeNum = likeNum;
        }

        public int getMakeNum() {
            return makeNum;
        }

        public void setMakeNum(int makeNum) {
            this.makeNum = makeNum;
        }

        public int getHot() {
            return hot;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public List<SportMenusBean> getSportMenus() {
            return sportMenus;
        }

        public void setSportMenus(List<SportMenusBean> sportMenus) {
            this.sportMenus = sportMenus;
        }

        public static class ParamsBean {
        }

        public static class SportMenusBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * id : 680
             * sportId : 19
             * menuId : 7
             * menuName : 瑜伽
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBeanX params;
            private int id;
            private int sportId;
            private int menuId;
            private String menuName;

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

            public ParamsBeanX getParams() {
                return params;
            }

            public void setParams(ParamsBeanX params) {
                this.params = params;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSportId() {
                return sportId;
            }

            public void setSportId(int sportId) {
                this.sportId = sportId;
            }

            public int getMenuId() {
                return menuId;
            }

            public void setMenuId(int menuId) {
                this.menuId = menuId;
            }

            public String getMenuName() {
                return menuName;
            }

            public void setMenuName(String menuName) {
                this.menuName = menuName;
            }

            public static class ParamsBeanX {
            }
        }
    }
}
