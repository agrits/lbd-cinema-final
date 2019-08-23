package pl.fis.java.userservice.tokenizer;

import org.springframework.util.DigestUtils;
import pl.fis.java.userservice.crypto.Cryptographer;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    public static String getToken(String email, String password, String role, HttpServletRequest request) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        String agent = request.getHeader("User-Agent");
        String hash = DigestUtils.md5DigestAsHex(agent.getBytes());
        String passwordDoubleHash = DigestUtils.md5DigestAsHex(password.getBytes());
        String token = Cryptographer.encryptAES(String.format("%s&%s&%s", email, role, passwordDoubleHash), hash).toString();
        return token;
    }

}
