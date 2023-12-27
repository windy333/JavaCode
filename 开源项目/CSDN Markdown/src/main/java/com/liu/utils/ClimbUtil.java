package com.liu.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 爬csdn博客工具
 */

public class ClimbUtil {

    public static void main(String[] args) {

        // 爬所有
        //climb("https://blog.csdn.net/qq_45774645");

        // 爬单个
        climbOne("https://csdnnews.blog.csdn.net/article/details/135235153?spm=1000.2115.3001.5927");
    }

    public static void climb(String url) {
        if (url.contains("?")) {
            url = url.substring(0, url.indexOf("?"));
        }

        // 把下面这个base_url换成你csdn的地址
        String secondUrl = url + "/article/list/";

        // 创建文件夹
        File file = new File("./post/");
        if (!file.exists()) {
            file.mkdir();
        }
        for (int i = 1; ; i++) {
            // 从第一页开始爬取
            String startUrl = secondUrl + i;
            Document doc = null;
            try {
                doc = Jsoup.connect(startUrl).get();
            } catch (IOException e) {
                System.out.println("jsoup获取url失败" + e.getMessage());
            }
            Element element = doc.body();
            //找到div class='article-list'
            element = element.select("div.article-list").first();
            if (element == null) {
                break;
            }
            Elements elements = element.children();
            List<CompletableFuture<Void>> futureList = new LinkedList<>();
            for (Element e : elements) {
                final String finalUrl = url;
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    // 拿到文章id
                    String articleId = e.attr("data-articleid");
                    // 爬取单篇文章
                    climbDetailById(finalUrl, articleId);
                });
                futureList.add(future);
            }
            //等待所有线程执行完毕
            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()])).join();
        }
    }

    private static void climbOne(String url) {
        System.out.println("-------爬取开始--------");

        //baseUrl是去除掉article/details之前的部分
        String baseUrl = url.substring(0, url.indexOf("article/details/"));
        //articleId是article/details/之后的部分
        String articleId= url.substring(url.indexOf("article/details/")+16);

        // 创建文件夹
        File file = new File("./post/");
        if (!file.exists()) {
            file.mkdir();
        }
        // 爬取单篇文章
        climbDetailById(baseUrl, articleId);
        System.out.println("-------爬取结束--------");
    }

    public static void climbDetailByUrl(String csdnUrl) {
        File file = new File("./post/");
        if (!file.exists()) {
            file.mkdir();
        }
        String startUrl = csdnUrl;
        Document doc = null;
        try {
            doc = Jsoup.connect(startUrl).get();
        } catch (IOException e) {
            System.out.println("jsoup获取url失败" + e.getMessage());
        }
        Element element = doc.body();
        Element htmlElement = element.select("div#content_views").first();
        Element titleElement = element.selectFirst(".title-article");
        String fileName = titleElement.text();
        System.out.println(fileName);
        // 设置jekyll格式博客title
        String jekyllTitle = "title:   " + fileName + "\n";

        // 设置jekyll格式博客categories
        Elements elements = element.select("div.tags-box");
        String jekyllCategories = "";
        if (elements.size() > 1) {
            jekyllCategories = "categories:\n";
            jekyllCategories = getTagsBoxValue(elements, 1, jekyllCategories);
        }

        // 设置jekyll格式博客tags
        String jekyllTags = "tags:\n";
        jekyllTags = getTagsBoxValue(elements, 0, jekyllTags);

        // 获取时间
        Element timeElement = element.selectFirst("span.time");
        String time = timeElement.text().substring(5);
        System.out.println(time);

        // 设置jekyll格式博客date
        String jekyllDate = "date:   " + time + "\n";
        String md = Html2Md.getMarkDownText(htmlElement);

        System.out.println(md);

        String jekylltr = "---\n" + "layout:  post\n" + jekyllTitle + jekyllDate
                + "author:  'zhangtao'\nheader-img: 'img/post-bg-2015.jpg'\ncatalog:   false\n"
                + jekyllCategories + jekyllTags + "\n---\n";
        String date = time.split(" ")[0];
        String mdFileName = "./post/" + date + '-' + fileName + ".md";
        md = jekylltr + md;
        FileWriter writer;
        try {
            writer = new FileWriter(mdFileName);
            writer.write(md);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void climbDetailById(String baseUrl, String articleId) {
        String startUrl = baseUrl + "/article/details/" + articleId;
        Document doc = null;
        try {
            doc = Jsoup.connect(startUrl).get();
        } catch (IOException e) {
            System.out.println("jsoup获取url失败" + e.getMessage());
        }
        Element element = doc.body();
        Element htmlElement = element.select("div#content_views").first();
        Element titleElement = element.selectFirst(".title-article");
        String fileName = titleElement.text();
        System.out.println(fileName);
        // 设置jekyll格式博客title
        String jekyllTitle = "title:   " + fileName + "\n";

        // 设置jekyll格式博客categories
        Elements elements = element.select("div.tags-box");
        String jekyllCategories = "";
        if (elements.size() > 1) {
            jekyllCategories = "categories:\n";
            jekyllCategories = getTagsBoxValue(elements, 1, jekyllCategories);
        }

        // 设置jekyll格式博客tags
        String jekyllTags = "tags:\n";
        jekyllTags = getTagsBoxValue(elements, 0, jekyllTags);

        // 获取时间
        Element timeElement = element.selectFirst("span.time");
        String time = timeElement.text().substring(5);
        System.out.println(time);

        // 设置jekyll格式博客date
        String jekyllDate = "date:   " + time + "\n";
        String md = Html2Md.getMarkDownText(htmlElement);

        System.out.println("正在爬取..."+fileName);

        String jekylltr = "---\n" + "layout:  post\n" + jekyllTitle + jekyllDate
                + "author:  'zhangtao'\nheader-img: 'img/post-bg-2015.jpg'\ncatalog:   false\n"
                + jekyllCategories + jekyllTags + "\n---\n";
        String date = time.split(" ")[0];
        String mdFileName = "./post/" + date + '-' + fileName + ".md";
        md = jekylltr + md;
        FileWriter writer;
        try {
            writer = new FileWriter(mdFileName);
            writer.write(md);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getTagsBoxValue(Elements elements, int index, String jekyllCategories) {
        Elements categories = elements.get(index).select("a.tag-link");
        for (Element e : categories) {
            String temp = e.text().replace("\t", "").replace("\n", "").replace("\r", "");
            jekyllCategories += "-" + temp + "\n";
        }
        return jekyllCategories;
    }


}
