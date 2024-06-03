import java.util.ArrayList;
import java.util.Random;

public class Aventureiro {
    private String nome;
    private int posicao;
    private int energia;
    private ArrayList<Tesouro> tesourosColetados;

    public Aventureiro(String nome) {
        this.nome = nome;
        this.posicao = 0; 
        this.energia = 10; 
        this.setTesourosColetados(new ArrayList<>());
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void mover(Labirinto labirinto, int base) {
        if (energia <= 0) {
            System.out.println("Energia insuficiente para mover.");
            return;
        }

        Random rand = new Random();
        int novaPosicao = posicao + rand.nextInt(6) + 1; 

        try {
            if (labirinto.isDentroDoLabirinto(novaPosicao, 0)) {
                this.posicao = novaPosicao;
                System.out.println(nome + " se moveu para a posição " + novaPosicao + ". Energia restante: " + energia);
                labirinto.atualizarPosicaoAventureiro(novaPosicao, base / 2); 
            } else {
                throw new Exception("Movimento inválido! Fora do labirinto.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void descansar() {
        if(energia>=10){
            System.out.println("você ja esta descansado, deixe de preguiça e siga seu caminho");
        }
        else{
            this.energia += 2;
            System.out.println(nome + " descansou e recuperou 2 de energia. Energia atual: " + energia);
        }
    }

    public void interagir(Labirinto labirinto) {
        System.out.println("Interagindo...");
    }

	public ArrayList<Tesouro> getTesourosColetados() {
		return tesourosColetados;
	}

	public void setTesourosColetados(ArrayList<Tesouro> tesourosColetados) {
		this.tesourosColetados = tesourosColetados;
	}

    public void moverNorte(Labirinto labirinto, int tamanho) {
        if (energia <= 0) {
            System.out.println("Energia insuficiente para mover.");
            return;
        }

        int novaLinha = linha - tamanho;
        int novaColuna = coluna;

        if (labirinto.isDentroDoLabirinto(novaLinha, novaColuna)) {
            this.linha = novaLinha;
            this.coluna = novaColuna;
            this.energia -= 1;
            System.out.println(nome + " se moveu para o Norte. Nova posição: (" + linha + ", " + coluna + "). Energia restante: " + energia);
            labirinto.atualizarPosicaoAventureiro(novaLinha, novaColuna);
        } else {
            System.out.println("Movimento inválido! Fora do labirinto.");
        }
    }

    public void moverSul(Labirinto labirinto, int tamanho) {
        if (energia <= 0) {
            System.out.println("Energia insuficiente para mover.");
            return;
        }

        int novaLinha = linha + tamanho;
        int novaColuna = coluna;

        if (labirinto.isDentroDoLabirinto(novaLinha, novaColuna)) {
            this.linha = novaLinha;
            this.coluna = novaColuna;
            this.energia -= 1;
            System.out.println(nome + " se moveu para o Sul. Nova posição: (" + linha + ", " + coluna + "). Energia restante: " + energia);
            labirinto.atualizarPosicaoAventureiro(novaLinha, novaColuna);
        } else {
            System.out.println("Movimento inválido! Fora do labirinto.");
        }
    }

    public void moverLeste(Labirinto labirinto, int tamanho) {
        if (energia <= 0) {
            System.out.println("Energia insuficiente para mover.");
            return;
        }

        int novaLinha = linha;
        int novaColuna = coluna + tamanho;

        if (labirinto.isDentroDoLabirinto(novaLinha, novaColuna)) {
            this.linha = novaLinha;
            this.coluna = novaColuna;
            this.energia -= 1;
            System.out.println(nome + " se moveu para o Leste. Nova posição: (" + linha + ", " + coluna + "). Energia restante: " + energia);
            labirinto.atualizarPosicaoAventureiro(novaLinha, novaColuna);
        } else {
            System.out.println("Movimento inválido! Fora do labirinto.");
        }
    }

    public void moverOeste(Labirinto labirinto, int tamanho) {
        if (energia <= 0) {
            System.out.println("Energia insuficiente para mover.");
            return;
        }

        int novaLinha = linha;
        int novaColuna = coluna - tamanho;

        if (labirinto.isDentroDoLabirinto(novaLinha, novaColuna)) {
            this.linha = novaLinha;
            this.coluna = novaColuna;
            this.energia -= 1;
            System.out.println(nome + " se moveu para o Oeste. Nova posição: (" + linha + ", " + coluna + "). Energia restante: " + energia);
            labirinto.atualizarPosicaoAventureiro(novaLinha, novaColuna);
        } else {
            System.out.println("Movimento inválido! Fora do labirinto.");
        }
    }

    public void descansar() {
        if (energia >= 10) {
            System.out.println("Você já está descansado, deixe de preguiça e siga seu caminho.");
        } else {
            this.energia += 2;
            System.out.println(nome + " descansou e recuperou 2 de energia. Energia atual: " + energia);
        }
    }

    public void interagir(Labirinto labirinto) {
        System.out.println("Interagindo...");
    }

    public ArrayList<Tesouro> getTesourosColetados() {
        return tesourosColetados;
    }

    public void setTesourosColetados(ArrayList<Tesouro> tesourosColetados) {
        this.tesourosColetados = tesourosColetados;
    }
}
