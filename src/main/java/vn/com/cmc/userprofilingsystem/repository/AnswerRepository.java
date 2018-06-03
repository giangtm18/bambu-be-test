package vn.com.cmc.userprofilingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.cmc.userprofilingsystem.model.Answer;

/**
 * @author: GiangTM
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	@Query(value = "SELECT IFNULL(\r\n" + 
			"	(\r\n" + 
			"		SELECT T1.score FROM user_profiling_system.answer AS T1\r\n" + 
			"		WHERE T1.question_id = :questionId AND T1.content = :content\r\n" + 
			"	), 0\r\n" + 
			") AS score", nativeQuery = true)
	int getScore(@Param("questionId") int questionId, @Param("content") String content);

}
