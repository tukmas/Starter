package com.example.Starter.config;

import com.example.Starter.model.HttpLog;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);
    private static final String START_TIME_ATTRIBUTE = "startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME_ATTRIBUTE, start);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long start = (long) request.getAttribute(START_TIME_ATTRIBUTE);
        long end = System.currentTimeMillis();
        long duration = end - start;

        String method = request.getMethod();
        String requestURL = request.getRequestURL().toString();
        int statusCode = response.getStatus();

        Map<String, String> requestHeaders = getHeader(request);
        Map<String, String> responseHeaders = getHeader(response);

        HttpLog httpLog = createMessage(method, requestURL, statusCode, duration, requestHeaders, responseHeaders);

        log.info("Лог HTTP {}", httpLog);
    }

    public Map<String, String> getHeader(HttpServletRequest request) {
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            headers.put(key, value);
        }
        return headers;
    }

    public Map<String, String> getHeader(HttpServletResponse response) {
        Map<String, String> headers = new HashMap<>();
        for (String header : response.getHeaderNames()) {
            String value = response.getHeader(header);
            headers.put(header, value);
        }
        return headers;
    }

    private HttpLog createMessage(String method, String requestURL, int statusCode, long duration,
                                  Map<String, String> requestHeaders,
                                  Map<String, String> responseHeaders) {
        HttpLog httpLog = new HttpLog();
        httpLog.setMethod(method);
        httpLog.setUriEndpoint(requestURL);
        httpLog.setStatus(statusCode);
        httpLog.setRequestHeaders(requestHeaders);
        httpLog.setResponseHeaders(responseHeaders);
        httpLog.setExecutionTime(duration);
        return httpLog;
    }
}
