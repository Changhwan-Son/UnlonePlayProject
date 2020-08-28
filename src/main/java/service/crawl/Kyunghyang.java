package service.crawl;

import model.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Thread.sleep;

public class Kyunghyang {
    public List<Article> crawl() {

        List<Article> list = new ArrayList<Article>();
        Article article1 = new Article();
        Article article2 = new Article();

        String url = "http://www.khan.co.kr";
        while(true) {
            try {
                sleep(1000);
                Document doc = Jsoup.connect(url).get();

                // 경향 메인1 제목
                String title1 = doc.select("div.mainLeft div.topNews a").text();
                article1.setArticle_title(title1);

                // 경향 메인1 url
                String url1 = doc.select("div.mainLeft div.topNews a").attr("href");
                article1.setArticle_url(url1);

                // 경향 메인1 이미지
                Document doc1 = Jsoup.connect(url1)
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                        .ignoreContentType(true).get();

                String image1 = doc1.select("div.art_body div.art_photo_wrap img").attr("src");
                article1.setArticle_image(image1);

                // 경향 메인1 내용
                String content1 = doc1.select("div.art_body p.content_text").text();
                article1.setArticle_content(content1);

                // 경향 메인1 분야
                String theme1 = doc1.select("meta[property=article:section]").attr("content");
                article1.setArticle_theme(theme1);


                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
                // 경향 메인1 작성시간
                String written_time1_str = doc1.select("div.pagecontrol div.byline em").first().text().substring(5);
                Date written_time1 = dateFormat.parse(written_time1_str);
                article1.setArticle_written_time(written_time1);


                // 경향 메인1 수정시간
                String modified_time1_str = doc1.select("div.pagecontrol div.byline em").last().text().substring(5);
                Date modified_time1 = dateFormat.parse(modified_time1_str);
                article1.setArticle_modified_time(modified_time1);

                // 경향 메인2 제목
                String title2 = doc.select("div.mArticle").text();
                article2.setArticle_title(title2);

                // 경향 메인2 이미지
                String image2 = doc.select("div.mArticle span.thumb img").attr("src");
                article2.setArticle_image(image2);


                // 경향 메인2 url
                String url2 = doc.select("div.mArticle a").attr("href");
                article2.setArticle_url(url2);


                // 경향 메인2 내용
                Document doc2 = Jsoup.connect(url2)
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                        .ignoreContentType(true).get();

                String content2 = doc2.select("div.art_body p.content_text").text();
                article2.setArticle_content(content2);

                // 경향 메인2 분야
                String theme2 = doc2.select("meta[property=article:section]").attr("content");
                article2.setArticle_theme(theme2);

                // 경향 메인2 작성시간
                String written_time2_str = doc2.select("div.pagecontrol div.byline em").first().text().substring(5);
                Date written_time2 = dateFormat.parse(written_time2_str);
                article2.setArticle_written_time(written_time2);


                // 경향 메인2 수정시간
                String modified_time2_str = doc2.select("div.pagecontrol div.byline em").last().text().substring(5);
                Date modified_time2 = dateFormat.parse(modified_time2_str);
                article2.setArticle_modified_time(modified_time2);

                // 메인1,2 크롤링 시간
                Date time = new Date();
                article1.setArticle_crawled_time(time);
                article2.setArticle_crawled_time(time);

                // 메인1,2 언론사
                article1.setArticle_press("경향신문");
                article2.setArticle_press("경향신문");

                list.add(article1);
                list.add(article2);


                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;

    }
}
