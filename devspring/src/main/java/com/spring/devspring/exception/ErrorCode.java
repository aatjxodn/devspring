package com.spring.devspring.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	// 잘못된 문법으로 요청을 보내고 있어 서버가 이해할 수 없음
	Bad_Request(400,HttpStatus.BAD_REQUEST,"COMMON-ERR-400-Bad_Request"),
	// 요청을 위해 권한 인증이 필요함 (ex. 토큰이 없음)
	Unauthorized(401,HttpStatus.UNAUTHORIZED,"COMMON-ERR-401-Unauthorized"),
	// 클라이언트가 요청한 컨텐츠에 대해 접근할 권리가 없음 (신원 인증은 되었지만 권한은 없음)
	Forbidden(403,HttpStatus.FORBIDDEN,"COMMON-ERR-403-Forbidden"),
	// 요청한 URI를 찾을 수 없음
	Not_Found(404,HttpStatus.NOT_FOUND,"COMMON-ERR-404-Not_Found"),
	// 클라이언트가 보낸 메소드가 해당 URI에서 지원하지 않음
	Method_Not_Allowed(405,HttpStatus.METHOD_NOT_ALLOWED,"COMMON-ERR-405-Method_Not_Allowed"),
	// 클라이언트의 요청에 대해 응답할만한 컨텐츠가 없음
	Not_Acceptable(406,HttpStatus.NOT_ACCEPTABLE,"COMMON-ERR-406-Not_Acceptable"),
	// 요청에 응답하는 시간이 오래 걸려 요청을 끊음 (보내지 않고 끊을 때도 있음)
	Request_Timeout(408,HttpStatus.REQUEST_TIMEOUT,"COMMON-ERR-408-Request_Timeout"),
	// 클라이언트의 요청이 서버의 상태와 충돌이 발생할 수 있음
	Conflict(409,HttpStatus.CONFLICT,"COMMON-ERR-409-Conflict"),
	// equest payload가 서버에서 정의한 최대 크기보다 큼
	Payload_Too_Large(413,HttpStatus.PAYLOAD_TOO_LARGE,"COMMON-ERR-413-Payload_Too_Large"),
	// 요청된 URI가 너무 길어서 처리할 수 없음
	URI_Too_Long(414,HttpStatus.URI_TOO_LONG,"COMMON-ERR-414-URI_Too_Long"),
	// 서버의 문제로 응답할 수 없음
	Internal_Server_Error(414,HttpStatus.INTERNAL_SERVER_ERROR,"COMMON-ERR-500-Internal_Server_Error");

    private int status;
    private HttpStatus statusMsg;
    private String message;

}