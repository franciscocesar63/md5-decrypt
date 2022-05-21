/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cesarfilho.md5decrypt.repository;

import br.com.cesarfilho.md5decrypt.model.Decrypt;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cesinha
 */
@Repository
public interface DecryptRepository extends CrudRepository<Decrypt, Long> {
    
    public Optional<Decrypt> findByValorReal(String valor);

}
