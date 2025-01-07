import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe TelaGameOver: Exibe a tela de Game Over.
 * 
 * Inclui o logotipo do Pac-Man e o texto "Game Over!".
 * @author (Vitor Firmino,Gabriel Henrique, Gabriela  ) 
 * @version (1.1 - 20/12/2024 - Versão inicial oficial.)
 */
public class TelaGameOver extends World {

    /**
     * Construtor para objetos da classe TelaGameOver.
     */
    public TelaGameOver() {    
        // Define o tamanho do mundo: 800 pixels de largura, 600 de altura
        super(800, 600, 1);
        // Prepara o mundo com os elementos iniciais
        prepare();
    }
    
    /**
     * Prepara o mundo adicionando o logotipo e o texto "Game Over!".
     */
    private void prepare() {
        // Define o fundo como a cor preta
        GreenfootImage fundo = new GreenfootImage(getWidth(), getHeight());
        fundo.setColor(Color.BLACK);
        fundo.fill();
        setBackground(fundo);

        // Carrega a imagem do logotipo
        GreenfootImage logo = new GreenfootImage("pac-man-logo-png-transparent.png");
        logo.scale(500, 500); // Ajusta o tamanho do logotipo
        getBackground().drawImage(logo, getWidth() / 2 - logo.getWidth() / 2, 0);

        // Adiciona o texto "Game Over!"
        GreenfootImage textoGameOver = new GreenfootImage("Game Over!", 80, Color.YELLOW, new Color(0, 0, 0, 0));
        getBackground().drawImage(textoGameOver, getWidth() / 2 - textoGameOver.getWidth() / 2, 350);
    }
}
