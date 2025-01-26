package com.example.Demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.Demo.config.CommonResult;
import com.example.Demo.vo.AccountVo;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CommonResult<AccountVo>> handleAccountNotFoundException(AccountNotFoundException ex) {
        CommonResult<AccountVo> res = CommonResult.fail(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AccountExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<CommonResult<AccountVo>> handleUsernameExistException(AccountExistException ex) {
        CommonResult<AccountVo> res = CommonResult.fail(ex.getMessage(), HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(res, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = SelfFollowNotAllowedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CommonResult<AccountVo>> handleSelfFollowException(SelfFollowNotAllowedException ex) {
        CommonResult<AccountVo> res = CommonResult.fail(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AccountNotFollowingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CommonResult<AccountVo>> handleNotFollowingException(AccountNotFollowingException ex) {
        CommonResult<AccountVo> res = CommonResult.fail(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
