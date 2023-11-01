/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view; 

/**
 *public void propertyChange(PropertyChangeEvent evt) {
    if ("countdownValue".equals(evt.getPropertyName())) {
        int newValue = (int) evt.getNewValue();
        if (newValue >= 1) {
            countdownLabel.setText(String.valueOf(newValue));
        } else {
            countdownLabel.setText("¡Ya!");
            // Después de un corto tiempo, podrías remover el label si lo deseas:
            new Timer(1000, e -> {
                remove(countdownLabel);
                revalidate();
                repaint();
                ((Timer) e.getSource()).stop();
            }).start();

            model.startGame();
        }
    } 
} 
 * @author tokyo
 */


import controller.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.Timer; 
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.border.LineBorder;
import model.GameModel;

public class Game1 extends JFrame {

    private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanel5, jPanel6, jPanel7, jPanel8, jPanel9, livesPanel;
    private JLabel score,heart1, heart2, heart3;
    private GameController controller;
    private JLabel countdownLabel;  // Etiqueta para mostrar la cuenta regresiva
    private final int countdownValue = 3;  // Valor inicial de la cuenta regresiva
    private GridBagConstraints countdownConstraints;
    private GameModel model;

    public Game1(GameController controller, GameModel model) {
        this.controller = controller; // Inicializa el controlador
        this.model = model;
        initComponents();
        initLives();
        setLayoutComponents(); 
// Temporizador que consulta el valor de countdownValue
        Timer countdownCheckTimer = new Timer(1000, e -> updateCountdownLabel());
        countdownCheckTimer.start();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(812, 650);  // Ajusta el tamaño de la ventana directamente aquí.
        setResizable(false);
        setLocationRelativeTo(null); 
       
        
        
// Evento de tecla para el JFrame
    this.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                handleAction();
            }
        }
    });
    this.setFocusable(true);
    this.requestFocusInWindow();
}
    
    
    

    private void initComponents() {
         if(controller == null) {
        throw new RuntimeException("El controlador no ha sido inicializado.");
        }
        score = new JLabel("Score");
        score.setFont(new java.awt.Font("Fira Code Retina", 0, 24));
        jPanel1 = createPanel(controller.getImage(10));
        jPanel2 = createPanel(controller.getImage(10));
        jPanel3 = createPanel(controller.getImage(10));
        jPanel4 = createPanel(controller.getImage(10));
        jPanel5 = createPanel(controller.getImage(10));
        jPanel6 = createPanel(controller.getImage(10));
        jPanel7 = createPanel(controller.getImage(10));
        jPanel8 = createPanel(controller.getImage(10));
        
        jPanel9 = new JPanel();
        jPanel9.setBackground(Color.WHITE);
        jPanel9.setPreferredSize(new Dimension(110, 95));
        jPanel9.setBorder(new LineBorder(Color.GREEN));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            handleAction();
        }
    });
        
        countdownLabel = new JLabel(String.valueOf(countdownValue));
        countdownLabel.setFont(new Font("Fira Code Retina", Font.BOLD, 36));
        countdownLabel.setHorizontalAlignment(JLabel.CENTER);
        
    }

    private JPanel createPanel(ImageIcon image) {
     JPanel panel = new JPanel(new BorderLayout());
    if(image != null) {
        Image scaledImage = image.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(scaledImage));
        panel.add(label, BorderLayout.CENTER);
    }
    panel.setPreferredSize(new Dimension(120, 100)); // Define un tamaño para los paneles
    return panel;
    }

    private void setLayoutComponents() {
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
  
    
    gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes
    //gbc.fill = GridBagConstraints.BOTH; // Para que los componentes llenen las celdas
    gbc.weightx = 1; // Asigna un peso en x
    gbc.weighty = 1; // Asigna un peso en y

    // Posicionamiento del Score en la esquina superior izquierda
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.NORTHWEST; // Alinea el componente hacia el noroeste
    add(score, gbc);

    // Restablecemos las restricciones para los paneles
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.CENTER; // Alinea el componente al centro

    // Posicionamiento de los paneles
    gbc.gridx = 0;
    gbc.gridy = 1;
    add(jPanel1, gbc);
    
    gbc.gridx = 1;
    add(jPanel2, gbc);

    gbc.gridx = 2;
    add(jPanel3, gbc);

    gbc.gridy = 2;
    gbc.gridx = 0;
    add(jPanel4, gbc);

    gbc.gridx = 1;
    add(jPanel5, gbc);

    gbc.gridx = 2;
    add(jPanel6, gbc);
    
    gbc.gridy = 3;
    gbc.gridx = 0;
    add(jPanel7, gbc);

    gbc.gridx = 1;
    add(jPanel8, gbc);
    
    gbc.gridy = 4;
    gbc.gridx = 2;
    add(jPanel9, gbc);
    
    gbc.gridx = 1;
    gbc.gridy = 4;
    add(countdownLabel, gbc);
    
    // Posicionamiento del contador de vidas en la esquina superior derecha
    GridBagConstraints gbcLives = new GridBagConstraints();
    gbcLives.gridx = 2;
    gbcLives.gridy = 0;
    gbcLives.anchor = GridBagConstraints.NORTHEAST; // Alinea el componente hacia el noreste
    add(livesPanel, gbcLives);
    
    
   
    
    }  

    

    private void handleAction() {
         System.out.println("Accion ejecutada!");
    }

    private void initLives() {
        
        ImageIcon heartIconOriginal = controller.getHeartIconOff();
        
    if(heartIconOriginal != null) {
        Image scaledHeart = heartIconOriginal.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon heartIcon = new ImageIcon(scaledHeart);
        
        // Inicializamos los JLabels con la imagen del corazón
        heart1 = new JLabel(heartIcon);
        heart2 = new JLabel(heartIcon);
        heart3 = new JLabel(heartIcon);
    }
    
    livesPanel = new JPanel();
    livesPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    livesPanel.add(heart1);
    livesPanel.add(heart2);
    livesPanel.add(heart3);
    }

    public void updateComponent() {
    updatePanelImage(jPanel1, controller.getImage(0));
    updatePanelImage(jPanel2, controller.getImage(0));
    updatePanelImage(jPanel3, controller.getImage(0));
    updatePanelImage(jPanel4, controller.getImage(10));
    updatePanelImage(jPanel5, controller.getImage(10));
    updatePanelImage(jPanel6, controller.getImage(10));
    updatePanelImage(jPanel7, controller.getImage(10));
    updatePanelImage(jPanel8, controller.getImage(10));
}


private void updatePanelImage(JPanel panel, ImageIcon newImage) {
    if(newImage != null) {
        Image scaledImage = newImage.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(scaledImage));
        panel.removeAll();
        panel.add(label, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }


}

     private void updateCountdownLabel() {
        int newValue = model.getCountdownValue();
        if (newValue >= 1) {
            countdownLabel.setText(String.valueOf(newValue));
        } else {
            countdownLabel.setText("¡Ya!");
            // Opcionalmente, después de un corto tiempo, podrías remover el label:
            new Timer(1000, e -> {
                remove(countdownLabel);
                revalidate();
                repaint();
                ((Timer) e.getSource()).stop();
            }).start();
            
            model.startGame();
        }
    }

}
    
   
    

