package bawei.com.week_lianxi2;

import android.util.Log;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;


/**
 * 类的用途：
 * 时间:  2017/4/11  14:41
 * 姓名:  李照照
 */
public class OkUtils {

    DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
            //设置数据库名，默认xutils.db
            .setDbName("myapp.db")
            //设置数据库路径，默认存储在app的私有目录
            //.setDbDir(new File("/mnt/sdcard/"))
            //设置数据库的版本号
            .setDbVersion(2)
            //设置数据库打开的监听
            .setDbOpenListener(new DbManager.DbOpenListener() {
                @Override
                public void onDbOpened(DbManager db) {
                    //开启数据库支持多线程操作，提升性能，对写入加速提升巨大
                    //db.getDatabase().enableWriteAheadLogging();
                }
            })
            //设置数据库更新的监听
            .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                @Override
                public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                }
            });

    //设置是否允许事务，默认true
    //.setAllowTransaction(true)

    DbManager db = x.getDb(daoConfig);


    public  void getAddress(String uri){
        OkHttpUtils.get().url(uri).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(Call call, String s) {
                Log.d("qqqqqq",s);
                Bean1 bean = Gsons.addBean(s, Bean1.class);
                if (bean.getResult().getStat().equals("1")) {
                    List<Bean1.ResultBean.DateBean> date = bean.getResult().getDate();
                    List<ChildInfo> list_c = new ArrayList<ChildInfo>();
                    for (Bean1.ResultBean.DateBean bb : date) {
                        ChildInfo child = new ChildInfo();
                        child.setUrl(bb.getUri());
                        child.setTittle(bb.getTitle());
                        list_c.add(child);
                    }
                        Log.d("qqqqqq", list_c.size()+"+++++++++++");
                    try {
                        DbManager con=x.getDb(daoConfig);
                        con.save(list_c);
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
