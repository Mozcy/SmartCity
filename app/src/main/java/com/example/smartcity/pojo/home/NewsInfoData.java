package com.example.smartcity.pojo.home;

public class NewsInfoData {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":"1","createTime":"2021-05-06 14:38:26","updateBy":"1","updateTime":"2021-05-08 09:55:01","remark":null,"params":{},"id":8,"appType":"smart_city","cover":"/prod-api/profile/upload/image/2021/05/06/2bfc61d3-5d6e-4157-ba5f-a9dfe23af07f.jpg","title":"六城市成智慧城市基础设施与智能网联汽车协同发展试点","subTitle":null,"content":"<p class=\"ql-align-justify\">据住建部网站消息，近日，住建部、工信部联合发布关于确定智慧城市基础设施与智能网联汽车协同发展第一批试点城市的通知。通知提到，在各城市申报和省级主管部门审核基础上，经组织专家评审和实地调研，确定北京、上海、广州、武汉、长沙、无锡等6个城市为智慧城市基础设施与智能网联汽车协同发展第一批试点城市。<\/p><p class=\"ql-align-justify\"><br><\/p><p class=\"ql-align-justify\">通知指出，请试点城市按照相关要求，制定完善试点工作方案，经专家评审通过后报住房和城乡建设部、工业和信息化部备案。试点城市要建立健全统筹协调机制，落实资金等保障措施，确保试点工作取得成效，形成可复制可推广的经验。有关省级住房和城乡建设、工业和信息化部门要加大对试点城市的指导支持力度。<\/p>","status":"Y","publishDate":"2021-05-06","tags":null,"commentNum":1,"likeNum":673,"readNum":1232,"type":"22","top":"Y","hot":"Y"}
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
         * createTime : 2021-05-06 14:38:26
         * updateBy : 1
         * updateTime : 2021-05-08 09:55:01
         * remark : null
         * params : {}
         * id : 8
         * appType : smart_city
         * cover : /prod-api/profile/upload/image/2021/05/06/2bfc61d3-5d6e-4157-ba5f-a9dfe23af07f.jpg
         * title : 六城市成智慧城市基础设施与智能网联汽车协同发展试点
         * subTitle : null
         * content : <p class="ql-align-justify">据住建部网站消息，近日，住建部、工信部联合发布关于确定智慧城市基础设施与智能网联汽车协同发展第一批试点城市的通知。通知提到，在各城市申报和省级主管部门审核基础上，经组织专家评审和实地调研，确定北京、上海、广州、武汉、长沙、无锡等6个城市为智慧城市基础设施与智能网联汽车协同发展第一批试点城市。</p><p class="ql-align-justify"><br></p><p class="ql-align-justify">通知指出，请试点城市按照相关要求，制定完善试点工作方案，经专家评审通过后报住房和城乡建设部、工业和信息化部备案。试点城市要建立健全统筹协调机制，落实资金等保障措施，确保试点工作取得成效，形成可复制可推广的经验。有关省级住房和城乡建设、工业和信息化部门要加大对试点城市的指导支持力度。</p>
         * status : Y
         * publishDate : 2021-05-06
         * tags : null
         * commentNum : 1
         * likeNum : 673
         * readNum : 1232
         * type : 22
         * top : Y
         * hot : Y
         */

        private Object searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private String appType;
        private String cover;
        private String title;
        private Object subTitle;
        private String content;
        private String status;
        private String publishDate;
        private Object tags;
        private int commentNum;
        private int likeNum;
        private int readNum;
        private String type;
        private String top;
        private String hot;

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

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
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

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(Object subTitle) {
            this.subTitle = subTitle;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public int getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(int likeNum) {
            this.likeNum = likeNum;
        }

        public int getReadNum() {
            return readNum;
        }

        public void setReadNum(int readNum) {
            this.readNum = readNum;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTop() {
            return top;
        }

        public void setTop(String top) {
            this.top = top;
        }

        public String getHot() {
            return hot;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }

        public static class ParamsBean {
        }
    }
}
