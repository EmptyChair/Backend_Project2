package myApp.myRepository;

import myApp.myDomain.Game;

public interface GameRepository {

    Game getById(Long id);
}
