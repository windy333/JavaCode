# climbCSDNblogsUtils
## 将CSDN文章转化为Markdown文档
>很多情况下，我们需要将CSDN中的文章转化为markdown文档，直接复制全文是不可以的，CSDN不支持。

## 那有什么办法快速得到md文档？
`原理`:
- 由于CSDN不是获取数据不是前后端分离的，所以无法根据接口获取文章的所有数据，它的数据是和页面元素组合在一起的，需要根据页面中的元素标签转化为markdown中的元素标签。
- 使用jsoup解析csdn文档

`使用`:
- 直接将CSDN文章的url放入`climbDetailByUrl(url)`方法的参数即可
- 也支持爬取某个作者所有的文章,`climb(userName)`

## 例如：
### 获取单个文章markdown
```java
public class ClimbUtil {
    public static void main(String[] args) {
        climbDetailByUrl("https://blog.csdn.net/qq_45774645/article/details/123489756?spm=1001.2014.3001.5502");
    }
}
```
### 获取所有的文章markdown
```java
public class limbUtil {
    public static void main(String[] args) {
        //其中userName指定是博客介绍中的名字
        climb(userName);
    }
}
```
## 项目中待解决的问题
`TODO ‘> ’标签中包含代码块，需要处理`<br>
`TODO 代码中格式待处理`<br>
`TODO 增加GUI页面`<br>
`TODO 公式、表格标签的处理`<br>
## 欢迎大家提出问题，一起完善这个项目