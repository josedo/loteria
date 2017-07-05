/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author amontess
 */
public class Utilitaria {

    public Utilitaria() {
    }
    
    //metodo que permite generar un codigo con 3 nros al azar y 3 letras.
    public static String generaCodigo(){
        String codigo="cod";
        codigo+=(int)(Math.random()*(999-100+1)+100);        
        for (int i = 0; i < 3; i++) {
            codigo+=(char)((int)(Math.random()*(90-65+1)+65));
        }
        return codigo;
    }
    
    public static boolean validarRut(String rut) {
 
        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
            char dv = rut.charAt(rut.length() - 1);
            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
}
