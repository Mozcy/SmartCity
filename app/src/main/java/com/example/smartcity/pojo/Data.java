package com.example.smartcity.pojo;

import android.graphics.Bitmap;

import com.example.smartcity.R;
import com.example.smartcity.activity.limited.N3Q2Activity;
import com.example.smartcity.activity.limited.N3Q3Activity;
import com.example.smartcity.activity.limited.N3Q4Activity;
import com.example.smartcity.activity.limited.N3Q5Activity;
import com.example.smartcity.activity.limited.N3Q6Activity;
import com.example.smartcity.activity.limited.N3Q7Activity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//智慧党建
public class Data {
    public static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static List<Integer> homeBanner = Arrays.asList(
            R.drawable.dang1, R.drawable.dang2, R.drawable.dang3, R.drawable.dang4, R.drawable.dang5, R.drawable.dang6, R.drawable.dang7
    );

    public static List<Service> homeEntry = Arrays.asList(
            new Service(R.drawable.nav3_entry1, "党建动态", N3Q2Activity.class),
            new Service(R.drawable.nav3_entry2, "党员学习", N3Q3Activity.class),
            new Service(R.drawable.nav3_entry3, "组织活动", N3Q4Activity.class),
            new Service(R.drawable.nav3_entry4, "建言献策", N3Q5Activity.class),
            new Service(R.drawable.nav3_entry5, "随手拍", N3Q6Activity.class),
            new Service(R.drawable.nav3_entry6, "百年党史", N3Q7Activity.class)
    );

    public static List<News> news = Arrays.asList(
            new News(0, R.drawable.dang1, R.raw.video01, "智慧党建 2023-06-02 12:32", "习近平向特朗普致慰问电", "国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。"),
            new News(2, R.drawable.dang2, R.raw.video01, "智慧党建 2023-06-01 10:32", "肖亚庆任工信部党组书记", "日前，中共中央决定：肖亚庆同志任工业和信息化部党组书记，苗圩同志不再担任工业和信息化部党组书记。"),
            new News(1, R.drawable.dang3, R.raw.video01, "智慧党建 2023-06-01 10:32", "民宿设计，再造空间之美", "近年来，伴随特色小镇、美丽乡村建设扎实推进，依托乡村闲置民居进行改造再利用的民宿业快速发展，民宿设计成为国内建筑领域的热点话题之一。一些乡村民宿经过设计改造，既保留了民居的古朴之美，亦适应了现代生活方式，在一定程度上带动了乡村整体发展。"),
            new News(0, R.drawable.dang4, R.raw.video01, "智慧党建 2023-06-01 13:32", "我市启动外文公示语管理规范工作", "  本报讯（大连新闻传媒集团记者鹿道铭）昨日上午，由市政府外办组织成立的大连市外文公示语审核委员会举行专家委员聘任仪式暨座谈会，来自大连海事大学、大连民族大学、辽宁师范大学、大连工业大学、大连外国语大学、大连大学等高校的9名专家学者获聘为专家委员，他们将负责对我市主要街面、商铺及机场、火车站等重点涉外区域的英、日、韩公示语译审工作。"),
            new News(0, R.drawable.dang5, R.raw.video01, "智慧党建 2023-06-01 14:32", "中国与世卫并肩抗疫，体现责任与担当", " 本报讯（大连新闻传媒集团记者鹿道铭）昨日上午，由市政府外办组织成立的大连市外文公示语审核委员会举行专家委员聘任仪式暨座谈会，来自大连海事大学、大连民族大学、辽宁师范大学、大连工业大学、大连外国语大学、大连大学等高校的9名专家学者获聘为专家委员，他们将负责对我市主要街面、商铺及机场、火车站等重点涉外区域的英、日、韩公示语译审工作。"),
            new News(1, R.drawable.dang6, R.raw.video01, "智慧党建 2023-06-02 15:32", "2020年戏曲百戏（昆山）盛典开幕", "10月11日，由文化和旅游部、江苏省政府主办的“2020年戏曲百戏（昆山）盛典”在昆山拉开帷幕。文化和旅游部党组成员、副部长李群到会致辞并宣布开幕，江苏省副省长马欣出席并致辞。"),
            new News(1, R.drawable.dang7, R.raw.video01, "智慧党建 2023-06-03 16:32", "外交部：将妥善安排驻休斯敦总领馆人员", "汪文斌：关于中国驻休斯敦总领馆馆员的有关情况，相信你已经从媒体上看到了。我这里要说的是，对于中国驻休斯敦总领馆的人员，中方将会作出妥善的安排。")
    );

    public static List<Integer> bannerLearn = Arrays.asList(
            R.drawable.danglearn1, R.drawable.danglearn2, R.drawable.danglearn3, R.drawable.danglearn4
    );
    public static List<Learn> learns = Arrays.asList(
            new Learn(R.drawable.danglearn1, R.raw.video01, "学习十九大，成为学习模范", "国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。"),
            new Learn(R.drawable.danglearn2, R.raw.video02, "肖亚庆任工信部党组书记", "国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。"),
            new Learn(R.drawable.danglearn3, R.raw.video03, "十九届五中全会定于今年10月召开", "国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。"),
            new Learn(R.drawable.danglearn4, R.raw.video01, "习近平向特朗普致慰问电", "国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。"),
            new Learn(R.drawable.danglearn1, R.raw.video02, "民宿设计，再造空间之美", "国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。"),
            new Learn(R.drawable.danglearn4, R.raw.video01, "习近平向特朗普致慰问电", "国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。"),
            new Learn(R.drawable.danglearn2, R.raw.video03, "看故宫与景德镇“同框”", "国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。"),
            new Learn(R.drawable.danglearn3, R.raw.video01, "党的伟大,100年", "国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。"),
            new Learn(R.drawable.danglearn1, R.raw.video02, "民宿设计，再造空间之美", "国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。"),
            new Learn(R.drawable.danglearn1, R.raw.video02, "党的伟大,100年", "国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。")
    );

