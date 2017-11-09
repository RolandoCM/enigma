/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import service.email.Email;

/**
 *
 * @author rolando
 */
public class mailPreba {
    
    public static void main (String args [])
    {
        Email mail = new Email();
        mail.send("hola", "prueba 0", "castillor493@gmail.com");
    }
    
}
