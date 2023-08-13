package ru.nb.favorite_data.db.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.nb.favorite_data.model.PeopleEntity;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PeopleDao_Impl implements PeopleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PeopleEntity> __insertionAdapterOfPeopleEntity;

  private final EntityDeletionOrUpdateAdapter<PeopleEntity> __deletionAdapterOfPeopleEntity;

  private final EntityDeletionOrUpdateAdapter<PeopleEntity> __updateAdapterOfPeopleEntity;

  public PeopleDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPeopleEntity = new EntityInsertionAdapter<PeopleEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `PeopleEntity` (`name`,`gender`,`starshipsCount`,`homeworld`,`url`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PeopleEntity value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getGender() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGender());
        }
        stmt.bindLong(3, value.getStarshipsCount());
        if (value.getHomeworld() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getHomeworld());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUrl());
        }
      }
    };
    this.__deletionAdapterOfPeopleEntity = new EntityDeletionOrUpdateAdapter<PeopleEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `PeopleEntity` WHERE `url` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PeopleEntity value) {
        if (value.getUrl() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUrl());
        }
      }
    };
    this.__updateAdapterOfPeopleEntity = new EntityDeletionOrUpdateAdapter<PeopleEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `PeopleEntity` SET `name` = ?,`gender` = ?,`starshipsCount` = ?,`homeworld` = ?,`url` = ? WHERE `url` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PeopleEntity value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getGender() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGender());
        }
        stmt.bindLong(3, value.getStarshipsCount());
        if (value.getHomeworld() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getHomeworld());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUrl());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUrl());
        }
      }
    };
  }

  @Override
  public Object insert(final PeopleEntity obj, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfPeopleEntity.insertAndReturnId(obj);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insert(final PeopleEntity[] obj, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPeopleEntity.insert(obj);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final PeopleEntity obj, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPeopleEntity.handle(obj);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final PeopleEntity obj, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPeopleEntity.handle(obj);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<PeopleEntity>> getAll() {
    final String _sql = "SELECT * FROM PeopleEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[]{"PeopleEntity"}, new Callable<List<PeopleEntity>>() {
      @Override
      public List<PeopleEntity> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
          try {
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
            final int _cursorIndexOfStarshipsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "starshipsCount");
            final int _cursorIndexOfHomeworld = CursorUtil.getColumnIndexOrThrow(_cursor, "homeworld");
            final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
            final List<PeopleEntity> _result = new ArrayList<PeopleEntity>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final PeopleEntity _item;
              final String _tmpName;
              if (_cursor.isNull(_cursorIndexOfName)) {
                _tmpName = null;
              } else {
                _tmpName = _cursor.getString(_cursorIndexOfName);
              }
              final String _tmpGender;
              if (_cursor.isNull(_cursorIndexOfGender)) {
                _tmpGender = null;
              } else {
                _tmpGender = _cursor.getString(_cursorIndexOfGender);
              }
              final int _tmpStarshipsCount;
              _tmpStarshipsCount = _cursor.getInt(_cursorIndexOfStarshipsCount);
              final String _tmpHomeworld;
              if (_cursor.isNull(_cursorIndexOfHomeworld)) {
                _tmpHomeworld = null;
              } else {
                _tmpHomeworld = _cursor.getString(_cursorIndexOfHomeworld);
              }
              final String _tmpUrl;
              if (_cursor.isNull(_cursorIndexOfUrl)) {
                _tmpUrl = null;
              } else {
                _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
              }
              _item = new PeopleEntity(_tmpName,_tmpGender,_tmpStarshipsCount,_tmpHomeworld,_tmpUrl);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
