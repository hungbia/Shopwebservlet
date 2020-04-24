package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.User;

@WebFilter(urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("admin");// lay du lieu tu client gui len req resp
		// cho di tiep
		// ddoc sesion
		/// DOC SESSION
		HttpServletRequest req = (HttpServletRequest) request;// ep kieu
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		System.out.println("session id: " + session.getId());

		Object obj = session.getAttribute("loginUser");

		if (obj != null) {
			// String username = (String) obj;// ep kieu xuong
			User user = (User) obj;// ep kieu xuong
			System.out.println(user.getUsername());
			if (user.getRole().equals("ROLE_ADMIN")) {
				// cho di tiep
				chain.doFilter(request, response);
			} else {
				// chuyen huong ve trang access.deny
				resp.sendRedirect("/HelloWeb6/access-deny");
			}
			/// cho di tiep
//			chain.doFilter(request, response);
			///
		} else {
			// Ko con login nua, het thoi gian,
			// session cu da bi xoa, du lieu cu troi theo may khoi
			resp.sendRedirect("/HelloWeb6/dang-nhap");
			return;
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
