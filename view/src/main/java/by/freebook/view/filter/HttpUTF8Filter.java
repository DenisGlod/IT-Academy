package by.freebook.view.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class HttpUTF8Filter extends GenericFilter {
    private static final long serialVersionUID = -3761779933949864315L;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	    throws IOException, ServletException {
	if (!(req instanceof HttpServletRequest && 
		res instanceof HttpServletResponse)) {
	    throw new ServletException("non-HTTP request or response");
	}
	log.info("setCharacterEncoding");
	req.setCharacterEncoding(StandardCharsets.UTF_8.name());
	res.setCharacterEncoding(StandardCharsets.UTF_8.name());
	this.doFilter((HttpServletRequest) req, (HttpServletResponse) res, chain);
    }

    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
	    throws IOException, ServletException {
	chain.doFilter(req, res);
    }

}
