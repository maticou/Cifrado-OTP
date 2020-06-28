/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradootp;

import java.util.ArrayList;

/**
 *
 * @author mati_
 */
public class TextToBinary {
    ArrayList<Character> textoOriginal;
    ArrayList<Integer> textoASCII;
    ArrayList<Integer> textoBytes;

    public TextToBinary(ArrayList<Character> textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public ArrayList<Character> getTextoOriginal() {
        return textoOriginal;
    }

    public void setTextoOriginal(ArrayList<Character> textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public ArrayList<Integer> getTextoASCII() {
        return textoASCII;
    }

    public void setTextoASCII(ArrayList<Integer> textoASCII) {
        this.textoASCII = textoASCII;
    }

    public ArrayList<Integer> getTextoBytes() {
        return textoBytes;
    }

    public void setTextoBytes(ArrayList<Integer> textoBytes) {
        this.textoBytes = textoBytes;
    }        
}
