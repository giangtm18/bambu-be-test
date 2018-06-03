package vn.com.cmc.userprofilingsystem.service;

import vn.com.cmc.userprofilingsystem.dto.UserDto;
import vn.com.cmc.userprofilingsystem.model.Users;

public interface IUserService {

  boolean isExistUserByEmail(String userName);
  
  Users createUser(Users user);
  
  Users getUsersByAnswer(UserDto userDto);

}
