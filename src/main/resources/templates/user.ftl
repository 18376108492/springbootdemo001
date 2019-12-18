<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <tb>编号</tb>
        <tb>姓名</tb>
        <tb>地址</tb>
        <#--<tb>生日</tb>-->
        <tb>性别</tb>
    </tr>
    <#list users as u>
     <tr>
         <tb>${u.id}</tb>
         <tb>${u.name}</tb>
         <tb>${u.add}</tb>
        <#--<tb>${u.birthday}</tb>-->

         <tb><#if u.sex==0>
             man
             <#elseif u.sex==1>
             wowan
             <#else >
             other
         </#if></tb>
     </tr>
    </#list>
</table>


</body>
</html>