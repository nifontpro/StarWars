package ru.nb.favorite_data.db.dao;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.nb.favorite_data.model.FilmEntity;
import ru.nb.favorite_data.model.PeopleEntity;
import ru.nb.favorite_data.model.PeopleWithFilmsEntity;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PeopleDao_Impl implements PeopleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PeopleEntity> __insertionAdapterOfPeopleEntity;

  private final EntityDeletionOrUpdateAdapter<PeopleEntity> __deletionAdapterOfPeopleEntity;

  private final EntityDeletionOrUpdateAdapter<PeopleEntity> __updateAdapterOfPeopleEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByUrl;

  public PeopleDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPeopleEntity = new EntityInsertionAdapter<PeopleEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `PeopleEntity` (`name`,`gender`,`starshipsCount`,`homeworld`,`peopleUrl`) VALUES (?,?,?,?,?)";
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
        if (value.getPeopleUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPeopleUrl());
        }
      }
    };
    this.__deletionAdapterOfPeopleEntity = new EntityDeletionOrUpdateAdapter<PeopleEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `PeopleEntity` WHERE `peopleUrl` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PeopleEntity value) {
        if (value.getPeopleUrl() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPeopleUrl());
        }
      }
    };
    this.__updateAdapterOfPeopleEntity = new EntityDeletionOrUpdateAdapter<PeopleEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `PeopleEntity` SET `name` = ?,`gender` = ?,`starshipsCount` = ?,`homeworld` = ?,`peopleUrl` = ? WHERE `peopleUrl` = ?";
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
        if (value.getPeopleUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPeopleUrl());
        }
        if (value.getPeopleUrl() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPeopleUrl());
        }
      }
    };
    this.__preparedStmtOfDeleteByUrl = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM PeopleEntity WHERE peopleUrl=?";
        return _query;
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
  public Object deleteByUrl(final String url, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByUrl.acquire();
        int _argIndex = 1;
        if (url == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, url);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteByUrl.release(_stmt);
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
            final int _cursorIndexOfPeopleUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "peopleUrl");
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
              final String _tmpPeopleUrl;
              if (_cursor.isNull(_cursorIndexOfPeopleUrl)) {
                _tmpPeopleUrl = null;
              } else {
                _tmpPeopleUrl = _cursor.getString(_cursorIndexOfPeopleUrl);
              }
              _item = new PeopleEntity(_tmpName,_tmpGender,_tmpStarshipsCount,_tmpHomeworld,_tmpPeopleUrl);
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

  @Override
  public Flow<List<String>> getUrls() {
    final String _sql = "SELECT peopleUrl FROM PeopleEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[]{"PeopleEntity"}, new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
          try {
            final List<String> _result = new ArrayList<String>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final String _item;
              if (_cursor.isNull(0)) {
                _item = null;
              } else {
                _item = _cursor.getString(0);
              }
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

  @Override
  public Flow<List<PeopleWithFilmsEntity>> getPeopleWithFilms() {
    final String _sql = "SELECT * FROM PeopleEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[]{"PeopleFilmCrossRef","FilmEntity","PeopleEntity"}, new Callable<List<PeopleWithFilmsEntity>>() {
      @Override
      public List<PeopleWithFilmsEntity> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
            final int _cursorIndexOfStarshipsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "starshipsCount");
            final int _cursorIndexOfHomeworld = CursorUtil.getColumnIndexOrThrow(_cursor, "homeworld");
            final int _cursorIndexOfPeopleUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "peopleUrl");
            final ArrayMap<String, ArrayList<FilmEntity>> _collectionFilms = new ArrayMap<String, ArrayList<FilmEntity>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfPeopleUrl);
              ArrayList<FilmEntity> _tmpFilmsCollection = _collectionFilms.get(_tmpKey);
              if (_tmpFilmsCollection == null) {
                _tmpFilmsCollection = new ArrayList<FilmEntity>();
                _collectionFilms.put(_tmpKey, _tmpFilmsCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipFilmEntityAsruNbFavoriteDataModelFilmEntity(_collectionFilms);
            final List<PeopleWithFilmsEntity> _result = new ArrayList<PeopleWithFilmsEntity>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final PeopleWithFilmsEntity _item;
              final PeopleEntity _tmpPeopleEntity;
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
              final String _tmpPeopleUrl;
              if (_cursor.isNull(_cursorIndexOfPeopleUrl)) {
                _tmpPeopleUrl = null;
              } else {
                _tmpPeopleUrl = _cursor.getString(_cursorIndexOfPeopleUrl);
              }
              _tmpPeopleEntity = new PeopleEntity(_tmpName,_tmpGender,_tmpStarshipsCount,_tmpHomeworld,_tmpPeopleUrl);
              ArrayList<FilmEntity> _tmpFilmsCollection_1 = null;
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfPeopleUrl);
              _tmpFilmsCollection_1 = _collectionFilms.get(_tmpKey_1);
              if (_tmpFilmsCollection_1 == null) {
                _tmpFilmsCollection_1 = new ArrayList<FilmEntity>();
              }
              _item = new PeopleWithFilmsEntity(_tmpPeopleEntity,_tmpFilmsCollection_1);
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

  private void __fetchRelationshipFilmEntityAsruNbFavoriteDataModelFilmEntity(
      final ArrayMap<String, ArrayList<FilmEntity>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      ArrayMap<String, ArrayList<FilmEntity>> _tmpInnerMap = new ArrayMap<String, ArrayList<FilmEntity>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipFilmEntityAsruNbFavoriteDataModelFilmEntity(_tmpInnerMap);
          _tmpInnerMap = new ArrayMap<String, ArrayList<FilmEntity>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipFilmEntityAsruNbFavoriteDataModelFilmEntity(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `FilmEntity`.`title` AS `title`,`FilmEntity`.`director` AS `director`,`FilmEntity`.`producer` AS `producer`,`FilmEntity`.`filmUrl` AS `filmUrl`,_junction.`peopleUrl` FROM `PeopleFilmCrossRef` AS _junction INNER JOIN `FilmEntity` ON (_junction.`filmUrl` = `FilmEntity`.`filmUrl`) WHERE _junction.`peopleUrl` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      if (_item == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = 4; // _junction.peopleUrl;
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfTitle = 0;
      final int _cursorIndexOfDirector = 1;
      final int _cursorIndexOfProducer = 2;
      final int _cursorIndexOfFilmUrl = 3;
      while(_cursor.moveToNext()) {
        final String _tmpKey = _cursor.getString(_itemKeyIndex);
        ArrayList<FilmEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final FilmEntity _item_1;
          final String _tmpTitle;
          if (_cursor.isNull(_cursorIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
          }
          final String _tmpDirector;
          if (_cursor.isNull(_cursorIndexOfDirector)) {
            _tmpDirector = null;
          } else {
            _tmpDirector = _cursor.getString(_cursorIndexOfDirector);
          }
          final String _tmpProducer;
          if (_cursor.isNull(_cursorIndexOfProducer)) {
            _tmpProducer = null;
          } else {
            _tmpProducer = _cursor.getString(_cursorIndexOfProducer);
          }
          final String _tmpFilmUrl;
          if (_cursor.isNull(_cursorIndexOfFilmUrl)) {
            _tmpFilmUrl = null;
          } else {
            _tmpFilmUrl = _cursor.getString(_cursorIndexOfFilmUrl);
          }
          _item_1 = new FilmEntity(_tmpTitle,_tmpDirector,_tmpProducer,_tmpFilmUrl);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
