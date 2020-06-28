/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradootp;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author mati_
 */
public class CifrarTexto {
    ArrayList<Integer> key;
    ArrayList<Integer> text;
    ArrayList<Integer> encryptedText;

    public CifrarTexto(ArrayList<Integer> key, ArrayList<Integer> text) {
        this.key = key;
        this.text = text;
        this.encryptedText = new ArrayList<>();
        cifrar();
    }

    public ArrayList<Integer> getKey() {
        return key;
    }

    public void setKey(ArrayList<Integer> key) {
        this.key = key;
    }

    public ArrayList<Integer> getText() {
        return text;
    }

    public void setText(ArrayList<Integer> text) {
        this.text = text;
    }               

    public ArrayList<Integer> getEncryptedText() {
        return encryptedText;
    }

    public void setEncryptedText(ArrayList<Integer> encryptedText) {
        this.encryptedText = encryptedText;
    }    

    public void cifrar(){
        for(int i=0;i<this.key.size();i++){
            if(Objects.equals(this.key.get(i), this.text.get(i))){
                this.encryptedText.add(0);
            }else{
                this.encryptedText.add(1);
            }
        }
    }    
}
