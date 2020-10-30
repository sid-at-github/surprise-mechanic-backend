package org.glovo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.*;
import java.util.List;
import java.util.Random;

import static jakarta.ws.rs.core.Response.*;
import static java.util.Arrays.*;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("products")
public class ProductResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductVM> getRandomProduct() throws IOException {
        Request request = new Request.Builder().url("http://localhost:5000").get().build();
        com.squareup.okhttp.Response response = new OkHttpClient().newCall(request).execute();

        AnalyticsDTO analyticsDTO = new Gson().fromJson(response.body().string(), AnalyticsDTO.class);

        return Mapper.map(analyticsDTO);
    }

    @GET
    @Path("/image/{name}")
    @Produces("image/png")
    public Response getProductImage(@PathParam("name") String name) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String filePath = "/Users/sid/Work/surprise-mechanic/images/" + name;
        File file = new File(filePath);
//        Thumbnails.of(file).scale(0.2).outputFormat("png").outputQuality(0.8).toOutputStream(outputStream);
//        byte[] data = outputStream.toByteArray();
        ResponseBuilder response = ok((Object) file);
        return response.build();
    }
}
