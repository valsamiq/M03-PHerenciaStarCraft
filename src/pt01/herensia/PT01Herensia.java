package pt01.herensia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import pt01.Exceptions.Exceptionz;

public class PT01Herensia {

    static ArrayList<Especies> especiess = new ArrayList<>();

    public static void main(String[] args) {
        title();
        options();
        boolean bnd; //bandera temporal, indica la volundad de salir cuando se baja.
        do {
            String CommandString = pedStr("|  Opcion:                               |");
            bnd = mainCommandAnalizer(CommandString);
        } while (bnd);
    }

    //Opciones Menu
    //--------------------------------------------------------------------------
    private static boolean mainCommandAnalizer(String CommandString) { //Esto analiza y separa la linea de comando, ya sabes.
        boolean bnd = true;
        try {
            String[] command = CommandString.split(" ");
            if (command.length == 7) {
                if (command[0].equalsIgnoreCase("a")) {
                    if (command[1].equalsIgnoreCase("terran")) {
                        terran(command);
                    } else if (command[1].equalsIgnoreCase("zerg")) {
                        zerg(command);
                    } else if (command[1].equalsIgnoreCase("protoss")) {
                        protoss(command);
                    } else {
                        throw new Exceptionz(2);
                    }
                } else {
                    throw new Exceptionz(1);
                }
            } else if (command[0].equalsIgnoreCase("r")) {

            } else if (command[0].equalsIgnoreCase("m")) {

            } else if (command[0].equalsIgnoreCase("c")) {

            } else if (command[0].equalsIgnoreCase("s")) {
                exit();
                bnd = false;
            }
        } catch (Exception e) {
        }
        return bnd;

    }

//Mejora
//--------------------------------------------------------------------------
    public static void mejorarEscuadron(String command[]) {
        try {
            for (Especies e : especiess) {
                if (command[1].equals(e.getNombre())) {
                    if (e instanceof Terran) {
                        if (command[2].equalsIgnoreCase("tecnologia")) {
                            ((Terran) e).setNumEdifi(Integer.parseInt(command[3]));
                        } else if (command[2].equalsIgnoreCase("edificio")) {
                            ((Terran) e).setNumEdifi(Integer.parseInt(command[3]));
                        } else {
                            System.out.println("");
                        }
                    }

                    if (e instanceof Zerg) {
                        switch (command[2].toLowerCase()) {
                            case "overlords":
                                ((Zerg) e).setNumOverlord(Integer.parseInt(command[3]));
                                break;
                            case "esbirros":
                                ((Zerg) e).setNumEsbirro(Integer.parseInt(command[3]));
                                break;
                        }
                    }
                    if (e instanceof Protoss) {
                        switch (command[2].toLowerCase()) {
                            case "pilones":
                                ((Protoss) e).setNumPilon(Integer.parseInt(command[3]));
                                break;
                        }
                    }
                } else {
                    System.out.println("Error");
                }
            }
        } catch (Exception e) {
        }

    }

    //Batalla
    //--------------------------------------------------------------------------
    public static void batalla(String command[]) {
        // pos 1 y 2 nombres de escuadrones a batallar.
        //comprobar que nombres existen.
        boolean bnd = checkSquad(command[1]);
        if (bnd) {
            boolean bnd2 = checkSquad(command[2]);
            if (bnd2) {

            } else {
                System.out.println("|  [!]   Escuadron NO registrado   [!]  |");
            }
        } else {
            System.out.println("|  [!]   Escuadron NO registrado   [!]  |");
        }
    }

    //Esquadrones
    //--------------------------------------------------------------------------
    public static void protoss(String command[]) {
        //protoss = nom atk def esb over
        String nom = command[2];
        int vic = 0; //Vitorias a 0
        double atk = 0;
        double def = 0;
        int pil = 0;
        boolean bnd = true;
        boolean bnd1 = checkNum(command[3]);
        try {
            if (!bnd1) {
                atk = (double) Integer.parseInt(command[3]);
                boolean bnd2 = checkNum(command[4]);
                if (!bnd2) {
                    def = (double) Integer.parseInt(command[4]);
                    boolean bnd3 = checkNum(command[5]);
                    if (!bnd3) {
                        pil = Integer.parseInt(command[5]);
                        bnd = false;
                    } else {
                        throw new Exceptionz(3);
                    }
                } else {
                    throw new Exceptionz(3);
                }
            } else {
                throw new Exceptionz(3);
            }
            if (bnd == false) {
                Protoss p = new Protoss(pil, nom, vic, atk, def);
                especiess.add(p);
                System.out.println("| [!]   OK: Escuadron Registrado    [!] |");
            } else if (bnd) {
                throw new Exceptionz(4);
            }
        } catch (Exception e) {
        }
    }

    public static void zerg(String command[]) {
        //Zerg = nom atk def esb over
        String nom = command[2];
        int vic = 0; //Vitorias a 0
        double atk = 0;
        double def = 0;
        int esb = 0;
        int ove = 0;
        boolean bnd = true;
        boolean bnd1 = checkNum(command[3]);
        try {
            if (!bnd1) {
                atk = (double) Integer.parseInt(command[3]);
                boolean bnd2 = checkNum(command[4]);
                if (!bnd2) {
                    def = (double) Integer.parseInt(command[4]);
                    boolean bnd3 = checkNum(command[5]);
                    if (!bnd3) {
                        esb = Integer.parseInt(command[5]);
                        boolean bnd4 = checkNum(command[6]);
                        if (!bnd4) {
                            ove = Integer.parseInt(command[6]);
                            bnd = false;
                        } else {
                            throw new Exceptionz(3);
                        }
                    } else {
                        throw new Exceptionz(3);
                    }
                } else {
                    throw new Exceptionz(3);
                }
            } else {
                throw new Exceptionz(3);
            }
            if (bnd == false) {
                Zerg z = new Zerg(esb, ove, nom, vic, atk, def);
                especiess.add(z);
                System.out.println("| [!]   OK: Escuadron Registrado     [!] |");
            } else if (bnd) {
                throw new Exceptionz(4);
            }
        } catch (Exception e) {
        }
    }

