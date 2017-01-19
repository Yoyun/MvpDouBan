package com.soulin.mvpdouban.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class Rating{

	@SerializedName("average")
	public abstract float average();

	@SerializedName("min")
	public abstract int min();

	@SerializedName("max")
	public abstract int max();

	@SerializedName("stars")
	public abstract String stars();

	public static TypeAdapter<Rating> typeAdapter(Gson gson) {
		return new AutoValue_Rating.GsonTypeAdapter(gson);
	}

	public static Builder builder() {
		return new AutoValue_Rating.Builder();
	}


	@AutoValue.Builder
	public abstract static class Builder {
		public abstract Builder average(float average);

		public abstract Builder min(int min);

		public abstract Builder max(int max);

		public abstract Builder stars(String stars);

		public abstract Rating build();
	}
}