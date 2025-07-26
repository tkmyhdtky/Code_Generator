<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>项目官网</title>
</head>
<body>
<h1>欢迎来到官网</h1>
<ul>
    <#list menuItems as item>
        <li><a href="${item.url}">${item.label}</a></li>
    </#list>
</ul>
</body>

<footer>
    ${currentYear} 项目官网. All rights reserved
</footer>
</html>