package ru.nb.favorite_data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import ru.nb.favorite_data.db.dao.PeopleDao;
import ru.nb.favorite_data.db.dao.PeopleDao_Impl;
import ru.nb.favorite_data.db.dao.StarshipDao;
import ru.nb.favorite_data.db.dao.StarshipDao_Impl;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class StarwarDatabase_Impl extends StarwarDatabase {
  private volatile PeopleDao _peopleDao;

  private volatile StarshipDao _starshipDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PeopleEntity` (`name` TEXT NOT NULL, `gender` TEXT NOT NULL, `starshipsCount` INTEGER NOT NULL, `homeworld` TEXT NOT NULL, PRIMARY KEY(`name`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `StarshipEntity` (`name` TEXT NOT NULL, `model` TEXT NOT NULL, `passengers` TEXT NOT NULL, `manufacturer` TEXT NOT NULL, PRIMARY KEY(`name`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '31772d4866df035693971a1afd57f780')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `PeopleEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `StarshipEntity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPeopleEntity = new HashMap<String, TableInfo.Column>(4);
        _columnsPeopleEntity.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPeopleEntity.put("gender", new TableInfo.Column("gender", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPeopleEntity.put("starshipsCount", new TableInfo.Column("starshipsCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPeopleEntity.put("homeworld", new TableInfo.Column("homeworld", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPeopleEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPeopleEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPeopleEntity = new TableInfo("PeopleEntity", _columnsPeopleEntity, _foreignKeysPeopleEntity, _indicesPeopleEntity);
        final TableInfo _existingPeopleEntity = TableInfo.read(_db, "PeopleEntity");
        if (! _infoPeopleEntity.equals(_existingPeopleEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "PeopleEntity(ru.nb.favorite_data.model.PeopleEntity).\n"
                  + " Expected:\n" + _infoPeopleEntity + "\n"
                  + " Found:\n" + _existingPeopleEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsStarshipEntity = new HashMap<String, TableInfo.Column>(4);
        _columnsStarshipEntity.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarshipEntity.put("model", new TableInfo.Column("model", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarshipEntity.put("passengers", new TableInfo.Column("passengers", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarshipEntity.put("manufacturer", new TableInfo.Column("manufacturer", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStarshipEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStarshipEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStarshipEntity = new TableInfo("StarshipEntity", _columnsStarshipEntity, _foreignKeysStarshipEntity, _indicesStarshipEntity);
        final TableInfo _existingStarshipEntity = TableInfo.read(_db, "StarshipEntity");
        if (! _infoStarshipEntity.equals(_existingStarshipEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "StarshipEntity(ru.nb.favorite_data.model.StarshipEntity).\n"
                  + " Expected:\n" + _infoStarshipEntity + "\n"
                  + " Found:\n" + _existingStarshipEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "31772d4866df035693971a1afd57f780", "7fa930f40cbe9da9bf415f9d9871c79c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "PeopleEntity","StarshipEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `PeopleEntity`");
      _db.execSQL("DELETE FROM `StarshipEntity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PeopleDao.class, PeopleDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StarshipDao.class, StarshipDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public PeopleDao getPeopleDao() {
    if (_peopleDao != null) {
      return _peopleDao;
    } else {
      synchronized(this) {
        if(_peopleDao == null) {
          _peopleDao = new PeopleDao_Impl(this);
        }
        return _peopleDao;
      }
    }
  }

  @Override
  public StarshipDao getStarshipDao() {
    if (_starshipDao != null) {
      return _starshipDao;
    } else {
      synchronized(this) {
        if(_starshipDao == null) {
          _starshipDao = new StarshipDao_Impl(this);
        }
        return _starshipDao;
      }
    }
  }
}