    public static void terran(String command[]) {
        String nom = command[2];
        int vic = 0; //Vitorias a 0
        double atk = 0;
        double def = 0;
        int edi = 0;
        int tech = 0;
        boolean bnd = true;
        boolean bnd1 = checkNum(command[3]);
        try {
            if (!bnd1) {
                atk = (double) Integer.parseInt(command[3]);
                boolean bnd2 = checkNum(command[4]);
                if (!bnd2) {
                    def = (double) Integer.parseInt(command[4]);
                    boolean bnd3 = checkNum(command[5]);
                    if (!bnd3) {
                        edi = Integer.parseInt(command[5]);
                        boolean bnd4 = checkNum(command[6]);
                        if (!bnd4) {
                            tech = Integer.parseInt(command[6]);
                            bnd = false;
                        } else {
                            throw new Exceptionz(3);
                        }
                    } else {
                        throw new Exceptionz(3);
                    }
                } else {
                    throw new Exceptionz(3);
                }
            } else {
                throw new Exceptionz(3);
            }
            if (bnd == false) {
                Terran t = new Terran(edi, tech, nom, vic, atk, def);
                especiess.add(t);
                System.out.println("| [!]   OK: Escuadron Registrado    [!] |");
            } else if (bnd) {
                throw new Exceptionz(4);
            }
        } catch (Exception e) {
        }
    }

    //Recursos
    //-------------------------------------------------------------------------- 
    private static boolean checkSquad(String nom) {
        boolean bnd = false;
        for (Especies e : especiess) {
            if (nom.equalsIgnoreCase(e.getNombre()));
            bnd = true;
        }
        return bnd;
    }

    private static String pedStr(String mensaje) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String text = "";
        boolean bnd = true;
        do {
            System.out.println(mensaje);
            System.out.print("|  -> ");
            try {
                text = teclado.readLine();
                if (text.equals("")) {
                    System.out.println("| [!]         Valor en Blanco        [!] |");
                } else {
                    bnd = false;
                }
            } catch (IOException ex) {
                System.out.println("| [!]    Error de entrada y salida   [!] |");
            }
        } while (bnd);
        return text;
    }

    private static int pedInt(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int op = 0;
        boolean bnd = true;
        do {
            try {
                System.out.println(mensaje);
                System.out.print("|  -> ");
                op = Integer.parseInt(br.readLine());
                bnd = false;
            } catch (IOException ex) {
                System.out.println("| [!]    Error de entrada y salida   [!] |");
            } catch (NumberFormatException ex) { //error de format solicitat
                System.out.println("| [!]     Numero entero requerido    [!] |");
            }
        } while (bnd == true);
        return op;
    }

    private static boolean checkNum(String valor) {
        boolean bnd = false;
        try {
            int chk = Integer.parseInt(valor);
        } //catch (IOException ex) {
        //System.out.println("| [!]    Error de entrada y salida   [!] |");
        //}
        catch (NumberFormatException ex) { //error de format solicitat
            System.out.println("| [!]     Numero ENTERO requerido    [!] |");
            bnd = true;
        }
        return bnd;
    }

    //Grafico
    //--------------------------------------------------------------------------
    public static void options() { //Traqnui, que solo es para orientarme yo, liego quito lo grafico y eso ;)
        System.out.println("|________________________________________|");
        System.out.println(" ________________________________________ ");
        System.out.println("|                                        |");
        System.out.println("|    Ingresa la sequencia apropiada:     |");
        System.out.println("|   Alta de nuevo escuadron              |");
        System.out.println("|   Registrar batalla                    |");
        System.out.println("|   Mejorar escuadron                    |");
        System.out.println("|   Mostrar calificacion                 |");
        System.out.println("|   Salir                                |");
        System.out.println("|                                        |");
    }

    public static void title() {
        System.out.println(" ________________________________________ ");
        System.out.println("|                                        |");
        System.out.println("| .---. .          ,---.         ,_ .    |");
        System.out.println("| |___  |- ,-. ,-. |  -' ,-. ,-. |_ |-   |");
        System.out.println("|     | |  ,-| |   |  -. |   ,-| |  |    |");
        System.out.println("| `---' `' `-^ '   `---' '   `-^ |  `'   |");
        System.out.println("|                              '         |");
        System.out.println("|       -------- Welcome --------        |");
    }

    private static void exit() {
        System.out.println("|________________________________________|");
        System.out.println(" ________________________________________ ");
        System.out.println("|                                        |");
        System.out.println("|            [!] Apa Ciau! [!]           |");
        System.out.println("|                   _.-;;-._             |");
        System.out.println("|            '-..-'|   ||   |            |");
        System.out.println("|            '-..-'|_.-;;-._|            |");
        System.out.println("|            '-..-'|   ||   |            |");
        System.out.println("|            '-..-'|_.-''-._|            |");
        System.out.println("|________________________________________|");
    }
}
