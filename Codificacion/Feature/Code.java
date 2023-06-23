package Feature;
import java.util.LinkedList;
import java.util.Scanner;

public class Code {

    public static void Viajar(String personaje[], String ladoRio){
        if(personaje[1].equals(ladoRio)){
            personaje[1] = "Lado derecho del rio";
        }
        else{
            personaje[1] = "Lado Izquierdo del rio";
        }
    }


    public static void main(String[] args) {
        String personajes[][] = {{"Barquero", "Lado Izquierdo del rio"}, 
                                {"Lobo", "Lado Izquierdo del rio"}, 
                                {"Caperucita", "Lado Izquierdo del rio"}, 
                                {"Uvas", "Lado Izquierdo del rio"}};
        
        int opcion = -1;
        int totalPersonajesLado = 0;
        String posicionBarca = personajes[0][1];
        Scanner entrada = new Scanner(System.in);

        while(true){
            
            for(int i = 0; i < personajes.length; i++){
                System.out.printf("%s  %s\n"  , personajes[i][0], personajes[i][1]);
            }

            System.out.println("Desea viajar solo?");
            System.out.println("1. Si\n2. No");
            opcion = Integer.parseInt(entrada.nextLine().toString());

            while(opcion != -1){
                if(opcion == 1){
                    posicionBarca = personajes[0][1];
                    totalPersonajesLado = 0;
                    LinkedList<String> personajesJuntoBarquero = new LinkedList<String>();

                    for(int i = 1; i < personajes.length; i++){
                        if(personajes[i][1].equals(posicionBarca)){
                            personajesJuntoBarquero.add(personajes[i][0]);
                            totalPersonajesLado++;
                        }
                    }

                    if((totalPersonajesLado == 1) || (totalPersonajesLado == 2 && !personajesJuntoBarquero.contains("Caperucita"))){
                        Viajar(personajes[0], "Lado Izquierdo del rio");
                        totalPersonajesLado--;
                    }
                    else if((totalPersonajesLado == 2 && personajesJuntoBarquero.contains("Caperucita")) || totalPersonajesLado == 3){
                        System.out.println("NO PUEDE REALIZAR SOLO ESTE VIAJE");
                        opcion =-1;
                    }
                    break;
                }           
                else{
                    System.out.println("ERROR.Opcion seleccionada invalida. Trate de nuevo.");
                    opcion = -1;
                }
            }
        }
    }
}