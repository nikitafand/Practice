package coding.dsa;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class FetchCountPosts {
    public static void main(String[] args) throws IOException {
       Gson gson= new Gson();
        String api= "https://coderbyte.com/api/challenges/json/all-posts";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(api).build();
        Call call = client.newCall(request);
        Response execute = call.execute();
        String string = execute.body().string();
        System.out.println(string);
        Post[] strArray= gson.fromJson(string, Post[].class);
        Type listType = new TypeToken<List<Post>>() {}.getType();
        List<Post> postsList = gson.fromJson(string, listType);

        System.out.println("Total posts: " + postsList.size());

    }
}
