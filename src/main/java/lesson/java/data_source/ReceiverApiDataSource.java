package lesson.java.data_source;

import lesson.java.models.InRadiusDto;
import lesson.java.models.ReceiverModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface ReceiverApiDataSource {
    @POST("inRadius")
    Call<List<ReceiverModel>> listRepos(@Body InRadiusDto dto);
}
