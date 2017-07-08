<%-- 
    Document   : loteria
    Created on : 07-05-2016, 08:31:20 AM
    Author     : Joe-Xidu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:useBean id="dm" class="utilities.DraftManager"/>
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
                        <a href="#" class="small-box-footer recarga" data-url="/loteria/recharge.htm">Abonar <i class="fa fa-usd"></i></a>
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
                                <i class="fa fa-check-circle"></i> Revisar Ticket
                            </a>
                            <a class="btn btn-app bg-green" id="recharge">
                                <i class="fa fa-credit-card"></i> Recargar Saldo
                            </a>
                            <a data-url="/loteria/schedule.htm" class="btn btn-app bg-blue" id="schedule">
                                <i class="fa fa-refresh"></i> Activar Sorteo
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
                                <div class="progress-bar" style="width: ${dm.successRate(ticket)}%"></div>
                            </div>
                            <span class="progress-description">
                                ${dm.successRate(ticket)} % de acierto en los números
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
                                            <th>Nro. Ticket</th>
                                            <th>N 1</th>
                                            <th>N 2</th>
                                            <th>N 3</th>
                                            <th>N 4</th>
                                            <th>N 5</th>
                                            <th>N 6</th>
                                            <th>% Acierto</th>
                                            <th>Sorteo</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listTickets}" var="ticket">
                                            <tr>
                                                <td>${ticket.id}</td>
                                                <td>${ticket.number1}</td>
                                                <td>${ticket.number2}</td>
                                                <td>${ticket.number3}</td>
                                                <td>${ticket.number4}</td>
                                                <td>${ticket.number5}</td>
                                                <td>${ticket.number6}</td>
                                                <td>${dm.successRate(ticket)} %</td>
                                                <td>${ticket.drafts.date}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                              </table>
                            </div>
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
                        <button type="button" class="btn btn-default" id="randomTicket" data-url="/loteria/randomTicket.htm">Comprar Al Azar</button>
                        <button type="button" class="btn btn-success" id="confirmTicket" data-url="./buyTicket.htm">Comprar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal" id="rechargeModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title">Realizar Recarga</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form class="form-horizontal form" id="addForm">
                                    <input class="form-control" name="id" id="id" type="hidden">
                                    <div class="form-group">
                                        <label for="account" class="col-sm-2 control-label">Cuenta</label>
                                        <div class="col-sm-10">
                                            <input class="form-control" name="account" id="account" placeholder="Cuenta" type="text" required="required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="amount" class="col-sm-2 control-label">Monto</label>
                                        <div class="col-sm-10">
                                            <input class="form-control" name="amount" id="amount" placeholder="Monto" type="text" required="required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="payMethod" class="col-sm-2 control-label">Medio de Pago</label>
                                        <div class="col-sm-10">
                                            <select name="payMethod" id="payMethod" class="form-control" style="width: 100%;">
                                                <option value="credito">Tarjeta de Crédito</option>
                                                <option value="debito">Tarjeta de Débito</option>
                                                <option value="paypal">PayPal</option>
                                            </select>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal" id="cancelTicket">Cerrar</button>
                        <button type="button" class="btn btn-success" id="confirmTicket" data-url="/loteria/recharge.htm">Recargar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.content -->
    </jsp:body>
</t:Master>