package th.co.softpos.ws.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AccessToken {

    @SerializedName("refresh_token_expires_in")
    private String refreshTokenExpiresIn;

    @SerializedName("api_product_list")
    private String apiProductList;

    @SerializedName("api_product_list_json")
    private String []apiProductListJson;

    @SerializedName("organization_name")
    private String organizationName;

    @SerializedName("developer.email")
    private String developerEmail;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("issued_at")
    private String issuedAt;

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("application_name")
    private String applicationName;

    @SerializedName("scope")
    private String scope;

    @SerializedName("expires_in")
    private String expiresIn;

    @SerializedName("refresh_count")
    private String refreshCount;

    @SerializedName("status")
    private String status;

}
