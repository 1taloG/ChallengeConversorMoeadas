package moedas.com.br;

public class Texto {

    public static void Texto() {
        System.out.print("\033[H\033[23");
        System.out.flush();
    }

    public static void centralizaTexto(String texto) {
        int larguraTerminal = 80;
        int espacoAntes = (larguraTerminal - texto.length()) / 2;
        String espacos = " ".repeat(espacoAntes);
        System.out.println(espacos + texto);
    }
}
