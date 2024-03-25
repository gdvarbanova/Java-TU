import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class NewspaperSystem {

    private ArrayList<User> users;
    private PrintStream printOutStream;


    public NewspaperSystem(){
        this.users = new ArrayList<>();
        this.createAdmin();
    }

    public void createAdmin(){
        Administrator admin = new Administrator("admin", "admin");
        users.add(admin);
    }

    public void logInUser(String username, String password, Socket clientSocket) throws IOException{
        printOutStream = new PrintStream(clientSocket.getOutputStream());
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                printOutStream.println("Logged in successfully!");
                switch (user.getUserType()){
                    case ADMINISTRATOR:
                        Administrator admin = (Administrator) user;
                        adminMenu(admin, clientSocket);
                        break;
                    case WRITER:
                        Writer writer = (Writer) user;
                        writerMenu(writer, clientSocket);
                        break;
                    case EDITOR:
                        Editor editor = (Editor) user;
                        editorMenu(editor, clientSocket);
                        break;
                }
            }
            printOutStream.println("Invalid username or password!\nTry again!");
        }
    }

    public void adminMenu(Administrator admin, Socket clientSocket) throws IOException{
        printOutStream.println("Welcome " + admin.getUsername());
        printOutStream.println("Creating new user...");
        Scanner scanner = new Scanner(clientSocket.getInputStream());
        printOutStream.println("Choose type (1 - Writer 2 - Editor): ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                if (createWriter(scanner)) {
                    printOutStream.println("Writer created successfully!");
                } else {
                    printOutStream.println("Writer creation failed! Please try again!");
                    createWriter(scanner);
                }
                break;
            case 2:
                if (createEditor(scanner, clientSocket)) {
                    printOutStream.println("Editor created successfully!");
                } else {
                    printOutStream.println("Editor creation failed! Please try again!");
                    createEditor(scanner, clientSocket);
                }
                break;
            default:
                printOutStream.println("Invalid input!");
        }
        printOutStream.println("Goodbye " + admin.getUsername());
    }

    public void writerMenu(Writer writer, Socket clientSocket) throws IOException{
        Scanner scanner = new Scanner(clientSocket.getInputStream());
        printOutStream.println("Welcome " + writer.getUsername());
        printOutStream.println("Writing article...");
        printOutStream.println("Enter date: ");
        String date = scanner.nextLine();
        StringBuilder text = new StringBuilder();
        printOutStream.println("Enter article (type 'stop' to stop): ");
        while (true) {
            String line = scanner.nextLine();
            if ("stop".equalsIgnoreCase(line.trim())) {
                break;
            }
            text.append(line).append("\n");
        }
        Article article = new Article(date, text.toString());
        writer.writeArticle(article);
        writer.displayArticle();
    }

    public void editorMenu(Editor editor, Socket clientSocket) throws  IOException{
        Scanner scanner = new Scanner(clientSocket.getInputStream());
        printOutStream.println("Welcome " + editor.getUsername());
        printOutStream.println("Edit article...");
        if (editedOrNot(editor, scanner)) {
            printOutStream.println("Article edited successfully!");
        } else {
            printOutStream.println("Article failed to be edited! Please try again!");
            editedOrNot(editor, scanner);
        }
        printOutStream.println("Goodbye " + editor.getUsername());
    }

    public boolean editedOrNot(Editor editor, Scanner scanner){
        printOutStream.println("Enter a writer username to edit their article: ");
        String username = scanner.nextLine();
        Writer writer = findWriterByUsername(username);
        if (writer == null) {
            printOutStream.println("Writer not found!");
            return false;
        } else {
            writer.displayArticle();
            printOutStream.println("Enter date: ");
            String date = scanner.nextLine();
            StringBuilder text = new StringBuilder();
            printOutStream.println("Enter article (type 'stop' to stop): ");
            while (true) {
                String line = scanner.nextLine();
                if ("stop".equalsIgnoreCase(line.trim())) {
                    break;
                }
                text.append(line).append("\n");
            }
            Article article = new Article(date, text.toString());
            editor.editArticle(article);
            editor.displayEditedArticle();
            return true;
        }
    }

    public boolean createWriter(Scanner scanner){
        printOutStream.println("Enter username: ");
        String username = scanner.nextLine();
        printOutStream.println("Enter password: ");
        String password = scanner.nextLine();
        if(validatePassword(password)){
            Writer writer = new Writer(username, password);
            users.add(writer);
            return true;
        }
        else return false;
    }

    public boolean createEditor(Scanner scanner, Socket clientSocket){
        printOutStream.println("Enter username: ");
        String username = scanner.nextLine();
        printOutStream.println("Enter password: ");
        String password = scanner.nextLine();
        if(validatePassword(password)){
            Editor editor = new Editor(username, password);
            users.add(editor);
            return true;
        }
        else return false;
    }

    public boolean validatePassword(String password){
        //password must be at least 5 symbols
        String passReg = "\\S{5,}";
        if (!password.matches(passReg)) {
            printOutStream.println("Password must be at least 5 characters long!");
            return false;
        }
        return true;
    }

    public Writer findWriterByUsername(String username) {
        for (User user : users) {
            if (user.getUserType() == UserType.WRITER) {
                Writer writer = (Writer) user;
                if (writer.getUsername().equals(username)) {
                    return writer;
                }
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
