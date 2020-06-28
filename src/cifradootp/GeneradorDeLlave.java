/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradootp;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mati_
 */
public class GeneradorDeLlave {
    private static Random random = new Random();
    int keySize;
    ArrayList<Integer> key;

    public GeneradorDeLlave(int keySize) {
        this.keySize = keySize;
        this.key = new ArrayList<>();
        
        generateRandomKey();
    }

    public int getKeySize() {
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }

    public ArrayList<Integer> getKey() {
        return key;
    }

    public void setKey(ArrayList<Integer> key) {
        this.key = key;
    }        
    
    public void generateRandomKey(){
        for(int i=0;i<this.keySize;i++){
            int randomNumber = random.nextInt((1 - 0) + 1) + 0;
            
            this.key.add(randomNumber);
        }
    }
}
