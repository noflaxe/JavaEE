package utility;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 20.07.13
 * Time: 22:50
 * To change this template use File | Settings | File Templates.
 */
public class UtilityMethods {

    private UtilityMethods(){

    }

    public static String md5(String input) throws NoSuchAlgorithmException {
        MessageDigest msg = MessageDigest.getInstance("MD5");
        byte[] temp = input.getBytes();
        temp = msg.digest(temp);


        StringBuffer sb = new StringBuffer();
        for (byte b : temp) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }

    public static void facesMessage(String message){
        FacesMessage msg = new FacesMessage("message");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void logSevere(Exception e){
        Logger log = Logger.getLogger("Error logger");
        log.severe(e.toString());
    }
}
