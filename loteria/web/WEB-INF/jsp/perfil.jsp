<%-- 
    Document   : loteria
    Created on : 07-05-2016, 08:31:20 AM
    Author     : Joe-Xidu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:Master>
    <jsp:body>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Perfil</h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-3">
                    <div class="box box-primary">
                        <div class="box-body box-profile">
                            <img src="/loteria/resources/dist/img/user2-160x160.jpg" class="profile-user-img img-responsive img-circle" alt="Usuario">
                            <h3 class="profile-username text-center">${user.firstName}</h3>
                            <p class="text-muted text-center">${user.firstName}</p>
                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <b>Rut</b>
                                    <a class="pull-right">${user.rut}-${user.dv}</a>
                                </li>
                                <li class="list-group-item">
                                    <b>Correo</b><br>
                                    <a class="email-large">${user.email}</a>
                                </li>
                            </ul>
                            <button id="change-password" class="btn btn-primary btn-block"><b>Cambiar Contraseña</b></button>
                        </div>
                        <!-- /.box-body -->
                    </div>
                </div>
                <div class="col-lg-4 col-xs-6">
                    <div class="small-box bg-green">
                        <div class="inner">
                            <h3>${fmt.format(user.wallet)}</h3>
                            <p>Bolsa de Dinero</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-bag"></i>
                        </div>
                        <a href="#" class="small-box-footer">Abonar <i class="fa fa-usd"></i></a>
                    </div>
                </div>
                <div class="col-lg-5 col-xs-12">
                    <div class="small-box bg-red">
                        <div class="inner">
                            <h3>${fmt.format(pp.pot)}</h3>
                            <p>Pozo Acumulado</p>
                        </div>
                        <div class="icon">
                            <i class="fa fa-money"></i>
                        </div>
                        <div class="small-box-footer">&nbsp;</div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="box box-primary">
                        <div class="box-body">
                            <a class="btn btn-app bg-yellow" id="buyTicket">
                                <i class="fa fa-money"></i> Comprar Ticket
                            </a>
                            <a class="btn btn-app bg-red">
                                <i class="fa  fa-check-circle"></i> Revisar Ticket
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5 col-xs-12">
                    <div class="info-box bg-yellow">
                        <span class="info-box-icon"><i class="ion ion-ios-pricetag-outline"></i></span>
                        <div class="info-box-content">
                            <span class="info-box-text">Último Ticket Comprado</span>
                            <span class="info-box-number">${ticket!=null?ticket.number1:'-'} | ${ticket!=null?ticket.number2:'-'} | ${ticket!=null?ticket.number3:'-'} | ${ticket!=null?ticket.number4:'-'} | ${ticket!=null?ticket.number5:'-'} | ${ticket!=null?ticket.number6:'-'}</span>
                            <div class="progress">
                                <div class="progress-bar" style="width: ${succesRate}%"></div>
                            </div>
                            <span class="progress-description">
                                ${succesRate} % de acierto en los números
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Últimos Tickets Comprados</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="table-responsive">
                                <table class="table no-margin">
                                    <thead>
                                        <tr>
                                            <th>Order ID</th>
                                            <th>Item</th>
                                            <th>Status</th>
                                            <th>Popularity</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><a href="pages/examples/invoice.html">OR9842</a></td>
                                            <td>Call of Duty IV</td>
                                            <td><span class="label label-success">Shipped</span></td>
                                            <td>
                                                <div class="sparkbar" data-color="#00a65a" data-height="20"><canvas style="display: inline-block; width: 34px; height: 20px; vertical-align: top;" width="34" height="20"></canvas></div>
                                            </td>
                                        </tr>
                                    </tbody>
                              </table>
                            </div>
                        </div>
                        <div class="box-footer clearfix">
                            <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-left">Place New Order</a>
                            <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-right">Ver Todos</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <div class="modal" id="newTicket">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title">Comprar Ticket</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <c:forEach begin="1" end="99" varStatus="loop">
                                    <input class="numberTicket" name="num${loop.index}" data-size="small" data-toggle="toggle" data-on="${loop.index}" data-off="${loop.index}" type="checkbox" value="${loop.index}">
                                    <c:if test="${loop.index%10 == 0}">
                                            </div>
                                        </div>
                                        <div class="row" style="margin-top:5px;">
                                            <div class="col-lg-12">
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal" id="cancelTicket">Cerrar</button>
                        <button type="button" class="btn btn-success" id="confirmTicket" data-url="./buyTicket.htm">Comprar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
        <!-- /.content -->
    </jsp:body>
</t:Master>