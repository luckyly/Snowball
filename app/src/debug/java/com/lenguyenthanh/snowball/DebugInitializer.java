package com.lenguyenthanh.snowball;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.lenguyenthanh.snowball.app.MainInitializer;
import com.lenguyenthanh.snowball.app.setting.OkHttpClientSetting;
import com.lenguyenthanh.snowball.app.support.ActivityHierarchyServer;
import com.lenguyenthanh.snowball.models.MemoryLeakProxy;
import hu.supercluster.paperwork.Paperwork;
import javax.inject.Inject;
import javax.inject.Singleton;
import timber.log.Timber;

@Singleton
public class DebugInitializer extends MainInitializer {

  private final Paperwork paperwork;
  private final MemoryLeakProxy memoryLeakProxy;

  @Inject
  public DebugInitializer(final Timber.Tree logTree, final OkHttpClientSetting okHttpClientSetting,
      final Application application, final ActivityHierarchyServer activityHierarchyServer,
      final Paperwork paperwork, final MemoryLeakProxy memoryLeakProxy) {
    super(logTree, okHttpClientSetting, application, activityHierarchyServer);
    this.paperwork = paperwork;
    this.memoryLeakProxy = memoryLeakProxy;
  }

  @Override
  public void initialize() {
    super.initialize();
    memoryLeakProxy.init();
    initializeStetho();
  }

  private void initializeStetho() {
    Stetho.initializeWithDefaults(application);
  }
}