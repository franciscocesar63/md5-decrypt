/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cesarfilho.md5decrypt.dao;

import br.com.cesarfilho.md5decrypt.model.Decrypt;
import br.com.cesarfilho.md5decrypt.repository.DecryptRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cesinha
 */
@Service
public class DecryptDao {

    private final DecryptRepository decryptRepository;

    public DecryptDao(DecryptRepository decryptRepository) {
        this.decryptRepository = decryptRepository;
    }

    public void cadastrarDecrypt(String valor, String criptografado) {

        Decrypt decrypt = new Decrypt();
        decrypt.setValorReal(valor);
        decrypt.setValorCriptografado(criptografado);

        decryptRepository.save(decrypt);

    }

}
