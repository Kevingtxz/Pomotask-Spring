package com.pomotask.pomotask.config.security.handler;

import com.pomotask.pomotask.util.VersionUtil;
import lombok.extern.slf4j.Slf4j;
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
        res.sendRedirect(VersionUtil.API_VERSION_FOR_URL);
        log.info("User authenticated");
    }

}
