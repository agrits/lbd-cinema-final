package pl.fis.java.gatewayservice.filters;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import pl.fis.java.gatewayservice.tokenizer.Tokenizer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AuthorizedFilter extends ZuulFilter {
    Set<String> roleSet = new HashSet<>();
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Optional<String> proxy = (Optional<String>) ctx.get("proxy");
        if(proxy.isPresent() && proxy.get().equals("/reservation")){
            roleSet.add("ADMIN");
            roleSet.add("USER");
            return true;
        }
        if(proxy.isPresent() && proxy.get().equals("/admin")){
            roleSet.add("ADMIN");
            return true;
        }
        else
            return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();

        Cookie[] cookies = request.getCookies();
        boolean found = false;
        for(Cookie cookie : cookies){
            if(cookie.getName().contentEquals("token")){
                found = true;
                Tokenizer.TokenInfo ti;
                try {
                    ti = Tokenizer.getTokenInfo(cookie.getValue(), request);
                } catch (Exception e) {
                    throw new ZuulException("Invalid token.", 401, "Error message.");
                }
                if(roleSet.contains(ti.getRole())){
                    return null;
                }
                else throw new ZuulException("Unauthorized user.", 401, "Error message.");
            }
        }
        if(!found){
            throw new ZuulException("Token not found.", 401, "Error message.");
        }
        return null;
    }
}
