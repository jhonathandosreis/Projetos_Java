
package classes;

public abstract class AbsPilhaDivisao {
    // ATIBUTOS
    private int a;
    private int tamanho ;
    private int[] PilhaConvertida ;
    private int topo ;
    
    // MÉTODOS
    public AbsPilhaDivisao() {
        a = 0;
        this.tamanho = 0;
        this.PilhaConvertida = new int[tamanho];
        this.topo = -1;
    }

    public AbsPilhaDivisao(int a, int tamanho, int[] resto, int topo) {
        this.a = a;
       this.tamanho = tamanho;
        this.PilhaConvertida = new int[tamanho];
        this.topo = -1;       
    }

    

    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }


    /**
     * @return the tamanho
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the resto
     */
    public int[] getResto() {
        return PilhaConvertida;
    }

    /**
     * @param resto the resto to set
     */
    public void setResto(int[] resto) {
        this.PilhaConvertida = resto;
    }

    /**
     * @return the topo
     */
    public int getTopo() {
        return topo;
    }

    /**
     * @param topo the topo to set
     */
    public void setTopo(int topo) {
        this.topo = topo;
    }

    public abstract int base();
    
    public int [] mudancaDeBase (int valorParaConverter ){
        int resultado = valorParaConverter/base();       // Ja faz a primeira divisão para continuar dividindo dentro do for pela base passada no metodo abstrato
        int restodadivisao = valorParaConverter%base(); // pega o resto dessa divisão
        inserir(restodadivisao);                       // Ja insese o primeiro valor na pilha no indise 0 que re´resenta o topo depois de inserir que é o resto da divisao vo valor com a base
        int tamanhoPilha = tamanhoDaPilha(valorParaConverter, base()); // chamo o metodo que criei para dizer o tamanho que a pilha tera
       for(int i = 0 ; i < tamanhoPilha-1 ; i++ ){   // como ja inseri um valor a pilha roda ate  pilha-1
           restodadivisao =  resultado % base();    //continuo pegando o resto e inserindo na pilha
           resultado = resultado / base();         // dividindo o tanto de vezes nessesaria
           inserir(restodadivisao);               // inserindo o resto na pilha que é o numero convertido
       } 
       
     return PilhaConvertida;
    } 
     
    public int tamanhoDaPilha(int valor, int base){ // Fiz esse metodo para saber o tanto de numeros iria ter o numero convertido
        int tamanhovet = 1;                        // como ja faço uma divisao fora do laço ja inicializo com um
        int resultado = valor/base;               // divido para saber a quantidade de restos que ira dar
        while (resultado!= 0) {                  // enquanto o resultado de valor / base nao for zero , pego esse resultado e continuo dividindo pela base     
            resultado = resultado / base;       //faço a divisao do resultado com a base passada o metodo abstrato
            tamanhovet++;                      //incremento o tamanho que o vetor tera
        }
        return tamanhovet;             
    }
    
    public void inserir (int valor){
       if(estaCheia()) throw  new RuntimeException("Pilha cheia");
       PilhaConvertida[ getTopo() + 1 ] = valor;
       topo++;
    }
    
    public void retirar() {
       if(estaVazia()) throw  new RuntimeException("Pilha vazia");
       topo--;
    }
    
     public int consultar (){
       if(estaVazia()) throw  new RuntimeException("Pilha vazia");
       int resposta = PilhaConvertida[getTopo()];
       return resposta;
    }
    
    public boolean estaCheia() {
        return getTopo() == (tamanho - 1);
    }

    public boolean estaVazia() {
        return getTopo() == -1;
    }
    
    public  int quantidadeElementos(){
        return  getTopo()+1;
    }
    
   
    }
        

