package service.crawl;

import model.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Joongang {

    public List<Article> crawl() {

        List<Article> list = new ArrayList<Article>();
        Article article1 = new Article();
        Article article2 = new Article();

        String url = "https://joongang.joins.com";

        try{
            Document doc = Jsoup.connect(url).get();

            // 중앙 메인1 제목
            String title1 = doc.select("div.section_topnews h2.headline.fs2").text();
            article1.setArticle_title(title1);

            // 중앙 메인1 이미지
            String image1 = doc.select("div.section_topnews div.img_type1.v2 img").attr("src");
            article1.setArticle_image(image1);

            // 중앙 메인1 url
            String url1 = doc.select("div.section_topnews a").first().attr("href");
            article1.setArticle_url(url1);


            // 중앙 메인1 내용
            Document doc1 = Jsoup.connect(url1).get();
            String content1 = doc1.select("div.article_body").first().ownText();
            article1.setArticle_content(content1);

            // 중앙 메인1 분야
            String theme1 = doc1.select("meta[property=article:section]").attr("content");
            article1.setArticle_theme(theme1);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
            // 중앙 메인1 작성시간
            String written_time1_str = doc1.select("div.clearfx div.byline em").get(1).text().substring(3);
            Date written_time1 = dateFormat.parse(written_time1_str);
            article1.setArticle_written_time(written_time1);

            // 중앙 메인1 수정시간
            String modified_time1_str = doc1.select("div.clearfx div.byline em").last().text().substring(3);
            Date modified_time1 = dateFormat.parse(modified_time1_str);
            article1.setArticle_modified_time(modified_time1);

            // 중앙 메인2 제목
            String title2 = doc.select("div.type1 h2.headline").first().text();
            article2.setArticle_title(title2);

            // 중앙 메인2 이미지
            String image2 = doc.select("div.type1 img").first().attr("src");
            article2.setArticle_image(image2);

            // 중앙 메인2 url
            String url2 = doc.select("div.type1 a").first().attr("href");
            article2.setArticle_url(url2);

            // 중앙 메인2 내용
            Document doc2 = Jsoup.connect(url2).get();
            String content2 = doc2.select("div.article_body").first().ownText();
            article2.setArticle_content(content2);

            // 중앙 메인2 분야
            String theme2 = doc2.select("meta[property=article:section]").attr("content");
            article2.setArticle_theme(theme2);

            // 중앙 메인2 작성시간
            String written_time2_str = doc2.select("div.clearfx div.byline em").get(1).text().substring(3);
            Date written_time2 = dateFormat.parse(written_time2_str);
            article2.setArticle_written_time(written_time2);

            // 중앙 메인2 수정시간
            String modified_time2_str = doc2.select("div.clearfx div.byline em").last().text().substring(3);
            Date modified_time2 = dateFormat.parse(modified_time2_str);
            article2.setArticle_modified_time(modified_time2);

            // 메인1,2 크롤링 시간
            Date time = new Date();
            article1.setArticle_crawled_time(time);
            article2.setArticle_crawled_time(time);

            // 메인1,2 언론사
            article1.setArticle_press("중앙일보");
            article2.setArticle_press("중앙일보");

            list.add(article1);
            list.add(article2);



        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
