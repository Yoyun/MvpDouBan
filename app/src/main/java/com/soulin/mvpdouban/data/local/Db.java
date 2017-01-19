package com.soulin.mvpdouban.data.local;

import android.content.ContentValues;
import android.database.Cursor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.soulin.mvpdouban.data.model.Celebrity;
import com.soulin.mvpdouban.data.model.Images;
import com.soulin.mvpdouban.data.model.Movie;
import com.soulin.mvpdouban.data.model.Rating;
import com.soulin.mvpdouban.util.MyGsonTypeAdapterFactory;

import java.util.List;

/**
 * Created by Soulin on 2017/1/17.
 */

public class Db {

    public Db() {}

    public abstract static class MovieTable {
        public static final String TABLE_NAME = "movie";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_ORIGINAL_TITLE = "original_title";
        public static final String COLUMN_YEAR = "year";
        public static final String COLUMN_RATING = "rating";
        public static final String COLUMN_GENRES = "genres";
        public static final String COLUMN_COLLECT_COUNT = "collect_count";
        public static final String COLUMN_SUBTYPE = "subtype";
        public static final String COLUMN_ALT = "alt";
        public static final String COLUMN_IMAGES = "images";
        public static final String COLUMN_CASTS = "casts";
        public static final String COLUMN_DIRECTORS = "directors";

        public static final String CREATE =
                "CREATE TABLE "+ TABLE_NAME +" (" +
                        COLUMN_ID + "  TEXT PRIMARY KEY," +
                        COLUMN_TITLE + "  TEXT," +
                        COLUMN_ORIGINAL_TITLE + "  TEXT," +
                        COLUMN_YEAR + "  TEXT," +
                        COLUMN_RATING + "  TEXT," +
                        COLUMN_GENRES + "  TEXT," +
                        COLUMN_COLLECT_COUNT + "  INTEGER," +
                        COLUMN_SUBTYPE + "  TEXT," +
                        COLUMN_ALT + "  TEXT," +
                        COLUMN_IMAGES + "  TEXT," +
                        COLUMN_CASTS + "  TEXT," +
                        COLUMN_DIRECTORS + "  TEXT" +
                ");";

        public static ContentValues toContentValues(Movie movie) {
            Gson gson = new Gson();

            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, movie.id());
            values.put(COLUMN_TITLE, movie.title());
            values.put(COLUMN_ORIGINAL_TITLE, movie.originalTitle());
            values.put(COLUMN_YEAR, movie.year());
            values.put(COLUMN_RATING, gson.toJson(movie.rating()));
            values.put(COLUMN_GENRES, gson.toJson(movie.genres()));
            values.put(COLUMN_COLLECT_COUNT, movie.collectCount());
            values.put(COLUMN_SUBTYPE, movie.subtype());
            values.put(COLUMN_ALT, movie.alt());
            values.put(COLUMN_IMAGES, gson.toJson(movie.images()));
            values.put(COLUMN_CASTS, gson.toJson(movie.casts()));
            values.put(COLUMN_DIRECTORS, gson.toJson(movie.directors()));

            return values;
        }

        public static Movie parseCursor(Cursor cursor) {
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(MyGsonTypeAdapterFactory.create()).create();

            Rating rating = gson.fromJson(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RATING)), Rating.class);
            Images images = gson.fromJson(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMAGES)), Images.class);
            List<String> genres = gson.fromJson(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GENRES)), new TypeToken<List<String>>(){}.getType());
            List<Celebrity> casts = gson.fromJson(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CASTS)), new TypeToken<List<Celebrity>>(){}.getType());
            List<Celebrity> directors = gson.fromJson(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DIRECTORS)), new TypeToken<List<Celebrity>>(){}.getType());

            return Movie.builder()
                    .setId(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID)))
                    .setTitle(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE)))
                    .setOriginalTitle(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ORIGINAL_TITLE)))
                    .setYear(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_YEAR)))
                    .setRating(rating)
                    .setGenres(genres)
                    .setCollectCount(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_COLLECT_COUNT)))
                    .setSubtype(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SUBTYPE)))
                    .setAlt(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALT)))
                    .setImages(images)
                    .setCasts(casts)
                    .setDirectors(directors)
                    .build();
        }
    }

