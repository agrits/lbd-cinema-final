package pl.fis.java.gatewayservice.filters;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import pl.fis.java.gatewayservice.tokenizer.Tokenizer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

public class PostFilter extends ZuulFilter {

    private final String PATH = "http://localhost:8080";

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletResponse response = ctx.getResponse();


        try (final InputStream responseDataStream = ctx.getResponseDataStream()) {
            String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));

            responseData = responseData.replaceAll("(http:\\/\\/)([^:]*)(:)(8081|8082|8083|8084|8085)", PATH);

            ctx.setResponseBody(responseData);

            System.out.print(responseData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
