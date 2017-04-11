package bawei.com.week_lianxi2;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.List;

/**
 * 类的用途：
 * 时间:  2017/4/11  9:48
 * 姓名:  李照照
 */
public class Myadapter extends BaseAdapter {
    private Context context;
    public List<Bean.ResultBean.DataBean> list;

    public Myadapter(Context context, List<Bean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.fragment_my, null);
            holder = new ViewHolder();
            holder.image01 = (ImageView) convertView.findViewById(R.id.image01);
            holder.text01 = (TextView) convertView.findViewById(R.id.text02);
            holder.text02 = (TextView) convertView.findViewById(R.id.text03);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder.image01);
        x.image().bind(holder.image01, list.get(position).getThumbnail_pic_s());
        holder.text01.setText(list.get(position).getTitle());
        holder.text02.setText(list.get(position).getAuthor_name());

        return convertView;
    }

    class ViewHolder {
        ImageView image01;
        TextView text01;
        TextView text02;
    }
}
