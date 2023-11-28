import modele.MessageSecret;
import modele.decoration.InverseurDeMessage;
import modele.decoration.MessageCrypteXOR;
import modele.decoration.MessageElite;

public class App {

	public static void main(String[] args) {
			MessageSecret message = new MessageSecret("Bonne journée !");
			MessageSecret messageInverse1 = new InverseurDeMessage(message);
			System.out.println(messageInverse1.getTexte());
			MessageSecret messageInverse2 = new InverseurDeMessage(messageInverse1);
			System.out.println(messageInverse2.getTexte());
			MessageSecret messageElite1 = new MessageElite(messageInverse2);
			System.out.println(messageElite1.getTexte());
			MessageCrypteXOR messageCrypte1 = new MessageCrypteXOR(messageElite1);
			System.out.println(messageCrypte1.getTexte());
	}
}
