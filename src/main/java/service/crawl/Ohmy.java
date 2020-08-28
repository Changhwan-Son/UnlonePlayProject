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

public class Ohmy {
    public List<Article> crawl() {

        List<Article> list = new ArrayList<Article>();
        Article article1 = new Article();
        Article article2 = new Article();

        String url = "http://www.ohmynews.com/";

        try{
            Document doc = Jsoup.connect(url).get();

            // 오마이 메인1 url
            Elements divTop = doc.select("div#dvTopBoard");

            String url1 = url + divTop.select("div.dvContents.box_in").first().select("a").attr("href");
            article1.setArticle_url(url1);
            Document doc1 = Jsoup.connect(url1).get();

            // 오마이 메인1 제목
            String title1 = doc1.select("div.newstitle h3.tit_subject").text();
            article1.setArticle_title(title1);

            // 오마이 메인1 이미지
            String image1 = doc1.select("div.at_contents table.photoCenter img").attr("src");
            if(title1.equals(""))
                title1 = "불러오기 오류";
            article1.setArticle_image(image1);

            // 오마이 메인1 내용
            String content1 = doc1.select("div.at_contents").text();
            if(content1.equals(""))
                content1 = "불러오기 오류";
            article1.setArticle_content(content1);


            // 오마이 메인1 분야
            String theme1 = doc1.select("meta[property=article:section]").attr("content");
            article1.setArticle_theme(theme1);


            SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd hh:mm");

            // 오마이 메인1 작성시간
            String written_time1_str = doc1.select("div.info_data").text().split("l")[0];
            if(written_time1_str.equals("")) {
                written_time1_str = "20.01.01 00:00";
            }
            Date written_time1 = dateFormat.parse(written_time1_str);
            article1.setArticle_written_time(written_time1);


            // 오마이 메인1 수정시간
            String modified_time1_str = "";
            if(!written_time1_str.equals("20.01.01 00:00")) {
                modified_time1_str = doc1.select("div.info_data").text().split("l")[1].substring(8);
            }
            else{
                modified_time1_str = "20.01.01 00:00";
            }
            Date modified_time1 = dateFormat.parse(modified_time1_str);
            article1.setArticle_modified_time(modified_time1);


            // 오마이 메인2 url
            String url2 = url + divTop.select("div.dvContents.box_in").get(1).select("a").attr("href");
            article2.setArticle_url(url2);

            Document doc2 = Jsoup.connect(url2).get();
            // 오마이 메인2 제목
            String title2 = doc2.select("div.newstitle h3.tit_subject").text();
            if(title2.equals(""))
                title2 = "불러오기 오류";
            article2.setArticle_title(title2);

            // 오마이 메인2 이미지
            String image2 = doc2.select("div.at_contents table.photoCenter img").attr("src");
            article2.setArticle_image(image2);

            // 프레시안 메인2 내용
            String content2 = doc2.select("div.at_contents").text();
            if(content2.equals(""))
                content2 = "불러오기 오류";
            article2.setArticle_content(content2);

            // 오마이 메인2 분야
            String theme2 = doc1.select("meta[property=article:section]").attr("content");
            article2.setArticle_theme(theme2);

            // 오마이 메인2 작성시간
            String written_time2_str = doc1.select("div.info_data").text().split("l")[0];
            if(written_time2_str.equals("")) {
                written_time2_str = "20.01.01 00:00";
            }
            Date written_time2 = dateFormat.parse(written_time2_str);
            article2.setArticle_written_time(written_time2);

            // 오마이 메인2 수정시간
            String modified_time2_str = "";
            if(!written_time2_str.equals("20.01.01 00:00")) {
                modified_time2_str =doc1.select("div.info_data").text().split("l")[1].substring(8);
            }
            else{
                modified_time2_str = "20.01.01 00:00";
            }
            Date modified_time2 = dateFormat.parse(modified_time2_str);
            article2.setArticle_modified_time(modified_time2);

            // 메인1,2 크롤링 시간
            Date time = new Date();
            article1.setArticle_crawled_time(time);
            article2.setArticle_crawled_time(time);

            // 메인1,2 언론사
            article1.setArticle_press("오마이뉴스");
            article2.setArticle_press("오마이뉴스");

            list.add(article1);
            list.add(article2);



        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }
}
