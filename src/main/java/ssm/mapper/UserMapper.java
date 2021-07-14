package ssm.mapper;

import org.springframework.stereotype.Repository;
import ssm.model.User;

@Repository
public interface UserMapper {
    void addUser(User user);
}
