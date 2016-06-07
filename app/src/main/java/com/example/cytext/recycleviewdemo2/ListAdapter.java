package com.example.cytext.recycleviewdemo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 16-2-17.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{
    private Context context;
    private List<DataBean> list;
//    private LayoutInflater mInflat;
    public ListAdapter (Context context,List<DataBean> dataBean){
        this.context=context;
        this.list = dataBean;
//        this.mInflat = LayoutInflater.from(context);不可以用这个
    }
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //当viewholder创建时的回调
//        View view = View.inflate(context,R.layout.item_recyclerview,null);
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        ListViewHolder viewHolder = new ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
    //当viewholder和数据绑定时的回调
        DataBean positionData = list.get(position);
        holder.setData(positionData);
    }

    @Override
    public int getItemCount() {
        //lsit的数据条数
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name;
        public ListViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
        }
        public void setData(DataBean positionData) {
            imageView.setImageResource(positionData.pic);
            name.setText(positionData.name);
                }

        
    }
}
