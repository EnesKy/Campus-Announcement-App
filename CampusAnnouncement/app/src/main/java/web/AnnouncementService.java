package web;

import java.util.List;

import model.Announcement;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AnnouncementService {

    @GET("announcement/all")
    Call<List<Announcement>> listAnnouncements();

}
