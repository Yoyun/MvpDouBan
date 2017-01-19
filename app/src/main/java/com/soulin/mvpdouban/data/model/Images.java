package com.soulin.mvpdouban.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class Images{

	@SerializedName("small")
	public abstract String small();

	@SerializedName("large")
	public abstract String large();

	@SerializedName("medium")
	public abstract String medium();

	public static TypeAdapter<Images> typeAdapter(Gson gson) {
		return new AutoValue_Images.GsonTypeAdapter(gson);
	}

	public static Builder builder() {
		return new AutoValue_Images.Builder();
	}

	@AutoValue.Builder
	public abstract static class Builder {
		public abstract Builder small(String small);

		public abstract Builder large(String large);

		public abstract Builder medium(String medium);

		public abstract Images build();
	}
}