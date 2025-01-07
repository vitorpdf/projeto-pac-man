import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe Placar: Gerencia a pontuação e as vidas no jogo.
 */
public class Placar extends Actor {

    private int pontuacao;
    private int vidas;

    public Placar() {
        pontuacao = 0;
        vidas = 3; // Começa com 3 vidas, mas você pode alterar
        atualizarImagem();
    }

    /**
     * Atualiza a imagem do placar exibida na tela.
     */
    private void atualizarImagem() {
        GreenfootImage imagem = new GreenfootImage(200, 50); // Largura e altura do placar
        imagem.setColor(Color.BLACK);
        imagem.fillRect(0, 0, 200, 50);

        imagem.setColor(Color.YELLOW);
        imagem.setFont(imagem.getFont().deriveFont(18.0f)); // Define o tamanho da fonte

        // Exibe a pontuação e as vidas no placar
        imagem.drawString("Pontuação: " + pontuacao, 10, 20);
        imagem.drawString("Vidas: " + vidas, 10, 40);

        setImage(imagem);
    }

    /**
     * Adiciona pontos ao placar.
     */
    public void adicionarPontos(int pontos) {
        pontuacao += pontos;
        atualizarImagem();
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
