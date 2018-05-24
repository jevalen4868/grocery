<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="ss" %>

<!DOCTYPE html>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#myNavbar">
                <span class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">grocery</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="<s:url value="/" />">home</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <ss:authorize access="!isAuthenticated()">
                    <li><s:url var="loginUrl" value="/login"/> <a id="loginLink"
                                                                  href="${loginUrl}"> <span
                            class="glyphicon glyphicon-log-in"></span>
                        login
                    </a></li>
                </ss:authorize>
                <ss:authorize access="isAuthenticated()">
                    <li><s:url var="logoutUrl" value="/logout"/> <!-- Use jquery to submit this form. According to spring docs, not using POST method here
					poses a security risk. --> <sf:form action="${logoutUrl}"
                                                        id="logoutForm" method="post" class="hidden">
                    </sf:form> <a id="logoutLink" href="#"> <span
                            class="glyphicon glyphicon-log-out"></span> logout
                    </a></li>
                </ss:authorize>
            </ul>
        </div>
    </div>
</nav>