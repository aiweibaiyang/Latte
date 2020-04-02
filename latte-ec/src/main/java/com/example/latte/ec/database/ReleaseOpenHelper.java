package com.example.latte.ec.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.entity.gen.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * Created by 25400 on 2020/3/31.
 */

public class ReleaseOpenHelper extends DaoMaster.OpenHelper {
    public ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    public ReleaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }
}
