
/**
 * Write a description of class MailItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    //Variable que representa quien escribe el mensaje
    private String from;
    //Variable que representa a quién va dirigido el mensaje
    private String to;
    //Variable que representa el mensaje
    private String message;

    /**
     * Constructor que permite crear un objeto MailItem inicializando sus atributos por medio de parámetros.
     */
    public MailItem(String fromX, String toX, String messageX)
    {
        from = fromX;
        to = toX;
        message = messageX;
    }

    /**
     * Método getter que nos devuelve el emisor del mensaje
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * Método getter que nos devuelve el receptor del mensaje
     */
    public String getTo()
    {
        return to;
    }

    /**
     * Método getter que nos devuelve el mensaje
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * Método que nos muestra por pantalla los atributos de MailItem
     */
    public void print()
    {
        System.out.println("from: " + from + " " + "to: " + to + " " + "message: " + message);
    }
}
