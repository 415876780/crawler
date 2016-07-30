package ccnu.computer.crawler;

import java.util.Arrays;
import java.util.Set;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import ccnu.computer.model.Text;
import ccnu.computer.summary.HyperGraph;
import ccnu.computer.util.CrawlerUtil;

/*
 * ����һ��������ҳ����ȡ������ݷ�Ϊ���¼�����
 * ��1��������ƴ��һ��������ҳ����ַ�����磺"http://search.sina.com.cn/?q="+ URLEncoder.encode(title, "utf-8")+"&c=news&from=channel&ie=utf-8";
 * ��2������ǻ�ȡ��һ����ȡ�˶��ٸ���¼��һ�㻻���ҳ�����㣬��������һ������ ����ȡ
 * ��3��ͨ���ڶ�����ȡ��ҳ����ƴ�ɶ����ַ
 * ��4����ȡ��������ÿһ����ַ�ϵ���������
 * ��5��ͨ�����Ĳ�������������ַ��ȡ���ŵ�����
 * 
 * 
 * */

@Component("tencentNewsParser")
public class TencentNewsParser extends AbstractNewsParser {

//http://news.sogou.com/news?query=site:qq.com%20%B0%B4%B4%CE%B5%E7%CC%DD%CA%D550%D4%AA&manual=true&mode=1&sort=0&p=42230302
//http://news.sogou.com/news?query=site:qq.com%20%BB%AA%CE%AA%D6%D0%D0%CB%B3%F6%C9%EE%DB%DA&manual=true&mode=1&sort=0&p=42230302
	@Override
	public String getUrl(String title){
		return getUrl(title,"http://news.sogou.com/news?query=site:qq.com","&manual=true&mode=1&sort=0&p=42230302");
	}
//http://news.sogou.com/news?mode=1&manual=true&query=site%3Aqq.com+%BB%AA%CE%AA%D6%D0%D0%CB%B3%F6%C9%EE%DB%DA&sort=0&page=2&p=42230302&dp=1
//http://news.sogou.com/news?mode=1&manual=true&query=site%3Aqq.com+%BB%AA%CE%AA%D6%D0%D0%CB%B3%F6%C9%EE%DB%DA&sort=0&page=1&p=42230302&dp=1
	@Override
	public String getUrl(String title,int page){
		return getUrl(title,page,"http://news.sogou.com/news?mode=1&manual=true&query=site%3Aqq.com+",
		        		"&sort=0&page=","&p=42230302&dp=1");
	}

	@Override
	public int getUrlsize(String url) {
		// TODO Auto-generated method stub
		return getUrlsize(url, "span.filt-result");
	}

	@Override
	public Set<String> getItemUrl(String url) {
		// TODO Auto-generated method stub
		return getItemUrl(url, ".*","h3.vrTitle");
	}
	@Override
	public void parse(Document doc, String url,String topic) {
		// TODO Auto-generated method stub
		Text text= new Text();
		String title = CrawlerUtil.getTitle(doc, "div.hd");
		text.setUrl(url);
		text.setTopic(topic);
		text.setTitle(title);
		System.out.println(title);
		String time = CrawlerUtil.getTime(doc, Arrays.asList(new String[]{"span.article-time","artInfo"}));
		text.setDate(time);
		System.out.println(time);
		String content = CrawlerUtil.getContent(doc, Arrays.asList(new String[]{"div#Cnt-Main-Article-QQ","td.l17"}));
		text.setContent(content);
		System.out.println(content);
		text.setIsLabel("δ���");
		//text.setSummary(HyperGraph.getSummary(content, 200));
		//textDao= new TextDao();
		if(!"".equals(content)){
			System.out.println("======================+++++++++===="+textDao==null);
			textDao.add(text);
		}
		text=null;
	}
}
