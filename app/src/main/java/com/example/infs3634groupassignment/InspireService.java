package com.example.infs3634groupassignment;

import retrofit2.Call;
import com.example.infs3634groupassignment.Entities.Inspire;
import retrofit2.http.GET;

public interface InspireService {
    @GET("/jokes/random?category=career")
    Call<Inspire> getValue();

}
