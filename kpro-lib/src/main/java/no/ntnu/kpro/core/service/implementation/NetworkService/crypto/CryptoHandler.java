/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.kpro.core.service.implementation.NetworkService.crypto;

import javax.mail.internet.MimeMessage;
import no.ntnu.kpro.core.model.XOMessage;

/**
 * This class should ideally be able to take in a XOMessage and spit out a 
 * MimeMessage with everything fixed; the message signed and encrypted.
 * Conversely, it should be able to take in an encrypted MimeMessage, decrypt 
 * and verify, and spit it out as an XOMessage.
 * 
 * @author magnus
 */
public class CryptoHandler {
    public MimeMessage prepareToSend(XOMessage mail){
        return null;
    }
    public XOMessage decrypt(MimeMessage mail){
        return null;
    }
}
