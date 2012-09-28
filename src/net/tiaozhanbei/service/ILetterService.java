/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tiaozhanbei.service;

import java.util.List;
import net.tiaozhanbei.model.Letter;

import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author buaatw
 */
public interface ILetterService {
    @Transactional
    void send(Letter letter);

    @Transactional
    List<Letter> receive(int id,int num);
    
    @Transactional
    List<Letter> receiveNew(int id,int num);
    
    @Transactional
    void del(int id,String action);


    
    @Transactional   
    Letter view(Letter letter);
    
    @Transactional
    List<Letter> send(int id,int num);

}
