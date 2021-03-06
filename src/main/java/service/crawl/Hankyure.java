package service.crawl;

import model.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hankyure {
    public List<Article> crawl(){

        List<Article> list = new ArrayList<Article>();
        Article article1 = new Article();
        Article article2 = new Article();
        String url = "http://www.hani.co.kr";

        try{
            Document doc = Jsoup.connect(url).get();

            // 한겨례 메인1 제목
            String title1 = doc.select("div.main-top-article h4.article-title").text();
            article1.setArticle_title(title1);

            // 한겨례 메인1 이미지
            String image1 = doc.select("div.main-top-article span.article-photo img").attr("src");
            article1.setArticle_image(image1);

            // 한겨례 메인1 url
            String url1 = url + doc.select("div.main-top-article h4.article-title a").attr("href");
            article1.setArticle_url(url1);

            // 한겨례 메인1 내용
            Document doc1 = Jsoup.connect(url1).get();
            String content1 = doc1.select("div.article-text div.text").first().ownText();
            article1.setArticle_content(content1);

            // 한겨례 메인1 분야
            String theme1 = doc1.select("meta[property=article:section]").attr("content");
            article1.setArticle_theme(theme1);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

            // 한겨례 메인1 작성시간
            String written_time1_str = doc1.select("p.date-time span").first().text().substring(4);
            Date written_time1 = dateFormat.parse(written_time1_str);
            article1.setArticle_written_time(written_time1);


            // 한겨례 메인1 수정시간
            String modified_time1_str = doc1.select("p.date-time span").last().text().substring(4);
            Date modified_time1 = dateFormat.parse(modified_time1_str);
            article1.setArticle_modified_time(modified_time1);


            // 한겨례 메인2 제목
            String title2 = doc.select("div.article01.first h4.article-title").text();
            article2.setArticle_title(title2);

            // 한겨례 메인2 이미지
            String image2 = doc.select("div.article01.first span.article-photo img").attr("src");
            article2.setArticle_image(image2);

            // 한겨례 메인2 url
            String url2 = url + doc.select("div.article01.first h4.article-title a").attr("href");
            article2.setArticle_url(url2);

            // 한겨례 메인2 내용
            Document doc2 = Jsoup.connect(url2).get();
            String content2 = doc2.select("div.article-text div.text").first().ownText();
            article2.setArticle_content(content2);

            // 한겨례 메인2 분야
            String theme2 = doc2.select("meta[property=article:section]").attr("content");
            article2.setArticle_theme(theme2);

            // 한겨례 메인2 작성시간
            String written_time2_str = doc2.select("p.date-time span").first().text().substring(4);
            Date written_time2 = dateFormat.parse(written_time2_str);
            article2.setArticle_written_time(written_time2);

            // 한겨례 메인2 수정시간
            String modified_time2_str = doc2.select("p.date-time span").last().text().substring(4);
            Date modified_time2 = dateFormat.parse(modified_time2_str);
            article2.setArticle_modified_time(modified_time2);

            // 메인1,2 크롤링 시간
            Date time = new Date();
            article1.setArticle_crawled_time(time);
            article2.setArticle_crawled_time(time);

            // 메인1,2 언론사
            article1.setArticle_press("한겨례");
            article2.setArticle_press("한겨례");

            list.add(article1);
            list.add(article2);


        }catch(Exception e){
            e.printStackTrace();

        }

        return list;
    }
}
