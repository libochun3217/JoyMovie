package com.charlee.joymovie.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.charlee.joymovie.cache.Cache;
import com.charlee.joymovie.cache.CacheDao;
import com.charlee.joymovie.cache.VodCollect;
import com.charlee.joymovie.cache.VodCollectDao;
import com.charlee.joymovie.cache.VodRecord;
import com.charlee.joymovie.cache.VodRecordDao;


/**
 * 类描述:
 *
 * @author pj567
 * @since 2020/5/15
 */
@Database(entities = {Cache.class, VodRecord.class, VodCollect.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract CacheDao getCacheDao();

    public abstract VodRecordDao getVodRecordDao();

    public abstract VodCollectDao getVodCollectDao();
}
