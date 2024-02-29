import core.logger.impl.LoggerTxt;
import core.view.View;


public class Main {
    public static void main(String[] args) {

        View view = new View(new LoggerTxt("log.txt"));
        view.run();

    }
}