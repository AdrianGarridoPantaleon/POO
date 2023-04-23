package carta;

import baraja.PalosCartas;

public class Carta {
    private int valorCarta;
    private PalosCartas paloCarta;

    public Carta(int valorCarta, PalosCartas paloCarta) {
        this.setValorCarta(valorCarta);
        this.setPaloCarta(paloCarta);
    }

    @Override
    public String toString() {
        return "Carta: " + this.valorCarta + " de " + this.paloCarta;
    }

    public int getValorCarta() {
        return valorCarta;
    }

    public void setValorCarta(int valorCarta) {
        this.valorCarta = valorCarta;
    }

    public PalosCartas getPaloCarta() {
        return paloCarta;
    }

    public void setPaloCarta(PalosCartas paloCarta) {
        this.paloCarta = paloCarta;
    }
}