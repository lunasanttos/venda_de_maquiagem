package venda_make;

public class MaquiagemOlhos extends Produto implements Desconto{
    private TipoMaquiagemOlhos tipo;

    public MaquiagemOlhos(String nome, double preco, TipoMaquiagemOlhos tipo){
        super(nome, preco);
        this.tipo = tipo;
    }

    public TipoMaquiagemOlhos getTipo() {
        return tipo;
    }

    @Override
    public double aplicarDesconto(double percentual) {
        double desconto = getPreco() * percentual/100;
        setPreco(getPreco() - desconto);
        return getPreco();
    }

    @Override
    public String toString() {
        return "Maquiagem para os Olhos: " + getNome() + " | Tipo: " + getTipo() + " | R$ " + String.format("%.2f", getPreco());
    }
}
