package io.github.dianamishanich;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:default.properties",
        "file:../secret.properties",
        "system:properties"
})

public interface ApiConfig extends Config {


    @Config.DefaultValue("https://yandex.ru")
    @Key("base.url")
    URL baseUrl();

    @Key("secret.token")
    String tokenSecret();


    @Key("non.secret.token")
    String tokenNonSecret();

}