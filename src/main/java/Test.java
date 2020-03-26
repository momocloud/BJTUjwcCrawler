public class Test {
    public static void main(String[] args) {
//        JWCCrawler crawler = new JWCCrawler(116289, "test");
//        try {
//            crawler.crawler();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            example();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void example() throws Exception {
        Writter sum = new Writter("总表.html");
        sum.deleteFile();
        JWCCrawler crawler = new JWCCrawler(116103, "电子信息学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(116292);
        crawler.setFileName("机电学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(116289);
        crawler.setFileName("土建学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(116295);
        crawler.setFileName("经济管理学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(116310);
        crawler.setFileName("运输学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(116298);
        crawler.setFileName("法学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(167622);
        crawler.setFileName("马克思主义学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(116301);
        crawler.setFileName("语言学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(116304);
        crawler.setFileName("理学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(116286);
        crawler.setFileName("计算机学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(116113);
        crawler.setFileName("电气学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(116307);
        crawler.setFileName("软件学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(116283);
        crawler.setFileName("建筑艺术学院");
        sum.writeFile(crawler.crawler());
        crawler.setId(146324);
        crawler.setFileName("体育部");
        sum.writeFile(crawler.crawler());
    }
}

/*
    116103 电子信息学院
    116292 机电学院
    116289 土建学院
    116295 经济管理学院
    116310 运输学院
    116298 法学院
    167622 马克思主义学院
    116301 语言学院
    116304 理学院
    116286 计算机学院
    116113 电气学院
    116307 软件学院
    116283 建筑艺术学院
    146324 体育部
 */