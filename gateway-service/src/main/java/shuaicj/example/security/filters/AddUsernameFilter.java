package shuaicj.example.security.filters;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.client.http.HttpHeaders;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class AddUsernameFilter extends ZuulFilter {
    @Override
    public String filterType() {
		return "pre";
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
	public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ctx.addZuulRequestHeader("Username", username);   
        return null;    
	}
}