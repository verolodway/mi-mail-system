
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    //Variable que representa el servidor asociado con ese cliente
    private MailServer server;
    //Variable que representa  la dirección de correo del usuario que usa ese cliente
    private String user;
    // Variable que representa si hay nuevos mensajes en el correo
    private boolean newMailItem;
    //Variable que representa el nuevo mensaje
    private MailItem nuevoMensaje;
    //Varialbe que representa el destinatario del mensaje
     private String destinatario;
    //Variable que representa el mensaje enviado
     private String mensaje;

    /**
     * Constructor que que permita crear un objeto MailClient inicializando sus atributos por medio de parámetros.
     */
    public MailClient(MailServer serverX, String userX)
    {
        server = serverX;
        user = userX;
        
    }

    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }

    /**
     * Método que recupera del servidor el siguiente mensaje que tenga el usuario e imprima por pantalla los datos de dicho mensaje. 
     * 
     */
    public void printNextMailItem()
    {
        MailItem nuevoMensaje = server.getNextMailItem(user);
        if (newMailItem == true)
        {
            System.out.println(nuevoMensaje);
        }
        else
        {
                System.out.println("No hay ningún mensaje.");
        }
    }
    
    /**
     * Método que envía el mensaje
     */
    public void sendMailItem(String destinatarioX, String mensajeEnv)
    {
        MailItem nuevoMensaje = new MailItem(user, destinatarioX, mensajeEnv);
        server.post(nuevoMensaje);
    }
}
