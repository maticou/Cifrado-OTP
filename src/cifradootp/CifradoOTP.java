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
    
    static ArrayList<Character> listaTextoOriginal;
    static ArrayList<Character> listaTextoDescifrado;
    static ArrayList<Integer> listaTextoBinario;
    static ArrayList<Integer> listaTextoCifrado;
    static ArrayList<Integer> llave;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here             
        
        while(true){
            Scanner in = new Scanner(System.in);
            System.out.println("\nElija el número de la acción a realizar: ");
            System.out.print("\n1.- Cifrar texto \n");
            System.out.print("2.- Descifrar texto \n");
            System.out.print("3.- Salir \n");
            
            listaTextoOriginal = new ArrayList<>();
            listaTextoDescifrado = new ArrayList<>();
            listaTextoBinario = new ArrayList<>();
            listaTextoCifrado = new ArrayList<>();
            llave = new ArrayList<>();
            
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
        System.out.println("\nIngrese la palabra a cifrar (SOLO SE PERMITEN CARACTERES ASCII IMPRIMIBLES DEL 32 AL 126):\n(Para saber cuales son dichos caracteres, diríjase a esta página: https://theasciicode.com.ar/)\n");
        if(text.hasNextLine()){
            texto = text.nextLine();
            for (char c : texto.toCharArray()) {
                if((c>31 && c<127)){
                    listaTextoOriginal.add(c);
                }else{
                    System.out.println("\nINGRESE UNA PALABRA CON LETRAS VÁLIDAS!!!\n");
                    break;
                }                
            }
            
            listaTextoBinario = new TextoABinario(listaTextoOriginal).getTextoBinary();
            llave = new GeneradorDeLlave(listaTextoBinario.size()).getKey();
            listaTextoCifrado = new CifrarTexto(llave, listaTextoBinario).getEncryptedText();
            
            
            System.out.print("\n");
            System.out.print("Llave generada:   "); 
            for(int k=0;k<llave.size();k++){
                System.out.print(llave.get(k));          
            }
            System.out.print("\n");
            System.out.print("Texto cifrado:    "); 
            for(int l=0;l<listaTextoCifrado.size();l++){
                System.out.print(listaTextoCifrado.get(l));          
            }
        }else{
            System.out.println("\nINGRESE UNA PALABRA VÁLIDO!!!\n");
        }        
    }

    private static void descifrar() {
        String textoCifrado = "";        
        Scanner text = new Scanner(System.in);
        System.out.println("\nIngrese el texto cifrado (SOLO SE PERMITE EL TEXTO EN BINARIO)");
        
        if(text.hasNextLine()){
            textoCifrado = text.nextLine();
            for (char c : textoCifrado.toCharArray()) {
                if(c == 48){
                    listaTextoCifrado.add(0);
                }
                else if(c == 49){
                    listaTextoCifrado.add(1);
                }             
            }
            
            String textoLlave = "";        
            Scanner textKey = new Scanner(System.in);
            System.out.println("\nIngrese la llave (SOLO SE PERMITE LA LLAVE EN BINARIO)");
            
            if(textKey.hasNextLine()){
                textoLlave = textKey.nextLine();
                for (char c : textoLlave.toCharArray()) {
                    if(c == 48){
                        llave.add(0);
                    }
                    else if(c == 49){
                        llave.add(1);
                    }             
                }
                
                listaTextoDescifrado = new DescifradoOTP(llave, listaTextoCifrado).getDecryptedText();
                
                System.out.print("\nTexto descifrado: "); 
                for(int j=0;j<listaTextoDescifrado.size();j++){
                    System.out.print(listaTextoDescifrado.get(j));          
                }
            }else{
                System.out.println("\nINGRESE UNA PALABRA VÁLIDO!!!\n");
            }                                     
        }else{
            System.out.println("\nINGRESE UNA PALABRA VÁLIDO!!!\n");
        }  
    }
}
