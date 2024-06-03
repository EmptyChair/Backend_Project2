package myApp.myRepository;

import myApp.myDomain.Game;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class GameRepositoryList implements GameRepository {

    private final LinkedList<Game> gamelist = new LinkedList<Game>();

    private GameRepositoryList() {
        gamelist.add(new Game(1L,"Mass Effect 2",new BigDecimal(50), 10));
        gamelist.add(new Game(2L,"Fallout 3",new BigDecimal(60), 15));
        gamelist.add(new Game(3L,"Mass Effect",new BigDecimal(40), 3));
        gamelist.add(new Game(4L,"Sherlock Adventure",new BigDecimal(25), 0));
        gamelist.add(new Game(27L,"Baba Yaga",new BigDecimal(10), 1));
    }

    @Override
    public Game getById(Long id) {
        //Game foundGame;
        for (Game foundgame : this.gamelist) {
            if (foundgame.getId().equals(id))
                return foundgame;
        }
        return null;
    }

}
