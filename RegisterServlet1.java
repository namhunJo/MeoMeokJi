package MMJ;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/RegisterServlet1")

public class RegisterServlet1 extends HttpServlet {
    private Connection conn;
    Statement stmt = null;
    ResultSet rs = null;
    public void init() throws ServletException {
        // 데이터베이스 연결 초기화
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://mmj.ctjtwbfhskrs.ap-northeast-2.rds.amazonaws.com:3306?useUnicode=true&characterEncoding=UTF-8", "meo", "Ska3028!");
            String useDatabaseSQL = "USE MMJ";
            stmt = conn.createStatement();
            stmt.execute(useDatabaseSQL);
        } catch (Exception e) {
            throw new ServletException("데이터베이스 연결 오류", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String nickname = request.getParameter("name");

        try {
        	
        	if (isUserIdDuplicate(id)) {
                // 이미 존재하는 사용자 아이디
                response.sendRedirect("registerFail.jsp"); // 중복 아이디 페이지로 리다이렉트
            } else if (isEmailDuplicate(email)) {
                // 이미 존재하는 이메일
                response.sendRedirect("registerFail.jsp"); // 중복 이메일 페이지로 리다이렉트
            }
            else if (isNameDuplicate(nickname)) {
                // 이미 존재하는 이메일
                response.sendRedirect("registerFail.jsp"); // 중복 이름 페이지로 리다이렉트
            }	
            else {
            // 사용자 정보 데이터베이스에 삽입
            String insertQuery = "INSERT INTO Users (userId, password, email, name) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, new String(nickname.getBytes("UTF-8"), "UTF-8"));
            preparedStatement.executeUpdate();

            // 이메일 전송
            String subject = "회원 가입을 환영합니다";
            String message = "회원 가입이 완료되었습니다. 환영합니다, " + nickname + "님!";
            sendEmail(email, subject, message);

            // 등록이 완료되면 페이지를 리다이렉트
            response.sendRedirect("registerComplete.jsp");}
        } catch (Exception e) {
            // 오류 처리
            throw new ServletException("등록 오류", e);
        }
        
        
    }
    
    private boolean isUserIdDuplicate(String userId) throws SQLException {
        // userId 중복 검사
        String query = "SELECT userId FROM Users WHERE userId = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next(); // 결과가 있으면 중복
    }

    private boolean isEmailDuplicate(String email) throws SQLException {
        // email 중복 검사
        String query = "SELECT email FROM Users WHERE email = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next(); // 결과가 있으면 중복
    }
    
    private boolean isNameDuplicate(String name) throws SQLException {
        // email 중복 검사
        String query = "SELECT email FROM Users WHERE name = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next(); // 결과가 있으면 중복
    }
    
    
    private void sendEmail(String to, String subject, String message) {
        // 이메일 전송 코드를 작성
        // 이 부분은 이메일 전송 라이브러리 또는 서비스를 사용하여 구현해야 합니다.
    }

    public void destroy() {
        // 데이터베이스 연결 닫기
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            log("데이터베이스 연결 닫기 오류", e);
        }
    }
}
