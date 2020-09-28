package dev.dto;

public class CreerCollegueResponseDto {

	private String matricule;
	private String email;

	public CreerCollegueResponseDto(String matricule, String email) {
		super();
		this.matricule = matricule;
		this.email = email;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
