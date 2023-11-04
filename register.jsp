<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins%3A400%2C600%2C700%2C900"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro%3A400%2C600%2C700%2C900"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Titan+One%3A400"/>
  <link rel="stylesheet" href="/MMJ/styles/registration.css"/>

</head>
<body>
    
    <p id="passwordMismatch" style="color: red; display: none;">비밀번호가 일치하지 않습니다.</p>
    
    

     <div class="registration-xru">
  <img class="backgroundimg-hZb" src="./assets/backgroundimg.png"/>
  <div class="backgroundwhite-qQu">
  </div>
  <form action="RegisterServlet1" method="post" onsubmit="return validateForm()" >
        <div class="id-Zd3">
        <img class="userid-5LV" src="./assets/userid.png"/>
        <div class="auto-group-racy-c5X">
            <p class="item--YUy">아이디</p>
            <input type="text" name="id" class="kdhong-t33" value="kdhong" required>
        </div><br>
        </div>
          <div class="checkpassword-h7f">
        <img class="logokey-NDo" src="./assets/logokey-GU9.png"/>
        <div class="auto-group-3gv5-hG5">
            <p class="item--eh7">비밀번호 확인</p>
            <input type="password" name="passwordcheck" class="item--xSu" value="***********" required>
        </div>
    </div>
    <div class="password-URF">
        <img class="logokey-PYD" src="./assets/logokey-4ob.png"/>
        <div class="auto-group-ymwx-tzm">
            <p class="item--4PT">비밀번호</p>
            <input type="password" name="password" class="item--Bys" value="***********" required>
        </div>
    </div>
    <div class="email-KaH">
        <img class="emaillogo-RtD" src="./assets/emaillogo.png"/>
        <div class="auto-group-7ub3-jtu">
            <p class="item--W8y">이메일</p>
            <input type="email" name="email" class="examplenavercom-qS9" value="example@naver.com" required>
        </div>
    </div>

    <div class="name-ND7">
        <img class="username-r8H" src="./assets/username.png"/>
        <div class="auto-group-2sgh-BAZ">
            <p class="item--8rV">이름</p>
            <input type="text" name="name" class="item--TNy" value="홍길동" required>
        </div>
    </div>>
    <div class="registerbutton-YaD">
    <p class="item--pGq">가입하기</p>
    <input type="submit" value="가입하기">
    <img class="dart-Xww" src="REPLACE_IMAGE:109:112" />
  </div>
    
    </form>
  <script>
        function validateForm() {
            var password = document.querySelector("input[name='password']").value;
            var passwordcheck = document.querySelector("input[name='passwordcheck']").value;
            var passwordMismatch = document.getElementById("passwordMismatch");

            if (password !== passwordcheck) {
                passwordMismatch.style.display = "block";
                return false;
            } else {
                passwordMismatch.style.display = "none";
                return true;
            }
        }
    </script>
  
  <div class="rememberme-Fsw">
    <div class="check-Mvy">
    </div>
    <p class="item--GHF">로그인 상태 유지</p>
  </div>
  
  <div class="logoregister-aTb">
    <img class="logomeo-VaZ" src="./assets/logomeo-YEd.png"/>
    <p class="welcome-to-meomeokji-Rz1">
      <span class="welcome-to-meomeokji-Rz1-sub-0">
      
      <br/>
      
      </span>
      <span class="welcome-to-meomeokji-Rz1-sub-1">
      Welcome to
      <br/>
      
      </span>
      <span class="welcome-to-meomeokji-Rz1-sub-2">
      MeoMeoKji
      <br/>
      
      </span>
    </p>
  </div>
  
</div>
<script>
  
<script>
// 이미지를 클릭했을 때 폼을 제출하는 이벤트 핸들러를 추가합니다.
document.getElementById("submitimage").addEventListener("click", function() {
    var password = document.getElementById("password").value;
    var passwordcheck = document.getElementById("passwordcheck").value;

    if (password !== passwordcheck) {
        document.getElementById("passwordMismatch").style.display = "block";
        return false; // 폼 제출을 막음
    }
});

// 비밀번호와 비밀번호 확인 필드가 변경될 때 메시지를 숨깁니다.

</body>

</html>
