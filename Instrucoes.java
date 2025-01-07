import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe mostra as instruçoes do jogo  
 * se a tecla "backspace" foi clicada e seleciona a classe startScreen
 * @author (Vitor) 
 * @version (1.1)
 */
public class Instrucoes extends World
{

    /**
     * Construtor do objeto da classe Instrucoes.
     * 
     */
    public Instrucoes()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
    
    public void act()
    {
        voltarMenu();
    }
    
    private void voltarMenu(){
        //Verifica se a tecla "backspace" esta pressionada e seleciona o mundo da startScreen
        if (Greenfoot.isKeyDown("backspace")){
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
