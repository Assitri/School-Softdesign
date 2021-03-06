package com.softdesign.school.utils;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;

/*
  Новый класс который блокирует скроллинг на AppBarLayout,
  зачем выносить в отдельный класс а не поставить в MainActivity как метод -
  проще подгружается в файле ContactsFragment.

 */

public class BlockToolbar {
    public static void setDrag(boolean isDrag, AppBarLayout appBar){
        final boolean drag = isDrag;
        ((CoordinatorLayout.LayoutParams) appBar.getLayoutParams()).setBehavior(new AppBarLayout.Behavior() {});
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams();
        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) lp.getBehavior();
        behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return drag;
            }
        });
    }
}
