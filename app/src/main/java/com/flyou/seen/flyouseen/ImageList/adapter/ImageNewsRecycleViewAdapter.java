package com.flyou.seen.flyouseen.ImageList.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flyou.seen.flyouseen.ImageList.domain.ImageNews;
import com.flyou.seen.flyouseen.R;

import java.util.List;

/**
 * ============================================================
 * 项目名称：HenuCenterPro
 * 包名称：com.flyou.henucenter.adapter
 * 文件名：ImageNewsRecycleViewAdapter
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2015/12/26 15:03
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public class ImageNewsRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    private boolean mShowFooter = true;
    private Context context;
    private List<ImageNews.DataEntity> mDate;

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public ImageNewsRecycleViewAdapter(Context context, List<ImageNews.DataEntity> news) {
        this.context=context;
        this.mDate =news;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_ITEM) {
            ItemViewHolder viewHolder = new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.view_news_item, null));

            return viewHolder;
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.view_recyclerview_footer, null);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return new FooterViewHolder(view);
        }
    }
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).title.setText(mDate.get(position).getName());
            ((ItemViewHolder) holder).date.setText(mDate.get(position).getCreatetime());


            Glide.with(context)
                    .load(mDate.get(position).getCover_thumb_url())
                    .placeholder(R.drawable.pic_loading)

                    .crossFade()
                    .error(R.drawable.pic_loading)
                    .into(((ItemViewHolder) holder).imageView);
            // 如果设置了回调，则设置点击事件
            if (mOnItemClickLitener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickLitener.onItemClick(holder.itemView, pos);
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                        return false;
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        int begin = mShowFooter?1:0;
        if(mDate == null) {
            return begin;
        }
        return mDate.size() + begin;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imageView;
        TextView date;

        public ItemViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.date);
            imageView = (ImageView) view.findViewById(R.id.imageView);


        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View view) {
            super(view);
        }

    }


    public void addItem(ImageNews.DataEntity news) {

        this.mDate.add(news);
        notifyItemInserted(0);
    }

    public void removeItem(int position) {
        mDate.remove(position);
        notifyItemRemoved(position);
    }
    public void isShowFooter(boolean showFooter) {
        this.mShowFooter = showFooter;
    }

    public boolean isShowFooter() {
        return this.mShowFooter;
    }
    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if(!mShowFooter) {
            return TYPE_ITEM;
        }
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }
}
