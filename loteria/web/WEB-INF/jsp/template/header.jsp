<%-- 
    Document   : header
    Created on : 06-05-2016, 02:36:54 AM
    Author     : Joe-Xidu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="wrapper">
    <header class="main-header">
        <!-- Logo -->
        <a href="/loteria/perfil.htm" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini">LOTERIA</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b draggable="true">LOTERIA</b></span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <!-- Notifications: style can be found in dropdown.less -->
                    <!-- Tasks: style can be found in dropdown.less -->
                    <!-- User Account: style can be found in dropdown.less -->
                    <!-- Control Sidebar Toggle Button -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="/loteria/resources/dist/img/user2-160x160.jpg" class="user-image" alt="${user.username}">
                            <span class="hidden-xs">${user.firstName}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="/loteria/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="${user.username}">
                                <p>
                                    ${user.firstName}
                                    <small>${user.username}</small>
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="/loteria/perfil.htm" class="btn btn-default btn-flat">Perfil</a>
                                </div>
                                <div class="pull-right">
                                    <a href="/loteria/salir.htm" class="btn btn-default btn-flat">Salir</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section style="height: auto;" class="sidebar">
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu tree" data-widget="tree">
                <li class="header">Navegación</li>
                <c:forEach items="${pageList}" var="objPage">
                    <c:if test="${objPage.parent==0}">
                        <c:choose>
                            <c:when test="${objPage.url=='#'}">
                                <li class="treeview">
                                    <a href="${objPage.url}">
                                        <i class="fa ${objPage.icon}"></i>
                                        <span>${objPage.name}</span>
                                        <i class="fa fa-angle-left pull-right"></i>
                                    </a>
                                    <ul class="treeview-menu">
                                        <c:forEach items="${pageList}" var="objPageChild">
                                            <c:if test="${objPageChild.id!=0 && objPage.id == objPageChild.parent}">
                                                <li>
                                                    <c:choose>
                                                        <c:when test="${objPageChild.url=='#'}">
                                                            <a href="${objPageChild.url}">
                                                                <i class="fa ${objPageChild.icon}"></i>
                                                                <span>${objPageChild.name}</span>
                                                                <span class="pull-right-container">
                                                                    <i class="fa fa-angle-left pull-right"></i>
                                                                </span>
                                                            </a>
                                                            <ul class="treeview-menu">
                                                                <c:forEach items="${pageList}" var="objPageSubChild">
                                                                    <c:if test="${objPageSubChild.id!=0 && objPageChild.id == objPageSubChild.parent}">
                                                                        <li><a href="${objPageSubChild.url}"><i class="fa ${objPageSubChild.icon}"></i> ${objPageSubChild.name}</a></li>
                                                                    </c:if>
                                                                </c:forEach>
                                                            </ul>
                                                         </c:when>
                                                        <c:otherwise>
                                                            <a href="${objPageChild.url}"><i class="fa ${objPageChild.icon}"></i> ${objPageChild.name}</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${objPage.url}"><i class="fa ${objPage.icon}"></i> ${objPage.name}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </c:forEach>
            </ul>
            
        </section>
        <!-- /.sidebar -->
    </aside>