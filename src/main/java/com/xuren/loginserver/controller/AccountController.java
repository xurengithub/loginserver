package com.xuren.loginserver.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.xuren.loginserver.dto.LoginRequest;
import com.xuren.loginserver.dto.RegisterRequest;
import com.xuren.loginserver.dto.Response;
import com.xuren.loginserver.entity.AccountInfo;
import com.xuren.loginserver.entity.UserInfo;
import com.xuren.loginserver.service.IAccountInfoService;
import com.xuren.loginserver.service.IRoleInfoService;
import com.xuren.loginserver.service.IUserInfoService;
import jakarta.annotation.Resource;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * @author xuren
 */
@RestController
@RequestMapping("auth")
public class AccountController {
    @Resource
    private IUserInfoService userInfoService;
    @Resource
    private IRoleInfoService roleInfoService;
    @Resource
    private IAccountInfoService accountInfoService;

    @PostMapping("/login")
    public Response<String> login(@RequestBody LoginRequest request) {
        if (StringUtils.hasText(request.getAccount()) && StringUtils.hasText(request.getAccount())) {
            AccountInfo accountInfo = accountInfoService.getBaseMapper().selectOne(Wrappers.lambdaQuery(AccountInfo.class).eq(AccountInfo::getAccount, request.getAccount()));
            if (accountInfo != null) {
                if (!accountInfo.getPassword().equals(DigestUtils.md5DigestAsHex(request.getPassword().getBytes(StandardCharsets.UTF_8)))) {
                    return Response.error("密码不正确");
                }
            } else {
                return Response.error("用户不存在");
            }
        }
//        boolean exists = userInfoService.getBaseMapper().selectOne(Wrappers.lambdaQuery(UserInfo.class).eq(UserInfo::getAccount, request.getAccount()));

        return Response.ok("roleToken");
    }

    @PostMapping("/register")
    public Response<String> register(@RequestBody RegisterRequest request) {
        boolean exists = accountInfoService.getBaseMapper().exists(Wrappers.lambdaQuery(AccountInfo.class).eq(AccountInfo::getAccount, request.getAccount()));
        if (exists) {
            return Response.error("账号已存在");
        }
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccount(request.getAccount());
        accountInfo.setPassword(DigestUtils.md5DigestAsHex(request.getPassword().getBytes(StandardCharsets.UTF_8)));
        accountInfoService.getBaseMapper().insert(accountInfo);
        return Response.ok();
    }
}
