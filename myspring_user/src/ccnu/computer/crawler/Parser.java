package ccnu.computer.crawler;

import java.net.URL;
import java.util.Set;

import org.jsoup.nodes.Document;

public interface Parser {
	/*
	 * ͨ���ؼ��ʵõ�url
	 * @param url1
	 * 		����url��ǰ�벿��
	 * @param url2
	 * 		����url�ĺ�벿��
	 * */
    public String getUrl(String title);
  
    /*
     * ������ȡ�����������ҳ����
     * @param 
     * */
    public int getUrlsize(String url);
    /*
     * ͨ��ҳ����������url,url�ֱ���url1,url2,url3�������Լ�page���
     * 
     * */
    
    public String getUrl(String title,int page);
    /*
     * ������ȡ������������������
     * @param url
     * 		url Ϊ�������ӵ���ַ
     * @param regex
     * 		regex Ϊ����ƥ�����ַ
     * */
    public Set<String> getItemUrl(String url);
    
	
	public Document getDocs(String url);
	/*
	 * ��ȡ���ŵ�����
	 * */
	public void parse( Document doc,String baseTag,String topic);
}