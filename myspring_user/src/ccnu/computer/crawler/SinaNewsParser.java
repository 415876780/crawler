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

@Component("sinaNewsParser")
public class SinaNewsParser extends AbstractNewsParser {



	@Override
	public String getUrl(String title){
		return getUrl(title,"http://search.sina.com.cn/?q=","&c=news&from=channel&ie=utf-8");
	}
	@Override
	public String getUrl(String title,int page){
		return getUrl(title,page,"http://search.sina.com.cn/?q=",
		        		"&c=news&from=channel&ie=utf-8&col=&range=&source=&country=&size=&time=&a=&page=","&pf=2131425461&ps=2134309112&dpc=1");
	}

	@Override
	public int getUrlsize(String url) {
		// TODO Auto-generated method stub
		return getUrlsize(url, "div.l_v2");
	}

	@Override
	public Set<String> getItemUrl(String url) {
		// TODO Auto-generated method stub
		return getItemUrl(url, "http://(finance|news).sina.com.cn.*","div.result");
	}
	@Override
	public void parse(Document doc, String url,String topic) {
		// TODO Auto-generated method stub
		Text text= new Text();
		String title = CrawlerUtil.getTitle(doc, ".page-header");
		text.setUrl(url);
		text.setTopic(topic);
		text.setTitle(title);
		System.out.println(title);
		String time = CrawlerUtil.getTime(doc, Arrays.asList(new String[]{"span.time-source","artInfo"}));
		text.setDate(time);
		System.out.println(time);
		String content = CrawlerUtil.getContent(doc, Arrays.asList(new String[]{"#artibody","td.l17"}));
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
