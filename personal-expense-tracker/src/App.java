import service.UserInputService;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            UserInputService.selectOption();         
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
