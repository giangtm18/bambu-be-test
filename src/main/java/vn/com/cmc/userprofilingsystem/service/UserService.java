package vn.com.cmc.userprofilingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.cmc.userprofilingsystem.dto.UserDto;
import vn.com.cmc.userprofilingsystem.model.Answer;
import vn.com.cmc.userprofilingsystem.model.Users;
import vn.com.cmc.userprofilingsystem.repository.AnswerRepository;
import vn.com.cmc.userprofilingsystem.repository.UsersRepository;
import vn.com.cmc.userprofilingsystem.utils.Constants.UserRank;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public boolean isExistUserByEmail(String email) {
		return usersRepository.existsById(email);
	}

	@Override
	public Users getUsersByAnswer(UserDto userDto) {
		List<Answer> answers = userDto.getAnswers();
		int score = 0;
		for (Answer answer : answers) {
			score += answerRepository.getScore(answer.getQuestion().getId(), answer.getContent());
		}
		Users user = new Users();
		user.setEmail(userDto.getEmail());
		if (score >= 8)
			user.setProfile(UserRank.RANK_A);
		else if (score >= 6)
			user.setProfile(UserRank.RANK_B);
		else if (score >= 4)
			user.setProfile(UserRank.RANK_C);
		else
			user.setProfile(UserRank.RANK_D);
		return this.createUser(user);
	}

	@Override
	public Users createUser(Users user) {
		return usersRepository.save(user);
	}
}
