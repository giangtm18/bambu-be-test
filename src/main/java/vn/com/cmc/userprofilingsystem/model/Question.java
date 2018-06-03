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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author GiangTM
 */
@Entity
@Table(name = "question", catalog = "user_profiling_system", schema = "")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer id;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(nullable = false, length = 255)
	private String content;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private Collection<Answer> answers;

	@JoinColumn(name = "question_type_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private QuestionType questionType;

	public Question() {
	}

	public Question(Integer id) {
		this.id = id;
	}

	public Question(Integer id, String content) {
		this.id = id;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Collection<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Collection<Answer> answers) {
		this.answers = answers;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

}
