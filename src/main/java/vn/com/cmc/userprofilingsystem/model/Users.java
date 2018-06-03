package vn.com.cmc.userprofilingsystem.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author GiangTM
 */
@Entity
@Table(name = "users", catalog = "user_profiling_system", schema = "")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String email;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(nullable = false, length = 1)
	private String profile;

	public Users() {
	}

	public Users(String email) {
		this.email = email;
	}

	public Users(String email, String profile) {
		this.email = email;
		this.profile = profile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
