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
            <h1>Mantenedor Páginas</h1>
        </section>
        <!-- Main content -->
        <section class="content animated fadeInDown">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Páginas</h3>
                            <button type="submit" class="btn btn-primary pull-right" id="newItem">Nueva</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="mantenedor" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>URL</th>
                                        <th>Ícono</th>
                                        <th>Padre</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="page">
                                        <tr>
                                            <td>${page.name}</td>
                                            <td>${page.url}</td>
                                            <td>${page.icon}</td>
                                            <td>${page.parent}</td>
                                            <td>
                                                <a class="btn btn-primary btn-xs btnEditar" data-id="${page.id}" data-url="./getPagina.htm" data-original-title="Editar" data-toggle="tooltip"><i class="fa fa-pencil-square-o"></i></a>
                                                <a class="btn btn-primary btn-xs btnEliminar" data-id="${page.id}" data-url="./deletePagina.htm" data-original-title="Eliminar" data-toggle="tooltip"><i class="fa fa-times-circle"></i></a>
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
                                <label for="name" class="col-sm-2 control-label">Nombre</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="name" id="name" placeholder="Nombre" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="url" class="col-sm-2 control-label">Dirección</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="url" id="url" placeholder="Dirección" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="icon" class="col-sm-2 control-label">Ícono</label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="icon" id="icon" placeholder="fa-icon" type="text" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="parent" class="col-sm-2 control-label">Padre</label>
                                <div class="col-sm-10">
                                    <select name="parent" id="parent" class="form-control" style="width: 100%;">
                                        <option value="0">Sin Padre</option>
                                        <c:forEach items="${pages}" var="page">
                                            <option value="${page.id}">${page.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary" id="addNew" data-controller="usuarios" data-url="./updatePagina.htm">Guardar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </jsp:body>
</t:Master>