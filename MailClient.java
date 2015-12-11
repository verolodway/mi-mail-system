
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
    //Variable que representa el asunto del mensaje enviado
    private String asunto;
    /**
     * Constructor que que permita crear un objeto MailClient inicializando sus atributos por medio de parámetros.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = new MailServer();
        this.server = server;
        this.user = user;
    }

    public MailItem getNextMailItem()
    {   if (mensaje.contains("propaganda"))
        {
           return null;
        }
         else if (mensaje.contains("regalo"))
        {
            return null;
        }
        else if (mensaje.contains("trabajo"))
        {
           return server.getNextMailItem(user);
        }
        return server.getNextMailItem(user);
    }

    /**
     * Método que recupera del servidor el siguiente mensaje que tenga el usuario e imprima por pantalla los datos de dicho mensaje. 
     * 
     */
    public void printNextMailItem()
    {
        MailItem nuevoMensaje = server.getNextMailItem(user);
        if (nuevoMensaje != null)
        {
            nuevoMensaje.print();
        }
        else
        {
            System.out.println("No hay ningún mensaje.");
        }
        
        if (mensaje.contains("promoción"))
        {
            System.out.println("Se ha recibido spam.");
        }
        else if (mensaje.contains("regalo"))
        {
            System.out.println("Se ha recibido spam.");
        }
    }

    /**
     * Método que muestra el número de mensajes
     */
    public void numMens()
    {
        System.out.println("Hay "+ server.howManyMailItems(user) + " mensajes nuevos");
    }

    /**
     * Método que envía el mensaje
     */
    public void sendMailItem(String destinatarioX, String mensajeEnv, String asunto)
    {
        MailItem nuevoMensaje = new MailItem(user, destinatarioX, mensajeEnv, asunto);
        server.post(nuevoMensaje);
    }

    /**
     * Método que responde automáticamente a los mensajes
     */
    public void getNextMailItemAndSendAutomaticRespond()
    {   
        MailItem email = getNextMailItem();
        if (email != null)
        {
            sendMailItem(email.getFrom(),
                " No estoy en  la oficina. " + email.getSubject(),
                "RE: " + email.getSubject());
        }
        else if (mensaje.contains("propaganda"))
        {
           email = null;
        }
         else if (mensaje.contains("regalo"))
        {
            email = null;
        }
    }

    public class Test
    {
        /** 
         * Metodo que prueba el segundo apartado de la actividad
         * 0170.
         */
        public void test1()
        {
            MailServer gmail = new MailServer();
            MailClient cliente1 = new MailClient(gmail, "pepe@gmail.com");
            MailClient cliente2 = new MailClient(gmail, "maria@gmail.com");

            cliente1.sendMailItem("maria@gmail.com","Hola","Hola Maria");
            cliente2.getNextMailItemAndSendAutomaticRespond();
            cliente1.printNextMailItem();

            cliente2.getNextMailItemAndSendAutomaticRespond();
            cliente1.printNextMailItem();
        }
    }
}
