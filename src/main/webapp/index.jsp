<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>


springmvc上传文件
<%--action:指向controller请求、enctype:不对字符编码，用于发送二进制的文件--%>
<form name="form1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <%--name对应controller的upload方法的参数@RequestParam(value = "upload_file", required = false) MultipartFile file--%>
    <input type="file" name="upload_file">
    <input type="submit" value="springmvc上传文件">
</form>

富文本图片上传文件
<%--action:指向controller请求、enctype:不对字符编码，用于发送二进制的文件--%>
<form name="form1" action="/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file">
    <input type="submit" value="富文本图片上传文件">
</form>


</body>
</html>
