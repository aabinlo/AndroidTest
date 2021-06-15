package com.example.liuliang.recylerviewtest210;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.ListResourceBundle;

/**
 * Created by liuliang on 2017/4/12.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private Context context;
    private LayoutInflater layoutInflater;
    private List<ArticleBean> list;

    //构造方法，传进上下文
    public MyAdapter(Context context) {
        this.context=context;
        layoutInflater=LayoutInflater.from(this.context);
    }

    //传递数据源
    public void setList(List<ArticleBean> list){
        this.list=list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvtitle,tvdescript,tvtime;
        Button button;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
            tvtitle=(TextView)itemView.findViewById(R.id.textView);
            tvdescript=(TextView)itemView.findViewById(R.id.textView2);
            tvtime=(TextView)itemView.findViewById(R.id.textView3);
            button=(Button)itemView.findViewById(R.id.button);
        }
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position) {
        ArticleBean articleBean=list.get(position);
        if (articleBean==null) return;

        holder.imageView.setImageResource(articleBean.getImgid());
        holder.tvtitle.setText(articleBean.getTitle());
        holder.tvdescript.setText(articleBean.getDescription());
        holder.tvtime.setText(articleBean.getTime());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int id=list.get(position).getArticleId();
                Toast.makeText(context,""+id, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
