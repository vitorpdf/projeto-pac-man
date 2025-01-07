import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fantasma here.
 * 
 * @author (Vitor Firmino,Gabriel Henrique, Gabriela  ) 
 * @version (1.1 - 20/12/2024 - Versão inicial oficial.)
 */
public class Fantasma extends Actor
{   
    private static int velocidade = 3;
    // indica se o fantasma está viva ou não
    private boolean estaVivoF;
    // Referência ao jogador
    private PacJogador pacJogador;

    public Fantasma(){
        GreenfootImage imagem = new GreenfootImage("fantasma-azul.png");
        // como a imagem é muito grande, vamos redimensioná-la para 27x34 pixels
        imagem.scale(27,34);
        // usamos a imagem como a imagem do Fantasma
        setImage(imagem);

    }

    /**
     * Act - do whatever the Fantasma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        comer();
        movimentar();
    }
    
    /**
     * Método responsável por mover o fantasma. 
       Optamos por criar um movimento imprevisível, em que em 10% das 
       vezes o fantasma gira aleatoriamente entre -60 e 60 graus.

     */
    public void movimentar(){
        move(velocidade);
        isAtEdge();
        if (Greenfoot.getRandomNumber(100) < 10) {
            int angulo = Greenfoot.getRandomNumber(90) -60;
            turn(angulo);
        }
    }
    /**
     * Esse método verifica se o fantasma colidiu com o jogador, se não houver colisão 
     * retornará null. Se houver colisão, o jogador é removido do mundo, simulando que foi "comido"
     */
    public void comer(){
        PacJogador  pac = (PacJogador) getOneIntersectingObject(PacJogador.class);
        
        if (pac != null) {
            // Obtemos uma referência (ponteiro) para o mundo
            World mundo = getWorld();
            // Removemos o pac do mundo
            mundo.removeObject(pacJogador);
            pac.fantasmizado();

        }
    }
    /**
     * Método responsável por definir o fantasma como morto.
     */
    public void morreu(){
        if (estaVivoF){
            estaVivoF= false;

        }
    }
}
