package StackHire.Service;

import StackHire.Entity.User;
import StackHire.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {return userRepository.findByEmail(email);}

    public List<User> getAllUsers() {return userRepository.findAll();}

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User userDetails) {
        Optional<User> userOpt = userRepository.findById(id);

        if(userOpt.isPresent()) {
            User user = userOpt.get();
            user.setEmail(userDetails.getEmail());
            user.setPassword(user.getPassword());
            user.setRole(userDetails.getRole());
            return userRepository.save(user);
        }
        return null;
    }

    public boolean userExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
