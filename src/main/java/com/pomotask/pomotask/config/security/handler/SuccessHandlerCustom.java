package com.pomotask.pomotask.config.security.handler;

import com.pomotask.pomotask.util.Version;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class SuccessHandlerCustom implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest req,
            HttpServletResponse res,
            Authentication auth) throws IOException {
        res.sendRedirect(Version.API_VERSION_FOR_URL + "auth");
        log.info("User authenticated");
    }

}
