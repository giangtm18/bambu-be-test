package vn.com.cmc.userprofilingsystem.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author GiangTM
 */
@Entity
@Table(name = "answer", catalog = "user_profiling_system", schema = "")
public class Answer implements Serializable {

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

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private short score;

	@JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
	@NotNull
	@ManyToOne(optional = false)
	private Question question;

	public Answer() {
	}

	public Answer(Integer id) {
		this.id = id;
	}

	public Answer(Integer id, String content, short score) {
		this.id = id;
		this.content = content;
		this.score = score;
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

	public short getScore() {
		return score;
	}

	public void setScore(short score) {
		this.score = score;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
