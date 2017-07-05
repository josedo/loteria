<%-- 
    Document   : listado
    Created on : 02-04-2017, 03:37:02 PM
    Author     : Joe-Xidu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:Master>
    <jsp:body>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Mantenedor Usuarios</h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Usuarios</h3>
                            <button type="submit" class="btn btn-primary pull-right" id="newItem">Nuevo</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="mantenedor" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Usuario</th>
                                        <th>Nombre</th>
                                        <th>Rut</th>
                                        <th>Dinero</th>
                                        <th>Email</th>
                                        <th>Perfil</th>
                                        <th>Estado</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="user">
                                        <tr>
                                            <td>${user.username}</td>
                                            <td>${user.firstName} ${user.lastName}</td>
                                            <td>${user.rut} - ${user.dv}</td>
                                            <td>${user.wallet}</td>
                                            <td>${user.email}</td>
                                            <td>${user.profiles.name}</td>
                                            <td>
                                                <span class="label label-${user.status?"success":"danger"}">${user.status?"Activo":"Inactivo"}</span>
                                            </td>
                                            <td>
                                                <a class="btn btn-primary btn-xs btnEditar" data-id="${user.id}" data-url="./getUsuario.htm" data-original-title="Editar" data-toggle="tooltip"><i class="fa fa-pencil-square-o"></i></a>
                                                <c:if test="${user.status}"><a class="btn btn-primary btn-xs btnEliminar" data-id="${user.id}" data-url="./deleteUsuario.htm" data-original-title="Eliminar" data-toggle="tooltip"><i class="fa fa-times-circle"></i></a></c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot></tfoot>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
        <div class="modal" id="new">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title">Detalles Usuario</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal form" id="addForm">
                            <input class="form-control" name="id" id="id" type="hidden">
                            <div class="form-group">
                                <label for="username" class="col-sm-2 control-label">Usuario</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="username" id="username" placeholder="Usuario" type="email" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-2 control-label">Contraseña</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="password" id="password" placeholder="Contraseña" type="password" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="firstName" class="col-sm-2 control-label">Nombre</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="firstName" id="firstName" placeholder="Nombre" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastName" class="col-sm-2 control-label">Apellido</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="lastName" id="lastName" placeholder="Apellido" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-2 control-label">Nombre</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="email" id="email" placeholder="Email" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="rut" class="col-sm-2 control-label">Rut</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="rut" id="rut" placeholder="Rut" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="dv" class="col-sm-2 control-label">DV</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="dv" id="dv" placeholder="DV" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="wallet" class="col-sm-2 control-label">Dinero</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="wallet" id="wallet" placeholder="Ingrese monto" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="profile" class="col-sm-2 control-label">Perfil</label>
                                <div class="col-sm-10">
                                    <select name="profile" id="profile" class="form-control" style="width: 100%;" required="required">
                                        <c:forEach items="${profiles}" var="profile">
                                            <option value="${profile.id}">${profile.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="status" class="col-sm-2 control-label">Estado</label>
                                <div class="col-sm-10">
                                    <select name="status" id="status" class="form-control" style="width: 100%;" required="required">
                                        <option value="1">Activo</option>
                                        <option value="0">Inactivo</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary" id="addNew" data-controller="usuarios" data-url="./updateUsuario.htm">Guardar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </jsp:body>
</t:Master>