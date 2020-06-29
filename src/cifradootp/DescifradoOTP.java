/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradootp;

import static cifradootp.CifradoOTP.listaTextoBinario;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author mati_
 */
public class DescifradoOTP {
    ArrayList<Integer> key;
    ArrayList<Integer> encryptedText;
    ArrayList<Integer> decryptedTextBinary;
    ArrayList<Character> decryptedText;

    public DescifradoOTP(ArrayList<Integer> key, ArrayList<Integer> encryptedText) {
        this.key = key;
        this.encryptedText = encryptedText;
        this.decryptedTextBinary = new ArrayList<>();
        this.decryptedText = new ArrayList<>();
        
        descifrar();
    }

    public ArrayList<Integer> getKey() {
        return key;
    }

    public void setKey(ArrayList<Integer> key) {
        this.key = key;
    }

    public ArrayList<Integer> getEncryptedText() {
        return encryptedText;
    }

    public void setEncryptedText(ArrayList<Integer> encryptedText) {
        this.encryptedText = encryptedText;
    }

    public ArrayList<Integer> getDecryptedTextBinary() {
        return decryptedTextBinary;
    }

    public void setDecryptedTextBinary(ArrayList<Integer> decryptedTextBinary) {
        this.decryptedTextBinary = decryptedTextBinary;
    }

    public ArrayList<Character> getDecryptedText() {
        return decryptedText;
    }

    public void setDecryptedText(ArrayList<Character> decryptedText) {
        this.decryptedText = decryptedText;
    }        
    
    public void descifrar(){
        for(int i=0;i<this.key.size();i++){
            if(Objects.equals(this.key.get(i), this.encryptedText.get(i))){
                this.decryptedTextBinary.add(0);
            }else{
                this.decryptedTextBinary.add(1);
            }
        }
        
        int ciclos = (this.decryptedTextBinary.size()/8);          
        int b = 0;

        for(int a=0;a<ciclos;a++){  
            int subciclo = 0;
            int c = b+8;
            int suma = 0;
            while(b<c){
                switch (subciclo) {
                    case 0:
                        if(this.decryptedTextBinary.get(b) == 1){
                            suma += 128;
                        }else{
                            
                        }   break;
                    case 1:
                        if(this.decryptedTextBinary.get(b) == 1){
                            suma += 64;
                        }else{
                            
                        }   break;
                    case 2:
                        if(this.decryptedTextBinary.get(b) == 1){
                            suma += 32;
                        }else{
                            
                        }   break;
                    case 3:
                        if(this.decryptedTextBinary.get(b) == 1){
                            suma += 16;
                        }else{
                            
                        }   break;
                    case 4:
                        if(this.decryptedTextBinary.get(b) == 1){
                            suma += 8;
                        }else{
                            
                        }   break;
                    case 5:
                        if(this.decryptedTextBinary.get(b) == 1){
                            suma += 4;
                        }else{
                            
                        }   break;
                    case 6:
                        if(this.decryptedTextBinary.get(b) == 1){
                            suma += 2;
                        }else{
                            
                        }   break;
                    case 7:
                        if(this.decryptedTextBinary.get(b) == 1){
                            suma += 1;
                        }else{
                            
                        }   break;
                    default:
                        break;
                }
                b++;
                subciclo++;
            }
            this.decryptedText.add((char)suma);
        }                
    }
}
