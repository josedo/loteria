<%-- 
    Document   : loteria
    Created on : 07-05-2016, 08:31:20 AM
    Author     : Joe-Xidu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>LOTERIA</title>
        <!-- Tell the browser to be responsive to screen
              width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" href="/loteria/resources/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <!-- DataTables -->
        <link rel="stylesheet" href="/loteria/resources/plugins/datatables/dataTables.bootstrap.css">
        <!-- Select2 -->
        <link rel="stylesheet" href="/loteria/resources/plugins/select2/select2.min.css">
        <!-- SweetAlert -->
        <link rel="stylesheet" href="/loteria/resources/plugins/sweetalert/sweetalert.css">
        <!-- daterange picker -->
        <link rel="stylesheet" href="/loteria/resources/plugins/daterangepicker/daterangepicker-bs3.css">
        <!-- Bootstrap time Picker -->
        <link rel="stylesheet" href="/loteria/resources/plugins/timepicker/bootstrap-timepicker.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="/loteria/resources/dist/css/AdminLTE.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of
              downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="/loteria/resources/dist/css/skins/_all-skins.min.css">
        <link rel="stylesheet" href="/loteria/resources/plugins/pace/pace.min.css">
        <link rel="stylesheet" href="/loteria/resources/plugins/iCheck/square/blue.css">
        <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media
              queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file://
              -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    
    <body class="page-header-fixed page-quick-sidebar-over-content skin-blue">
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
                        <li class="dropdown user user-menu">
                            <a href="/loteria/login.htm">
                                <i class="glyphicon glyphicon-log-in"></i>
                                <span class="hidden-xs">Ingresar al Sistema</span>
                            </a>
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
                <ul class="sidebar-menu">
                    <li class="header">Navegación</li>
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Loteria</h1>
            </section>
            <!-- Main content -->
            <section class="content animated fadeInDown">
                <div class="row">
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
                    <div class="col-md-6">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">Últimos Ganadores</h3>
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
                                                <th>Nombre</th>
                                                <th>Sorteo</th>
                                                <th>Monto</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listWinners}" var="winner">
                                                <tr>
                                                    <td>${winner.users.firstName} ${winner.users.lastName}</td>
                                                    <td>${winner.draft.date}</td>
                                                    <td>${winner.prize}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                  </table>
                                </div>
                            </div>
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
                    <div class="col-md-7">
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
                                                    <td>${ticket.drafts.date}</td>
                                                </tr>
                                            </c:forEach>
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
                            <button type="button" class="btn btn-default" id="randomTicket" data-url="/loteria/randomTicket.htm">Comprar Al Azar</button>
                            <button type="button" class="btn btn-success" id="confirmTicket" data-url="/loteria/buyTicket.htm">Comprar</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
            <!-- /.content -->
        </div>
        <footer class="main-footer">
            <div class="pull-right hidden-xs">
                <b>Version</b> 1.0.0
            </div>
            <strong>Copyright © 2016-2017 <a href="http://localhost:8080/index.htm">LOTERIA</a>.</strong> Todo los Derechos Reservados.
        </footer>
        <!-- Control Sidebar -->
        <aside class="control-sidebar control-sidebar-dark">
            <!-- Create the tabs -->
            <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
                <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane" id="control-sidebar-home-tab">
                </div>
            </div>
        </aside>
        <!-- /.control-sidebar -->
        <!-- Add the sidebar's background. This div must be placed immediately
                after the control sidebar -->
        <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->
        <script src="/loteria/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
        <!-- Bootstrap 3.3.5 -->
        <script src="/loteria/resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="/loteria/resources/plugins/pace/pace.js"></script>
        <!-- Select2  -->
        <script src="/loteria/resources/plugins/select2/select2.full.min.js"></script>
        <!-- DataTables -->
        <script src="/loteria/resources/plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="/loteria/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
        <!-- SlimScroll -->
        <script src="/loteria/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="/loteria/resources/plugins/fastclick/fastclick.min.js"></script>
        <!-- Sparkline -->
        <script src="/loteria/resources/plugins/sparkline/jquery.sparkline.min.js"></script>
        <!-- jvectormap -->
        <script src="/loteria/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="/loteria/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
        <!-- AdminLTE App -->
        <script src="/loteria/resources/dist/js/app.min.js"></script>
        <!-- ChartJS 1.0.1 -->
        <script src="/loteria/resources/plugins/chartjs/Chart.min.js"></script>
        <!-- iCheck -->
        <script src="/loteria/resources/plugins/iCheck/icheck.min.js"></script>
        <!-- SweetAlert -->
        <script src="/loteria/resources/plugins/sweetalert/sweetalert.min.js"></script>
        <!-- date-range-picker -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
        <script src="/loteria/resources/plugins/daterangepicker/daterangepicker.js"></script>
        <script src="/loteria/resources/dist/js/pages/dashboard2.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="/loteria/resources/dist/js/demo.js"></script>
        <!-- FLOT CHARTS -->
        <script src="/loteria/resources/plugins/flot/jquery.flot.min.js"></script>
        <!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
        <script src="/loteria/resources/plugins/flot/jquery.flot.resize.min.js"></script>
        <!-- FLOT PIE PLUGIN - also used to draw donut charts -->
        <script src="/loteria/resources/plugins/flot/jquery.flot.pie.min.js"></script>
        <!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
        <script src="/loteria/resources/plugins/flot/jquery.flot.categories.min.js"></script>
        <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
        <!-- page script -->
        <script src="/loteria/resources/dist/js/scripts.js"></script>
    </body>
</html>