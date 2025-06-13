package venda_make;

public class MaquiagemPele extends Produto implements Desconto{
    private TipoMaquiagemPele tipoMaquiagem;

    public MaquiagemPele(String nome, double preco, TipoMaquiagemPele tipoMaquiagem) {
        super(nome, preco);
        this.tipoMaquiagem = tipoMaquiagem;
    }

    public TipoMaquiagemPele getTipoMaquiagem() {
        return tipoMaquiagem;
    }

    @Override
    public double aplicarDesconto(double percentual) {
        double desconto = getPreco() * percentual/100;
        setPreco(getPreco() - desconto);
        return getPreco();
    }

    @Override
    public String toString() {
        return "Maquiagem para a Pele: " + getNome() + " | Tipo: " + getTipoMaquiagem() + " | R$ " + String.format("%.2f", getPreco());
    }



}
