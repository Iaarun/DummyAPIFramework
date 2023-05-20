
package com.apitest.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Favfood {

    @JsonProperty("lunch")
    private String lunch;
    @JsonProperty("breakfast")
    private String breakfast;

    @JsonProperty("lunch")
    public String getLunch() {
        return lunch;
    }

    @JsonProperty("lunch")
    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    @JsonProperty("breakfast")
    public String getBreakfast() {
        return breakfast;
    }

    @JsonProperty("breakfast")
    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

}
