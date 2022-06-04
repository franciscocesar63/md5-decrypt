/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cesarfilho.md5decrypt.util;

import br.com.cesarfilho.md5decrypt.dao.DecryptDao;
import java.security.*;
import java.math.*;
import java.util.ArrayList;

/**
 *
 * @author Cesinha
 */
public class Util {

    private int valorInicial;
    private int valorFinal;

    private int qntCaracteres;

    private static ArrayList<String> lista = new ArrayList<>();
    private static String senha = "";
    private static String[] carct = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
        "!", "@", "#", "$", "*", "(", ")", "-", "_", ".", ","};


    public Util(int valorInicial, int valorFinal, int qntCaracteres) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.qntCaracteres = qntCaracteres;
    }
    

    public void preencherBanco(DecryptDao dao) throws NoSuchAlgorithmException {

        while (valorInicial < valorFinal) {

            for (int i = 0; i < qntCaracteres; i++) {
                int j = (int) (Math.random() * carct.length);
                senha += carct[j];

            }
            if (!lista.contains(senha)) {
                lista.add(senha);

                String hash = getHashMd5(senha);
                if (senha != null && hash != null) {
                    dao.cadastrarDecrypt(senha, hash);

                }
            }
            senha = "";
            valorInicial++;

        }
    }

    public String getHashMd5(String valor) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger hash = new BigInteger(1, md.digest(valor.getBytes()));
        return hash.toString(16);
    }

}
