/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cesarfilho.md5decrypt.controller;

import br.com.cesarfilho.md5decrypt.dao.DecryptDao;
import br.com.cesarfilho.md5decrypt.model.Decrypt;
import br.com.cesarfilho.md5decrypt.repository.DecryptRepository;
import br.com.cesarfilho.md5decrypt.util.Util;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cesinha
 */
@RestController
public class DecryptController {

    private int valorInicial = 0;
    private int valorFinal = 1000000000;
    @Autowired
    private DecryptRepository decryptRepository;

    private Util util;

    @GetMapping("/get/{valor}")
    public String getDecrypt(@PathVariable String valor) {

        Optional<Decrypt> result = decryptRepository.findByValorReal(valor);

        if (result.isPresent()) {
            return result.get().getValorCriptografado();
        }
        return "Valor não encontrado";
    }

    @GetMapping("/preencher")
    public String preencherDecrypt() throws NoSuchAlgorithmException {
        System.out.println("entou preencher");
        DecryptDao dao = new DecryptDao(decryptRepository);

        for (int i = 1; i < 11; i++) {
            System.out.println("preenchendo " + i);
            util = new Util(valorInicial, valorFinal, i);
            util.preencherBanco(dao);
        }

        return "Finalizado";
    }

}
