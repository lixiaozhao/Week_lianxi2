package bawei.com.week_lianxi2;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * 类的用途：
 * 时间:  2017/4/11  9:32
 * 姓名:  李照照
 */
public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    /*    ImageLoaderConfiguration con=new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480,800).build();
        ImageLoader.getInstance().init(con);*/
    }
}
