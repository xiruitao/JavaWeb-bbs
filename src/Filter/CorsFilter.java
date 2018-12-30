package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse res = (HttpServletResponse) resp;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "*");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type,x-requested-with");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json");
        chain.doFilter(req, res);
    }
    public void init(FilterConfig config) throws ServletException {

    }

}
