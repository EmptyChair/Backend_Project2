package myClient;

import myApp.myController.GameController;
import myApp.myDomain.Game;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class myClient {
    public static void main(String[] args) {
        AbstractApplicationContext myContext = new AnnotationConfigApplicationContext("myApp");
        GameController controller = myContext.getBean(GameController.class);

        Game game0 = controller.getById(0L);
        System.out.println("First game: "+game0);
        Game game1 = controller.getById(1L);
        System.out.println("Second game: "+game1);
        Game game2 = controller.getById(2L);
        System.out.println("Third game: "+game1);
        Game game3 = controller.getById(3L);
        System.out.println("Fourth game: "+game1);
        Game game5 = controller.getById(5L);
        System.out.println("Fifth game: "+game5);
        Game game26 = controller.getById(26L);
        System.out.println("26th game: "+game26);
        Game game27 = controller.getById(27L);
        System.out.println("27th game: "+game27);
        Game game28 = controller.getById(28L);
        System.out.println("28th game: "+game28);
    }

}
