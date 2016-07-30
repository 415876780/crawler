<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
      <title>EasyUI入门——创建EasyUI的Dialog</title>
    <!-- 引入JQuery -->
    <script type="text/javascript" src="jquery-easyui-1.4.5/jquery.min.js"></script>  
   
    <!-- 引入EasyUI -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
   <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
   <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
   <!-- 引入EasyUI的样式文件-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.4.5/themes/default/easyui.css" type="text/css"/>
   <!-- 引入EasyUI的图标样式文件-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.4.5/themes/icon.css" type="text/css"/>
   
   <script type="text/javascript">
       $(function(){
           //console.info($('#dd2'));
           /*使用JavaScript动态创建EasyUI的Dialog的步骤：
           1、定义一个div，并给div指定一个id
           2、使用Jquery选择器选中该div，然后调用dialog()方法就可以创建EasyUI的Dialog
           */
          $('#dd2').dialog();//使用默认的参数创建EasyUI的Dialog
           //使用自定义参数创建EasyUI的Dialog
           $('#dd3').dialog({
               title: '使用JavaScript创建的Dialog',
               width: 400,
               height: 200,
               closed: false,
               cache: false,
               modal: true
           });
       });
   </script>
   
   </head>
   
   <body>
       <%--使用纯html的方式创建创建EasyUI的Dialog的步骤：
       1、定义一个div
       2、将div的class样式属性设置成easyui-dialog，这样就可以将普通的div变成EasyUI的Dialog了
        --%>
     <div class="easyui-dialog" id="dd1" title="EasyUI Dialog" style="width: 500px;height: 300px;">
         Hello World!
     </div>
     <div id="dd2">Dialog Content</div>
     <div id="dd3">Dialog Content</div>
   </body>
 </html>