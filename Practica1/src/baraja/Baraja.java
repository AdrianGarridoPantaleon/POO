package baraja;

import java.util.ArrayList;
import java.util.Collections;

import carta.Carta;


public class Baraja {
    private ArrayList<Carta> cartasBaraja = new ArrayList<>();
    private TipoBaraja tipoBaraja;


    public Baraja(TipoBaraja tipoBaraja) {
        this.tipoBaraja = tipoBaraja;
        if (this.tipoBaraja == TipoBaraja.ESP) {
            crearBarajaEsp();
        } else {
            crearBarajaFr();
        }
    }

    private void crearBarajaEsp() {
        Carta carta;

        for (int i = 1; i <= 12; i++) {
            carta = new Carta(i, PalosCartas.OROS);
            this.cartasBaraja.add(carta);
        }

        for (int i = 1; i <= 12; i++) {
            carta = new Carta(i, PalosCartas.BASTOS);
            this.cartasBaraja.add(carta);
        }

        for (int i = 1; i <= 12; i++) {
            carta = new Carta(i, PalosCartas.COPAS);
            this.cartasBaraja.add(carta);
        }

        for (int i = 1; i <= 12; i++) {
            carta = new Carta(i, PalosCartas.ESPADAS);
            this.cartasBaraja.add(carta);
        }
    }

    private void crearBarajaFr() {
        Carta carta;

        for (int i = 1; i <= 13; i++) {
            carta = new Carta(i, PalosCartas.TREBOLES);
            this.cartasBaraja.add(carta);
        }

        for (int i = 1; i <= 13; i++) {
            carta = new Carta(i, PalosCartas.PICAS);
            this.cartasBaraja.add(carta);
        }

        for (int i = 1; i <= 13; i++) {
            carta = new Carta(i, PalosCartas.CORAZONES);
            this.cartasBaraja.add(carta);
        }

        for (int i = 1; i <= 13; i++) {
            carta = new Carta(i, PalosCartas.DIAMANTES);
            this.cartasBaraja.add(carta);
        }
    }

    public void barajar() {
        Collections.shuffle(this.cartasBaraja);
    }

    public Carta robarCarta() {
        Carta cartaRobada = this.cartasBaraja.get(0);
        this.cartasBaraja.remove(0);
        return cartaRobada;
    }
    
  
    public void mostrarBaraja() {
        for (Carta carta: this.cartasBaraja) {
            System.out.println(carta.toString());
        }
    }

}