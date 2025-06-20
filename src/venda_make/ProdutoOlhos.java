package venda_make;

public class ProdutoOlhos extends Produto implements Venda {
    public ProdutoOlhos(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public void vender(){
        System.out.println("Venda - Produto específico para os olhos: " + getNome());
    }

    @Override
    public String toString() {
        return "[Olhos] " + super.toString();
    }

}
