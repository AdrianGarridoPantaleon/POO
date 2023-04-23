package jugador;

import carta.Carta;
import java.util.ArrayList;

public class Jugador {
    private final String alias;
    private final String nombre;
    private final String apellidos;
    private boolean maquina;
    private double puntuacion = 0;
    private final ArrayList<Carta> cartasJugador = new ArrayList<>();

    public Jugador(String alias, String nombre, String apellidos, boolean maquina) {
        this.alias = alias;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.maquina = maquina;
    }

    public void mostrarCartas() {
        for (Carta carta: this.cartasJugador) {
            System.out.println(carta.toString());
        }
    }

    public String getAlias() {
        return alias;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public boolean esMaquina() {
        return maquina;
    }

    public void setEsMaquina(boolean maquina) {
        this.maquina = maquina;
    }

    public ArrayList<Carta> getCartasJugador() {
        return cartasJugador;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
}