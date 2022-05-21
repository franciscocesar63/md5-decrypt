package br.com.cesarfilho.md5decrypt;

import java.security.NoSuchAlgorithmException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Md5DecryptApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        SpringApplication.run(Md5DecryptApplication.class, args);

    }

}
