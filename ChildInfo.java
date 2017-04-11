package bawei.com.week_lianxi2;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * 类的用途：
 * 时间:  2017/4/11  14:07
 * 姓名:  李照照
 */
@Table(name = "lizhaozhao",onCreated = "")
public class ChildInfo {
    @Column(name = "id",isId = true,autoGen = true,property = "NOT NULL")
    private int id;
    @Column(name = "url")
    private   String url;
    @Column(name = "tittle")
    private String tittle;

    public ChildInfo(int id, String url, String tittle) {
        this.id = id;
        this.url = url;
        this.tittle = tittle;
    }
    public  ChildInfo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public String toString() {
        return "ChildInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", tittle='" + tittle + '\'' +
                '}';
    }
}
