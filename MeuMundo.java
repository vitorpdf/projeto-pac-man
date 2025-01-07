import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Vitor Firmino,Gabriel Henrique, Gabriela Ribeiro  ) 
 * @version (1.1 - 20/12/2024 - Versão inicial oficial.)
 */
public class MeuMundo extends World
{
    private PacJogador pacJogador;
    private Fantasma fantasma;
    private Placar placar;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MeuMundo()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
         // Cria uma imagem do tamanho do mundo
        GreenfootImage imagemFundoPreto = new GreenfootImage(800, 600);
        // Desenha um retângulo preto em toda a imagem
        imagemFundoPreto.setColor(Color.BLACK);
        imagemFundoPreto.fillRect(0, 0, 800, 600);
        // Define a imagem com o plano de fundo do mundo
        setBackground(imagemFundoPreto);
        placar = new Placar();
        // Adiciona o placar na parte superior esquerda do mundo
        addObject(placar, 100, 20);
        
        prepare();
        criarLabirinto();
        
    }
    
        private void prepare() {
        //Adiciona o Pac ao mundo
        PacJogador pacJogador = new PacJogador();
        addObject(pacJogador,69,55);
        Fantasma fantasma = new Fantasma();
        addObject(fantasma,400,300);
        Fantasma fantasma2 = new Fantasma();
        addObject(fantasma2,430,300);
        Fantasma fantasma3 = new Fantasma();
        addObject(fantasma3,370,300);
             
    }
    
    /**
     * Método chamado quando o jogo termina
     */
    public void fimDeJogo() {
        // Exibe a tela de game over
        Greenfoot.setWorld(new TelaGameOver());
    }
    
    public Placar getPlacar() {
        return placar;
    }
    
    /**
     * Verifica se todas as bolas foram comidas.
     * Se sim, exibe a tela de vitória.
     */
    public void verificarVitoria() {
        if (getObjects(Bola.class).isEmpty()) {
            mostrarTelaVitoria();
        }
        
    }
    
        /**
     * Cria um labirinto de bolas no mundo.
     */
    private void criarLabirinto() {
        // Define o tamanho e a posição inicial do labirinto
        int espacoEntreBolas = 33; // Distância entre as bolas
        int inicioX = 50; // Posição inicial no eixo X
        int inicioY = 50; // Posição inicial no eixo Y
        int linhas = 16;   // Número de linhas do labirinto
        int colunas = 22;  // Número de colunas do labirinto

        // Gera as bolas em posições fixas
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                // Cria espaços vazios para formar o labirinto
                if ((i % 2 == 0 || j % 3 != 0) && !(i == 5 && j > 5 && j < 10)) {
                    Bola bola = new Bola();
                    addObject(bola, inicioX + j * espacoEntreBolas, inicioY + i * espacoEntreBolas);
                }
            }
        }
    }
    
     /**
     * Exibe a tela de vitória.
     */
    private void mostrarTelaVitoria() {
        GreenfootImage telaVitoria = new GreenfootImage(getWidth(), getHeight());
        telaVitoria.setColor(Color.BLACK);
        telaVitoria.fill();
        
        // Carrega a imagem do logotipo
        GreenfootImage logo = new GreenfootImage("pac-man-logo-png-transparent.png");
        logo.scale(500, 500); // Ajusta o tamanho do logotipo
        getBackground().drawImage(logo, getWidth() / 2 - logo.getWidth() / 2, 0);

        telaVitoria.setColor(Color.YELLOW);
        telaVitoria.setFont(new Font("Arial", 50));
        telaVitoria.drawString("Você Venceu!", getWidth() / 2 - 150, getHeight() / 2);

        setBackground(telaVitoria);
        Greenfoot.stop(); // Pausa o jogo
    }
}
