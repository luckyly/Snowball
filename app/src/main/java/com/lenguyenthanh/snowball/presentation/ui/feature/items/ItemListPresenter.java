package com.lenguyenthanh.snowball.presentation.ui.feature.items;

import com.lenguyenthanh.nimble.NimblePresenter;

interface ItemListPresenter extends NimblePresenter<ItemListView> {
  void loadItemList();

  void doRefresh();

  void gotoItemDetail();
}
