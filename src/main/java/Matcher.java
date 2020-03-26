public class Matcher {
    public static String matchToGet(String content) {
        if (content != null && !"".equals(content)) {
            content = content.replace("/teaching_", "http://jwc.bjtu.edu.cn/teaching_");
            return content;
        } else {
            return content;
        }
    }
}
