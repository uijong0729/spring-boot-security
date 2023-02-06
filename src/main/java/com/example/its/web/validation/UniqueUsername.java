package com.example.its.web.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// 참고 : https://jongmin92.github.io/2019/11/21/Spring/bean-validation-2/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUserNameValidator.class)
public @interface UniqueUsername {
    String message() default "입력된 유저는 이미 존재합니다. 다른 이름을 등록하세요";
    
    // 유효성 검사가 어떤 상황에서 실행되는지 정의할 수 있는 매개 변수 그룹.
    Class<?>[] groups() default {};
    
    // 페이로드(payload)는 전송되는 데이터를 의미한다.
    Class<? extends Payload>[] payload() default {};
}
