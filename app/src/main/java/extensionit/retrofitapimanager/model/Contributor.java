package extensionit.retrofitapimanager.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rifatullah on 3/22/18.
 */

public class Contributor {

    @SerializedName("login")
    private String login;
    @SerializedName("contributions")
    private int contributions;
    @SerializedName("avatar_url")
    private String avatar_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
