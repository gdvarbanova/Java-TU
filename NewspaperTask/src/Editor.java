import java.util.ArrayList;

public class Editor extends User {

    private final ArrayList<Article> editedArticles;

    public Editor(String username, String password) {
        super(username, password);
        this.editedArticles = new ArrayList<>();
    }

    @Override
    public UserType getUserType() {
        return UserType.EDITOR;
    }

    public void editArticle(Article article){
        synchronized (editedArticles){
            editedArticles.add(article);
        }
    }

    public ArrayList<Article> getEditedArticles() {
        synchronized (editedArticles) {
            return editedArticles;
        }
    }

    public void displayEditedArticle(){
        for(Article article : editedArticles){
            System.out.println(article);
        }
    }


    @Override
    public String toString() {
        return "Editor{" + getUsername() + "}";
    }
}
