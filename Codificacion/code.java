import java.util.LinkedList;
import java.util.Scanner;

public class code {

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
        
        int option = -1;
        int aux = 0;
        String posicionBarca = personajes[0][1];
        Scanner entrada = new Scanner(System.in);

        while(true){
            
            for(int i = 0; i < personajes.length; i++){
                System.out.printf("%s  %s\n"  , personajes[i][0], personajes[i][1]);
            }

            System.out.println("Desea viajar solo?");
            System.out.println("1. Si\n2. No");
            option = Integer.parseInt(entrada.nextLine().toString());

            while(option != -1){
                if(option == 1){
                    posicionBarca = personajes[0][1];
                    aux = 0;
                    LinkedList<String> nombres = new LinkedList<String>();

                    for(int i = 1; i < personajes.length; i++){
                        if(personajes[i][1].equals(posicionBarca)){
                            nombres.add(personajes[i][0]);
                            aux++;
                        }
                    }

                    if((aux == 1) || (aux == 2 && !nombres.contains("Caperucita"))){
                        Viajar(personajes[0], "Lado Izquierdo del rio");
                        aux--;
                    }
                    else if((aux == 2 && nombres.contains("Caperucita")) || aux == 3){
                        System.out.println("NO PUEDE REALIZAR SOLO ESTE VIAJE");
                        option =-1;
                    }
                    break;
                }           
                else if(option == 2){
                    boolean auxDos = true;

                    while(auxDos){                    
                        aux = 0;
                        posicionBarca = personajes[0][1];
                        LinkedList<String> nombres = new LinkedList<String>();

                        for(int i = 1; i < personajes.length; i++){
                            if(personajes[i][1].equals(posicionBarca)){
                                nombres.add(personajes[i][0]);
                                aux++;
                            }
                        }

                        System.out.println("Con quien va a viajar?");
                        System.out.println("1. Lobo\n2. Caperucita\n3.Uvas");
                        option = Integer.parseInt(entrada.nextLine().toString());

                        if(!nombres.contains(personajes[option][0])){
                            System.out.println("Error. Este personaje no se encuentra en el mismo lado del río que el barquero.");
                        }
                        else{
                            if(aux == 1 || aux == 2 || (aux == 3 && option == 2)){      
                                Viajar(personajes[0], "Lado Izquierdo del rio");  
                                Viajar(personajes[option], "Lado Izquierdo del rio");
                                aux--;                
                            }
                            else if(aux == 3 && option != 2){
                                System.out.println(personajes[option][0] + " no puede viajar esta vez");
                            }                         
                        }
                        auxDos = false; 
                        option = -1;
                        break;
                    }

                    if(personajes[0][1].equals("Lado derecho del rio") && aux == 0){
                        System.out.println("TODOS SE HAN MOVIDO");
                        return;
                    }

                }
                else{
                    System.out.println("ERROR.Opcion seleccionada invalida. Trate de nuevo.");
                    option = -1;
                }
            }
        }
    }
}