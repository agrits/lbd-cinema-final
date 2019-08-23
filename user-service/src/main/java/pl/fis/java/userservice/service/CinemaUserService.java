package pl.fis.java.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.fis.java.userservice.entity.CinemaUser;
import pl.fis.java.userservice.model.Credentials;
import pl.fis.java.userservice.model.ErrorMessage;
import pl.fis.java.userservice.repository.CinemaUserRepository;
import pl.fis.java.userservice.tokenizer.Tokenizer;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
public class CinemaUserService {

    @Autowired
    CinemaUserRepository cinemaUserRepository;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessage handle(MethodArgumentNotValidException e){
        return new ErrorMessage(e.getMessage());
    }

    @PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@Valid @RequestBody CinemaUser user, HttpServletResponse response, HttpServletRequest request){
        if(cinemaUserRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body(new ErrorMessage("User with email "+user.getEmail()+" already exists."));
        }
        else{
            return ResponseEntity.ok(cinemaUserRepository.save(user));
        }
    }

    @PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody Credentials credentials, HttpServletResponse response, HttpServletRequest request) throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        Optional<CinemaUser> user = cinemaUserRepository.findByEmail(credentials.getEmail());
        if(user.isEmpty()){
            return ResponseEntity.badRequest().body(new ErrorMessage("User "+credentials.getEmail()+" not found."));
        }
        else if(user.get().getPassword().contentEquals(credentials.getPassword())){
            String token = Tokenizer.getToken(user.get().getEmail(), user.get().getPassword(), user.get().getRole(), request);
            response.addCookie(new Cookie("token", token));
            return ResponseEntity.ok(user.get());
        }
        else{
            return ResponseEntity.badRequest().body(new ErrorMessage("Password is not valid"));
        }
    }
}
