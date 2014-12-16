package masfraud.base.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserTO implements Serializable {
	
	private static final long serialVersionUID = -7590317347612436291L;

	private Long id;
	private String cpf;
	private String username;
	private String name;
	private String lastName;
	private String password;
	private String email;
	private String phonne;
	private String status;
	private Boolean logged;
	private List<ClientTO> clientTOList;
	private List<Long> clients;
	private List<ProfileTO> profiles;
	private Integer profile;
	private String phone;
	private List<LoyaltyProgramTO> programList;
	private List<Integer> programs;

	public UserTO() {
	}

	public UserTO(Long id) {
		this.id = id;
	}

	public ProfileTO getProfile() {
		if (profiles != null && profiles.size() > 0) {
			return profiles.get(0);
		} else if (this.profile != null) {
			return new ProfileTO(this.profile.longValue());
		} else {
			return null;
		}
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getClients() {
		return clients;
	}

	public void setClients(List<Long> clients) {
		this.clients = clients;
	}

	public List<ClientTO> getClientTOList() {
		return clientTOList;
	}

	public void setClientTOList(List<ClientTO> clientTOList) {
		this.clientTOList = clientTOList;
	}

	public String getPhonne() {
		return this.phonne;
	}

	public void setPhonne(String phonne) {
		this.phonne = phonne;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ProfileTO> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<ProfileTO> profiles) {
		this.profiles = profiles;
	}

	public Boolean getLogged() {
		return logged;
	}

	public void setLogged(Boolean logged) {
		this.logged = logged;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @param profile
	 *            the saveMember to set
	 */
	public void setProfile(Integer profile) {
		if (this.profiles == null) {
			this.profiles = new ArrayList<>();
			this.profiles.add(new ProfileTO(profile.longValue()));
		}
		this.profile = profile;

	}

	public List<LoyaltyProgramTO> getProgramList() {
		return programList;
	}

	public void setProgramList(List<LoyaltyProgramTO> programList) {
		this.programList = programList;
	}

	public List<Integer> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Integer> programs) {
		this.programs = programs;
	}
	
}