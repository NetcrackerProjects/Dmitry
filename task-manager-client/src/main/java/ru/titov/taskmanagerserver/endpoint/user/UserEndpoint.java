package ru.titov.taskmanagerserver.endpoint.user;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-01-16T15:07:23.366+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://user.endpoint.taskmanagerserver.titov.ru/", name = "UserEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface UserEndpoint {

    @WebMethod
    @Action(input = "http://user.endpoint.taskmanagerserver.titov.ru/UserEndpoint/viewAllRequest", output = "http://user.endpoint.taskmanagerserver.titov.ru/UserEndpoint/viewAllResponse")
    @RequestWrapper(localName = "viewAll", targetNamespace = "http://user.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.user.ViewAll")
    @ResponseWrapper(localName = "viewAllResponse", targetNamespace = "http://user.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.user.ViewAllResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.titov.taskmanagerserver.endpoint.user.UserListResponse viewAll(
        @WebParam(name = "token", targetNamespace = "")
        java.lang.String token
    );

    @WebMethod
    @Action(input = "http://user.endpoint.taskmanagerserver.titov.ru/UserEndpoint/changePasswordRequest", output = "http://user.endpoint.taskmanagerserver.titov.ru/UserEndpoint/changePasswordResponse")
    @RequestWrapper(localName = "changePassword", targetNamespace = "http://user.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.user.ChangePassword")
    @ResponseWrapper(localName = "changePasswordResponse", targetNamespace = "http://user.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.user.ChangePasswordResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.titov.taskmanagerserver.endpoint.user.Response changePassword(
        @WebParam(name = "token", targetNamespace = "")
        java.lang.String token,
        @WebParam(name = "newPassword", targetNamespace = "")
        java.lang.String newPassword
    );

    @WebMethod
    @Action(input = "http://user.endpoint.taskmanagerserver.titov.ru/UserEndpoint/signInRequest", output = "http://user.endpoint.taskmanagerserver.titov.ru/UserEndpoint/signInResponse")
    @RequestWrapper(localName = "signIn", targetNamespace = "http://user.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.user.SignIn")
    @ResponseWrapper(localName = "signInResponse", targetNamespace = "http://user.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.user.SignInResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.titov.taskmanagerserver.endpoint.user.TokenResponse signIn(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );

    @WebMethod
    @Action(input = "http://user.endpoint.taskmanagerserver.titov.ru/UserEndpoint/signUpRequest", output = "http://user.endpoint.taskmanagerserver.titov.ru/UserEndpoint/signUpResponse")
    @RequestWrapper(localName = "signUp", targetNamespace = "http://user.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.user.SignUp")
    @ResponseWrapper(localName = "signUpResponse", targetNamespace = "http://user.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.user.SignUpResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.titov.taskmanagerserver.endpoint.user.Response signUp(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );
}
