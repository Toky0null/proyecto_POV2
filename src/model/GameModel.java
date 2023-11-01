
package model;
import controller.GameController;
import javax.swing.*;
import view.Game1;
import javax.swing.ImageIcon;
/**
 *
 * @author tokyo
 */
// Clase del Modelo (Model)
public class GameModel {
    private int score;
    private int lives;
    private int speed;
    private int countdownValue = 4; 
    private Timer gameTimer;
    private int updateInterval = 1000;  // intervalo inicial de 1000 ms (1 segundo)
    private ImageIcon[] imageArray;

    //Game1 game;
    //GameController controller;
    // Agrega más atributos y lógica según sea necesario

    public GameModel() {       
        gameTimer = new Timer(updateInterval, e -> updateGameState());
      //  game = new Game1(controller,this);
        // Inicializa tus atributos aquí
         initCountdown();
        imageArray = new ImageIcon[11];
        imageArray[0] = new ImageIcon(getClass().getResource("/view/img/heartoff.png"));
        imageArray[1] = new ImageIcon(getClass().getResource("/view/img/1bot.png"));
        imageArray[2] = new ImageIcon(getClass().getResource("/view/img/1bot.png"));
        imageArray[3] = new ImageIcon(getClass().getResource("/view/img/1bot.png"));
        imageArray[4] = new ImageIcon(getClass().getResource("/view/img/1bot.png"));
        imageArray[5] = new ImageIcon(getClass().getResource("/view/img/1bot.png"));
        imageArray[6] = new ImageIcon(getClass().getResource("/view/img/1bot.png"));
        imageArray[7] = new ImageIcon(getClass().getResource("/view/img/1bot.png"));
        imageArray[8] = new ImageIcon(getClass().getResource("/view/img/1bot.png"));
        imageArray[9] = new ImageIcon(getClass().getResource("/view/img/1bot.png"));
        imageArray[10] = new ImageIcon(getClass().getResource("/view/img/1bot.png"));
    }
    
    
    public ImageIcon getImage(int index) {
        if(index >= 0 && index < imageArray.length) {
            return imageArray[index];
        }
        return null; // O una imagen predeterminada
    }
    
    
    public ImageIcon getHeartIcon() {
        return new ImageIcon(getClass().getResource("/view/img/heart.png"));
    }
     
    public ImageIcon getHeartIconOff() {
        return new ImageIcon(getClass().getResource("/view/img/heartoff.png"));
    }
    
    
    public int getCountdownValue() {
        return countdownValue;
    }
    // Métodos para la lógica del juego
    public void updateScore(int points) {
        // Actualiza el puntaje
    }

    public void updateLives() {
        // Actualiza las vidas
    }

    public void increaseSpeed() {
        // Aumenta la velocidad
    }

    

   

   

    public void startGame() {
    gameTimer.start();
    }
    
    public void stopGame() {
    gameTimer.stop();
    }
    
    
    public void setUpdateInterval(int intervalInMilliseconds) {
    this.updateInterval = intervalInMilliseconds;
    if (gameTimer.isRunning()) {
        gameTimer.stop();
        gameTimer.setDelay(updateInterval);
        gameTimer.start();
    } else {
        gameTimer.setDelay(updateInterval);
    }
}
    
     private void updateGameState() {
        System.out.println("El juego ha actualizado");
       

    }

    private void initCountdown() {
                Timer timer = new Timer(1000, e -> {
            if (countdownValue >= 1) {
                countdownValue--;
            } else {
                ((Timer) e.getSource()).stop();  // Detiene el temporizador
            }
        });
        timer.start();
    }
    
}

