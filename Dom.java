import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

// rejestr do tworzenia implementacji DOM
import org.w3c.dom.bootstrap.DOMImplementationRegistry;

// Implementacja DOM Level 3 Load & Save
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSParser; // Do serializacji (zapisywania) dokumentow
import org.w3c.dom.ls.LSSerializer;
import org.w3c.dom.ls.LSOutput;

// Konfigurator i obsluga bledow
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;

// Do pracy z dokumentem
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Dom {

	public static void main(String[] args) {


		try {
			File xmlFile = new File("zoo.xml");

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();
			DOMImplementationRegistry registry = DOMImplementationRegistry
					.newInstance();

			DOMImplementationLS impl = (DOMImplementationLS) registry
					.getDOMImplementation("LS");

			System.out.println("1: Edytuj");
			System.out.println("2: Dodaj");
			System.out.println("3: Usuń");
			System.out.println("4: Sortuj");
			Scanner scanner = new Scanner(System. in);
			String inputString = scanner.nextLine();
			String nastepnyWybor;
			NodeList nodes;
			String wybor;
			Element n;
			switch (inputString){
				case "1":
					System.out.println("1: Gatunek");
					System.out.println("2: Rzad");
					System.out.println("3: Opiekun");
					System.out.println("4: Zwierze");
					nastepnyWybor = scanner.nextLine();
					switch (nastepnyWybor){
						case "1":
							nodes = doc.getElementsByTagName("gatunki").item(0).getChildNodes();
							for (int i = 0; i < nodes.getLength(); i++){
								System.out.println(i+ ". " + nodes.item(i).getTextContent());
							}
							System.out.println("Który obiekt chcesz edytować?");
							wybor = scanner.nextLine();
							System.out.println("Nowa nazwa: ");
							String nowaNazwa = scanner.nextLine();
							nodes.item(Integer.parseInt(wybor)).setTextContent(nowaNazwa);

							break;

						case "2":
							nodes = doc.getElementsByTagName("rzad");
							for (int i = 0; i < nodes.getLength(); i++){
								n = (Element) nodes.item(i);
								System.out.println(i + ". " + n.getTextContent() + " " + n.getAttributeNode("gatunek"));
							}
							System.out.println("Który obiekt chcesz edytować?");
							wybor = scanner.nextLine();
							System.out.println("Nowy gatunek");
							String gatunek = scanner.nextLine();
							System.out.println("Nowa nazwa");
							String nazwa = scanner.nextLine();
							n = (Element) nodes.item(Integer.parseInt(wybor));
							n.setTextContent(nazwa);
							n.getAttributeNode("gatunek").setTextContent(gatunek);

							break;
						case "3":
							nodes = doc.getElementsByTagName("opiekun");
							for (int i = 0; i < nodes.getLength(); i++){
								 n = (Element) nodes.item(i);
								System.out.println(i + ". " + n.getAttributeNode("id")
										+ " "  + n.getElementsByTagName("imie").item(0).getTextContent()
										+ " " +  n.getElementsByTagName("nazwisko").item(0).getTextContent());
							}
							System.out.println("Który obiekt chcesz edytować?");
							wybor = scanner.nextLine();
							System.out.println("Nowe id");
							String id = scanner.nextLine();
							System.out.println("Nowe imie");
							String imie = scanner.nextLine();
							System.out.println("Nowe nazwisko");
							String nazwisko = scanner.nextLine();
							n = (Element) nodes.item(Integer.parseInt(wybor));
							n.getAttributeNode("id").setTextContent(id);
							n.getElementsByTagName("imie").item(0).setTextContent(imie);
							n.getElementsByTagName("nazwisko").item(0).setTextContent(nazwisko);

							break;
						case "4":
							nodes = doc.getElementsByTagName("zwierze");

							for (int i = 0; i < nodes.getLength(); i++){
								n = (Element) nodes.item(i);
								System.out.println(i + ". " + n.getAttributeNode("rzad") + " "  + n.getAttributeNode("opiekun")
										+ " "  + n.getElementsByTagName("nazwa").item(0).getTextContent()
										+ " " +  n.getElementsByTagName("ilosc").item(0).getTextContent() + " " + ((Element) n.getElementsByTagName("ilosc").item(0)).getAttributeNode("plec")
										+ " " +  n.getElementsByTagName("ilosc").item(1).getTextContent() + " " + ((Element) n.getElementsByTagName("ilosc").item(1)).getAttributeNode("plec")
										+ " " +  n.getElementsByTagName("sredni_wzrost").item(0).getTextContent() + " " + ((Element) n.getElementsByTagName("sredni_wzrost").item(0)).getAttributeNode("jednostka_wzrostu")
								+ " " +  n.getElementsByTagName("srednia_waga").item(0).getTextContent() + " " + ((Element) n.getElementsByTagName("srednia_waga").item(0)).getAttributeNode("jednostka_wagi"));

							}
							System.out.println("Który obiekt chcesz edytować?");
							wybor = scanner.nextLine();
							System.out.println("Nowy rzad");
							String rzad = scanner.nextLine();
							System.out.println("Nowy opiekun");
							String opiekun = scanner.nextLine();
							System.out.println("Nowa nazwa");
							String nowa_nazwa = scanner.nextLine();
							System.out.println("Nowe ilosc f");
							String ilosc_f = scanner.nextLine();
							System.out.println("Nowe ilosc m");
							String ilosc_m = scanner.nextLine();
							System.out.println("Nowy sredni wzrost");
							String sredni_wzrost = scanner.nextLine();
							System.out.println("Nowa jednostka wzrostu");
							String sredni_wzrost_jednostka = scanner.nextLine();

							System.out.println("Nowa srednia waga");
							String srednia_waga = scanner.nextLine();
							System.out.println("Nowa jednostka wagi");
							String srednia_waga_jednostka = scanner.nextLine();


							n = (Element) nodes.item(Integer.parseInt(wybor));
							n.getAttributeNode("rzad").setTextContent(rzad);
							n.getAttributeNode("opiekun").setTextContent(opiekun);
							n.getElementsByTagName("nazwa").item(0).setTextContent(nowa_nazwa);
							if (((Element) n.getElementsByTagName("ilosc").item(0)).getAttributeNode("plec").getTextContent().equals("f"))
							{
								n.getElementsByTagName("ilosc").item(0).setTextContent(ilosc_f);
								n.getElementsByTagName("ilosc").item(1).setTextContent(ilosc_m);

							}
							else {

								n.getElementsByTagName("ilosc").item(1).setTextContent(ilosc_f);
								n.getElementsByTagName("ilosc").item(0).setTextContent(ilosc_m);
							}
							n.getElementsByTagName("sredni_wzrost").item(0).setTextContent(sredni_wzrost);
							((Element) n.getElementsByTagName("sredni_wzrost").item(0)).getAttributeNode("jednostka_wzrostu").setTextContent(sredni_wzrost_jednostka);

							n.getElementsByTagName("srednia_waga").item(0).setTextContent(srednia_waga);
							((Element) n.getElementsByTagName("srednia_waga").item(0)).getAttributeNode("jednostka_wagi").setTextContent(srednia_waga_jednostka);
							break;
					}

					break;
				case "2":
					System.out.println("1: Gatunek");
					System.out.println("2: Rzad");
					System.out.println("3: Opiekun");
					System.out.println("4: Zwierze");
					nastepnyWybor = scanner.nextLine();
					switch (nastepnyWybor) {
						case "1":
							System.out.println("nazwa: ");
							String nowaNazwa = scanner.nextLine();
							n = doc.createElement("gatunek");
							n.setTextContent(nowaNazwa);
							doc.getElementsByTagName("gatunki").item(0).appendChild(n);

							break;
						case "2":
							System.out.println("gatunek");
							String gatunek = scanner.nextLine();
							System.out.println("nazwa");
							String nazwa = scanner.nextLine();
							n = doc.createElement("rzad");
							n.setTextContent(nazwa);
							n.setAttribute("gatunek", gatunek);
							doc.getElementsByTagName("rzedy").item(0).appendChild(n);
							break;
						case "3":
							System.out.println("id");
							String id = scanner.nextLine();
							System.out.println("imie");
							String imie = scanner.nextLine();
							System.out.println("nazwisko");
							String nazwisko = scanner.nextLine();
							n = doc.createElement("opiekun");
							n.appendChild(createUserElement(doc, "imie", imie));
							n.appendChild(createUserElement(doc, "nazwisko", nazwisko));
							n.setAttribute("id", id);
							doc.getElementsByTagName("opiekunowie").item(0).appendChild(n);
							break;
						case "4":
							System.out.println("rzad");
							String rzad = scanner.nextLine();
							System.out.println("opiekun");
							String opiekun = scanner.nextLine();
							System.out.println("nazwa");
							String nowa_nazwa = scanner.nextLine();
							System.out.println("ilosc f");
							String ilosc_f = scanner.nextLine();
							System.out.println("ilosc m");
							String ilosc_m = scanner.nextLine();
							System.out.println("sredni wzrost");
							String sredni_wzrost = scanner.nextLine();
							System.out.println("jednostka wzrostu");
							String sredni_wzrost_jednostka = scanner.nextLine();

							System.out.println("srednia waga");
							String srednia_waga = scanner.nextLine();
							System.out.println("jednostka wagi");
							String srednia_waga_jednostka = scanner.nextLine();
							n = doc.createElement("zwierze");

							n.appendChild(createUserElement(doc, "nazwa", nowa_nazwa));
							Element e_ilosc_m =(Element) createUserElement(doc, "ilosc", ilosc_m);
							e_ilosc_m.setAttribute("plec", "m");
							n.appendChild(e_ilosc_m);
							Element e_ilosc_f =(Element) createUserElement(doc, "ilosc", ilosc_f);
							e_ilosc_m.setAttribute("plec", "f");
							n.appendChild(e_ilosc_f);

							Element e_sredni_wzrost = (Element) createUserElement(doc, "sredni_wzrost", sredni_wzrost);
							e_ilosc_m.setAttribute("jednostka_wzrostu", sredni_wzrost_jednostka);
							n.appendChild(e_sredni_wzrost);

							Element e_srednia_waga = (Element) createUserElement(doc, "srednia_waga",srednia_waga);
							e_ilosc_m.setAttribute("jednostka_wagi", srednia_waga_jednostka);
							n.appendChild(e_srednia_waga);

							n.setAttribute("rzad", rzad);
							n.setAttribute("opiekun", opiekun);

							doc.getElementsByTagName("zwierzeta").item(0).appendChild(n);
							break;
						default:
							System.out.println("Nieznany wybor");
							break;
					}
					break;

				case "3":
					System.out.println("1: Gatunek");
					System.out.println("2: Rzad");
					System.out.println("3: Opiekun");
					System.out.println("4: Zwierze");
					nastepnyWybor = scanner.nextLine();
					switch (nastepnyWybor){
						case "1":
							nodes = doc.getElementsByTagName("gatunki").item(0).getChildNodes();
							for (int i = 0; i < nodes.getLength(); i++){
								System.out.println(i+ ". " + nodes.item(i).getTextContent());
							}
							System.out.println("Który obiekt chcesz usunac?");
							wybor = scanner.nextLine();
							doc.getElementsByTagName("gatunki").item(0).removeChild(nodes.item(Integer.parseInt(wybor)));

							break;

						case "2":
							nodes = doc.getElementsByTagName("rzad");
							for (int i = 0; i < nodes.getLength(); i++){
								n = (Element) nodes.item(i);
								System.out.println(i + ". " + n.getTextContent() + " " + n.getAttributeNode("gatunek"));
							}
							System.out.println("Który obiekt chcesz usunac?");
							wybor = scanner.nextLine();
							doc.getElementsByTagName("rzedy").item(0).removeChild(nodes.item(Integer.parseInt(wybor)));


							break;
						case "3":
							nodes = doc.getElementsByTagName("opiekun");
							for (int i = 0; i < nodes.getLength(); i++){
								n = (Element) nodes.item(i);
								System.out.println(i + ". " + n.getAttributeNode("id")
										+ " "  + n.getElementsByTagName("imie").item(0).getTextContent()
										+ " " +  n.getElementsByTagName("nazwisko").item(0).getTextContent());
							}
							System.out.println("Który obiekt chcesz usunac?");
							wybor = scanner.nextLine();
							doc.getElementsByTagName("opiekunowie").item(0).removeChild(nodes.item(Integer.parseInt(wybor)));

							break;
						case "4":
							nodes = doc.getElementsByTagName("zwierze");
							for (int i = 0; i < nodes.getLength(); i++){
								n = (Element) nodes.item(i);
								System.out.println(i + ". " + n.getAttributeNode("rzad") + " "  + n.getAttributeNode("opiekun")
										+ " "  + n.getElementsByTagName("nazwa").item(0).getTextContent()
										+ " " +  n.getElementsByTagName("ilosc").item(0).getTextContent() + " " + ((Element) n.getElementsByTagName("ilosc").item(0)).getAttributeNode("plec")
										+ " " +  n.getElementsByTagName("ilosc").item(1).getTextContent() + " " + ((Element) n.getElementsByTagName("ilosc").item(1)).getAttributeNode("plec")
										+ " " +  n.getElementsByTagName("sredni_wzrost").item(0).getTextContent() + " " + ((Element) n.getElementsByTagName("sredni_wzrost").item(0)).getAttributeNode("jednostka_wzrostu")
										+ " " +  n.getElementsByTagName("srednia_waga").item(0).getTextContent() + " " + ((Element) n.getElementsByTagName("srednia_waga").item(0)).getAttributeNode("jednostka_wagi"));

							}
							System.out.println("Który obiekt chcesz usunac?");
							wybor = scanner.nextLine();
							doc.getElementsByTagName("zwierzeta").item(0).removeChild(nodes.item(Integer.parseInt(wybor)));
							break;
					}

					break;
				case "4":
					nodes = doc.getElementsByTagName("gatunek");
					ArrayList<Element> nodes1 = new ArrayList<>();
					for (int i = 0; i < nodes.getLength(); i++)
					{
						nodes1.add((Element)nodes.item(i));
					}
					nodes1.sort(Comparator.comparing(Node::getTextContent));
					Node gatunek = doc.getElementsByTagName("gatunki").item(0);
					for(int i = 0 ; i < nodes.getLength(); i++) {
						gatunek.removeChild(nodes.item(i));
					}
					for (int i = 0; i< nodes1.size(); i++) {
						gatunek.appendChild(nodes1.get(i));
					}

					nodes = doc.getElementsByTagName("rzad");
					nodes1 = new ArrayList<>();
					for (int i = 0; i < nodes.getLength(); i++)
					{
						nodes1.add((Element) nodes.item(i));
					}
					nodes1.sort(Comparator.comparing(Node::getTextContent));
					Node rzad = doc.getElementsByTagName("rzedy").item(0);
					for(int i = 0 ; i < nodes.getLength(); i++) {
						rzad.removeChild(nodes.item(i));
					}
					for (int i = 0; i< nodes1.size(); i++) {
						rzad.appendChild(nodes1.get(i));
					}

					nodes = doc.getElementsByTagName("opiekun");
					nodes1 = new ArrayList<>();
					for (int i = 0; i < nodes.getLength(); i++)
					{
						nodes1.add((Element ) nodes.item(i));
					}
					nodes1.sort(Comparator.comparing(n2 -> n2.getElementsByTagName("nazwisko").item(0).getTextContent()));
					Node opiekun = doc.getElementsByTagName("opiekunowie").item(0);
					for(int i = 0 ; i < nodes.getLength(); i++) {
						opiekun.removeChild(nodes.item(i));
					}
					for (int i = 0; i< nodes1.size(); i++) {
						opiekun.appendChild(nodes1.get(i));
					}

					nodes = doc.getElementsByTagName("zwierze");
					nodes1 = new ArrayList<>();
					for (int i = 0; i < nodes.getLength(); i++)
					{
						nodes1.add((Element ) nodes.item(i));
					}
					nodes1.sort(Comparator.comparing(n2 -> n2.getElementsByTagName("nazwa").item(0).getTextContent()));
					Node zwierze = doc.getElementsByTagName("zwierzeta").item(0);
					for(int i = 0 ; i < nodes.getLength(); i++) {
						zwierze.removeChild(nodes.item(i));
					}
					for (int i = 0; i< nodes1.size(); i++) {
						zwierze.appendChild(nodes1.get(i));
					}




					break;
				default:
					System.out.println("Nieznana wartość");
			}



			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Result output = new StreamResult(new File("output.xml"));
			Source input = new DOMSource(doc);

			transformer.transform(input, output);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static Node createUserElement(Document doc, String name,
										  String value) {

		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));

		return node;
	}


}
