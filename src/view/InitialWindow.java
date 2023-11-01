package view;

import controller.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import model.GameModel;
import model.TextPrompt;

public class InitialWindow extends JFrame {

    private JLabel adosaII;
    private JLabel creators;   
    private JButton getOut;
    private JButton init;
    private JButton instructions;
    private JButton purposeButton;  //botón "Para qué sirve"
    public JTextField TFname;
    private BackGround background;
    public String playerT;
    GameController controller;
    GameModel model;

    public InitialWindow() {
        super("Menú Principal");
        settWindow();
        initiaLabels();
        initButtons();
        //initTextFields();
        initialWindowGame();   
        model = new GameModel();
        controller = new  GameController(model);

    }

    public void settWindow(){
        background = new BackGround();
        
        this.setContentPane(background);
        this.setSize(380, 430);  // Incremento en el tamaño de la ventana
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public void initiaLabels(){
        adosaII = new JLabel("ADOSADOS");
        adosaII.setOpaque(true);
        adosaII.setBounds(90, 30, 200, 40);
        adosaII.setFont(new Font("Arial Black", 1, 30));
        adosaII.setHorizontalAlignment(SwingConstants.CENTER);
        adosaII.setBackground(new Color(255, 255, 255, 0));
        this.add(adosaII);  

        creators = new JLabel("by:@Toky0null");
        creators.setOpaque(true);
        creators.setBounds(182, 365, 200, 30);  // Ajuste en la posición
        creators.setFont(new Font("Arial", 0, 11));
        creators.setHorizontalAlignment(SwingConstants.CENTER);
        creators.setBackground(new Color(255, 255, 255, 0));
        this.add(creators);
    }

    public void initButtons(){
        init = new JButton("Iniciar");
        init.setOpaque(true);
        init.setBounds(135, 145, 110, 35);  // Ajuste en la posición
        init.setFont(new Font("Arial Black", 0, 16));
        init.setHorizontalAlignment(SwingConstants.CENTER);
        init.setBackground(new Color(240, 240, 240));
        init.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(init);

        instructions = new JButton("Instrucciones");
        instructions.setOpaque(true);
        instructions.setBounds(135, 190, 110, 35);  // Ajuste en la posición
        instructions.setFont(new Font("Arial Black", 0, 11));
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        instructions.setBackground(new Color(240, 240, 240));
        instructions.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(instructions);

        purposeButton = new JButton("Para qué sirve");
        purposeButton.setOpaque(true);
        purposeButton.setBounds(135, 235, 110, 35);  // Posición del nuevo botón
        purposeButton.setFont(new Font("Arial Black", 0, 10));
        purposeButton.setHorizontalAlignment(SwingConstants.CENTER);
        purposeButton.setBackground(new Color(240, 240, 240));
        purposeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(purposeButton);

        getOut = new JButton("Salir");
        getOut.setOpaque(true);
        getOut.setBounds(135, 280, 110, 35);  // Ajuste en la posición
        getOut.setFont(new Font("Arial Black", 0, 16));
        getOut.setHorizontalAlignment(SwingConstants.CENTER);
        getOut.setBackground(new Color(240, 240, 240));
        getOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(getOut);
    }

    
    /**
  public void initTextFields() {
        TFname = new JTextField(10);
        TFname.setBounds(115, 85, 150, 35);  // Ajuste en la posición
        TextPrompt placeholder = new TextPrompt("Ingrese su nombre", TFname);
        placeholder.setFont(new Font("Arial", 2, 13));
        placeholder.setForeground(Color.lightGray);
        this.add(TFname);
    }
  
 */
   

    public void initialWindowGame() {
        init.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // playerT = TFname.getText();
                
                controller.showGame(model);
            }
        });
    }  
}
