package com.soulin.mvpdouban.data.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.soulin.mvpdouban.data.model.Movie;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Soulin on 2017/1/18.
 */

@Singleton
public class DatabaseHelper {

    private final BriteDatabase mDb;

    @Inject
    public DatabaseHelper(DbOpenHelper dbOpenHelper) {
        SqlBrite.Builder briteBuilder = new SqlBrite.Builder();
        mDb = briteBuilder.build().wrapDatabaseHelper(dbOpenHelper, Schedulers.immediate());
    }

    public BriteDatabase getBriteDb() {
        return mDb;
    }

    public Observable<Movie> setMovies(final Collection<Movie> newMovies) {
        return Observable.create(new Observable.OnSubscribe<Movie>() {

            @Override
            public void call(Subscriber<? super Movie> subscriber) {
                if (subscriber.isUnsubscribed()) return;
                BriteDatabase.Transaction transaction = mDb.newTransaction();
                try {
                    mDb.delete(Db.MovieTable.TABLE_NAME, null);
                    for (Movie movie : newMovies) {
                        long result = mDb.insert(Db.MovieTable.TABLE_NAME,
                                Db.MovieTable.toContentValues(movie),
                                SQLiteDatabase.CONFLICT_REPLACE);
                        if (result >= 0) subscriber.onNext(movie);
                    }
                    transaction.markSuccessful();
                } finally {
                    transaction.end();
                    subscriber.onCompleted();
                }
            }
        });
    }

    public Observable<List<Movie>> getMovies() {
        return mDb.createQuery(Db.MovieTable.TABLE_NAME,
                "SELECT * FROM " + Db.MovieTable.TABLE_NAME)
                .mapToList(new Func1<Cursor, Movie>() {
                    @Override
                    public Movie call(Cursor cursor) {
                        return Db.MovieTable.parseCursor(cursor);
                    }
                });
    }
}
