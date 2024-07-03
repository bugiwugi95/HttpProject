package lesson.java.models;

public class InRadiusDto {

    float latitude;
    float longitude;
    int radius;
    int page;
    int pageSize;

    public InRadiusDto(float latitude, float longitude, int radius, int page, int pageSize) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.page = page;
        this.pageSize = pageSize;
    }
}
