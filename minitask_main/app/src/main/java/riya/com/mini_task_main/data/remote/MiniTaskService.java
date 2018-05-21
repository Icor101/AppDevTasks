package riya.com.mini_task_main.data.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import riya.com.mini_task_main.data.model.PersonalDetails;

/**
 * Created by BBMishra on 15-May-18.
 */

public interface MiniTaskService {
    @GET("https://jsonplaceholder.typicode.com/users")
    Call<PersonalDetails[]> getName();

    @GET("https://jsonplaceholder.typicode.com/users")
    Call<PersonalDetails[]> getUsername();

    @GET("https://jsonplaceholder.typicode.com/users")
    Call<PersonalDetails[]> getId();

}
