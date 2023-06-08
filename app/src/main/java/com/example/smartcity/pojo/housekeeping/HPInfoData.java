package com.example.smartcity.pojo.housekeeping;

public class HPInfoData {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":"1","createTime":"2022-06-20 16:37:59","updateBy":null,"updateTime":"2022-07-11 17:03:21","remark":null,"params":{},"id":5,"serverName":"家庭保洁","serverTitle":"家庭保洁 保洁 家政 沙发清洗 地毯清洗 油烟机收拾卫生小时","companyId":5,"menusId":20,"serverMoneyOld":260,"serverMoneyNew":190,"serverMoney":null,"consultNum":395,"serverComtent":"<p><span style=\"color: rgb(0, 0, 0);\">承接：工程开荒，家庭保洁、新居开荒、开锁换锁 指纹锁安装<\/span><\/p><p><span style=\"color: rgb(0, 0, 0);\">拆除砸墙 家电清洗 空调清洗 油烟机清洗 自移机清洗 地毯清<\/span><\/p><p><span style=\"color: rgb(0, 0, 0);\">洗，沙发清洗、家庭开荒，沙发清洗、日常保洁<\/span><\/p><p><span style=\"color: rgb(0, 0, 0);\">地板打蜡、<\/span><\/p>","picUrl":"/prod-api/profile/upload/image/2022/06/20/c7178e25-a347-4fe4-806c-6f707d41eb45.jpeg","companyName":"三亚金熔佳家政"}
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
         * createBy : 1
         * createTime : 2022-06-20 16:37:59
         * updateBy : null
         * updateTime : 2022-07-11 17:03:21
         * remark : null
         * params : {}
         * id : 5
         * serverName : 家庭保洁
         * serverTitle : 家庭保洁 保洁 家政 沙发清洗 地毯清洗 油烟机收拾卫生小时
         * companyId : 5
         * menusId : 20
         * serverMoneyOld : 260
         * serverMoneyNew : 190
         * serverMoney : null
         * consultNum : 395
         * serverComtent : <p><span style="color: rgb(0, 0, 0);">承接：工程开荒，家庭保洁、新居开荒、开锁换锁 指纹锁安装</span></p><p><span style="color: rgb(0, 0, 0);">拆除砸墙 家电清洗 空调清洗 油烟机清洗 自移机清洗 地毯清</span></p><p><span style="color: rgb(0, 0, 0);">洗，沙发清洗、家庭开荒，沙发清洗、日常保洁</span></p><p><span style="color: rgb(0, 0, 0);">地板打蜡、</span></p>
         * picUrl : /prod-api/profile/upload/image/2022/06/20/c7178e25-a347-4fe4-806c-6f707d41eb45.jpeg
         * companyName : 三亚金熔佳家政
         */

        private Object searchValue;
        private String createBy;
        private String createTime;
        private Object updateBy;
        private String updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private String serverName;
        private String serverTitle;
        private int companyId;
        private int menusId;
        private int serverMoneyOld;
        private int serverMoneyNew;
        private Object serverMoney;
        private int consultNum;
        private String serverComtent;
        private String picUrl;
        private String companyName;

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

        public String getServerName() {
            return serverName;
        }

        public void setServerName(String serverName) {
            this.serverName = serverName;
        }

        public String getServerTitle() {
            return serverTitle;
        }

        public void setServerTitle(String serverTitle) {
            this.serverTitle = serverTitle;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public int getMenusId() {
            return menusId;
        }

        public void setMenusId(int menusId) {
            this.menusId = menusId;
        }

        public int getServerMoneyOld() {
            return serverMoneyOld;
        }

        public void setServerMoneyOld(int serverMoneyOld) {
            this.serverMoneyOld = serverMoneyOld;
        }

        public int getServerMoneyNew() {
            return serverMoneyNew;
        }

        public void setServerMoneyNew(int serverMoneyNew) {
            this.serverMoneyNew = serverMoneyNew;
        }

        public Object getServerMoney() {
            return serverMoney;
        }

        public void setServerMoney(Object serverMoney) {
            this.serverMoney = serverMoney;
        }

        public int getConsultNum() {
            return consultNum;
        }

        public void setConsultNum(int consultNum) {
            this.consultNum = consultNum;
        }

        public String getServerComtent() {
            return serverComtent;
        }

        public void setServerComtent(String serverComtent) {
            this.serverComtent = serverComtent;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public static class ParamsBean {
        }
    }
}
