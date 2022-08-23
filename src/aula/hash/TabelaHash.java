package aula.hash;
import java.util.LinkedList;
import java.util.List;

public class TabelaHash {
    private int m; // total de classes
    private List tabela[];
    
    public TabelaHash(int totalClasses) {
        this.m = totalClasses;
        this.tabela = new LinkedList[this.m];    
        for (int i = 0; i < this.m; i++) {
            this.tabela[i] = new LinkedList();   
        }          
    }           
    
    public int funcaoHash(int chave) {
        return chave % this.m;  // resto da divisão da chave
    }
    
    public void insereChave(int chave) {
        int classe = funcaoHash(chave);
        this.tabela[classe].add(chave);
    }
    
    public int pesquisa(int chave) {
        int posicao = -1;
        int classe = funcaoHash(chave);
        List listaValores = this.tabela[classe];
        for (int i = 0; i < listaValores.size(); i++) {
            int valor = (int) listaValores.get(i);
            if (valor == chave) {
                posicao = i;
                break;
            }
        }
       
        return posicao;
    }
    
    public void remove(int chave){
        int classe = funcaoHash(chave);
        int posicao = pesquisa(chave);
        if (posicao != -1) {
            this.tabela[classe].remove(posicao);
            System.out.println("Valor " + chave + ", removido da classe " + classe + " na posição " + posicao + ".");
        } else {
            System.out.println("Valor " + chave + " inexistente na tabela.");
        }
    }
    
    public void mostra() {
        
        for (int i = 0; i < this.m; i++) {
           System.out.println("Classe: " + i 
                   + " lista de valores: " + this.tabela[i].toString()); 
        }
        
    }  
}