    public static List<Doing> doings = Arrays.asList(
            new Doing(R.drawable.dang1, "党员干部职工参观汉源九襄镇", f.format(System.currentTimeMillis()), "北京市朝阳区", "全局党员干部职工先后参观了汉源县九襄镇小城镇建设、民主村中国传统村落建设和县城城湾区综合开发建设情况，同汉源县住建局同志进行了工作交流。"),
            new Doing(R.drawable.dang2, "重温入党誓词", f.format(System.currentTimeMillis()), "山东菏泽曹县", "主题党日有“味”才值得“回味”。当日干部职工还开展了拔河、跳绳等趣味活动，大家在轻松活泼的气氛中释放了压力，增进了领导与职工、职工与职工间的互动和友谊。"),
            new Doing(R.drawable.dang3, "机关党委书记领学《党章》", f.format(System.currentTimeMillis()), "山东省溜博", "党的十八大以来，中国电子党组以打造中国操作系统核心力量为目标，全力攻坚网信领域重大工程，加速实现对“卡脖子”技术的突破。目前，麒麟软件创新研发的银河麒麟操作系统已连续10年占据中国Linux操作系统市场占有率第一名。"),
            new Doing(R.drawable.dang4, "主题党日有“味”才值得“回味", f.format(System.currentTimeMillis()), "山东省济南市", "雅安市住建局相关负责人表示，全局将把主题党日作为推进全市住建系统全面从严治党，规范基层组织生活，提升党员服务能力的有效载体，突出“政治性”，注重“丰富性”，增强“实效性”，让雅安住建系统党员活动开展更加“有滋有味”。"),
            new Doing(R.drawable.dang5, "奋斗百年路 启航新征程", f.format(System.currentTimeMillis()), "重庆市渝中区", "汪文斌：关于中国驻休斯敦总领馆馆员的有关情况，相信你已经从媒体上看到了。我这里要说的是，对于中国驻休斯敦总领馆的人员，中方将会作出妥善的安排。")
    );

    public static List<Comment> q5 = new ArrayList<>();
    public static List<Comment> q6 = new ArrayList<>();

    public static class Service implements Serializable {
        private int img;
        private String title;
        private Class aClass;

        public Service(int img, String title, Class aClass) {
            this.img = img;
            this.title = title;
            this.aClass = aClass;
        }

        public int getImg() {
            return img;
        }

        public String getTitle() {
            return title;
        }

        public Class getaClass() {
            return aClass;
        }
    }

    public static class News implements Serializable {
        private int item;
        private int img;
        private int video;
        private String time;
        private String title;
        private String content;

        public News(int item, int img, int video, String time, String title, String content) {
            this.item = item;
            this.img = img;
            this.video = video;
            this.time = time;
            this.title = title;
            this.content = content;
        }

        public int getItem() {
            return item;
        }

        public int getImg() {
            return img;
        }

        public int getVideo() {
            return video;
        }

        public String getTitle() {
            return title;
        }

        public String getTime() {
            return time;
        }

        public String getContent() {
            return content;
        }
    }

    public static class Learn implements Serializable {
        private int img;
        private int video;
        private String title;
        private String content;

        public Learn(int img, int video, String title, String content) {
            this.img = img;
            this.video = video;
            this.title = title;
            this.content = content;
        }

        public int getImg() {
            return img;
        }

        public int getVideo() {
            return video;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }
    }

    public static class Doing implements Serializable {
        private int img;
        private String title;
        private String date;
        private String address;
        private String content;

        public Doing(int img, String title, String date, String address, String content) {
            this.img = img;
            this.title = title;
            this.date = date;
            this.address = address;
            this.content = content;
        }

        public int getImg() {
            return img;
        }

        public String getTitle() {
            return title;
        }

        public String getDate() {
            return date;
        }

        public String getAddress() {
            return address;
        }

        public String getContent() {
            return content;
        }
    }

    public static class Comment implements Serializable {
        private Bitmap img;
        private String time;
        private String title;
        private String name;
        private String tel;
        private String content;
        private List<String[]> list = new ArrayList<>();

        public Comment(Bitmap img, String time, String title, String content) {
            this.img = img;
            this.time = time;
            this.title = title;
            this.content = content;
            q6.add(0, this);
        }

        public Comment(String title, String name, String tel, String content) {
            this.title = title;
            this.name = name;
            this.tel = tel;
            this.content = content;
            q5.add(0, this);
        }

        public void setList(List<String[]> list) {
            this.list = list;
        }

        public Bitmap getImg() {
            return img;
        }

        public String getTime() {
            return time;
        }

        public String getTitle() {
            return title;
        }

        public String getName() {
            return name;
        }

        public String getTel() {
            return tel;
        }

        public String getContent() {
            return content;
        }

        public List<String[]> getList() {
            return list;
        }
    }
}
