
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
    //Variable que representa los mensajes recibidos
    private int recibidos;
    //Variable que representa los mensajes enviados
    private int enviados;
    //Variable que representa los mensajes tipo spam
    private int spam;
    //Variable que representa el porcentaje de spam
    private float porcentajeSpam;
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
    {    MailItem mens = server.getNextMailItem(user);
        if (mens.getMessage().contains("promoción"))
        {
           return null;
        }
         else if (mens.getMessage().contains("regalo"))
        {
            return null;
        }
        else if (mens.getMessage().contains("trabajo"))
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
        if (nuevoMensaje.getMessage().contains("promoción"))
        {
            System.out.println("Se ha recibido spam.");
        }
        else if (nuevoMensaje.getMessage().contains("regalo"))
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
    
    public static void main(String[] args) { 
         String h = "número de caracteres";  
        } 

    static int contarCaracteres(String mensaje){ 
       return mensaje.length(); 
    }
    
    /**
     * Método que le permite al cliente mostrar por pantalla unas estadísticas que incluyan el número de mensajes enviados, recibidos, 
     * spam, porcentaje de spam y la persona que nos envió el mensaje más largo junto con cuántos caracteres tenía ese mensaje
     */
    public void showStats()
    {   recibidos = recibidos + 1;
        System.out.println("Has recibido " + recibidos + " mensajes");
        enviados = enviados + 1;
        System.out.println("Has enviado " + enviados + " mensajes");
        spam = spam + 1;
        porcentajeSpam = (recibidos * spam)/100;
        System.out.println("Has recibido " + porcentajeSpam + "%" + " de spam");
        MailItem email = getNextMailItem();
        String h = "número de caracteres";
        if(mensaje.length() < mensaje.length())
        {
            System.out.println("El mensaje de :" + email.getFrom() + " tiene: " + contarCaracteres(h) + "caracteres");
        }
    }
    
    public MailItem showInfoLastSpam()
    {
        if (mensaje.contains("propaganda"))
        {
           return server.getNextMailItem(user);
        }
         else if (mensaje.contains("regalo"))
        {
            return server.getNextMailItem(user);
        }
        else
        {
            System.out.println("No ha llegado aún spam");
        }
        return server.getNextMailItem(user);
    }
    
    public void sendMailItemWithTransmissionError(String user, String destinatarioY, String mensajeErr, String asunt)
    {
        MailItem nuevoMensaje = new MailItem(user, destinatarioY, mensajeErr, asunt);
        if (mensajeErr.contains("o"))
        {
            System.out.println("#o");
        }
        else if (mensajeErr.contains("i"))
        {
            System.out.println("$i");
        }
        server.post(nuevoMensaje);
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
