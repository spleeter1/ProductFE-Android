package com.example.productfe.api;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ProductService {

    // Lấy tất cả sản phẩm
    @GET("products")
    Call<List<Product>> getAllProducts();

    // Lấy chi tiết sản phẩm theo ID
    @GET("products/{id}")
    Call<Product> getProductById(@Path("id") int productId);

    // Lấy tất cả danh mục
    @GET("categories")
    Call<List<Category>> getAllCategories();

    // Tạo sản phẩm mới (không có ảnh)
    @POST("products")
    Call<Product> createProduct(@Body Product product);

    // Tạo sản phẩm mới (có ảnh)
    @Multipart
    @POST("products/upload")
    Call<Product> createProductWithImage(
            @Part("name") RequestBody name,
            @Part("description") RequestBody description,
            @Part("price") RequestBody price,
            @Part("stock") RequestBody stock,
            @Part("categoryId") RequestBody categoryId,
            @Part MultipartBody.Part image
    );

    // Cập nhật sản phẩm
    @PUT("products/{id}")
    Call<Product> updateProduct(@Path("id") int productId, @Body Product product);

    // Xóa sản phẩm
    @DELETE("products/{id}")
    Call<Void> deleteProduct(@Path("id") int productId);
}
