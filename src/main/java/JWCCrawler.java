import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class JWCCrawler {

    private String fileName = "test.html";
    private int id = 116103;

    public JWCCrawler(int pcID, String fileName) {
        this.fileName = fileName + ".html";
        this.id = pcID;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName + ".html";
    }

    public void setId(int id) {
        this.id = id;
    }

    private Boolean checker() {
        switch (this.id) {
            case 116103:
            case 116292:
            case 116289:
            case 116295:
            case 116310:
            case 116298:
            case 167622:
            case 116301:
            case 116304:
            case 116286:
            case 116113:
            case 116307:
            case 116283:
            case 146324: return true;
            default: return false;
        }
    }

    public String crawler() throws Exception{
        if (!checker()) {
            System.out.println("课程序号不对！");
            return "";
        }
        System.out.println("一个爬虫任务开始");
        String pcID = new String(String.valueOf(this.id));
        String finalContent = "";
        int pN = 1;
        Writter writter = new Writter(this.fileName);
        writter.deleteFile();
        while (true) {
            String pageNum = new String(String.valueOf(pN));
            CloseableHttpClient httpClient = HttpClients.createDefault();
            URIBuilder uriBuilder = new URIBuilder("http://jwc.bjtu.edu.cn/Admin/PageList.ashx");
            uriBuilder.setParameter("pc", pcID)
                    .setParameter("size", "25")
                    .setParameter("pn", pageNum);

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            System.out.println("发起的请求: " + httpGet);

            CloseableHttpResponse response = null;

            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf8");
                if (content.length() <= 1200) {
                    break;
                }
                content = Matcher.matchToGet(content);
                pN += 1;
                writter.writeFile(content);
                finalContent += content;
            }
            response.close();
            httpClient.close();
        }
        System.out.println("一个爬虫任务已经结束！");
        return finalContent;
    }
}
