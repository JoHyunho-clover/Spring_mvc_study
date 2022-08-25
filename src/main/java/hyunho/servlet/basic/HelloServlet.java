package hyunho.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet",urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override //Ctrl + O 로 찾음  // /hello url로 들어오면 서블릿이 호출되는데 서블릿 호출 시 이 메서드가 호출된다.
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);

        System.out.println("HelloServlet.service");
        System.out.println("request = " + req);
        System.out.println("response = " + resp);

        String username = req.getParameter("username"); //요청 중 키로 username을 가진 쿼리파라미터의 값을 가져온다.
        System.out.println("username = " + username);

        resp.setContentType("text/plain"); //Http 헤더로 들어가는 것
        resp.setCharacterEncoding("utf-8"); //Http 헤더로 들어가는 것
        resp.getWriter().write("hello "+username); //response 바디로 들어가는 것
    }
}
