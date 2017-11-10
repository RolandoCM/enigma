/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import service.email.Email;

/**
 *
 * @author rolando
 */
public class mailPreba {
    
    public static void main (String args [])
    {
        try {
            Email.send("sigecu0@gmail.com", "prueba","prueba 0 para email");
        } catch (MessagingException ex) {
            Logger.getLogger(mailPreba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
