import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.Vector;

public class ApplicationConstrainHandler {
	public ApplicationConstrainHandler(Document dom) {
		this.dom = dom;
	}

	public String exec() {
		Element root     = dom.getDocumentElement();
		String  country  = root.getAttribute("country");
		String  login    = root.getAttribute("login");
		String  password = root.getAttribute("password");

		return getCountryApplicationConstrain(country, login, password).toXML();
	}

	private ApplicationConstrain getCountryApplicationConstrain(String country, String login, String password) {
		//TODO: сделать чтение из БД
		Vector<ApplicationConstrain.SportConstrain> vec = new Vector<ApplicationConstrain.SportConstrain>();
		vec.add(new ApplicationConstrain.SportConstrain("Baseball",   10, ApplicationConstrain.Sex.Male));
		vec.add(new ApplicationConstrain.SportConstrain("Basketball", 15, ApplicationConstrain.Sex.Female));
		vec.add(new ApplicationConstrain.SportConstrain("Swim",       25, ApplicationConstrain.Sex.Undefined));

		return new ApplicationConstrain(vec);
	}

	private Document dom;
}
