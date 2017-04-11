package bawei.com.week_lianxi2;

import com.google.gson.Gson;

/**
 * 类的用途：
 * 时间:  2017/4/11  9:31
 * 姓名:  李照照
 */
public class Gsons {
   public  static <T>T addBean(String str,Class<T>beanClass){
       Gson gson=new Gson();
       T t = gson.fromJson(str, beanClass);
       return  t;
   }
}
