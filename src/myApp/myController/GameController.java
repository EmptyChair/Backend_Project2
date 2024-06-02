package myApp.myController;

import app.domain.Product;
import myApp.myDomain.Game;
import myApp.myService.GameService;
import org.springframework.stereotype.Component;

@Component
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    public Game getById(Long id) {
        return service.getById(id);
    }
}
