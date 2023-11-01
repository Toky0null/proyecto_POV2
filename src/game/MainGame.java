
package game;

import controller.GameController;
import model.GameModel;
import view.Game;
import view.Game1;
import view.InitialWindow;

/**
 *  
 * @author tokyo
 */
public class MainGame {

public static void main(String[] args) {
 GameModel model = new GameModel();
        GameController controller = new GameController(model);
        InitialWindow initialWindow = new InitialWindow();

        model.setController(controller); // Establece el controlador en el modelo

        initialWindow.setVisible(true);
        System.out.println("Menú principal mostrado");
    }
}
