package app_utils.ktteam.src.DatabaseContext;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import app_utils.ktteam.src.DAO.IRepairerDao;
import app_utils.ktteam.src.Entities.ERepaierDistance;

@Database(entities = {ERepaierDistance.class}, version = 1)
public abstract class RepairerDatabase extends RoomDatabase {
    private static final String databasename = "RepairerDatabase.db";

    private static RepairerDatabase instane;

    // singleton pattern
    public static synchronized RepairerDatabase getInstance(Context context)
    {
        if(instane == null)
            instane = Room.databaseBuilder(context.getApplicationContext(),RepairerDatabase.class, databasename)
                    .allowMainThreadQueries() // cho phép query trên mainthread
                    .build();
        return instane;
    }

    public abstract IRepairerDao repairerDao();
}
