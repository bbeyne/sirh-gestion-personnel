package dev.sgp.entite;


public enum TypeCollabEvt {
	CREATION_COLLAB ("Création d'un nouveau collaborateur "),

	MODIFICATION_COLLAB ("Modification d'un collaborateur ");
	private String name ="";
	TypeCollabEvt(String name){
		this.name=name;
	}
	public String toString(){
		return name;
	}
}
