package venda_make;

public class ProdutoPele extends Produto implements Venda {
    public ProdutoPele(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public void vender(){
        System.out.println("Venda - Produto específico para a pele:" + getNome());
    }

    @Override
    public String toString() {
        return "[Pele] " + super.toString();
    }

}
