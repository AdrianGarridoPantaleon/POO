package juego;

import baraja.*;
import carta.Carta;
import jugador.Jugador;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private int modoDeJuego;
    private Baraja barajaJuego;
    private final Scanner sc = new Scanner(System.in);

    private void mostrarCabecera() {
        System.out.println(
                /*********************************************/
                /********* JUEGO DEL 7 y MEDIO ***************/
                /*********************************************/
                "Modos de juego:"+
                "(1) Un jugador"+
                "(2) Dos jugadores");
    }

    private void seleccionarModoDeJuego() {
        System.out.print("Elija el modo de juego: ");
        this.modoDeJuego = this.sc.nextInt();
    }

    private void seleccionarBaraja() {
        System.out.println(
                "Tipos de baraja: "+
                "(E) Española"+
                "(F) Francesa");
        
        System.out.print("Elija el tipo de baraja: ");
        String tipoBaraja = sc.next();
        if (tipoBaraja.equals("E")) {
            this.barajaJuego = new Baraja(TipoBaraja.ESP);
        } else if (tipoBaraja.equals("F")) {
            this.barajaJuego = new Baraja(TipoBaraja.FR);
        }
        this.barajaJuego.barajar();
    }

    private Jugador datosJugador(int i) {
        String nombre, alias, primerApellido, segundoApellido;
        System.out.println("Introduzca los datos del jugador " + i + ".");
        System.out.print("Alias: ");
        alias = sc.next();
        System.out.print("Nombre: ");
        nombre = sc.next();
        System.out.print("Primer apellido: ");
        primerApellido = sc.next();
        System.out.print("Segundo apellido: ");
        segundoApellido = sc.next();
        return new Jugador(alias, nombre, primerApellido + " " + segundoApellido, true);
    }

    private boolean puntuarJugador(Jugador jugador, Carta carta) {
        if (carta.getValorCarta() <= 7) {
            jugador.setPuntuacion(jugador.getPuntuacion() + carta.getValorCarta());
        } else if (carta.getValorCarta() > 7) {
            jugador.setPuntuacion(jugador.getPuntuacion() + 0.5);
        }

        if (jugador.getPuntuacion() > 7.5) {
            jugador.setPuntuacion(0);
            System.out.println("Tu turno ha finalizado, has superado el 7,5.");
            return false;
        } else if (jugador.getPuntuacion() == 7.5) {
            System.out.println("Enhorabuena, has alcanzado la puntuación de 7,5.");
            return false;
        }

        return true;
    }

    private void partidaJugador(Jugador jugador, int i) {
        System.out.println("----------------------------------------");
        System.out.println("Inicio jugada jugador " + i + " - " + jugador.getNombre() + " " + jugador.getApellidos() + " " + "(" + jugador.getAlias() + ")");
        System.out.println("----------------------------------------");
        String sigueJugando = "S";
        boolean puntuaJugador;
        if (jugador.esMaquina()) {
            while (sigueJugando.equals("S")) {
                Carta carta = this.barajaJuego.robarCarta();
                jugador.getCartasJugador().add(carta);
                System.out.println(carta.toString());
                puntuaJugador = puntuarJugador(jugador, carta);
                if (puntuaJugador) {
                    System.out.print("¿Desea una nueva carta? S/N: ");
                    sigueJugando = sc.next();
                } else {
                    break;
                }
            }
        } else {
            if (jugador1.getPuntuacion() == 0) {
                Carta carta = this.barajaJuego.robarCarta();
                jugador.getCartasJugador().add(carta);
                puntuarJugador(jugador, carta);
            } else {
                Random rand = new Random();
                int turnosMaquina = rand.nextInt((8 - 1) + 1) + 1;
                for (int j = 0; j < turnosMaquina; j++) {
                    Carta carta = this.barajaJuego.robarCarta();
                    jugador.getCartasJugador().add(carta);
                    puntuaJugador = puntuarJugador(jugador, carta);
                    if (puntuaJugador) {
                        System.out.println(carta.toString());
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println("El jugador " + i + " se planta con las siguientes cartas ");
        jugador.mostrarCartas();
    }

    private void establecerGanador() {
        if (jugador1.getPuntuacion() > jugador2.getPuntuacion()) {
            System.out.println("Ha ganado el jugador 1.");
        } else if (jugador1.getPuntuacion() < jugador2.getPuntuacion()){
            System.out.println("Ha ganado el jugador 2.");
        } else {
            System.out.println("Empate.");
        }
    }

    public void iniciarPartida() {
        mostrarCabecera();
        seleccionarModoDeJuego();
        jugador1 = datosJugador(1);
        if (this.modoDeJuego == 1) {
            jugador2 = new Jugador("autogen", "player2", "auto generado", false);
        } else {
            jugador2 = datosJugador(2);
        }
        seleccionarBaraja();
        partidaJugador(jugador1, 1);
        partidaJugador(jugador2, 2);
        establecerGanador();
    }

}
