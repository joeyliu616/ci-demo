package com.aoe.service.account.api;

/**
 * Created by joey on 16-8-2.
 */
public interface AccountService {

    /**
     * 通过token获取用户id
     * @param password
     * @return 账号id
     */
    String getAccountId(String password);

    /**
     * 通过用户名,手机号,电子邮件注册
     * @param email
     * @param mobile
     * @param userName
     * @return 账号id
     */
    String getAccountId(String email,String mobile, String userName);

    /**
     * 登陆校验
     * @param accountId
     * @param password
     * @return token
     */
    String login(String accountId, String password);

    /**
     * 通过token登出
     * @param token
     * @return
     */
    boolean logout(String token);


}
