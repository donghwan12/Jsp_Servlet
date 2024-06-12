<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
PageContext:
PageContext는 JSP 페이지 내에서 사용 가능한 객체들의 집합을 나타내는 인터페이스입니다. 
JSP 페이지 내에서 다른 객체들에 접근하고 데이터를 공유하는 데 사용됩니다. 
주로 JSP 페이지에서 스크립트 요소나 표현 언어 (EL) 등을 이용하여 다른 Java 객체나 속성에 접근할 때 사용됩니다.

Request:
Request는 클라이언트(브라우저)가 서버에게 보내는 요청(Request) 정보를 나타냅니다. 
이를 통해 웹 애플리케이션은 클라이언트로부터 받은 데이터나 정보를 처리하고, 클라이언트의 요청을 수행합니다. 예를 들어, 
사용자가 폼을 제출하거나 URL을 통해 파라미터를 전달할 때, 해당 요청 정보는 Request 객체에 저장됩니다.

Response:
Response는 서버가 클라이언트로 보내는 응답(Response) 정보를 나타냅니다. 웹 애플리케이션은 클라이언트로부터 받은 요청을 처리하고 
그 결과를 Response 객체에 담아 클라이언트로 전송합니다. 이렇게 전송된 응답은 웹 페이지의 내용, HTTP 상태 코드, 헤더 등을 포함할 수 있습니다.

Session:
Session은 클라이언트와 서버 간에 유지되어야 하는 상태 정보를 저장하는 객체입니다. 웹 애플리케이션은 Session 객체를 사용하여 
특정 클라이언트의 세션 정보를 저장하고, 해당 세션을 통해 클라이언트와 지속적인 상태 정보를 유지할 수 있습니다. 세션은 일정 시간 동안 유지되며, 
브라우저를 닫거나 세션이 만료되면 삭제됩니다.

ServletContext:
ServletContext는 웹 애플리케이션의 컨텍스트 정보를 나타내는 객체입니다. 서버의 모든 JSP 페이지 및 Servlet에 대한 공통 정보를 저장하고, 
이를 공유하는 데 사용됩니다. 예를 들어, 웹 애플리케이션의 초기화 매개변수, 리소스의 절대 경로, 서버 정보 등을 ServletContext에 저장하여 
애플리케이션 전체에서 접근 가능하게 할 수 있습니다.