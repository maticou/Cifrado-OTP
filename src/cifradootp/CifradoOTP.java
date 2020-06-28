/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradootp;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mati_
 */
public class CifradoOTP {
    
    static ArrayList<Character> textoOriginal;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here     
        textoOriginal = new ArrayList<>();
        
        while(true){
            Scanner in = new Scanner(System.in);
            System.out.println("Elija el número de la acción a realizar: ");
            System.out.print("\n1.- Cifrar texto \n");
            System.out.print("2.- Descifrar texto \n");
            System.out.print("3.- Salir \n");
            
            if(in.hasNextInt()){
                int opcion = in.nextInt();  
                if(opcion>0 && opcion<4){
                   switch(opcion){
                        case 1: cifrar();
                                break;
                        case 2: descifrar();
                                break;
                        case 3: exit(0);
                                break;                               
                    } 
                    System.out.println(""); 
                }else{
                    System.out.println("\nINGRESE UN NÚMERO VÁLIDO!!!\n");
                }
            }else{
                System.out.println("\nINGRESE UN NÚMERO VÁLIDO!!!\n");
            }
        }               
    }    

    private static void cifrar() {
        String texto = "";        
        Scanner text = new Scanner(System.in);
        System.out.println("Ingrese el texto a cifrar (SOLO SE PERMITEN LETRAS DEL ALFABETO INGLÉS EN MAYÚSCULA Y MINÚSCULA): ");
        if(text.hasNextLine()){
            texto = text.nextLine();
            for (char c : texto.toCharArray()) {
                if((c>64 && c<91) || (c>96 && c<123)){
                    textoOriginal.add(c);
                }else{
                    System.out.println("\nINGRESE UN TEXTO CON LETRAS VÁLIDAS!!!\n");
                    break;
                }                
            }
        }else{
            System.out.println("\nINGRESE UN TEXTO VÁLIDO!!!\n");
        }        
    }

    private static void descifrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
