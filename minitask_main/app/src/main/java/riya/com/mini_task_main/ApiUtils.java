package riya.com.mini_task_main;

import riya.com.mini_task_main.data.remote.MiniTaskService;
import riya.com.mini_task_main.data.remote.RetrofitClient;

/**
 * Created by BBMishra on 16-May-18.
 */

public class ApiUtils {
    public static final String BASE_URL="https://www.jsonplaceholder.typicode.com";
    public static MiniTaskService getMiniTaskService()
    {
        return RetrofitClient.getClient(BASE_URL).create(MiniTaskService.class);
    }

}
