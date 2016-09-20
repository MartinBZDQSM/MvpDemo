package com.martin.mvp.common.base.view;

import java.util.List;

/**
 * com.martin.mvp.common.base
 * Created by Administrator
 * on 2016/9/19.
 */
public interface BaseView {

    void refresh();

    void loadMoreData(List mDatas);

    void netError();

    void showEmptyError();

    void hasNoMoreDate();

    void showToastError();

}
