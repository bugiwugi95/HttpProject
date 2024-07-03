package lesson.java.domain;

import lesson.java.data_source.ReceiverApiDataSource;
import lesson.java.models.InRadiusDto;
import lesson.java.models.ReceiverModel;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class ReceiveService {
    ReceiverApiDataSource receiverApiDataSource;
    private int currentPage = 0;
    private final int pageSize = 10;

    public ReceiveService(ReceiverApiDataSource receiverApiDataSource) {
        this.receiverApiDataSource = receiverApiDataSource;
    }

    public void fetch(float latitude, float longitude, int radius) throws IOException {
        int lastCount = pageSize;
        while (lastCount == pageSize) {
            InRadiusDto dto = new InRadiusDto(latitude, longitude, radius, this.currentPage, 10);
            Call<List<ReceiverModel>> rec = receiverApiDataSource.listRepos(dto);
            Response<List<ReceiverModel>> res = rec.execute();
            assert res.body() != null;
            currentPage++;
            lastCount = res.body().size();
            for (ReceiverModel r : res.body()) {
                System.out.println(r);
            }
        }


    }

}
