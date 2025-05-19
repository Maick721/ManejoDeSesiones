package services;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceImplement implements LoginService {

    @Override
    public Optional<String> getUserName(HttpServletRequest request){
        Cookie[] cookies = request.getCookies() != null ? request.getCookies() : new Cookie[0];
        return Arrays.stream(cookies)
                .filter(c->"username".equals(c.getName()))
                //convertimos la cookie a tipo string
                .map(Cookie::getValue)
                .findAny();
    }
}
