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

@WebFilter(urlPatterns = { "/member/*" })
public class MemberFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// doc session
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		System.out.println("session id: " + session.getId());

		Object obj = session.getAttribute("loginUser");// loginUser chinh la login uuser

		if (obj != null) {
			// String username = (String) obj;// ep kieu xuong
			User user = (User) obj;// ep kieu xuong
			System.out.println(user.getUsername());
			chain.doFilter(request, response);

		} else {
			// Ko con login nua, het thoi gian,
			// session cu da bi xoa, du lieu cu troi theo may khoi
			resp.sendRedirect(req.getContextPath() + "/HelloWeb6/dang-nhap");
			return;
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
