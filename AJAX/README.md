# EX1 使用ajax完成用户名的验证
ajax: 数据的交互
## issues

**Q1:取返回值时,取到的是一整个页面**

```
$('myres').value=myXmlHttpRequest.responseText;
```

![google network debug](https://github.com/Jane-QinJ/NoteBook/blob/master/AJAX/images/ex1_reponseText.png)

**S1:理解responseText, 返回的是*纯文本***


responseText 会将目标页面的所有字符以纯文本输出，包括html标签
