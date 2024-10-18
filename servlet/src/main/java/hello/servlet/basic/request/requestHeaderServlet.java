package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet")
public class RequestHeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String method = request.getMethod();
    request.getProtocol();

  }

  private void printHeaders(HttpServletRequest request){

    System.out.println("---- headers - start ----");

//    Enumeration<String> headerNames = request.getHeaderNames();
//    while(headerNames.hasMoreElements()){
//      String headerName = headerNames.nextElement();
//      System.out.println(headerName+" : "+headerName);
//    }

    request.getHeaderNames().asIterator()
            .forEachRemaining(headerName -> System.out.println("headerName = " + headerName));



    System.out.println("---- headers - end ----");

  }

}
