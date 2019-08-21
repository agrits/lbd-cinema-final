package pl.fis.java.gatewayservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fis.java.gatewayservice.tokenizer.Tokenizer;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
public class MainController {

    @GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String get(HttpServletRequest request) throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {
        return Tokenizer.decryptToken(Tokenizer.getToken("test@gmail.com", "password", "ADMIN", request), request);
    }
}
