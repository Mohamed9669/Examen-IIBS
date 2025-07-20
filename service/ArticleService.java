package service;

import entity.Article;
import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    private List<Article> articles;

    public ArticleService() {
        articles = new ArrayList<>();
        articles.add(new Article(1, "Stylo"));
        articles.add(new Article(2, "Cahier"));
        articles.add(new Article(3, "Classeur"));
    }

    public List<Article> getArticles() {
        return articles;
    }
} 