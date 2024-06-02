package myApp.myService;

import app.domain.Product;
import myApp.myDomain.Game;
import myApp.myRepository.GameRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:myApplication.properties")
public class GameServiceImpl implements GameService {

    private GameRepository repo;

    private String gamePrefix;

    public GameServiceImpl(GameRepository repo,
                           @Value("${game.prefix}") String gamePrefix) {
        this.repo = repo;
        this.gamePrefix = gamePrefix;
    }

    @Override
    public Game getById(Long id) {
        Game game = repo.getById(id);
        if (game!=null) {
            setArticle(game);
            return game;
        } else {
            return null;        }

    }

    private void setArticle(Game game) {
        String article = String.format("%s-%s-%d", gamePrefix, game.getTitle().charAt(0),game.getId());
        game.setArticle(article);
    }
}
