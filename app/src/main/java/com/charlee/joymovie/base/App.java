package com.charlee.joymovie.base;

import androidx.multidex.MultiDexApplication;

import com.blankj.utilcode.util.LogUtils;
import com.charlee.joymovie.callback.EmptyCallback;
import com.charlee.joymovie.callback.LoadingCallback;
import com.charlee.joymovie.data.AppDataManager;
import com.charlee.joymovie.server.ControlManager;
import com.charlee.joymovie.util.HawkConfig;
import com.charlee.joymovie.util.OkGoHelper;
import com.charlee.joymovie.util.PlayerHelper;
import com.kingja.loadsir.core.LoadSir;
import com.orhanobut.hawk.Hawk;

import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;

/**
 * @author pj567
 * @date :2020/12/17
 * @description:
 */
public class App extends MultiDexApplication {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initParams();
        // OKGo
        OkGoHelper.init();
        // 初始化Web服务器
        ControlManager.init(this);
        //初始化数据库
        AppDataManager.init();
        LoadSir.beginBuilder()
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .commit();
        AutoSizeConfig.getInstance().setCustomFragment(true).getUnitsManager()
                .setSupportDP(false)
                .setSupportSP(false)
                .setSupportSubunits(Subunits.MM);
        PlayerHelper.init();
        LogUtils.getConfig().setBorderSwitch(false).setLogHeadSwitch(false);
    }

    private void initParams() {
        // Hawk
        Hawk.init(this).build();
        Hawk.put(HawkConfig.DEBUG_OPEN, false);
        if (!Hawk.contains(HawkConfig.PLAY_TYPE)) {
            Hawk.put(HawkConfig.PLAY_TYPE, 1);
        }
    }

    public static App getInstance() {
        return instance;
    }
}