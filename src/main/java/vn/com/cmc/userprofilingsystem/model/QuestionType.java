package vn.com.cmc.userprofilingsystem.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author GiangTM
 */
@Entity
@Table(name = "question_type", catalog = "user_profiling_system", schema = "", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "type" }) })
public class QuestionType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer id;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String type;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionType")
	@JsonIgnore
	private Collection<Question> questions;

	public QuestionType() {
	}

	public QuestionType(Integer id) {
		this.id = id;
	}

	public QuestionType(Integer id, String type) {
		this.id = id;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}

}
