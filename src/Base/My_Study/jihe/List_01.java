package Base.My_Study.jihe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
使用List的实现类添加三本图书并遍历 打印如下
名称：xx   价格：xx   作者：xx
要求：
    1、价格从低到高（冒泡）
    2、使用ArrayList、Linklist和Vector三种集合实现
 */
@SuppressWarnings({"all"})
public class List_01 {
    public static void main(String[] arg){
        List list = new ArrayList();
        list.add(new Book("红楼梦","曹雪芹",210));
        list.add(new Book("三国演","罗贯中",160));
        list.add(new Book("水浒传","施耐庵",180));
        list.add(new Book("西游记","吴承恩",200));

        //排序
        /*
        list1.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 1;
            }
        });
         */
        BookSort(list);
        //遍历
        for(Object obj:list){
            System.out.println(obj.toString());
        }
    }
    //排序 写一个静态方法
    public static void BookSort(List list){
        int length = list.size();
        for(int i = 0; i < length-1; ++i){
            for(int j = 0; j < length-1-i; ++j){
                //先取出Book对象
                //Object o = list.get(j);  这样取出来是一个对象 因此需要向下转型
                Book bookj1 = (Book) list.get(j);
                Book bookj2 = (Book) list.get(j+1);
                if(bookj1.getPrice() > bookj2.getPrice()){
                    //集合的交换就是set方法的更改  原来j的位置是book1 现在换为book2
                    list.set(j,bookj2);
                    list.set(j+1,bookj1);
                }
            }
        }
    }
}

class Book{
    private String name;
    private String Author;
    private int price;

    //输出的时候需要用到toString 直接输toString选就行
    @Override
    public String toString() {
        return "名称： "+name+"\t\t价格："+price+"\t\t作者："+Author;
    }

    public Book(String name, String Author, int price) {
        this.name = name;
        this.Author = Author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getAuthor() {
        return Author;
    }
}
