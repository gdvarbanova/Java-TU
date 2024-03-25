import java.util.ArrayList;

public class Writer extends User{

    private final ArrayList<Article> articles;
    public Writer(String username, String password) {
        super(username, password);
        this.articles = new ArrayList<>();
    }

    public ArrayList<Article> getArticles() {
        synchronized (articles) {
            return articles;
        }
    }

    public void writeArticle(Article article) {
        synchronized (articles) {
            articles.add(article);
        }
    }

    public void displayArticle(){
        for(Article article : articles){
            System.out.println(article);
        }
    }

    @Override
    public UserType getUserType() {
        return UserType.WRITER;
    }


}
