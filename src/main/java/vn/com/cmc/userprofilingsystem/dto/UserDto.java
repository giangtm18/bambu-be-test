package vn.com.cmc.userprofilingsystem.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import vn.com.cmc.userprofilingsystem.model.Answer;

/**
 * @author GiangTM
 */
public class UserDto {

	@NotNull
	private String email;

	@NotNull
	private List<Answer> answers;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
