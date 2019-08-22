package pl.fis.java.gatewayservice.tokenizer;

import org.springframework.util.DigestUtils;
import pl.fis.java.gatewayservice.crypto.Cryptographer;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Tokenizer {

    public static String getToken(String email, String password, String role, HttpServletRequest request) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        String agent = request.getHeader("User-Agent");
        String hash = DigestUtils.md5DigestAsHex(agent.getBytes());
        String passwordDoubleHash = DigestUtils.md5DigestAsHex(password.getBytes());
        String token = Cryptographer.encryptAES(String.format("%s&%s&%s", email, role, passwordDoubleHash), hash).toString();
        return token;
    }

    public static String decryptToken(String token, HttpServletRequest request) throws NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String agent = request.getHeader("User-Agent");
        String hash = DigestUtils.md5DigestAsHex(agent.getBytes());
        String info = Cryptographer.decryptAES(token, hash);
        return info;
    }
}
