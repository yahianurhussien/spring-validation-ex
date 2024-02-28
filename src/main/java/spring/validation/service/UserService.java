package spring.validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.validation.dto.UserRequest;
import spring.validation.entity.User;
import spring.validation.exception.UserNotFoundException;
import spring.validation.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest){

        User user = User
                .build(0,userRequest.getName(),
                        userRequest.getEmail(),userRequest.getMobile(),
                            userRequest.getGender(),userRequest.getAge(),
                              userRequest.getNationality());

       return userRepository.save(user);

    }

    public List<User> getAllUsers(){

        return userRepository.findAll();

    }

    public User getUser(int userId) throws UserNotFoundException {
      User user = userRepository.findByUserId(userId);

      if(user != null){
          return user;
      }else {
          throw new UserNotFoundException("user not found with id : "+userId);
      }

    }

}
