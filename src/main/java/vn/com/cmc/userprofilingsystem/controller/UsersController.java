package vn.com.cmc.userprofilingsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.com.cmc.userprofilingsystem.dto.UserDto;
import vn.com.cmc.userprofilingsystem.service.IUserService;
import vn.com.cmc.userprofilingsystem.utils.Constants.MessageError;

/**
 * @author: GiangTM
 */
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1")
public class UsersController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto userDto) {
		if( userService.isExistUserByEmail(userDto.getEmail()))
			return new ResponseEntity<>(MessageError.EMAIL_EXIST, HttpStatus.CONFLICT);
		if(userDto.getAnswers().size() == 0)
			return new ResponseEntity<>(MessageError.ANSWER_MUST_BE_NOT_NULL, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(userService.getUsersByAnswer(userDto), HttpStatus.OK);
	}

}
