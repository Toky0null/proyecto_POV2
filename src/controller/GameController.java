/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

//import model.GameModel;

import javax.swing.ImageIcon;
import model.GameModel;
import view.Game1;

//import view.GameView;

/**
 *
 * @author tokyo
 */
//Clase del Controlador (Controller)
public class GameController {
    private GameModel model;
    private Game1 view;
    // Agrega más atributos según sea necesario
    //(GameModel model, GameView view)

    public GameController(GameModel model) {
        this.model = model;  
        
    }
    
     public void setView(Game1 view) {
        this.view = view;
    }

    // Métodos para controlar eventos de usuario
    public void onBoxClick() {
        // Lógica cuando el usuario hace clic en un cuadro
    }

    public void onPlayButtonClick() {
        // Lógica cuando el usuario presiona el botón "Jugar"
    }

    // Agrega más métodos para controlar otros eventos
    public ImageIcon getImage(int index) {
        return model.getImage(index);
    }
    
    public ImageIcon getHeartIcon() {
        return model.getHeartIcon();
    }
    
     public ImageIcon getHeartIconOff() {
        return model.getHeartIconOff();
    }
    
    
    public void showGame(GameModel model){ 
       Game1 gameWindow = new Game1(this,model);
       this.view = gameWindow;
       gameWindow.setVisible(true);
       System.out.println("El juego ha iniciado");
    }
    
    public void updateGame(){
    
    view.updateComponent();
    model.setUpdateInterval(2500);
    
    }

    
}