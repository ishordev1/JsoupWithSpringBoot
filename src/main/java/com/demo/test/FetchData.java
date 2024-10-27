package com.demo.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FetchData {
	
	static public  void allPages(String url) throws Exception {
	
		Document doc = Jsoup.connect(url).get();
		System.out.println(doc.title());
		Elements e=doc.select("#allplist");
		Elements elements = doc.select("._lpdwgt._flx.pdbtlinks");
		elements.forEach((e1)->{
			System.out.println(e1.html());
			System.out.println("---------------------");
			  Element link = e1.selectFirst("h3 > a");
	            if (link != null) {
	                String href = link.attr("href");
	                try {
						perPage(href);
					} catch (Exception e2) {
				
						e2.printStackTrace();
					}
	            }
		System.exit(0);
			System.out.println("---------------------");
			
		});
		
	}
	
	
	
	
	static public  void perPage(String url) throws Exception {
		Document doc = Jsoup.connect(url).get();
		System.out.println(doc.title());
		Elements elements=doc.select("._pdswrp");
//		System.out.println(elements.html());
//		System.out.println(elements.select("ul>li").html());
	String text = elements.select("._pdsd>span").text();
	System.out.println(text);
	System.out.println("-------------------------");
	}
	
public static void main(String[] args) throws Exception {
	String url="https://www.gadgets360.com/mobiles/phone-finder#pfrom=topnav_desk";
	allPages(url);
}
}
