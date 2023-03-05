package yummy.cake.com.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import yummy.cake.com.dto.security.LoginViewModel;
import yummy.cake.com.principal.UserPrincipal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.auth0.jwt.algorithms.Algorithm.*;
import static yummy.cake.com.security.JwtProperties.*;
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final String CLAIM_NAME = "authorities";
    private static final String HEADERS_TYPE = "Access-Control-Expose-Headers";
    private static final String HEADERS_NAME = "Authorization";
    private final AuthenticationManager authenticationManager;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        LoginViewModel credentials = null;

        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(),
                credentials.getPassword(),
                new ArrayList<>());

        Authentication auth = null;

        try {
            auth = authenticationManager.authenticate(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return auth;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();

        List<String> claim = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withArrayClaim(CLAIM_NAME, claim.toArray(new String[claim.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));

        response.addHeader(HEADERS_TYPE, HEADERS_NAME);
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
