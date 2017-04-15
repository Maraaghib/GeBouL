import java.util.ArrayList;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "adherent")
public class Adherent {
	
	private long id;
	@DatabaseField(id = true) private long idAdherent;	
	@DatabaseField private String prenom;
	@DatabaseField private String nom;
	@DatabaseField private String telephone;
	@DatabaseField private String adresse;
	@DatabaseField private String mail ;
	private ArrayList<Commande> listeCommande;
	
	/**Constructors**/
	public Adherent(){
		
	}
	
	public Adherent(long id, long idAdherent, String prenom, String nom, String telephone, String adresse, String mail, ArrayList<Commande> listeCommande ) {
		this.id = id;
		this.idAdherent = idAdherent;
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		this.mail = mail;
		this.listeCommande = listeCommande;
		this.adresse = adresse;
	}
	
	/** getteurs et setteurs **/

	public long getId() {
		return id;
	}
	
	public long getIdAdherent() {
		return idAdherent;
	}
	
	public void setIdAdherent(long idAdherent) {
		this.idAdherent = idAdherent;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public ArrayList<Commande> getListeCommande() {
		return listeCommande;
	}
	public void setListeCommande(ArrayList<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}
	public Commande getCommande(int indice){
		return this.listeCommande.get(indice);
	}
	public void addCommande(Commande com){
		this.listeCommande.add(com);
	}
	
	
	public String toString(){
		double somme = 0;
		StringBuffer s = new StringBuffer("R�capitulatif des commandes de l'adherent: \n");
		for(int i=1; i<=listeCommande.size(); i++){
			s.append("Commande n� :"+i);
			s.append(listeCommande.get(i).toString());
			somme += listeCommande.get(i).facture();
		}
		s.append("La facture totale est de"+somme+" euros " );
		return new String(s);
	}
}