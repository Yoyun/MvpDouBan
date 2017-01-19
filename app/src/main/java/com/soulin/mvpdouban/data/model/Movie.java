package com.soulin.mvpdouban.data.model;

import java.util.List;
import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class Movie{

	@SerializedName("images")
	public abstract Images images();

	@SerializedName("casts")
	public abstract List<Celebrity> casts();

	@SerializedName("original_title")
	public abstract String originalTitle();

	@SerializedName("subtype")
	public abstract String subtype();

	@SerializedName("year")
	public abstract String year();

	@SerializedName("genres")
	public abstract List<String> genres();

	@SerializedName("directors")
	public abstract List<Celebrity> directors();

	@SerializedName("rating")
	public abstract Rating rating();

	@SerializedName("alt")
	public abstract String alt();

	@SerializedName("id")
	public abstract String id();

	@SerializedName("title")
	public abstract String title();

	@SerializedName("collect_count")
	public abstract int collectCount();

	public static TypeAdapter<Movie> typeAdapter(Gson gson) {
		return new AutoValue_Movie.GsonTypeAdapter(gson);
	}

	public static Builder builder() {
		return new AutoValue_Movie.Builder();
	}


	@AutoValue.Builder
	public abstract static class Builder {
		public abstract Builder setImages(Images images);

		public abstract Builder setCasts(List<Celebrity> casts);

		public abstract Builder setOriginalTitle(String originalTitle);

		public abstract Builder setSubtype(String subtype);

		public abstract Builder setYear(String year);

		public abstract Builder setGenres(List<String> genres);

		public abstract Builder setDirectors(List<Celebrity> directors);

		public abstract Builder setRating(Rating rating);

		public abstract Builder setAlt(String alt);

		public abstract Builder setId(String id);

		public abstract Builder setTitle(String title);

		public abstract Builder setCollectCount(int collectCount);

		public abstract Movie build();
	}
}