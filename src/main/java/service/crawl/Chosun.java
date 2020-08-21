package service.crawl;

import model.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Chosun {
    public List<Article> crawl(){
        List<Article> list = new ArrayList<Article>();
        Article article1 = new Article();
        Article article2 = new Article();

        String url = "https://www.chosun.com";

        try {
            Document doc = Jsoup.connect(url).get();

            // 조선 메인1 제목
            String title1 = doc.select("div.top_news h2 a span.center_tit").text();
            article1.setArticle_title(title1);

            // 조선 메인1 이미지 주소
            String image1 = doc.select("div.top_news dl img").attr("src");
            article1.setArticle_image(image1);

            // 조선 메인1 url
            String url1 = doc.select("div.top_news h2 a").attr("href");
            article1.setArticle_url(url1);
            Document doc1 = Jsoup.connect(url1).get();

            // 조선 메인1 내용
            String content1 = doc1.select(".par").text();
            article1.setArticle_content(content1);

            // 조선 메인1 분야
            String theme1 = doc1.select("meta[property=article:section]").first().attr("content");
            article1.setArticle_theme(theme1);


            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
            // 조선 메인1 작성시간
            String written_time1_str = doc1.select("div.news_date").text().split("\\|")[0].substring(3);
            Date written_time1 = dateFormat.parse(written_time1_str);
            article1.setArticle_written_time(written_time1);


            // 조선 메인1 수정시간
            String modified_time1_str = doc1.select("div.news_date").text().split("\\|")[1].substring(4);
            Date modified_time1 = dateFormat.parse(modified_time1_str);
            article1.setArticle_modified_time(modified_time1);

            // 조선 메인2 제목
            Elements titles = doc.select("dl#head_top dt a");
            String title2 = titles.first().text();
            article2.setArticle_title(title2);

            // 조선 메인2 이미지 주소
            Elements images = doc.select("dl#head_top dd a img");
            Element image_ele = images.first();
            String image2 = image_ele.attr("src");
            article2.setArticle_image(image2);

            // 조선 메인2 url
            String url2 = titles.first().attr("href");
            article2.setArticle_url(url2);

            // 조선 메인2 내용
            Document doc2 = Jsoup.connect(url2).get();
            String content2 = doc2.select(".par").text();
            article2.setArticle_content(content2);

            // 조선 메인2 분야
            String theme2 = doc2.select("meta[property=article:section]").first().attr("content");
            article2.setArticle_theme(theme2);

            // 조선 메인2 작성시간
            String written_time2_str = doc2.select("div.news_date").text().split("\\|")[0].substring(3);
            Date written_time2 = dateFormat.parse(written_time2_str);
            article2.setArticle_written_time(written_time2);

            // 조선 메인2 수정시간
            String modified_time2_str = doc2.select("div.news_date").text().split("\\|")[1].substring(4);
            Date modified_time2 = dateFormat.parse(modified_time2_str);
            article2.setArticle_modified_time(modified_time2);


            // 메인1,2 크롤링 시간
            Date time = new Date();
            article1.setArticle_crawled_time(time);
            article2.setArticle_crawled_time(time);

            // 메인1,2 언론사
            article1.setArticle_press("조선일보");
            article2.setArticle_press("조선일보");

            list.add(article1);
            list.add(article2);






        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return list;
    }
}
