
package com.cisco.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "responseCode", "status", "desription", "data" })
public class JsonResponse {

  @JsonProperty("responseCode")
  private int responseCode;

  @JsonProperty("status")
  private String status;

  @JsonProperty("desription")
  private String desription;

  @JsonProperty("data")
  private Object data;

  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * No args constructor for use in serialization
   * 
   */
  public JsonResponse() {
  }

  /**
   * 
   * @param responseCode
   * @param status
   * @param desription
   */
  public JsonResponse(int responseCode, String status, String desription, Object data) {
    this.responseCode = responseCode;
    this.status = status;
    this.desription = desription;
    this.data = data;
  }

  /**
   * 
   * @return The responseCode
   */
  @JsonProperty("responseCode")
  public int getResponseCode() {
    return responseCode;
  }

  /**
   * 
   * @param responseCode
   *          The responseCode
   */
  @JsonProperty("responseCode")
  public void setResponseCode(int responseCode) {
    this.responseCode = responseCode;
  }

  /**
   * 
   * @return The status
   */
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  /**
   * 
   * @param status
   *          The status
   */
  @JsonProperty("status")
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * 
   * @return The desription
   */
  @JsonProperty("desription")
  public String getDesription() {
    return desription;
  }

  /**
   * 
   * @param desription
   *          The desription
   */
  @JsonProperty("desription")
  public void setDesription(String desription) {
    this.desription = desription;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
  
  /**
   * 
   * @return Object
   */
  @JsonProperty("data")
  public Object getData() {
    return data;
  }

  /**
   * 
   * @param Object
   */
  @JsonProperty("data")
  public void setData(Object data) {
    this.data = data;
  }

}
