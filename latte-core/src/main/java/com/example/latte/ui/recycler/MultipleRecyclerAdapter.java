package com.example.latte.ui.recycler;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.latte.R;
import com.example.latte.ui.banner.BannerCreator;
import com.example.latte.ui.image.GlideApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 25400 on 2020/4/18.
 */

public class MultipleRecyclerAdapter extends
        BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder>
        implements
        BaseQuickAdapter.SpanSizeLookup,
        OnItemClickListener {

    //确保初始化一次Banner，防止重复item加载
    private boolean mIsInitBanner = false;

    //设置图片加载策略
    private static final RequestOptions RECYCLER_OPTIONS =
            new RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate();

    protected MultipleRecyclerAdapter(List<MultipleItemEntity> data) {
        super(data);
        init();
    }

    public static MultipleRecyclerAdapter create(List<MultipleItemEntity> data) {
        return new MultipleRecyclerAdapter(data);
    }

    public static MultipleRecyclerAdapter create(DataConverter converter) {
        return new MultipleRecyclerAdapter(converter.convert());
    }

    private void init() {
        //设置不同的布局
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
        addItemType(ItemType.IMAGE, R.layout.item_multiple_image);
        addItemType(ItemType.TEXT_IMAGE, R.layout.item_multiple_image_text);
        addItemType(ItemType.BANNER, R.layout.item_multiple_banner);
        //设置宽度监听
        setSpanSizeLookup(this);
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
    }

    @Override
    protected MultipleViewHolder createBaseViewHolder(View view) {
        return MultipleViewHolder.create(view);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {
        final String text;
        final String imageUrl;
        final ArrayList<String> bannerImages;
        switch (holder.getItemViewType()) {
            case ItemType.TEXT:
                text = entity.getFiled(MultipleFields.TEXT);
                holder.setText(R.id.text_single, text);
                break;
            case ItemType.IMAGE:
                imageUrl = entity.getFiled(MultipleFields.IMAGE_URL);
                Glide.with(mContext)
                        .load(imageUrl)
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .dontAnimate()
//                        .centerCrop()
                        .apply(RECYCLER_OPTIONS)
                        .into((ImageView) holder.getView(R.id.image_single));
                break;
            case ItemType.TEXT_IMAGE:
                text = entity.getFiled(MultipleFields.TEXT);
                imageUrl = entity.getFiled(MultipleFields.IMAGE_URL);
                Glide.with(mContext)
                        .load(imageUrl)
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .apply(RECYCLER_OPTIONS)
//                        .dontAnimate()
//                        .centerCrop()
                        .into((ImageView) holder.getView(R.id.img_multiple));
                holder.setText(R.id.tv_multiple, text);
                break;
            case ItemType.BANNER:
                if (mIsInitBanner) {
                    bannerImages = entity.getFiled(MultipleFields.BANNERS);
                    final ConvenientBanner<String> convenientBanner = holder.getView(R.id.banner_recycler_item);
                    BannerCreator.setDefault(convenientBanner, bannerImages, this);
                    mIsInitBanner = true;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return getData().get(position).getFiled(MultipleFields.SPAN_SIZE);
    }

    @Override
    public void onItemClick(int position) {

    }
}
