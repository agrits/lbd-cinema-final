package pl.fis.java.gatewayservice.tokenizer;

import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.util.DigestUtils;
import pl.fis.java.gatewayservice.crypto.Cryptographer;

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

    public static String decryptToken(String token, HttpServletRequest request) throws NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String agent = request.getHeader("User-Agent");
        String hash = DigestUtils.md5DigestAsHex(agent.getBytes());
        String info = Cryptographer.decryptAES(token, hash);
        return info;
    }

    public static TokenInfo getTokenInfo(String token, HttpServletRequest request) throws IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, ZuulException {
        String decryptedToken = decryptToken(token, request);
        TokenInfo ti = new TokenInfo();
        final String regex = "^(.+@[a-z0-9]+\\.[a-z0-9]+)&(ADMIN|USER|UNVERIFIED)&[a-z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(decryptedToken);
        if(matcher.matches()){
            String email = matcher.group(0);
            String role = matcher.group(1);
            ti.setEmail(email);
            ti.setRole(role);
            return ti;
        }
        else{
            throw new ZuulException("Invalid token.", 400, "Error details message.");
        }
    }

    public static class TokenInfo{
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        private String email;
        private String role;
    }
}