//    public abstract static class CelebrityTable {
//        public static final String TABLE_NAME = "celebrity";
//
//        public static final String COLUMN_ID = "id";
//        public static final String COLUMN_NAME = "name";
//        public static final String COLUMN_ALT = "alt";
//        public static final String COLUMN_AVATARS = "avatars";
//
//        public static final String CREATE =
//                "CREATE TABLE " + TABLE_NAME + " (" +
//                        COLUMN_ID + " TEXT PRIMARY KEY," +
//                        COLUMN_NAME + " TEXT," +
//                        COLUMN_ALT + " TEXT," +
//                        COLUMN_AVATARS + " TEXT" +
//                ");";
//
//        public static ContentValues toContentValues(Celebrity celebrity) {
//            Gson gson = new Gson();
//
//            ContentValues values = new ContentValues();
//            values.put(COLUMN_ID, celebrity.id());
//            values.put(COLUMN_NAME, celebrity.name());
//            values.put(COLUMN_ALT, celebrity.alt());
//            values.put(COLUMN_AVATARS, gson.toJson(celebrity.avatars()));
//
//            return values;
//        }
//
//        public static Celebrity parseCursor(Cursor cursor) {
//            Gson gson = new Gson();
//
//            Avatars avatars = gson.fromJson(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AVATARS)), Avatars.class);
//
//            return Celebrity.builder()
//                    .setId(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID)))
//                    .setName(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)))
//                    .setAlt(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALT)))
//                    .setAvatars(avatars)
//                    .build();
//        }
//    }
//
//    public abstract static class MovieCastCelebrityTable {
//        public static final String TABLE_NAME = "movie_cast_celebrity";
//
//        public static final String COLUMN_MOVIE_ID = "movie_id";
//        public static final String COLUMN_CELEBRITY_ID = "celebrity_id";
//
//        public static final String CREATE =
//                "CREATE TABLE " + TABLE_NAME +" (" +
//                        COLUMN_MOVIE_ID + "  TEXT," +
//                        COLUMN_CELEBRITY_ID + "  TEXT," +
//                        "FOREIGN KEY (" + COLUMN_MOVIE_ID + ") REFERENCES " + MovieTable.TABLE_NAME + " (" + MovieTable.COLUMN_ID + ")," +
//                        "FOREIGN KEY (" + COLUMN_CELEBRITY_ID + ") REFERENCES " + CelebrityTable.TABLE_NAME + " (" + CelebrityTable.COLUMN_ID + ")," +
//                        "UNIQUE (" + COLUMN_MOVIE_ID + ", " + COLUMN_CELEBRITY_ID + ")" +
//                        ");";
//    }
//
//    public abstract static class MovieDirectorCelebrityTable {
//        public static final String TABLE_NAME = "movie_director_celebrity";
//
//        public static final String COLUMN_MOVIE_ID = "movie_id";
//        public static final String COLUMN_CELEBRITY_ID = "celebrity_id";
//
//        public static final String CREATE =
//                "CREATE TABLE " + TABLE_NAME +" (" +
//                        COLUMN_MOVIE_ID + "  TEXT," +
//                        COLUMN_CELEBRITY_ID + "  TEXT," +
//                        "FOREIGN KEY (" + COLUMN_MOVIE_ID + ") REFERENCES " + MovieTable.TABLE_NAME + " (" + MovieTable.COLUMN_ID + ")," +
//                        "FOREIGN KEY (" + COLUMN_CELEBRITY_ID + ") REFERENCES " + CelebrityTable.TABLE_NAME + " (" + CelebrityTable.COLUMN_ID + ")," +
//                        "UNIQUE (" + COLUMN_MOVIE_ID + ", " + COLUMN_CELEBRITY_ID + ")" +
//                        ");";
//    }
}
