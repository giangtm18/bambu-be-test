package vn.com.cmc.userprofilingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.cmc.userprofilingsystem.model.Users;

/**
 * @author GiangTM
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

}
